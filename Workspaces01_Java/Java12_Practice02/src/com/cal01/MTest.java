package com.cal01;

import java.util.Scanner;

public class MTest {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("연도 입력 : ");
		int year = sc.nextInt();
		System.out.print("월 입력 : ");
		int month = sc.nextInt();
		
		DayOfCalendar.prn(year,month);
			
	}
}
