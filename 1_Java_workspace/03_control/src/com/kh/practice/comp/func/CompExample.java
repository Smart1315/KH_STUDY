package com.kh.practice.comp.func;

import java.util.Scanner;

public class CompExample {

	public void practice1() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 : ");
		int num = sc.nextInt();

		if (num > 0) {
			for (int i = 1; i <= num; i++) {
				if (i % 2 == 1) {
					System.out.print("박");
				} else {
					System.out.print("수");
				}
			}
		} else {
			System.out.println("양수가 아닙니다.");
		}

		sc.close();
	}

	public void practice2() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("정수 : ");
			int num = sc.nextInt();

			if (num > 0) {
				for (int i = 1; i <= num; i++) {
					if (i % 2 == 1) {
						System.out.print("박");
					} else {
						System.out.print("수");
					}
				}
				sc.close();
				break;
			} else {
				System.out.println("양수가 아닙니다.");
			}
		}
	}

	public void practice3() {
		Scanner sc = new Scanner(System.in);

		System.out.print("문자열 : ");
		String text = sc.nextLine();
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);

		int count = 0;

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ch) {
				count++;
			}
		}

		System.out.println(text + " 안에 포함된 " + ch + " 개수 : " + count);

		sc.close();
	}

	public void practice4() {
		Scanner sc = new Scanner(System.in);

		boolean con = true;
		while (con) {
			System.out.print("문자열 : ");
			String text = sc.nextLine();
			System.out.print("문자 : ");
			char ch = sc.nextLine().charAt(0);

			int count = 0;

			for (int i = 0; i < text.length(); i++) {
				if (text.charAt(i) == ch) {
					count++;
				}
			}

			System.out.println(text + " 안에 포함된 " + ch + " 개수 : " + count);

			while (true) {
				System.out.print("더 하시겠습니까?(y/n) : ");
				char ans = sc.nextLine().charAt(0);

				if (ans == 'y' || ans == 'Y') {
					break;
				} else if (ans == 'n' || ans == 'N') {
					con = false;
					break;
				} else {
					System.out.println("잘못된 대답입니다. 다시 입력해주세요.");
				}
			}

		}

		sc.close();
	}

}
