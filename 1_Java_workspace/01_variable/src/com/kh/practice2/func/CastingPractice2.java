package com.kh.practice2.func;

import java.util.Scanner;

public class CastingPractice2 {
	
	public void method() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("±¹¾î : ");
		double a = sc.nextDouble();
		System.out.print("¿µ¾î : ");
		double b = sc.nextDouble();
		System.out.print("¼öÇÐ : ");
		double c = sc.nextDouble();
		
		System.out.println("ÃÑÁ¡ : " + (int) (a + b + c));
		System.out.println("Æò±Õ : " + (int) ((a + b + c) / 3));
		
		sc.close();
		
	}

}
