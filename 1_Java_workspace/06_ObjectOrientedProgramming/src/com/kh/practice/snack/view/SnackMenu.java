package com.kh.practice.snack.view;

import java.util.Scanner;

import com.kh.practice.snack.controller.SnackController;

public class SnackMenu {
	private Scanner sc = new Scanner(System.in);
	private SnackController scr = new SnackController();

	public void menu() {
		System.out.println("�������� �Է��ϼ���.");
		System.out.print("���� : "); // String kind, String name, String flavor, int numOf, int price
		String kind = sc.nextLine();
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("�� : ");
		String flavor = sc.nextLine();
		System.out.print("���� : ");
		int numOf = sc.nextInt();
		System.out.print("���� : ");
		int price = sc.nextInt();
		sc.nextLine();

		String result = scr.saveData(kind, name, flavor, numOf, price);

		if (result.equals("����Ϸ�")) {
			System.out.println("���� �Ϸ�Ǿ����ϴ�.");
			char res = 0;
			while (res != 'y' || res != 'n') {
				System.out.print("������ ������ Ȯ���Ͻðڽ��ϱ�?(y/n) : ");
				res = sc.nextLine().toLowerCase().charAt(0);
				if (res == 'y') {
					System.out.println(scr.confirmData());
				} else if (res == 'n') {
					return;
				} else {
					System.out.println("�߸��� �Է��Դϴ� �ٽ� �Է��ϼ���.");
				}
			}
		} else {
			System.out.println("���忡 �����Ͽ����ϴ�.");
		}
	}
}
