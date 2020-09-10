package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice4 {
	
	public void method() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열을 입력하세요 : ");
		String word = sc.nextLine();
		
		System.out.println("첫 번째 문자 : " + word.charAt(0));
		System.out.println("두 번째 문자 : " + word.charAt(1));
		System.out.println("세 번째 문자 : " + word.charAt(2));

		
		sc.close();
	}

}
