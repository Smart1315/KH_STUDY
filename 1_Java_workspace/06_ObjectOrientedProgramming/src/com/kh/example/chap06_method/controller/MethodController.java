package com.kh.example.chap06_method.controller;

import com.kh.example.chap05_constructor.model.vo.User;

public class MethodController {
	// �Ű����� ������ ��ȯ �� ������ ���� ����
	// 1. �Ű����� ���� ��ȯ�� ���� �޼ҵ�
	public void method1() {
		// ��ȯ��X �Ű�����X
		// �޼ҵ� ���븸 ���� �� �ƹ� ���� ��ȯ���� �ʰ�(���� �� ����)
		// ȣ���� �޼ҵ�� ���ư�
		System.out.println("�Ű������� ��ȯ �� �� �� ���� �޼ҵ��Դϴ�.");
//		return;
	}

	// 2. �Ű����� ���� ��ȯ�� �ִ� �޼ҵ�
	public int method2() {
		// ��ȯ��O �Ű�����X
//		int i = 0;
//		return i;

		return 0;
	}

	// 3. �Ű����� �ְ� ��ȯ�� ���� �޼ҵ�
	public void method3(int a, int b) {
		// ��ȯ��X �Ű�����O
		int result = a + b;

		System.out.println(result);
	}

	// 4. �Ű����� �ְ� ��ȯ�� �ִ� �޼ҵ�
	public int method4(int a, int b) {
//		int result = a + b;
//		return result;
		return a + b;
	}

	// ��ȯ���� �迭�� ���
	public int[] method5() {
		int[] iArr = { 1, 2, 3, 4, 5 };
		System.out.println("MethodController iArr : " + iArr);

		for (int i = 0; i < iArr.length; i++) {
			iArr[i] *= 10;
		}

		return iArr;
	}

	// ��ȯ���� Ŭ������ ���
	public User method6() {
		User user = new User("user01", "pass01", "ȫ�浿");
		System.out.println("MethodController user : " + user);

		return user;

	}
}
