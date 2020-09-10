package com.kh.example.chap02.loop;

import java.util.Scanner;

public class B_While {
	// while(���ǽ�) {
	// 		���๮��;
	// 		[������ or �б⹮];
	// }
	// ���ǽ� Ȯ�� -> (���ǽ��� true�� ��) ���๮�� ���� -> ���ǽ� Ȯ�� -> (�ݺ�)
	// ���ǽ��� ����� false�� �� ������ �ݺ�

	public void method1() {
		// 1���� 5���� ���

		int i = 1;

		while (i <= 5) {
			System.out.println(i);
			i++;
		}
	}

	public void method1_1() {
		// �ڱ�Ұ� 5�� �ϱ�

		int i = 0;

		while (i < 5) {
			System.out.println("�� �̸��� �ȿ����.");
			i++;
		}
	}

	public void method2() {
		// 5���� 1���� ����ϱ�

		int i = 5;

		while (i > 0) {
			System.out.println(i--);
		}
	}

	public void method2_1() {
		// 8���� 3���� ���
		int i = 8;

		while (i >= 3) {
			System.out.println(i--);
		}
	}

	public void method3() {
		// 1���� 10 ������ Ȧ���� ���
		int i = 1;

		while (i <= 10) {
			System.out.println(i);
			i += 2;
		}
	}

	public void method4() {
		// ���� �� ���� �Է¹޾� �� ���� ���� ���
		Scanner sc = new Scanner(System.in);

		System.out.println("���� �� ���� �Է��ϼ���.");

		System.out.print("ù ��° ���� : ");
		int start = sc.nextInt();
		System.out.print("�� ��° ���� : ");
		int end = sc.nextInt();

		int max = 0; // �� ���� �� ū ���ڸ� ������ ����
		int min = 0; // �� ���� �� ���� ���ڸ� ������ ����

		if (start > end) {
			max = start;
			min = end;
		} else {
			max = end;
			min = start;
		}

		while (min <= max) {
			System.out.print((min++) + " ");
		}

		sc.close();
	}

	public void method4_1() {
		// ������ �ϳ� �Է� �޾� �� ���� 1~9������ �����϶��� �� ���� ������ ���

		Scanner sc = new Scanner(System.in);

		System.out.print("1~9 ������ ����� �ϳ� �Է��ϼ��� : ");
		int dan = sc.nextInt();

		if (dan >= 1 && dan <= 9) {
			int i = 1;
			while (i <= 9) {
				System.out.println(dan + " X " + i + " = " + (dan * i++));
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

		double r = Math.random();
		System.out.println("Math.random() : " + r);

		int random = (int) (r * 10 + 1);
		System.out.println("���� : " + random);
		int sum = 0;

		int i = 1;
		while (i <= random) {
			sum += i++;
		}

		System.out.println("1���� " + random + "������ �� : " + sum);

	}

	public void method6() {
		// ���ڿ��� �Է� �޾� �ε��� ���� ���� ���

		Scanner sc = new Scanner(System.in);

		System.out.print("���ڿ� �Է� : ");
		String str = sc.nextLine();

		System.out.println("���� �Է��� ���ڿ� : " + str);

		int i = 0;
		// String Ŭ������ length() �޼ҵ� : ���ڿ��� ���� ��ȯ(int)
		while (i < str.length()) {
			System.out.println(i + " : " + str.charAt(i++));
		}

		sc.close();

	}

	public void method7() {
		// ��ø while�� : while�� ���ο� while�� ���
		// 2~9�� ������

		int i = 1;
		while (i <= 9) {
			int j = 2;
			while (j <= 9) {
				System.out.print(j + " X " + i + " = " + (j * i) + "\t");
				j++;
			}
			System.out.println();
			i++;
		}

	}

	public void method8() {
		// �Ƴ��α� �ð� : 0�� 0�� ~ 23��59�� ���� ���

		int hour = 0;
		while (hour <= 23) {
			int min = 0;
			while (min <= 59) {
				System.out.printf("%02d��%02d��\t", hour, min);
				min++;
			}
			System.out.println();
			hour++;
		}
	}

	public void method9() {
		// �� �ٿ� �� ǥ(*)�� 5�� ��µǴµ� �� ���� ����ڰ� �Է��� �� ��ŭ ���

		Scanner sc = new Scanner(System.in);

		System.out.print("����� �� �� : ");
		int row = sc.nextInt();

		int i = 0;
		while (i < row) {
			int j = 0;
			while (j < 5) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}

		sc.close();
	}

	public void method10() {
		// �� �ٿ� ��ǥ ���ڸ� �Է��� �� ���� ĭ ����ŭ �Է�
		// ��, �� ���� ĭ ���� ��ġ�ϴ� ��ġ���� �� ��ȣ�� ���� ���� ���

		Scanner sc = new Scanner(System.in);

		System.out.print("�� �� : ");
		int row = sc.nextInt();
		System.out.print("ĭ �� : ");
		int col = sc.nextInt();

		int i = 1;
		while (i <= row) {
			int j = 1;
			while (j <= col) {
				if (i != j) {
					System.out.print("*");
				} else {
					System.out.print(i);
				}
				j++;
			}
			System.out.println();
			i++;
		}

		sc.close();
	}

	public void method11() {
		Scanner sc = new Scanner(System.in);

		int menu = 0;
//		while (menu != 9) {
//
//			System.out.println("1. 1~5 ���");
//			System.out.println("2. 5~1 ���");
//			System.out.println("3. 1~10���� Ȧ�� ���");
//			System.out.println("9. ����");
//			System.out.print("�޴� ��ȣ : ");
//			menu = sc.nextInt();
//
//			switch (menu) {
//			case 1:
//				method1();
//				break;
//			case 2:
//				method2();
//				break;
//			case 3:
//				method3();
//				break;
//			case 9:
//				System.out.println("�����մϴ�.");
//				break;
//			default:
//				System.out.println("�Է� ����");
//				break;
//			}
//		}
		
		
		do {
			System.out.println("1. 1~5 ���");
			System.out.println("2. 5~1 ���");
			System.out.println("3. 1~10 �� Ȧ�� ���");
			System.out.println("9. ����");
			System.out.print("�޴� ���� : ");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				method1();
				break;
			case 2:
				method2();
				break;
			case 3:
				method3();
				break;
			case 9:
				System.out.println("�����մϴ�.");
				sc.close();
				return;
			default:
				System.out.println("�Է� ����");
				break;
			}

		} while (menu != 9);

		sc.close();
	}

	public void method12() {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("1. 1~5 ���");
			System.out.println("2. 5~1 ���");
			System.out.println("3. 1~10 �� Ȧ�� ���");
			System.out.println("9. ����");
			System.out.print("�޴� ���� : ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				method1();
				break;
			case 2:
				method2();
				break;
			case 3:
				method3();
				break;
			case 9:
				System.out.println("�����մϴ�.");
				sc.close();
				return;
			default:
				System.out.println("�Է� ����");
				break;
			}
			
		}

	}
}
