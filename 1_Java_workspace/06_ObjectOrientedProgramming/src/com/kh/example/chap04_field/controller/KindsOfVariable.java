package com.kh.example.chap04_field.controller;

public class KindsOfVariable { // <== 클래스 영역의 시작
	// 클래스 영역에 작성하는 변수 : 필드
	// 필드 == 멤버 변수 == 멤버 필드 == 전역 변수
	private int globalNum; // 멤버 변수

	public void method1(int num) { // <== 메소드 영역의 시작
		int localNum; // 지역 변수

//		System.out.println(localNum);
		// The local variable localNum may not have been initialized
		// 지역변수는 선언 외에 다시 사용하기 위해서는 반드시 초기화가 되어 있어야 한다

		System.out.println(num);

		System.out.println(globalNum);
	} // <== 메소드 영역의 끝

	public void method2() {
//		System.out.println(localNum); // 지역 변수는 해당 지역(블록 안)에서만 사용 가능
		System.out.println(globalNum);
	}

	
	

} // <== 클래스 영역의 끝
