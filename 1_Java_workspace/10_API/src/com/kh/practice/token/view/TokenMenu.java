package com.kh.practice.token.view;

import java.util.Scanner;

import com.kh.practice.token.controller.TokenController;

public class TokenMenu {
	private Scanner sc = new Scanner(System.in);
	private TokenController tc = new TokenController();

	public void mainMenu() {
		while (true) {
			System.out.println("1. ���� ���ڿ�");
			System.out.println("2. �Է� ���ڿ�");
			System.out.println("9. ���α׷� ������");
			System.out.print("�޴� ���� : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				tokenMenu();
				break;
			case 2:
				inputMenu();
				break;
			case 9:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
				break;
			}
		}
	}

	public void tokenMenu() {
		String str = "J a v a P r o g r a m ";
		System.out.println("��ū ó�� �� ���� : " + str);
		System.out.println("��ū ó�� �� ���� : " + str.length());
		str = tc.afterToken(str);
		System.out.println("��ū ó�� �� ���� : " + str);
		System.out.println("��ū ó�� �� ���� : " + str.length());
		System.out.println("��� �빮�ڷ� ��ȯ : " + str.toUpperCase());
	}

	public void inputMenu() {
		System.out.print("���ڿ��� �Է��ϼ��� : ");
		String input = sc.nextLine();
		System.out.println("ù ���� �빮�� : " + tc.firstCap(input));
		System.out.print("ã�� ���� �ϳ��� �Է��ϼ��� : ");
		char one = sc.nextLine().charAt(0);
		System.out.println(one + " ���ڰ� �� ���� : " + tc.findChar(input, one));
	}
}
