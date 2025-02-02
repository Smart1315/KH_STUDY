package com.kh.example.chap01.condition;

import java.util.Scanner;

public class A_If {
	// 단독 if
	// if (조건식) {
	// 실행할 문장
	// }
	// 조건식의 결과 값이 true면 {} 안의 코드 실행, false이면 무시됨

	public void method1() {
		// 입력한 숫자가 양수인지 음수인지 출력
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 한 개를 입력하세요 : ");
		int num = sc.nextInt();

		if (num > 0) {
			System.out.println("입력하신 숫자는 양수입니다.");
		}

		if (num < 0) {
			System.out.println("입력하신 숫자는 음수입니다.");
		}

		if (num == 0) {
			System.out.println("입력하신 숫자는 0입니다.");
		}

		System.out.println("프로그램 종료");

		sc.close();
	}

	public void method2() {
		// 입력한 숫자가 짝수인지 홀수인지 출력
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 한 개를 입력하세요 : ");
		int num = sc.nextInt();

		if (num % 2 == 0) {
			System.out.println("짝수입니다.");
		}

		if (num % 2 == 1) {
			System.out.println("홀수입니다.");
		}
		sc.close();
	}

	public void method3() {
		// 입력한 숫자가 1~10 사이의 숫자인지 확인
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 한 개를 입력하세요 : ");
		int num = sc.nextInt();

		if (1 <= num && num <= 10) {
			System.out.println("1과 10 사이의 숫자입니다.");
		}

		if (num <= 0 || 11 <= num) {
			System.out.println("1과 10 사이의 숫자가 아닙니다.");
		}

		sc.close();
	}

	public void method4() {
		// 문자열 비교하기
		// 이름을 입력받아 본인 이름과 같으면 본인입니다 출력
		Scanner sc = new Scanner(System.in);

		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		// String 자료형은 참조자료형(String 클래스)으로 주소값이 저장되기 때문에 == 으로는 비교가 불가능하다. 
		// String클래스 안의 equals() 메소드로 비교 가능 
		if (name.equals("안영재")) {
			System.out.println("본인입니다.");
		}
		
		if (!name.equals("안영재")) {
			System.out.println("본인이 아닙니다.");
		}

		sc.close();
	}
}
