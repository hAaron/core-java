package com.aaron.framework.spring.ioc;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 模拟ioc容器
 * 
 * @author Aaron
 * @date 2018年8月2日
 * @version 1.0
 * @package_type com.aaron.spring.ioc.ClassPathXmlApplicationContext
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {
    /** 存储单例对象容器 */
    private Map<String, Object> singletonBeanFactory;
    /** 存储创建类定义对象的容器 */
    private Map<String, Class<?>> beanDefinationFactory;
    /** 存储beanElement对象容器 */
    private Map<String, Element> beanEleMap;
    /** 存储bean的scope属性容器 */
    private Map<String, String> beanScopeMap;

    public ClassPathXmlApplicationContext() {}

    /** 有参的构造方法，在创建此类实例时需要指定xml文件路径 */
    public ClassPathXmlApplicationContext(String xmlPath) {
        // 初始化容器
        singletonBeanFactory = new ConcurrentHashMap<String, Object>();
        beanDefinationFactory = new ConcurrentHashMap<String, Class<?>>();
        beanEleMap = new ConcurrentHashMap<String, Element>();
        beanScopeMap = new ConcurrentHashMap<String, String>();
        // 调用初始化方法
        init(xmlPath);
    }

    /**
     * 初始化方法，在创建ClassPathXmlApplicationContext对象时初始化容器， 并解析xml配置文件，获取bean元素，在运行时动态创建对象，并为对象的属性赋值， 最后把对象存放在容器中以供获取
     * 
     * @param xmlPath
     *            配置文件路径
     */
    private void init(String xmlPath) {

        /*
         * 使用dom4j技术读取xml文档 首先创建SAXReader对象
         */
        SAXReader reader = new SAXReader();
        try {
            // 获取读取xml配置文件的输入流
            InputStream is = getClass().getClassLoader().getResourceAsStream(xmlPath);
            // 读取xml，该操作会返回一个Document对象
            Document document = reader.read(is);
            // 获取文档的根元素
            Element rootElement = document.getRootElement();
            // 获取根元素下所有的bean元素，elements方法会返回元素的集合
            List<Element> beanElements = rootElement.elements("bean");
            // 遍历元素集合
            for (Element beanEle : beanElements) {
                // 获取bean的id值，该值用于作为key存储于Map集合中
                String beanId = beanEle.attributeValue("id");
                // 将beanElement对象存入map中，为对象设置属性值时使用
                beanEleMap.put(beanId, beanEle);
                // 获取bean的scope值
                String beanScope = beanEle.attributeValue("scope");
                // 如果beanScope不等于null，将bean的scope值存入map中方便后续使用
                if (beanScope != null) {
                    beanScopeMap.put(beanId, beanScope);
                }
                // 获取bean的class路径
                String beanClassPath = beanEle.attributeValue("class");
                // 利用反射技术根据获得的beanClass路径得到类定义对象
                Class<?> cls = Class.forName(beanClassPath);
                // 如果反射获取的类定义对象不为null，则放入工厂中方便创建其实例对象
                if (cls != null) {
                    beanDefinationFactory.put(beanId, cls);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 根据传入的bean的id值获取容器中的对象，类型为Object
     */
    @Override
    public Object getBean(String beanId) {
        // 根据传入beanId获取类对象
        Class<?> cls = beanDefinationFactory.get(beanId);
        // 根据id获取该bean对象的element元素对象
        Element beanEle = beanEleMap.get(beanId);
        // 获取存在map中的bean元素的scope属性值
        String scope = beanScopeMap.get(beanId);
        Object obj = null;
        try {
            // 如果scope等于singleton,创建单例对象
            if ("singleton".equals(scope) || null == scope) {
                // 判断容器中是否已有该对象的实例,如果没有,创建一个实例对象放到容器中
                if (singletonBeanFactory.get(beanId) == null) {
                    Object instance = cls.newInstance();
                    singletonBeanFactory.put(beanId, instance);
                }
                // 根据beanId获取对象
                obj = singletonBeanFactory.get(beanId);
            }
            // 如果scope等于prototype,则创建并返回多例对象
            if ("prototype".equals(scope)) {
                obj = cls.newInstance();
            }
            setFieldValues(beanId, beanEle, cls, obj);
            return obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        // 暂不支持其它类型，若不是以上两种类型或遭遇异常，返回null
        return null;
    }

    /**
     * 此为重载方法，在根据传入的bean的id值获取容器中的对象的同时，还可以自动转换类型， 返回指定的类型，在调用该方法时省去强转的步骤，传入时第二个参数为指定的类型， 方法实现同上一个方法，只是在返回对象前加了类型强转
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T getBean(String beanId, Class<T> c) {
        return (T)getBean(beanId);

    }

    /**
     * 该方法用于为对象设置成员属性值
     * 
     * @param beanEle
     *            bean所对应的element对象
     * @param beanId
     *            bean元素的id属性
     * @param beanScope
     *            bean元素的scope属性
     * @param cls
     *            类对象
     * @param obj
     *            要为其成员属性赋值的实例对象
     */
    private void setFieldValues(String beanId, Element beanEle, Class<?> cls, Object obj) {
        try {
            // 获取每个bean元素下的所有property元素，该元素用于给属性赋值
            List<Element> propEles = beanEle.elements("property");
            // 如果property元素集合为null，调用putInMap方法将对象放进Map中
            if (propEles == null) {
                return;
            }
            // 遍历property元素集合
            for (Element propEle : propEles) {
                // 获取每个元素的name属性值和value属性值
                String fieldName = propEle.attributeValue("name");
                String fieldValue = propEle.attributeValue("value");
                // 利用反射技术根据name属性值获得类的成员属性
                Field field = cls.getDeclaredField(fieldName);
                // 将该属性设置为可访问(防止成员属性被私有化导致访问失败)
                field.setAccessible(true);
                // 获取成员属性的类型名称，若非字符串类型，则需要做相应转换
                String fieldTypeName = field.getType().getName();
                // 判断该成员属性是否为int或Integer类型
                if ("int".equals(fieldTypeName) || "java.lang.Integer".equals(fieldTypeName)) {
                    // 转换为int类型并为该成员属性赋值
                    int intFieldValue = Integer.parseInt(fieldValue);
                    field.set(obj, intFieldValue);
                }
                // 判断该成员属性是否为String类型
                if ("java.lang.String".equals(fieldTypeName)) {
                    // 为该成员属性赋值
                    field.set(obj, fieldValue);
                }
                // 此处省略其它类型的判断......道理相同！
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 销毁方法，用于释放资源
     */
    @Override
    public void destroy() {
        singletonBeanFactory.clear();
        singletonBeanFactory = null;

        beanDefinationFactory.clear();
        beanDefinationFactory = null;

        beanEleMap.clear();
        beanEleMap = null;

        beanScopeMap.clear();
        beanScopeMap = null;
    }
}
