package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {

	public void practice1() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 : ");
		int num = sc.nextInt();

		System.out.println(0 < num ? "양수다" : "양수가 아니다");

		sc.close();
	}

	public void parctice2() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 : ");
		int num = sc.nextInt();

		System.out.println(0 < num ? "양수다" : (num == 0 ? "0이다" : "음수다"));

		sc.close();
	}

	public void practice3() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 : ");
		int num = sc.nextInt();

		System.out.println(num % 2 == 0 ? "짝수다" : "홀수다");

		sc.close();
	}

	public void practice4() {
		Scanner sc = new Scanner(System.in);

		System.out.print("인원 수 : ");
		int num1 = sc.nextInt();
		System.out.print("사탕 개수 : ");
		int num2 = sc.nextInt();

		System.out.println("1인당 사탕 개수 : " + (num2 / num1));
		System.out.println("남는 사탕 개수 : " + (num2 % num1));

		sc.close();
	}

	public void practice5() {
		Scanner sc = new Scanner(System.in);

		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("학년(숫자만) : ");
		int grade = sc.nextInt();
		System.out.print("반(숫자만) : ");
		int group = sc.nextInt();
		System.out.print("번호(숫자만) : ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("성별(M/F) : ");
		char g = sc.nextLine().charAt(0);
		String gender = g == 'M' ? "남학생" : (g == 'F' ? "여학생" : "학생");
		System.out.print("성적(소수점 아래 둘째자리까지) : ");
		double score = sc.nextDouble();

		System.out
				.println(grade + "학년 " + group + "반 " + number + "번 " + name + " " + gender + "의 성적은 " + score + "이다.");

		sc.close();

	}

	public void practice6() {
		Scanner sc = new Scanner(System.in);

		System.out.print("나이 : ");
		int age = sc.nextInt();

		String result = age <= 13 ? "어린이" : (age <= 19 ? "청소년" : "성인");

		System.out.println(result);

		sc.close();
	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);

		System.out.print("국어 : ");
		int num1 = sc.nextInt();
		System.out.print("영어 : ");
		int num2 = sc.nextInt();
		System.out.print("수학 : ");
		int num3 = sc.nextInt();

		int result1 = num1 + num2 + num3;
		double result2 = result1 / 3.0;
		String result3 = 40 <= num1 && 40 <= num2 && 40 <= num3 && 60.0 <= result2 ? "합격" : "불합격";
		System.out.println("합계 : " + result1);
		System.out.println("평균 : " + result2);
		System.out.println(result3);

		sc.close();
	}

	public void practice8() {
		Scanner sc = new Scanner(System.in);

		System.out.print("주민번호를 입력하세요(- 포함) : ");
		String number = sc.nextLine();

		int num = number.charAt(7) - '0';
		System.out.println(num % 2 == 1 ? "남자" : "여자");

		sc.close();
	}

	public void practice9() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수1 : ");
		int num1 = sc.nextInt();
		System.out.print("정수2 : ");
		int num2 = sc.nextInt();
		System.out.print("입력 : ");
		int num3 = sc.nextInt();

		boolean result = num3 <= num1 || num2 < num3;

		System.out.println(result);

		sc.close();
	}

	public void practice10() {
		Scanner sc = new Scanner(System.in);

		System.out.print("입력1 : ");
		int num1 = sc.nextInt();
		System.out.print("입력2 : ");
		int num2 = sc.nextInt();
		System.out.print("입력3 : ");
		int num3 = sc.nextInt();

		boolean result = num1 == num2 && num2 == num3;

		System.out.println(result);

		sc.close();
	}

	public void practice11() {
		Scanner sc = new Scanner(System.in);
		
		double i1 = 0.4;
		double i2 = 0.0;
		double i3 = 0.15;

		System.out.print("A사원의 연봉 : ");
		int num1 = sc.nextInt();
		double inum1 = num1 + num1 * i1;
		System.out.print("B사원의 연봉 : ");
		int num2 = sc.nextInt();
		double inum2 = num2 + num2 * i2;
		System.out.print("C사원의 연봉 : ");
		int num3 = sc.nextInt();
		double inum3 = num3 + num3 * i3;
		
		System.out.println("A사원 연봉/연봉+a : " + num1 + "/" + inum1);
		System.out.println(inum1 >= 3000 ? "3000 이상" : "3000 미만");
		System.out.println("B사원 연봉/연봉+a : " + num2 + "/" + inum2);
		System.out.println(inum2 >= 3000 ? "3000 이상" : "3000 미만");
		System.out.println("C사원 연봉/연봉+a : " + num3 + "/" + inum3);
		System.out.println(inum3 >= 3000 ? "3000 이상" : "3000 미만");
		
		sc.close();
	}

}
