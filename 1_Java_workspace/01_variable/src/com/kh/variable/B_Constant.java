package com.kh.variable;

public class B_Constant {
	public void finalConstant() { // ��� �׽�Ʈ
		// ���� �� �ʱ�ȭ : (int)�Ϲݺ��� age, ������� AGE
		int age;
		final int AGE;
		
		age = 20;
		AGE = 20;
		
		System.out.println("age : " + age);
		System.out.println("AGE : " + AGE);
		
		// ������ �� ����
		age = 30;
//		AGE = 25; // The final local variable AGE may already have been assigned
		
		System.out.println("���� �� age : " + age);
		System.out.println("���� �� AGE : " + AGE);
		System.out.println("��� ���� �� �� ��� �� �� ���� �Ұ���");
	}

}
