package com.aaron.design.iterator.part1;

/**
 * 
 * @author Aaron
 * @date 2019年4月19日
 * @version 1.0
 * @package_type com.aaron.design.iterator.part1.TestIterator
 */
public class TestIterator {
	public static void main(String[] args) {
		String fileName = "E:\\temp\\data.txt";
		DataVector dataVector = new DataVector(fileName);
		Iterator iVector = dataVector.createIterator();
		for (iVector.first(); !iVector.isDone(); iVector.next()) {
			iVector.currentItem();
		}
	}
}