package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice4 {
	
	public void method() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ��� �Է��ϼ��� : ");
		String word = sc.nextLine();
		
		System.out.println("ù ��° ���� : " + word.charAt(0));
		System.out.println("�� ��° ���� : " + word.charAt(1));
		System.out.println("�� ��° ���� : " + word.charAt(2));

		
		sc.close();
	}

}
