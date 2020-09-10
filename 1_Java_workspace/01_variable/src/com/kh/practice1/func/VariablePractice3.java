package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice3 {
	
	public void method() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가로 : ");
		double h = sc.nextDouble();
		System.out.print("세로 : ");
		double v = sc.nextDouble();
		
		System.out.println("면적 : " + (h * v));
		System.out.println("둘레 : " + (h + v) * 2);

		sc.close();
	}
}
