package com.kh.example.dto;

import com.kh.example.vo.Account;

public class Task1 implements Runnable {
	Account acc;

	public Task1(Account acc) {
		this.acc = acc;
	}

	@Override
	public void run() {
		while (acc.getBalance() > 0) {
			// 100, 200, 300 ���� �� ���� ���Ƿ� �����ؼ� ���(withDraw)�Ѵ�.
			int money = (int) (Math.random() * 3 + 1) * 100;
			acc.withDraw(money);

		}
	}
}