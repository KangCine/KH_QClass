package com.test03;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Functional03 {
	
	public static void main(String[] args) {
		// func01();
		func02();
	}
	
	public static void func01() {
		Function<Integer, String> time = n -> (n<10) ? "0" + n : "" + n;
		
		System.out.println(time.apply(1));
		System.out.println(time.apply(3));
		System.out.println(time.apply(5));
		System.out.println(time.apply(10));
		
	}

	private static void func02() {
		BiFunction<String, String, Integer> sum = (i, j) -> Integer.parseInt(i) + Integer.parseInt(j);
		System.out.println(sum.apply("1", "3") + 1);
	}
	
}
