package com.test02;

import java.util.Scanner;

public class MTest {
	
	public static void main(String[] args) {
		MYProc sum = (a, b) -> a + b;
		MYProc sub = (a, b) -> a - b;
		MYProc mul = (a, b) -> a * b;
		MYProc div = (a, b) -> a / b;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("i 입력 : ");
		int i = sc.nextInt();
		System.out.println("j 입력 : ");
		int j = sc.nextInt();
		
		System.out.printf("%d + %d = %.0f\n", i, j, sum.calc(i, j));
		System.out.printf("%d - %d = %.0f\n", i, j, sub.calc(i, j));
		System.out.printf("%d * %d = %.0f\n", i, j, mul.calc(i, j));
		System.out.printf("%d / %d = %.2f\n", i, j, div.calc(i, j));
		
		// 나머지(%)
		MYProc mod = (a, b) -> a % b;
		System.out.printf("%d %% %d = %.0f\n", i, j, mod.calc(i, j));
	}

}
