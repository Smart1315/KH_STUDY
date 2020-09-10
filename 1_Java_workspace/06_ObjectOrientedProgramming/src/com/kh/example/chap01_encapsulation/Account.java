package com.kh.example.chap01_encapsulation;

public class Account {
	// 속성값 설정
	private String name = "안영재";
	private String phone = "010-0000-1309";
	private String pwd = "dks1560023";
	private int bankCode = 1234;
	private int balance = 0; // 잔액

	// 기능정의 설정
	// 입금을 위한 메소드
	public void deposit(int money) {
		if (money > 0) {
			balance += money;
			System.out.println(name + "님의 계좌에 " + money + "원이 입금되었습니다.");
			displayBalance();
		} else {
			System.out.println("잘못된 금액이 입력되었습니다.");
		}
	}

	// 출금을 위한 메소드
	public void withdraw(int money) {
		if (money > 0 && money <= balance) {
			balance -= money;
			System.out.println(name + "님의 계좌에 " + money + "원이 출금되었습니다.");
			displayBalance();
		} else {
			System.out.println("잘못된 금액이 입력되었습니다.");
		}
	}

	// 잔액 조회를 위한 메소드
	public void displayBalance() {
		System.out.println(name + "님의 계좌의 잔액은 " + balance + "원 입니다.");
	}

}
