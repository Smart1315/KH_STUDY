package com.kh.example.chap03_tryCatch.controller;

import java.io.IOException;

public class TryCatchController {

	public void method1() {
		System.out.println("method1() ȣ���...");
		try {
			method2();
			System.out.println("���� ����� �ɱ� �ȵɱ�?");
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception���� ����");
		} finally {
			System.out.println("���� ���ο� ������� ������ ����");
		}
		System.out.println("method1() �����...");
	}

	public void method2() throws IOException {
		System.out.println("method2() ȣ���...");

//		throw new NullPointerException("null�� ���Դ�!!"); 
		// Unchecked Exception�̱� ������ ����ó�� ���ص� ���� �߻� x

		throw new IOException("������ IOException�� �߻��ð���ϴ�.");

//		System.out.println("method2() �����...");
	}
}
