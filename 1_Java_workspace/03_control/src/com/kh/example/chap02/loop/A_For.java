package com.kh.example.chap02.loop;

import java.util.Scanner;

public class A_For {
	// for(�ʱ��; ���ǽ�; ������) {
	// 		���� ����;
	// }
	// �ʱ�� -> ���ǽ� -> (���ǽ��� true�� ��)���๮�� ���� -> ������ -> ���ǽ� Ȯ�� -> (�ݺ�)
	// ���ǽ��� ����� false�� �� ������ �ݺ�

	// for�� �ȿ� �ִ� �ʱ��, ���ǽ�, ������ ���� ����
	// �ʱ���� ��������, ������ ��������, ������ �󸶳� �Ǵ��� �Ұ�ȣ ���� �ƴϾ ��򰡿��� ǥ���ؾ���
	// �ᱹ for() �ȿ����� ������ �� ��� �ʿ��� ���

	public void method1() {
		// 1���� 5���� ���

		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "��° �ݺ��� ����");
		}
	}

	public void method1_1() {
		// �ڱ�Ұ� 5�� �ϱ�

		for (int i = 0; i < 5; i++) {
			System.out.println("�� �̸��� �ȿ����.");
		}

	}

	public void method2() {
		// 5���� 1���� ���

//		for(int i = 5; i > 0; i--) {
//			System.out.println(i);
//		}

		for (int i = 0; i < 5; i++) {
			System.out.println(5 - i);
		}
	}

	public void method2_1() {
		// 8���� 3���� ���

		for (int i = 8; i > 2; i--) {
			System.out.print(i + " ");
		}
	}

	public void method3() {
		// 1���� 10 ������ Ȧ���� ���

//		for (int i = 1; i < 11; i++) {
//			if (i % 2 == 1) {
//				System.out.print(i + " ");
//			}
//		}

		for (int i = 1; i < 11; i += 2) {
			System.out.print(i + " ");
		}
	}

	public void method4() {
		// ���� �� ���� �Է¹޾� �� ���� ���� ���

		Scanner sc = new Scanner(System.in);

		System.out.println("���� �� ���� �Է��ϼ���.");
//		System.out.println("��, ù ��° ���ڸ� �� ��° ���ں��� �۰� �Է����ּ���");

		System.out.print("ù ��° ���� : ");
		int start = sc.nextInt();
		System.out.print("�� ��° ���� : ");
		int end = sc.nextInt();

		sc.close();

//		for (; start <= end; start++) {
//			System.out.print(start + " ");
//		}

		int max = 0; // �� ���� �� ū ���ڸ� ������ ����
		int min = 0; // �� ���� �� ���� ���ڸ� ������ ����

		if (start > end) {
			max = start;
			min = end;
		} else {
			max = end;
			min = start;
		}

		for (; min <= max; min++) {
			System.out.print(min + " ");
		}
		
		
	}

	public void method4_1() {
		// ������ �ϳ� �Է� �޾� �� ���� 1~9������ �����϶��� �� ���� ������ ���

		Scanner sc = new Scanner(System.in);

		System.out.print("1~9 ������ ����� �ϳ� �Է��ϼ��� : ");
		int dan = sc.nextInt();

		if (dan >= 1 && dan <= 9) {
			for (int i = 1; i <= 9; i++) {
				System.out.println(dan + " X " + i + " = " + (dan * i));
			}
		} else {
			System.out.println("1~9 ������ ����� �Է��ؾ��մϴ�");
		}

		sc.close();
	}

	public void method5() {
		// 1���� 10 ������ ������ ������ ���� 1���� ���������� ��
		// ���� �� ���� �޼ҵ� : Math.random()
		// 0 �̻� 1 �̸��� �Ǽ��� �������� ��ȯ
		// System.out.println(Math.random());
		// (0 �ܰ�) 0 <= Math.random() < 1 : �Ǽ�
		// (1 �ܰ�) Math.random() * 10 : 0 ~ 9.9999999999
		// (2 �ܰ�) Math.random() * 10 + 1 : 1 ~ 10.99999999999
		// (3 �ܰ� ) (int) (Math.random() * 10 + 1) : 1 ~ 10
		double r = Math.random();
		System.out.println("Math.random() : " + r);

		int random = (int) (r * 10 + 1);
		System.out.println("���� : " + random);
		int sum = 0;

		for (int i = 1; i <= random; i++) {
			sum += i;
		}

		System.out.println("1���� " + random + "������ �� : " + sum);

	}

	public void method6() {
		// ��ø for�� : for�� ���ο� for�� ���
		// 2~9�� ������

		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.print(j + " X " + i + " = " + (j * i) + "\t");
			}
			System.out.println();
		}
	}

	public void method7() {
		// �Ƴ��α� �ð� : 0�� 0�� ~ 23��59�� ���� ���

		for (int i = 0; i <= 23; i++) {
			for (int j = 0; j <= 59; j++) {
				System.out.printf("%2d��%2d��\t", i, j);
			}
			System.out.println();
		}

	}

	public void method8() {
		// �� �ٿ� �� ǥ(*)�� 5�� ��µǴµ� �� ���� ����ڰ� �Է��� �� ��ŭ ���
		// ex
		// ����� �� �� : 3
		// *****
		// *****
		// *****

		Scanner sc = new Scanner(System.in);

		System.out.print("����� �� �� : ");
		int row = sc.nextInt();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		sc.close();
	}

	public void method9() {
		// �� �ٿ� ��ǥ ���ڸ� �Է��� �� ���� ĭ ����ŭ �Է�
		// ��, �� ���� ĭ ���� ��ġ�ϴ� ��ġ���� �� ��ȣ�� ���� ���� ���
		Scanner sc = new Scanner(System.in);

		System.out.print("�� �� : ");
		int row = sc.nextInt();
		System.out.print("ĭ �� : ");
		int col = sc.nextInt();

		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (i != j) {
					System.out.print("*");
				} else {
					System.out.print(i);
				}
			}
			System.out.println();
		}

		sc.close();
	}

}
