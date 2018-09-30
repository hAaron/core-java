package com.aaron.util.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 动态刷新properties文件
 * 
 * @author Aaron
 * @date 2018年9月30日
 * @version 1.0
 * @package_type com.aaron.util.properties.ReloadProperties
 */
public class ReloadProperties {

	private static Map<String, String> propertiesMap = new ConcurrentHashMap<String, String>();
	private static Set<String> propertiesFiles = new HashSet<String>();

	private static ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {
		AtomicInteger flag = new AtomicInteger(0);

		@Override
		public Thread newThread(Runnable r) {
			Thread thread = new Thread(r);
			thread.setName("ReloadProperties-thread-" + flag.getAndIncrement());
			return thread;
		}
	});

	static {
		pool.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				reloadProperties();
			}
		}, 0, 3, TimeUnit.SECONDS);
	}

	@SuppressWarnings("rawtypes")
	private static void reloadProperties() {
		String path = ReloadProperties.class.getClassLoader().getResource("").getPath();
		list(new File(path));
		try {
			for (String propertiesFile : propertiesFiles) {
				Properties properties = new Properties();
				InputStream is = new FileInputStream(propertiesFile);
				properties.load(is);
				Enumeration en = properties.propertyNames();
				while (en.hasMoreElements()) {
					String key = (String) en.nextElement();
					String value = properties.getProperty(key);
					propertiesMap.put(key, value);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 列出某文件夹及其子文件夹下面的文件，并可根据扩展名过滤
	 * 
	 * @param file
	 */
	public static void list(File file) {
		if (!file.exists()) {
			System.out.println("文件名称不存在!");
		} else {
			if (file.isFile()) {
				if (file.getName().toLowerCase().endsWith(".properties")) {// 文件格式
					propertiesFiles.add(file.getPath());
				}
			} else {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					list(files[i]);
				}
			}
		}
	}

	public String getConfig(String key) {
		return propertiesMap.get(key);

	}

	public static void main(String[] args) {
		reloadProperties();
	}

}
