package com.kh.example.chap01_encapsulation;

public class Run {

	public static void main(String[] args) {
		Account a; // Stack ������ Account ��ü ����
		a = new Account(); // Heap ������ a��ü�� �޸𸮿� �Ҵ�(�ν��Ͻ�ȭ)

		a.displayBalance();

		a.deposit(1000000);
		a.deposit(1500000);

		a.withdraw(500000);

//		a.balance -= 2000000;
		// The field Account.balance is not visible
		
		a.withdraw(500000);
		a.displayBalance();
	}

}
