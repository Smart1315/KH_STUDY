package com.kh.practice2.func;

import java.util.Scanner;

public class CastingPractice2 {
	
	public void method() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		double a = sc.nextDouble();
		System.out.print("���� : ");
		double b = sc.nextDouble();
		System.out.print("���� : ");
		double c = sc.nextDouble();
		
		System.out.println("���� : " + (int) (a + b + c));
		System.out.println("��� : " + (int) ((a + b + c) / 3));
		
		sc.close();
		
	}

}
