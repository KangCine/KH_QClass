package com.test03;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Functional01 {
	
	public static void main(String[] args) {
		// unaryTest();
		binaryTest();
	}
	
	private static void unaryTest() {
		UnaryOperator<String> hello = (name) -> "Hello, " + name;
		System.out.println(hello.apply("Lamda"));
	}
	
	private static void binaryTest() {
		BinaryOperator<Integer> sum = (i, j) -> i + j;
		System.out.println(sum.apply(10, 20));
	}
	
	// UnaryOperator
	// BinariOperator
}
