package com.kh.example.chap03.branch;

import java.util.Scanner;

public class A_Break {
	// break문은 가장 가까운 반복문을 탈출

	public void method1() {
		// 문자열을 입력 받아 글자 개수를 출력하는 프로그램
		// end가 입력되면 반복 종료
		// do~while 사용

		Scanner sc = new Scanner(System.in);

//		String str = null;
//		do {
//			System.out.print("문자열 입력 : ");
//			str = sc.nextLine();
//
//			System.out.println("글자 수 : " + str.length());
//
//		} while (!str.equals("end"));
		
		String str = null;
		do {
			System.out.print("문자열 입력 : ");
			str = sc.nextLine();

			if (str.equals("end")) {
				break;
			}

			System.out.println("글자 수 : " + str.length());

		} while (true);

		sc.close();
	}
}
