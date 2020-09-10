package com.kh.example.person.controller;

import com.kh.example.person.model.vo.Person;

public class PersonController {

	public void method1() {
		// ��ü �迭�� ��ü�� ���� �迭
		// Person��ü�� �� �� �ִ� 5���� ���� pArr����

		Person[] pArr = new Person[5]; // Person��ü�� �� �� �ִ� 5���� ���� pArr����

		for (int i = 0; i < pArr.length; i++) {
			System.out.print(pArr[i] + " ");
		}
		System.out.println();

		// �ε����� �̿��� �ʱ�ȭ
		pArr[0] = new Person("���ǰ�", 25, '��', 179.5, 75.6);
		pArr[1] = new Person("������", 13, '��', 155.9, 45.2);
		pArr[2] = new Person("�����", 40, '��', 185.1, 109.8);
		pArr[3] = new Person("�����", 5, '��', 100.7, 13.0);
		pArr[4] = new Person("���̹�", 27, '��', 160.4, 55.2);

		for (int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i].personInfo());
		}
	}

	public void method2() {
		// ��ü �迭�� �Ҵ�� ���ÿ� �ʱ�ȭ ����
		int[] iArr = { 1, 2, 3, 4, 5 };

		Person[] pArr = { new Person("�ں���", 28, '��', 171.0, 50.2), 
						  new Person("�ۼ���", 17, '��', 156.9, 42.0),
						  new Person("������", 32, '��', 179.2, 74.2) };
		
		for (int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i].personInfo());
		}
	}
}
