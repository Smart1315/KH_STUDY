package com.kh.example.chap02.loop;

import java.util.Scanner;

public class C_DoWhile {

	public void method1() {
		// 키보드로 문자열 값을 입력받아 출력 반복 실행
		// exit가 들어올 때까지 반복
		Scanner sc = new Scanner(System.in);

		// 1. while
//		String str = ""; // null인 상태로 사용하려고 하면 NullPointerException이 발생 할 수 있음
//		while (!str.toLowerCase().equals("exit")) {
//			System.out.print("문자열 입력 : ");
//			str = sc.nextLine();
//			System.out.println("내가 입력한 문자열 : " + str);
//			
//		}

		// 2. do ~ while
		String str = null; // null이어도 str에 내용이 들어간 후 String 메소드를 사용하므로 오류가 발생하지 않음
		do {
			System.out.print("문자열 입력 : ");
			str = sc.nextLine();

			System.out.println("내가 입력한 문자열 : " + str);

		} while (!str.toLowerCase().equals("exit"));

		sc.close();
	}

}
