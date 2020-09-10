package com.kh.example.chap01.condition;

import java.util.Scanner;

public class B_IfElse {
	// if-else��
	// if(���ǽ�) {
	// 		������ ����1;
	// } else {
	// 		������ ����2;
	// }
	// �� �� �� ���� �����ϴ� ���ǹ�
	// ���ǽ��� ��� ���� ��(true)�̸� if �ȿ� �ִ� ���� ����1 ����
	// ���ǽ��� ��� ���� ����(false)�̸� else �ȿ� �ִ� ���� ����2 ����
	// ==> ������ ���� ���� ������ ��쿡 �����ϴ� ����� ���� �ۼ��ϴ� ��� ���

	public void method1() {
		// �Է��� ���ڰ� ������� �������� ���
		Scanner sc = new Scanner(System.in);

		System.out.print("���� �� ���� �Է� : ");
		int num = sc.nextInt();

		if (num > 0) {
			System.out.println("����Դϴ�.");
		} else {
			// ����, 0
//			System.out.println("�Է��Ͻ� ���ڴ� ����� �ƴմϴ�.");
			if (num == 0) {
				System.out.println("0 �Դϴ�.");
			} else {
				System.out.println("�����Դϴ�.");
			}
		}

		sc.close();
	}

	public void method2() {
		// �Է��� ���ڰ� ¦������ Ȧ������ ���
		Scanner sc = new Scanner(System.in);

		System.out.print("���� �� ���� �Է��ϼ��� : ");
		int num = sc.nextInt();

		if (num % 2 == 0) {
			System.out.println("¦���Դϴ�.");
		} else {
			System.out.println("Ȧ���Դϴ�.");
		}

		sc.close();
	}

	public void method3() {
		// �Է��� ���ڰ� 1~10 ������ �������� Ȯ��
		Scanner sc = new Scanner(System.in);

		System.out.print("���� �� ���� �Է� : ");
		int num = sc.nextInt();

		if (num >= 1 && num <= 10) {
			System.out.println("1~10 ������ ����");
		} else {
			System.out.println("1~10 ������ ���ڰ� �ƴ�");
		}

		sc.close();
	}

	public void method4() {
		// ���ڿ� ���ϱ�
		Scanner sc = new Scanner(System.in);

		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = sc.nextLine();

		if (name.equals("�ȿ���")) {
			System.out.println("�����Դϴ�.");
		} else {
			System.out.println("������ �ƴմϴ�.");
		}

		sc.close();
	}

}
