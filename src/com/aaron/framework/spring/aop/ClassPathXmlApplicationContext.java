package com.aaron.framework.spring.aop;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 自定义context容器
 * 
 * @author Aaron
 * @date 2018年8月3日
 * @version 1.0
 * @package_type com.aaron.spring.aop.ClassPathXmlApplicationContext
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {

	/**
	 * 存放代理类的集合
	 */
	public static ConcurrentHashMap<String, Object> beanDefinationFactory = new ConcurrentHashMap<String, Object>();

	public ClassPathXmlApplicationContext() {
		init("com.aaron.spring.aop");
	}

	/**
	 * 初始化 aop 容器
	 */
	public static void init(String basePath) {
		try {
			Set<Class<?>> classSet = getClassSet(basePath);

			for (Class<?> clazz : classSet) {
				if (clazz.isAnnotationPresent(Aspect.class)) {
					// 找到切面
					Method[] methods = clazz.getMethods();

					for (Method method : methods) {

						if (method.isAnnotationPresent(PointCut.class)) {
							// 找到切点
							PointCut pointCut = (PointCut) method.getAnnotations()[0];
							String pointCutStr = pointCut.value();
							
							String[] porintCuts = pointCutStr.split(",");
							for (String string : porintCuts) {
								String[] pointCutArr = string.split("_");
								// 被代理的类名
								String className = pointCutArr[0];
								// 被代理的方法名
								String methodName = pointCutArr[1];

								// 根据切点 创建被代理对象
								Object targetObj = Class
										.forName(className, false, Thread.currentThread().getContextClassLoader())
										.newInstance();
								// 根据切面类创建代理者
								CglibAbsMethodAdvance proxyer = (CglibAbsMethodAdvance) clazz.newInstance();
								// 设置代理的方法
								proxyer.setProxyMethodName(methodName);

								Object object = proxyer.getProxyInstance(targetObj);

								if (object != null) {
									beanDefinationFactory.put(targetObj.getClass().getSimpleName().toLowerCase(), object);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加载指定包下的所有类
	 *
	 * @param @param
	 *            packageName
	 * @param @return
	 *            设定文件
	 * @return Set<Class < ?>> 返回类型
	 * @throws ClassNotFoundException
	 * @throws @Title:
	 *             getClassSet
	 * @Description:
	 */
	public static Set<Class<?>> getClassSet(String packageName) throws IOException, ClassNotFoundException {
		Set<Class<?>> classSet = new HashSet<>();
		try {
			Enumeration<URL> urls = Thread.currentThread().getContextClassLoader()
					.getResources(packageName.replace(".", "/"));
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				if (url != null) {
					String protocol = url.getProtocol();
					if (protocol.equals("file")) {
						// 转码
						String packagePath = URLDecoder.decode(url.getFile(), "UTF-8");
						addClass(classSet, packagePath, packageName);
					} else if (protocol.equals("jar")) {
						JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
						if (jarURLConnection != null) {
							JarFile jarFile = jarURLConnection.getJarFile();
							if (jarFile != null) {
								Enumeration<JarEntry> jarEntries = jarFile.entries();
								while (jarEntries.hasMoreElements()) {
									JarEntry jarEntry = jarEntries.nextElement();
									String jarEntryName = jarEntry.getName();
									if (jarEntryName.endsWith(".class")) {
										String className = jarEntryName.substring(0, jarEntryName.lastIndexOf("."))
												.replaceAll("/", ".");
										Class<?> cls = Class.forName(className, false,
												Thread.currentThread().getContextClassLoader());
										classSet.add(cls);
									}
								}
							}
						}
					}
				}
			}
		} catch (IOException e) {
			throw e;
		}

		return classSet;
	}

	/**
	 * 添加文件到SET集合
	 *
	 * @param @param
	 *            classSet
	 * @param @param
	 *            packagePath
	 * @param @param
	 *            packageName 设定文件
	 * @return void 返回类型
	 * @throws @Title:
	 *             addClass
	 * @Description:
	 */
	private static void addClass(Set<Class<?>> classSet, String packagePath, String packageName) {

		File[] files = new File(packagePath).listFiles(new FileFilter() {

			@Override
			public boolean accept(File file) {
				return (file.isFile() && file.getName().endsWith(".class") || file.isDirectory());
			}
		});

		for (File file : files) {
			String fileName = file.getName();
			if (file.isFile()) {
				String className = fileName.substring(0, fileName.lastIndexOf("."));

				if (packageName != null) {
					className = packageName + "." + className;
				}
				// 添加
				try {
					Class<?> cls = Class.forName(className, false, Thread.currentThread().getContextClassLoader());
					classSet.add(cls);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} else {
				// 子目录
				String subPackagePath = fileName;
				if (packageName != null) {
					subPackagePath = packagePath + "/" + subPackagePath;
				}

				String subPackageName = fileName;
				if (packageName != null) {
					subPackageName = packageName + "." + subPackageName;
				}

				addClass(classSet, subPackagePath, subPackageName);
			}
		}

	}

	@Override
	public Object getBean(String beanName) {
		// 根据传入beanId获取类对象
		return beanDefinationFactory.get(beanName.toLowerCase());
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getBean(String beanName, Class<?> T) {
		return (T)getBean(beanName);
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		try {
			Class cls = Class.forName("com.spring.aop.LogAspect");
			System.out.println(cls.isAnnotationPresent(Aspect.class));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
