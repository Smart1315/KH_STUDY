package com.kh.test.controller;

public class TestController {
	public int count = 0;

	public void methodA() {
		printTab();
		System.out.println("methodA() ȣ���...");
		count++;
		
		methodB();
		
		count--;
		printTab();
		System.out.println("methodA() �����...");
		//return
	}

	public void methodB() {
		printTab();
		System.out.println("methodB() ȣ���...");
		count++;
		
		methodC();
		
		count--;
		printTab();
		System.out.println("methodB() �����...");
		//return
	}

	public void methodC() {
		printTab();
		System.out.println("methodC() ȣ���...");
		count++;
		
		// ���� ����
		
		count--;
		printTab();
		System.out.println("methodC() �����...");
		//return
	}

	public void printTab() {
		for (int i = 0; i < count; i++) {
			System.out.print("\t");
		}
		//return
	}
}
