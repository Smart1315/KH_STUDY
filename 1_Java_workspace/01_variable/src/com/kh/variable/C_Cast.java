package com.kh.variable;

public class C_Cast {

	public void rule1() {
		int num = 'a';
		// 4byte <- 2byte : 자동 형변환
		System.out.println("num : " + num);

		char c = 65;
		// 97이 리터럴값이기 때문에 char 변수에 들어갈 수 있다
		System.out.println("c : " + c);

		char c2 = (char) num; // int자료형의 크기가 더 크기때문에 대입 불가 // 강제형변환
		System.out.println("c2 : " + c2);

		int num2 = -97;
		char c3 = (char) num2;
		System.out.println("c3 : " + c3); // 매칭되는 값이 없어서 ? 출력
	}

	public void rule2() {
		int iNum = 10;
		long lNum = 100L;

//		int sum = iNum + lNum;
		// int + long
		// (자동형변환)long + long = long (8byte)

		// 방법 1. 수행결과를 int로 강제 형변환
		int sum1 = (int) (iNum + lNum);
		System.out.println("sum1 : " + sum1);
		// 방법 2. long형의 값을 int로 강제 형변환
		int sum2 = iNum + (int) lNum;
		System.out.println("sum2 : " + sum2);
		// 방법 3. 결과 자료형을 long로 받기
		long sum3 = iNum + lNum;
		System.out.println("sum3 : " + sum3);

	}
}
