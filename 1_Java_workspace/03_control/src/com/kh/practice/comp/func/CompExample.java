package com.kh.practice.comp.func;

import java.util.Scanner;

public class CompExample {

	public void practice1() {
		Scanner sc = new Scanner(System.in);

		System.out.print("���� : ");
		int num = sc.nextInt();

		if (num > 0) {
			for (int i = 1; i <= num; i++) {
				if (i % 2 == 1) {
					System.out.print("��");
				} else {
					System.out.print("��");
				}
			}
		} else {
			System.out.println("����� �ƴմϴ�.");
		}

		sc.close();
	}

	public void practice2() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("���� : ");
			int num = sc.nextInt();

			if (num > 0) {
				for (int i = 1; i <= num; i++) {
					if (i % 2 == 1) {
						System.out.print("��");
					} else {
						System.out.print("��");
					}
				}
				sc.close();
				break;
			} else {
				System.out.println("����� �ƴմϴ�.");
			}
		}
	}

	public void practice3() {
		Scanner sc = new Scanner(System.in);

		System.out.print("���ڿ� : ");
		String text = sc.nextLine();
		System.out.print("���� : ");
		char ch = sc.nextLine().charAt(0);

		int count = 0;

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ch) {
				count++;
			}
		}

		System.out.println(text + " �ȿ� ���Ե� " + ch + " ���� : " + count);

		sc.close();
	}

	public void practice4() {
		Scanner sc = new Scanner(System.in);

		boolean con = true;
		while (con) {
			System.out.print("���ڿ� : ");
			String text = sc.nextLine();
			System.out.print("���� : ");
			char ch = sc.nextLine().charAt(0);

			int count = 0;

			for (int i = 0; i < text.length(); i++) {
				if (text.charAt(i) == ch) {
					count++;
				}
			}

			System.out.println(text + " �ȿ� ���Ե� " + ch + " ���� : " + count);

			while (true) {
				System.out.print("�� �Ͻðڽ��ϱ�?(y/n) : ");
				char ans = sc.nextLine().charAt(0);

				if (ans == 'y' || ans == 'Y') {
					break;
				} else if (ans == 'n' || ans == 'N') {
					con = false;
					break;
				} else {
					System.out.println("�߸��� ����Դϴ�. �ٽ� �Է����ּ���.");
				}
			}

		}

		sc.close();
	}

}
