package com.kh.operator;

import java.util.Scanner;

public class E_Logical {

	public void method1() {
		// 입력한 정수 값이 1~100 사이의 숫자인지 확인
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 하나 입력 : ");
		int num = sc.nextInt();

		// 1 ~ 100 == 1보다 크거나 같고 100보다 작거나 같다
		boolean result = 1 <= num && num <= 100;

		System.out.println("입력한 숫자가 1과 100 사이에 있나요? " + result);

		sc.close();
	}

	public void method2() {
		// 입력한 문자 값이 대문자인지 확인
		Scanner sc = new Scanner(System.in);

		System.out.print("문자 하나 입력 : ");
		char ch = sc.nextLine().charAt(0);

		boolean result = 'A' <= ch && ch <= 'Z'; // 65 <= ch && ch <= 90

		System.out.println("영어 대문자가 맞습니까? " + result);

		System.out.println("계속 하시려면 y 혹은 Y를 입력하세요.");
		System.out.print("계속 하시겠습니까?(Y/y) : ");
		char answer = sc.nextLine().charAt(0);
		
		boolean result2 = answer == 'Y' || answer == 'y';
		
		System.out.println("계속 하시겠다구요? " + result2);
		
		sc.close();
	}
}
