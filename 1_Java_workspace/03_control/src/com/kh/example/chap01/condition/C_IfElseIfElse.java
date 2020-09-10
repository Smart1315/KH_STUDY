package com.kh.example.chap01.condition;

import java.util.Scanner;

public class C_IfElseIfElse {
	// if-else if 문
	// if(조건식1) {
	// 		실행할 문장1;
	// } else if(조건식2) {
	// 		실행할 문장2;
	// } else {
	// 		실행할 문장3;
	// }
	// 다중 조건을 줄 수 있는 조건문
	// if문의 조건식의 결과 값이 참(true)이면 if문 안에 있는 실행문장1 수행
	// if문의 조건식의 결과 값이 거짓(false)이고 else if문의 조건식 결과 값이 참(true)이면 else if 안에 있는 실행문장2 수행
	// 둘 다 거짓(false)이면 실행문장3 수행
	// ===> if문에서 true라고 수행이 되었으면 그 아래 문장들은 수행되지 않음
	// else if문이 여러 개 일 수 있고, else문은 없을 수 도 있음

	public void method1() {
		// 입력한 숫자가 양수인지 0인지 음수인지 출력
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 한 개 입력 : ");
		int num = sc.nextInt();

		if (num > 0) {
			System.out.println("양수입니다.");
		} else if (num == 0) {
			System.out.println("0 입니다.");
		} else {
			System.out.println("음수입니다.");
		}

		sc.close();
	}

	public void method2() {
		// 점수를 하나 입력 받아 등급을 나누어 점수와 등급 출력
		// 90점 이상은 A등급,
		// 90점 미만 80점 이상은 B등급,
		// 80점 미만 70점 이상은 C등급,
		// 70점 미만 60점 이상은 D등급,
		// 60점 미만은 F등급으로 나눈다
		Scanner sc = new Scanner(System.in);

		System.out.print("점수 : ");
		int score = sc.nextInt();
		char grade = ' ';

//		if (score >= 90) {
//			grade = 'A';
//		} else if (score < 90 && score >= 80) {
//			grade = 'B';
//		} else if (score < 80 && score >= 70) {
//			grade = 'C';
//		} else if (score < 70 && score >= 60) {
//			grade = 'D';
//		} else {
//			grade = 'F';
//		}

		if (score >= 90) {
			grade = 'A';
		} else if (score >= 80) { // 이 구문이 실행되는 조건이 score >= 90이 거짓일 때 즉 score < 90 일 때이기 때문에 생략
			grade = 'B';
		} else if (score >= 70) { // 위와 같은 경우로 생략
			grade = 'C';
		} else if (score >= 60) { // 위와 같은 경우로 생략
			grade = 'D';
		} else {
			grade = 'F';
		}

		System.out.printf("점수는 %d점이고 등급은 %c입니다.", score, grade);

		sc.close();
	}

	public void method3() {
		// 위의 문제에서 각 등급 별 중간점수 이상의 경우에는 +라는 문자를 추가로 출력하세요
		// 예) 95점 이상은 등급이 A+, 90정 이상은 A, ...

		Scanner sc = new Scanner(System.in);

		System.out.print("점수 : ");
		int score = sc.nextInt();
		String grade = "";

		if (score >= 95) {
			grade = "A+";
		} else if (score >= 90) {
			grade = "A";
		} else if (score >= 85) {
			grade = "B+";
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 75) {
			grade = "C+";
		} else if (score >= 70) {
			grade = "C";
		} else if (score >= 65) {
			grade = "D+";
		} else if (score >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}

		System.out.printf("점수는 %d점이고 등급은 %s입니다.", score, grade);

		sc.close();
	}

	public void method4() {
		// 위의 문제에서 각 등급 별 중간점수 이상의 경우에는 +라는 문자를 추가로 출력하세요
		// 예) 95점 이상은 등급이 A+, 90정 이상은 A, ...

		Scanner sc = new Scanner(System.in);

		System.out.print("점수 : ");
		int score = sc.nextInt();
		String grade = "";

		if (score >= 90) {
			grade = "A";
			if (score >= 95) {
				grade += "+";
			}
		} else if (score >= 80) {
			grade = "B";
			if (score >= 85) {
				grade += "+";
			}
		} else if (score >= 70) {
			grade = "C";
			if (score >= 75) {
				grade += "+";
			}
		} else if (score >= 60) {
			grade = "D";
			if (score >= 65) {
				grade += "+";
			}
		} else {
			grade = "F";
		}

		System.out.printf("점수는 %d점이고 등급은 %s입니다.", score, grade);

		sc.close();
	}
}
