package com.kh.example.chap04_field.controller;

public class KindsOfVariable { // <== Ŭ���� ������ ����
	// Ŭ���� ������ �ۼ��ϴ� ���� : �ʵ�
	// �ʵ� == ��� ���� == ��� �ʵ� == ���� ����
	private int globalNum; // ��� ����

	public void method1(int num) { // <== �޼ҵ� ������ ����
		int localNum; // ���� ����

//		System.out.println(localNum);
		// The local variable localNum may not have been initialized
		// ���������� ���� �ܿ� �ٽ� ����ϱ� ���ؼ��� �ݵ�� �ʱ�ȭ�� �Ǿ� �־�� �Ѵ�

		System.out.println(num);

		System.out.println(globalNum);
	} // <== �޼ҵ� ������ ��

	public void method2() {
//		System.out.println(localNum); // ���� ������ �ش� ����(��� ��)������ ��� ����
		System.out.println(globalNum);
	}

	
	

} // <== Ŭ���� ������ ��
