package com.kh.variable;

public class A_Variable { // 기능 클래스
	public void declareVariable() {
		// 변수 선언 후 초기화
		// A. 변수선언 : 메모리 공간에 저장 공간만 생성
		// 1. 논리형
		boolean isTrue;
		// 2. 문자형
		// 2-1. 문자형
		char ch;
		// 2-2. 문자열
		String str;
		// 3. 숫자형
		// 3-1. 정수형
		byte bNum;
		short sNum;
		int iNum;
		long lNum;
		// 3-2. 실수형
		float fNum;
		double dNum;
		
		// B. 초기화(대입)
		isTrue = true; // true/false 만 저장가능
		
		ch = 'A';
		str = "ABCD";
		
		bNum = 1;
		sNum = 2;
		iNum = 4;
		lNum = 8L;
		
		fNum = 4.0f;
		dNum = 8.0;
		
		System.out.println("isTrue의 값 : " + isTrue);
		
		System.out.println("ch의 값 : " + ch);
		System.out.println("str의 값 : " + str);
		
		System.out.println("bNum의 값 : " + bNum);
		System.out.println("sNum의 값 : " + sNum);
		System.out.println("iNum의 값 : " + iNum);
		System.out.println("lNum의 값 : " + lNum);
		
		System.out.println("fNum의 값 : " + fNum);
		System.out.println("dNum의 값 : " + dNum);
	}
	
	public void initVariable() {
		// 변수 선언과 동시에 초기화
		// 1. 논리형
		boolean isTrue = true;
		
		// 2. 문자형
		char ch = '가';
		String str = "안영재";
		
		// 3. 숫자형
		byte bNum = 1;
		short sNum = 2;
		int iNum = 4;
		long lNum = 8L;
		
		float fNum = 4.0f;
		double dNum = 8.0d;
		
		System.out.println("isTrue의 값 : " + isTrue);
		
		System.out.println("ch의 값 : " + ch);
		System.out.println("str의 값 : " + str);
		
		System.out.println("bNum의 값 : " + bNum);
		System.out.println("sNum의 값 : " + sNum);
		System.out.println("iNum의 값 : " + iNum);
		System.out.println("lNum의 값 : " + lNum);
		
		System.out.println("fNum의 값 : " + fNum);
		System.out.println("dNum의 값 : " + dNum);
	}
}