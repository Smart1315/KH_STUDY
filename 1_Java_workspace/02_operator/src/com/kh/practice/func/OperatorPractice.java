package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {

	public void practice1() {
		Scanner sc = new Scanner(System.in);

		System.out.print("���� : ");
		int num = sc.nextInt();

		System.out.println(0 < num ? "�����" : "����� �ƴϴ�");

		sc.close();
	}

	public void parctice2() {
		Scanner sc = new Scanner(System.in);

		System.out.print("���� : ");
		int num = sc.nextInt();

		System.out.println(0 < num ? "�����" : (num == 0 ? "0�̴�" : "������"));

		sc.close();
	}

	public void practice3() {
		Scanner sc = new Scanner(System.in);

		System.out.print("���� : ");
		int num = sc.nextInt();

		System.out.println(num % 2 == 0 ? "¦����" : "Ȧ����");

		sc.close();
	}

	public void practice4() {
		Scanner sc = new Scanner(System.in);

		System.out.print("�ο� �� : ");
		int num1 = sc.nextInt();
		System.out.print("���� ���� : ");
		int num2 = sc.nextInt();

		System.out.println("1�δ� ���� ���� : " + (num2 / num1));
		System.out.println("���� ���� ���� : " + (num2 % num1));

		sc.close();
	}

	public void practice5() {
		Scanner sc = new Scanner(System.in);

		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("�г�(���ڸ�) : ");
		int grade = sc.nextInt();
		System.out.print("��(���ڸ�) : ");
		int group = sc.nextInt();
		System.out.print("��ȣ(���ڸ�) : ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("����(M/F) : ");
		char g = sc.nextLine().charAt(0);
		String gender = g == 'M' ? "���л�" : (g == 'F' ? "���л�" : "�л�");
		System.out.print("����(�Ҽ��� �Ʒ� ��°�ڸ�����) : ");
		double score = sc.nextDouble();

		System.out
				.println(grade + "�г� " + group + "�� " + number + "�� " + name + " " + gender + "�� ������ " + score + "�̴�.");

		sc.close();

	}

	public void practice6() {
		Scanner sc = new Scanner(System.in);

		System.out.print("���� : ");
		int age = sc.nextInt();

		String result = age <= 13 ? "���" : (age <= 19 ? "û�ҳ�" : "����");

		System.out.println(result);

		sc.close();
	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);

		System.out.print("���� : ");
		int num1 = sc.nextInt();
		System.out.print("���� : ");
		int num2 = sc.nextInt();
		System.out.print("���� : ");
		int num3 = sc.nextInt();

		int result1 = num1 + num2 + num3;
		double result2 = result1 / 3.0;
		String result3 = 40 <= num1 && 40 <= num2 && 40 <= num3 && 60.0 <= result2 ? "�հ�" : "���հ�";
		System.out.println("�հ� : " + result1);
		System.out.println("��� : " + result2);
		System.out.println(result3);

		sc.close();
	}

	public void practice8() {
		Scanner sc = new Scanner(System.in);

		System.out.print("�ֹι�ȣ�� �Է��ϼ���(- ����) : ");
		String number = sc.nextLine();

		int num = number.charAt(7) - '0';
		System.out.println(num % 2 == 1 ? "����" : "����");

		sc.close();
	}

	public void practice9() {
		Scanner sc = new Scanner(System.in);

		System.out.print("����1 : ");
		int num1 = sc.nextInt();
		System.out.print("����2 : ");
		int num2 = sc.nextInt();
		System.out.print("�Է� : ");
		int num3 = sc.nextInt();

		boolean result = num3 <= num1 || num2 < num3;

		System.out.println(result);

		sc.close();
	}

	public void practice10() {
		Scanner sc = new Scanner(System.in);

		System.out.print("�Է�1 : ");
		int num1 = sc.nextInt();
		System.out.print("�Է�2 : ");
		int num2 = sc.nextInt();
		System.out.print("�Է�3 : ");
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

		System.out.print("A����� ���� : ");
		int num1 = sc.nextInt();
		double inum1 = num1 + num1 * i1;
		System.out.print("B����� ���� : ");
		int num2 = sc.nextInt();
		double inum2 = num2 + num2 * i2;
		System.out.print("C����� ���� : ");
		int num3 = sc.nextInt();
		double inum3 = num3 + num3 * i3;
		
		System.out.println("A��� ����/����+a : " + num1 + "/" + inum1);
		System.out.println(inum1 >= 3000 ? "3000 �̻�" : "3000 �̸�");
		System.out.println("B��� ����/����+a : " + num2 + "/" + inum2);
		System.out.println(inum2 >= 3000 ? "3000 �̻�" : "3000 �̸�");
		System.out.println("C��� ����/����+a : " + num3 + "/" + inum3);
		System.out.println(inum3 >= 3000 ? "3000 �̻�" : "3000 �̸�");
		
		sc.close();
	}

}
