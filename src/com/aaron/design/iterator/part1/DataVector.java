package com.aaron.design.iterator.part1;

import java.io.*;
import java.util.*;

/**
 * 定义具体容器角色
 * 
 * @author Aaron
 * @date 2017年6月2日
 * @version 1.0
 * @package_name com.aaron.design.iterator
 */
public class DataVector implements Aggregate {
	private Vector data = new Vector();

	public DataVector(String fileName) {
		try {
			BufferedReader f = new BufferedReader(new FileReader(fileName));
			String s = f.readLine();
			while (s != null) {
				if (s.trim().length() > 0) {
					data.add(s);
				}
				s = f.readLine();
			}
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("Can not find such file !");
		} catch (IOException e) {
			System.out.println("I/O Error !");
			System.exit(0);
		}
	}

	public Iterator CreateIterator() {
		return new VectorIterator(data);
	}

}