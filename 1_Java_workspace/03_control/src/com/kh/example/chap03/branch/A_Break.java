package com.kh.example.chap03.branch;

import java.util.Scanner;

public class A_Break {
	// break���� ���� ����� �ݺ����� Ż��

	public void method1() {
		// ���ڿ��� �Է� �޾� ���� ������ ����ϴ� ���α׷�
		// end�� �ԷµǸ� �ݺ� ����
		// do~while ���

		Scanner sc = new Scanner(System.in);

//		String str = null;
//		do {
//			System.out.print("���ڿ� �Է� : ");
//			str = sc.nextLine();
//
//			System.out.println("���� �� : " + str.length());
//
//		} while (!str.equals("end"));
		
		String str = null;
		do {
			System.out.print("���ڿ� �Է� : ");
			str = sc.nextLine();

			if (str.equals("end")) {
				break;
			}

			System.out.println("���� �� : " + str.length());

		} while (true);

		sc.close();
	}
}
