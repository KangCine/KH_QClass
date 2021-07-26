package com.test01;

public class MTest {
	
	public static void main(String[] args) {
		
		Test01 test01_1 = new Test01() {
			@Override
			public void prn() {
				System.out.println("Interface 구현!");
			}
		};
		test01_1.prn();
		
		// () -> {code};
		Test01 test01_2 = () -> {System.out.println("Lamda!");};
		test01_2.prn();
		
		// () -> code; // 바디({})안에 명령이 하나만 있을때는 { } 생략 가능
		Test01 test01_3 = () -> System.out.println("Lamda! 재밌다!");
		test01_3.prn();
		
		System.out.println("---------");
		
		// (parameter) -> {};
		Test02 test02_1 = (int i) -> {System.out.println("input : " + i);};
		test02_1.prn(10);
		
		Test02 test02_2 = (i) -> {System.out.println("input : " + i);};
		test02_2.prn(20);
		
		// parameter -> {};
		Test02 test02_3 = i -> System.out.println("input : " + i);
		test02_3.prn(30);
		
		System.out.println("---------");
		
		// parameter -> {return code;};
		Test03 test03_1 = i -> {return i + 10;};
		System.out.println(test03_1.prn(10));
		
		// parameter -> code; // return 생략
		Test03 test03_2 = i -> i + 20;
		System.out.println(test03_2.prn(10));
		
		System.out.println("---------");
		
		// (param1, parma2) -> {return code;};
		Test04 test04_1 = (n, m) -> {return n + m;};
		System.out.println(test04_1.prn(10, 20));
		
		// (param1, param2) -> code;
		Test04 test04_2 = (n, m) -> n * m;
		System.out.println(test04_2.prn(10, 20));
		
		// (param1, param2) -> {code; return code;};
		Test04 test04_3 = (n, m) -> {
			System.out.printf("%d * %d = ", n, m);
			return n * m;
		};
		System.out.println(test04_3.prn(30, 40));
	}

}
