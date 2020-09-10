package com.kh.example.exception;

import java.io.IOException;

public class ExceptionTest {
	
	public ExceptionTest() {
		
	}
	
	public void test1() throws IOException {
		try {
			throw new IOException();
		} catch (IOException e) {
			System.out.println("test1에서 오류처리");
		}
	}
	
}
