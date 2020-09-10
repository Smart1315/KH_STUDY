package com.kh.example.chap04_user.controller;

import java.util.Scanner;

import com.kh.example.chap04_user.model.exception.MyException;

public class MyExceptionController {

	public void inputAge() {
		Scanner sc = new Scanner(System.in);

		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		sc.nextLine();

		try {
			checkAge(age);
		} catch (MyException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public void checkAge(int age) throws MyException {
		if (age < 19) {
			throw new MyException("만 19세 미만은 입장이 불가합니다.");
		} else {
			System.out.println("즐거운 관람 되세요^^");
		}
	}
}
