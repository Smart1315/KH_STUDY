package com.kh.example.chap03_tryCatch.controller;

import java.io.IOException;

public class TryCatchController {

	public void method1() {
		System.out.println("method1() 호출됨...");
		try {
			method2();
			System.out.println("나는 출력이 될까 안될까?");
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception으로 잡음");
		} finally {
			System.out.println("예외 여부와 상관없이 무조건 수행");
		}
		System.out.println("method1() 종료됨...");
	}

	public void method2() throws IOException {
		System.out.println("method2() 호출됨...");

//		throw new NullPointerException("null이 들어왔다!!"); 
		// Unchecked Exception이기 때문에 예외처리 안해도 오류 발생 x

		throw new IOException("강제로 IOException을 발생시겼습니다.");

//		System.out.println("method2() 종료됨...");
	}
}
