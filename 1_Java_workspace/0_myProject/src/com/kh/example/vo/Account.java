package com.kh.example.vo;

public class Account {
	private int balance = 1000;
	private String name;

	public Account(String name) {
		this.name = name;
	}

	public void deposit(int money) {
		if (money > 0) {
			try {
				Thread thread = Thread.currentThread();
				System.out.println(thread.getName() + " 입금 금액 ->> " + money);
				balance += money;
				System.out.println(name + " balance: " + balance);
				Thread.sleep(100);
			} catch (Exception e) {

			}
		} else {
			System.out.println("잘못된 금액이 입력되었습니다.");
		}
	}

	public void withDraw(int money) {

		if (money > 0 && money <= balance) {
			try {
				Thread thread = Thread.currentThread();
				System.out.println(thread.getName() + " 출금 금액 ->> " + money);
				balance -= money;
				System.out.println(name + " balance: " + balance);
				Thread.sleep(100);
			} catch (Exception e) {

			}

		}
	}

	public int getBalance() {
		return balance;
	}
}