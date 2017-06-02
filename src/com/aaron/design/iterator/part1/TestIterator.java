package com.aaron.design.iterator.part1;

public class TestIterator {
	public static void main(String[] args) {
		String fileName = "E:\\temp\\data.txt";
		DataVector dataVector = new DataVector(fileName);
		Iterator iVector = dataVector.CreateIterator();
		for (iVector.First(); !iVector.IsDone(); iVector.Next()) {
			iVector.CurrentItem();
		}
	}
}