package com.kh.example.chap01_encapsulation;

public class Run {

	public static void main(String[] args) {
		Account a; // Stack 영역에 Account 객체 생성
		a = new Account(); // Heap 영역에 a객체를 메모리에 할당(인스턴스화)

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
