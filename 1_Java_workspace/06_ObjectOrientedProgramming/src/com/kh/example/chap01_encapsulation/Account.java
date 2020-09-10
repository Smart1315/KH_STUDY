package com.kh.example.chap01_encapsulation;

public class Account {
	// �Ӽ��� ����
	private String name = "�ȿ���";
	private String phone = "010-0000-1309";
	private String pwd = "dks1560023";
	private int bankCode = 1234;
	private int balance = 0; // �ܾ�

	// ������� ����
	// �Ա��� ���� �޼ҵ�
	public void deposit(int money) {
		if (money > 0) {
			balance += money;
			System.out.println(name + "���� ���¿� " + money + "���� �ԱݵǾ����ϴ�.");
			displayBalance();
		} else {
			System.out.println("�߸��� �ݾ��� �ԷµǾ����ϴ�.");
		}
	}

	// ����� ���� �޼ҵ�
	public void withdraw(int money) {
		if (money > 0 && money <= balance) {
			balance -= money;
			System.out.println(name + "���� ���¿� " + money + "���� ��ݵǾ����ϴ�.");
			displayBalance();
		} else {
			System.out.println("�߸��� �ݾ��� �ԷµǾ����ϴ�.");
		}
	}

	// �ܾ� ��ȸ�� ���� �޼ҵ�
	public void displayBalance() {
		System.out.println(name + "���� ������ �ܾ��� " + balance + "�� �Դϴ�.");
	}

}
