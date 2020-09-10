package com.kh.example.chap02_control.controller;

import java.util.Scanner;

import com.kh.example.chap02_control.thread.Thread5;

public class InterruptController {

	public void sleepInterrupt() {
		Thread5 th5 = new Thread5();
		Thread thread = new Thread(th5);
		thread.start();

		Scanner sc = new Scanner(System.in);
		System.out.print("�ƹ� ���̳� �Է��ϼ��� : ");
		String input = sc.nextLine();

		System.out.println("�Է��� �� : " + input);
		thread.interrupt();
		
		System.out.println("inInterrupted() : " + thread.isInterrupted());
	}
}
