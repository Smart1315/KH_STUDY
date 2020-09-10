package com.kh.example.view;

import java.util.Scanner;

import com.kh.example.dao.ConvertString;

public class ConvertView {
	private Scanner sc = new Scanner(System.in);

	public void menu() {
		do {
			System.out.print("���ڿ� �Է� : ");
			String input = sc.nextLine();

			if (input.equalsIgnoreCase("exit")) {
				sc.close();
				break;
			}

			try {
				System.out.println("�����ڵ� ��ȯ : " + ConvertString.convertUnicode(input));
				System.out.println("String ��ȯ : " + ConvertString.convertString(input));
			} catch (Exception e) {
				System.out.print("Error : ");
				System.out.println(e.getMessage());
			}

		} while (true);
	}
}
