package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice3 {
	
	public void method() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		double h = sc.nextDouble();
		System.out.print("���� : ");
		double v = sc.nextDouble();
		
		System.out.println("���� : " + (h * v));
		System.out.println("�ѷ� : " + (h + v) * 2);

		sc.close();
	}
}
