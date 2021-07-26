package com.test03;

import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Functional02 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// predic01();
		// predic02();
		predic03();
	}
	
	public static boolean inNull(String name, Predicate<String>predic) {
		return predic.test(name);
	}
	
	private static void predic01() {
		String name = null;
		
		while(true) {
			System.out.println("이름 입력 : ");
			name = sc.nextLine();
			if(inNull(name, (input) -> input.trim().length() == 0)) {
				System.out.println("다시 입력해 주세요 !");
			}else {
				break;
			}
		}
		System.out.println("제 이름은 " + name + "입니다.");
	}

	private static void predic02() {
		Predicate<Integer> p2 = (n) -> n % 2 == 0;
		Predicate<Integer> p3 = (n) -> n % 3 == 0;
		
		System.out.println("숫자를 입력해 주세요 : ");
		int input = sc.nextInt();
		
		if(p2.test(input)) {
			System.out.println(input + " : 2의 배수");
		}
		
		if(p3.test(input)) {
			System.out.println(input + " : 3의 배수");
		}
		
		// and
		Predicate<Integer> p6 = p2.and(p3);
		if(p6.test(input)) {
			System.out.println(input + " : 2와 3의 공배수!!");
		}
	}
	
	private static void predic03() {
		BiPredicate<Integer, Integer> bp01 = (i, j) -> i - j > 0;
		
		System.out.println("i 입력 : ");
		int i = sc.nextInt();
		System.out.println("j 입력 : ");
		int j = sc.nextInt();
		
		if(bp01.test(i, j)) {
			System.out.println("i - j > 0");
		} else {
			System.out.println("i - j <= 0");
		}
	}
	
	
}
