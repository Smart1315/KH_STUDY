package com.kh.example.test.model.vo;

public class Parent {
	private int num; // private 같은 클래스 까지
	double dNum; // 같은 패키지 까지
	protected boolean bool; // 상속한 자식 클래스 까지
	public char ch; // 모든 곳에서

	public void setNum(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}
}
