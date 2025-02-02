package com.kh.hw.controller;

import java.util.Scanner;

public class Function {

	public void calculator() {
		Scanner sc = new Scanner(System.in);

		System.out.print("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 : ");
		int num2 = sc.nextInt();
		sc.nextLine();
		System.out.print("연산자(+, -, x, /) : ");
		char op = sc.nextLine().charAt(0);

		int res = 0;

		switch (op) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num1 - num2;
			break;
		case 'x':
		case 'X':
			res = num1 * num2;
			break;
		case '/':
			if (num2 == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
				res = 0;
				break;
			}
			res = num1 / num2;
			if (res == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
				break;
			}
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			return;
		}

		System.out.println(num1 + " " + op + " " + num2 + " = " + res);

	}

	public void totalCalculator() {
		Scanner sc = new Scanner(System.in);

		System.out.print("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 : ");
		int num2 = sc.nextInt();

		if (num1 > num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		int res = 0;
		for (int i = num1; i <= num2; i++) {
			res += i;
		}

		System.out.println(num1 + "부터 " + num2 + "까지 정수들의 합 : " + res);
	}

	public void printProfile() {
		Scanner sc = new Scanner(System.in);

		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("성별 : ");
		String gender = sc.nextLine();
		System.out.print("성격 : ");
		String chr = sc.nextLine();

		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("성별 : " + gender);
		System.out.println("성격 : " + chr);

	}

	public void printScore() {
		Scanner sc = new Scanner(System.in);

		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("반 : ");
		int group = sc.nextInt();
		System.out.print("번 : ");
		int num = sc.nextInt();
		sc.nextLine();
		System.out.print("성별(M/F) : ");
		char gender = sc.nextLine().charAt(0);

		if (gender == 'M' || gender == 'm') {
			gender = '남';
		} else if (gender == 'F' || gender == 'f') {
			gender = '여';
		} else {
			System.out.println("성별 입력 오류");
			return;
		}

		System.out.print("성적 : ");
		double score = sc.nextDouble();

		char grades;

		if (score >= 90) {
			grades = 'A';
		} else if (score >= 80) {
			grades = 'B';
		} else if (score >= 70) {
			grades = 'C';
		} else if (score >= 60) {
			grades = 'D';
		} else {
			grades = 'F';
		}

//		System.out.printf("%d학년 %d반 %d번 %c학생 %s의 점수는 %.2f이고 %c학점입니다.\n", grade, group, num, gender, name, score, grades);
		System.out.println(grade + "학년 " + group + "반 " + num + "번 " + gender + "학생 " + name + "의 점수는 " + score + "이고 " + grades + "학점입니다.");
	}

	public void printStarNumber() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 : ");
		int num = sc.nextInt();

		if (num < 1) {
			System.out.println("양수가 아닙니다.");
			return;
		}

		for (int i = 0; i < num; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j) {
					System.out.print(i + 1);
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

	}

	public void sumRandom() {
		int rand = (int) (Math.random() * 100) + 1;

		int total = 0;
		for (int i = 1; i <= rand; i++) {
			total += i;
		}

		System.out.println("1부터 " + rand + "까지의 합 : " + total);
	}

	public void exceptGugu() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 : ");
		int num = sc.nextInt();

		if (num < 1) {
			System.out.println("양수가 아닙니다.");
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (i % num == 0) {
				continue;
			}
			System.out.println(num + " * " + i + " = " + (num * i));
		}
	}

	public void diceGame() {
		Scanner sc = new Scanner(System.in);

		int dice1 = (int) (Math.random() * 6) + 1;
		int dice2 = (int) (Math.random() * 6) + 1;
		int total = dice1 + dice2;

		int ans = -1;
		while (true) {
			System.out.print("주사위 두 개의 합을 맞춰보세요(1~12입력) : ");
			ans = sc.nextInt();

			if (ans == total) {
				sc.nextLine();

				System.out.println("정답입니다.");
				System.out.println("주사위의 합 : " + total);

				char a = '뷁';
				while (a != 'y' || a != 'Y' || a != 'n' || a != 'N') {
					System.out.print("계속 하시겠습니까?(y/n) : ");
					a = sc.nextLine().charAt(0);

					if (a == 'y' || a == 'Y') {
						dice1 = (int) (Math.random() * 6) + 1;
						dice2 = (int) (Math.random() * 6) + 1;
						total = dice1 + dice2;
						ans = -1;
						break;
					} else if (a == 'n' || a == 'N') {
						System.out.println("종료합니다.");
						return;
					} else {
						System.out.println("잘못된 입력입니다.");
					}
				}
			} else {
				System.out.println("틀렸습니다.");
			}
		}
	}
}
