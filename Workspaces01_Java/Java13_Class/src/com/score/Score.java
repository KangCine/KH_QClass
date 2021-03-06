package com.score;

public class Score {
	
	//field
	private String name;
	private int kor;
	private int eng;
	private int math;

	//constructor
	public Score() {
		
	}
	
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	//getter & setter(값 넣어주는거 세터, 값 가져오는거 게터)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	
	//getSum, getAvg, getGrade
	public int getSum() {
		return kor + eng + math;
	}
	
	public double getAvg() {
		return (double)(kor + eng + math) / 3;
	}
	
	public String getGrade() {
		String grade = null;
		//100~90 : A, 80~89 : B, 70~79 : C, 60~69 : D, 0~59 : F 
		if(getAvg() <= 100 && 90 <= getAvg()) {
			grade = "A";
		}else if(getAvg() < 90 && 80 <= getAvg()) {
			grade = "B";
		}else if(getAvg() < 80 && 70 <= getAvg()){
			grade = "C";
		}else if(getAvg() < 70 && 60 <= getAvg()) {
			grade = "D";
		}else {
			grade = "F";
		}
		
		
		return grade;
	}
	
	@Override//재정의
	public String toString() {
		
		return "이름 : " + name + " 국어 : " + kor + " 영어 : " + eng + " 수학 : " + math + 
				"\n총점 : " + getSum() + " 평균 : " +getAvg() + " 등급 : " + getGrade();
	}
	
}
