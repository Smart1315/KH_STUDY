package com.kh.operator;

public class B_InDecrease {

	public void method1() {
		// 전위 증감 연산자
		int num1 = 10;

		System.out.println("전위 증감 연산자 적용 전 : " + num1); // 10
		System.out.println("++num1을 1회 수행 후 결과 : " + (++num1)); // 11
		System.out.println("++num1을 2회 수행 후 결과 : " + (++num1)); // 12
		System.out.println("++num1을 3회 수행 후 결과 : " + (++num1)); // 13
		System.out.println("++num1을 4회 수행 후 결과 : " + (++num1)); // 14
		System.out.println("++num1을 5회 수행 후 결과 : " + (++num1)); // 15
		System.out.println("전위 증감 연산 수행 후 num1의 값 : " + num1); // 15

		// 후위 증감 연산자
		int num2 = 10;
		
		System.out.println("후위 연산자 적용 전 : " + num2); // 10
		System.out.println("num2++을 1회 수행 후 결과 : " + (num2++)); // 10 --> 11
		System.out.println("num2++을 2회 수행 후 결과 : " + (num2++)); // 11 --> 12
		System.out.println("num2++을 3회 수행 후 결과 : " + (num2++)); // 12 --> 13
		System.out.println("num2++을 4회 수행 후 결과 : " + (num2++)); // 13 --> 14
		System.out.println("num2++을 5회 수행 후 결과 : " + (num2++)); // 14 --> 15
		System.out.println("후위 증감 연산 수행 후 num2의 값 : " + num2); // 15
	}
	
	public void method2() {
		int num1 = 20;
		
		int result1 = num1++ * 3; // 20 * 3 = 60 --> 21
		System.out.println("num1 : " + num1);
		System.out.println("result1 : " + result1);
		
		int num2 = 20;
		
		int result2 = ++num2 * 3; // 21 * 3 = 63
		System.out.println("num2 : " + num2);
		System.out.println("result2 : " + result2);
	}
	
	public void method3() {
		int a = 10;
		int b = 20;
		int c = 30;
		
		System.out.println(a++); // 10 
		// a = 11
		
		System.out.println((++a) + (b++)); // 12 + 20 = 32 
		// a = 12, b = 21
		
		System.out.println((a++) + (--b) + (--c)); // 12 + 20 + 29 = 61 
		// a = 13, b = 20, c = 29
		
		System.out.println("a : " + a); // 13
		System.out.println("b : " + b); // 20
		System.out.println("c : " + c); // 29
	}
}
