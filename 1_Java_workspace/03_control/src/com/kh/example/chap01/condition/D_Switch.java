package com.kh.example.chap01.condition;

import java.util.Scanner;

public class D_Switch {
	// ���ǽ��� ��� ���� case���� ã�� ����� �����ϴ� ���ǹ�
	// �ش��ϴ� ���� case�� ���� ��쿡�� default�� ��ɹ� ����

	// case�� ���๮ ���̿��� �ݷ�(:)�� ��� ��
	// break�� ������ ������ �ʰ� ��� ����

	// switch(����) {
	// case ��1: ���๮1; break;
	// case ��2: ���๮2; break;
	// default: ���๮3;
	// }

	public void method1() {
		// ���� �� ���� �����ȣ ���� 1���� �Է¹޾�
		// ���� ��ȣ ���ڿ� �ش��ϴ� ����� �����ϰ� ����Ͻÿ�
		Scanner sc = new Scanner(System.in);

		System.out.print("ù ��° �� : ");
		int first = sc.nextInt();
		System.out.print("�� ��° �� : ");
		int second = sc.nextInt();

		sc.nextLine();
		System.out.print("������(+, -, *, /) : ");
		char op = sc.nextLine().charAt(0);

		int result = 0;

		switch (op) {
		case '+':
			result = first + second;
			break;
		case '-':
			result = first - second;
			break;
		case '*':
			result = first * second;
			break;
		case '/':
			result = first / second;
			break;

		default:
			System.out.println("�Է� ����");
			break;
		}

		System.out.println(result);

		sc.close();
	}

	public void method2() {
		Scanner sc = new Scanner(System.in);

		System.out.println("***********���ϰ���***********");
		System.out.println("���, �ٳ��� , ������, Ű�� �ֽ��ϴ�.");
		System.out.print("� ������ ������ �ñ��ϼ���? : ");
		String fruit = sc.nextLine();

		int price = 0;

		switch (fruit) {
		case "���":
			price = 1000;
			break;
		case "�ٳ���":
			price = 3000;
			break;
		case "������":
			price = 2000;
			break;
		case "Ű��":
			price = 5000;
			break;
		default:
			System.out.println("�� ������ ������� �ʽ��ϴ�.");
			break;
		}

		System.out.println(fruit + "�� ������ " + price + "�� �Դϴ�.");

		sc.close();
	}

	public void method3() {
		// 1������ 12������ �Է¹޾� �ش��ϴ� ���� ������ ��¥�� ����ϼ���
		Scanner sc = new Scanner(System.in);

		System.out.print("1��~12������ �� �ϳ��� �Է��ϼ��� : ");
		int num = sc.nextInt();


//		switch (num) {
//		case 1:
//			System.out.println("31�� �����Դϴ�.");
//			break;
//		case 2:
//			System.out.println("28�� �����Դϴ�.");
//			break;
//		case 3:
//			System.out.println("31�� �����Դϴ�.");
//			break;
//		case 4:
//			System.out.println("30�� �����Դϴ�.");
//			break;
//		case 5:
//			System.out.println("31�� �����Դϴ�.");
//			break;
//		case 6:
//			System.out.println("30�� �����Դϴ�.");
//			break;
//		case 7:
//			System.out.println("31�� �����Դϴ�.");
//			break;
//		case 8:
//			System.out.println("31�� �����Դϴ�.");
//			break;
//		case 9:
//			System.out.println("30�� �����Դϴ�.");
//			break;
//		case 11:
//			System.out.println("30�� �����Դϴ�.");
//			break;
//		case 10:
//			System.out.println("31�� �����Դϴ�.");
//			break;
//		case 12:
//			System.out.println("31�� �����Դϴ�.");
//			break;
//		default:
//			System.out.println("�Է� ����");
//			break;
//		}

		switch (num) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("31�� �����Դϴ�.");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30�� �����Դϴ�.");
			break;
		case 2:
			System.out.println("28�� �����Դϴ�.");
			break;
		default:
			System.out.println("�Է� ����");
			break;
		}

		sc.close();
	}
	
	public void method4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("***** GŬ���� �츮�� �޴��Դϴ�. *****");
		System.out.println("1. �����ϰ� ����ϱ�");
		System.out.println("2. ���� ����");
		System.out.println("3. ���� ������ �� ���");
		System.out.print("�޴� ��ȣ : ");
		int menu = sc.nextInt();
		
		switch (menu) {
		case 1:
			System.out.println("���� ���");
			method1();
			break;
		case 2:
			System.out.println("���� ����");
			method2();
			break;
		case 3:
			System.out.println("���� ��������");
			method3();
			break;
		default:
			System.out.println("�Է� ����");
			break;
		}
		
		sc.close();
	}
}
