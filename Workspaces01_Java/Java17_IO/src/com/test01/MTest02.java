package com.test01;

import java.io.File;

public class MTest02 {
	
	public static void main(String[] args) {
		File fi = new File("C:\\");
		prnList01(fi);
		System.out.println("--------------------------------------");
		prnList02(fi);
	}
	
	public static void prnList01(File fi) {
		for (String list : fi.list()) {
			System.out.println(list);
		}
	}
	
	public static void prnList02(File fi) {
		//파일과 디렉토리를 구분해서 출력하자.
		//file : ...
		//dir : ...
		//폴더의 갯수 : 0개
		//파일의 갯수 : 0개
		int fileCount = 0;
		int dirCount = 0;
		for (File f : fi.listFiles()) {
			if(f.isDirectory()){
			System.out.println("dir : " + f.getName());
			dirCount++;
			} else if(f.isFile()) {
				System.out.println("file : " + f.getName());
				fileCount++;
			} 
		}
		System.out.println("폴더의 갯수 : " + dirCount);
		System.out.println("파일의 갯수 : " + fileCount);
	}

}
