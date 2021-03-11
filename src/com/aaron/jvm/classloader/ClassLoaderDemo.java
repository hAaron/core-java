package com.aaron.jvm.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义类加载器:定义一个类，继承classloader；重写loader方法；实例化class对象
 * 
 * @author Aaron
 * @date 2018年11月20日
 * @version 1.0
 * @package_type com.aaron.jvm.classloader.ClassLoaderDemo
 */
public class ClassLoaderDemo {

    public static void main(String[] args)
        throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ClassLoader loader = new ClassLoader() {
            @SuppressWarnings("finally")
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream inputStream = getClass().getResourceAsStream(fileName);

                if (inputStream == null) {
                    return super.loadClass(name);
                }
                try {
                    byte[] buff = new byte[inputStream.available()];
                    inputStream.read(buff);
                    return defineClass(name, buff, 0, buff.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };

        Object object = loader.loadClass("com.aaron.jvm.classloader.ClassLoaderDemo").newInstance();

        System.out.println(object.getClass());
        // object实例化是由上面自定义类加载器获取
        // ClassLoaderDemo 是由jvm自己的类加载器实例化
        System.out.println(object instanceof ClassLoaderDemo);
    }

}
