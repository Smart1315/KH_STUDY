package com.kh.example.view;

import com.kh.example.dto.Task1;
import com.kh.example.dto.Task2;
import com.kh.example.vo.Account;

public class ThreadTestView {

	public void menu() {
		Account acc = new Account("�ȿ���");

		Task1 task1 = new Task1(acc);
		Task2 task2 = new Task2(acc);
		Thread t1 = new Thread(task1, "t1-Thread");
		Thread t2 = new Thread(task2, "t2-Thread");

		t1.start();
		t2.start();
	}
}
