package com.kh.variable;

import java.util.Scanner;

public class E_keyboardInput {

	public void input1() {
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("���ϴ� ���� �Է��ϼ��� : ");
//		String value = sc.next(); // ��ȯ�� String
//		
//		System.out.println("���� �Է��� �� : " + value);
		
		System.out.print("�̸��� �Է��ϼ��� : ");
//		String name = sc.next();
		String name = sc.nextLine();
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = sc.nextInt();
		System.out.print("Ű�� �Է��ϼ���(�Ҽ��� ù°�ڸ�����) : ");
		Double height = sc.nextDouble();
		
		System.out.println(name + "���� " + age + "���̸�, Ű�� " + height + "cm �Դϴ�.");
//		System.out.printf("�̸��� %s, ���̴� %d��, Ű�� %.1fcm", name, age, height);
		
		sc.close();
		
	}
	
	public void input2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = sc.nextLine();
		
		System.out.print("���̸� �Է��ϼ��� : ");
//		int age = sc.nextInt();
//		
//		System.out.print("�ּҸ� �Է��ϼ��� : ");
//		String address = sc.nextLine();
		
		// 1. �ּҸ� next()�� �ޱ�
//		String address = sc.next();
		// next() : ���� �Է� �Ұ�, ���⸦ �����ڷ� �ν�
		
		// 2. ���̸� �޴� nextInt()�� �ּҸ� �޴� nextLine() ���̿� nextLint() �߰�
//		sc.nextLine(); // ���ۿ� �����ִ� \n ����
//		String address = sc.nextLine();
		
		// 3. ���̸� ���� �� ���Ͱ� ���� �ʵ��� nextLine()�� �� �� �Ľ�(String �ڷ����� �ٸ� �ڷ������� ����)�ϱ�
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("�ּҸ� �Է��ϼ��� : ");
		String address = sc.nextLine();
		
		System.out.println(name + "���� " + age + "���̸�, �ּҴ� " + address + " �Դϴ�.");
		
		// int -> nextInt()
		// double -> nextDouble()
		// float -> nextFloat()
		// String -> next(), nextLine()
		// boolean -> nextBoolean()
		// char -> System.in.read()
		
		System.out.print("����! ����� ������ �����ΰ���?(M/F) : ");
		String genderStr = sc.nextLine();
		char gender = genderStr.charAt(0);
		System.out.println(gender + "�� �����̶��! ��� ������ϴ�...!!");
		
		sc.close();
	}
}
