package com.kh.example.chap02.loop;

import java.util.Scanner;

public class C_DoWhile {

	public void method1() {
		// Ű����� ���ڿ� ���� �Է¹޾� ��� �ݺ� ����
		// exit�� ���� ������ �ݺ�
		Scanner sc = new Scanner(System.in);

		// 1. while
//		String str = ""; // null�� ���·� ����Ϸ��� �ϸ� NullPointerException�� �߻� �� �� ����
//		while (!str.toLowerCase().equals("exit")) {
//			System.out.print("���ڿ� �Է� : ");
//			str = sc.nextLine();
//			System.out.println("���� �Է��� ���ڿ� : " + str);
//			
//		}

		// 2. do ~ while
		String str = null; // null�̾ str�� ������ �� �� String �޼ҵ带 ����ϹǷ� ������ �߻����� ����
		do {
			System.out.print("���ڿ� �Է� : ");
			str = sc.nextLine();

			System.out.println("���� �Է��� ���ڿ� : " + str);

		} while (!str.toLowerCase().equals("exit"));

		sc.close();
	}

}
