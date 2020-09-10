package com.kh.example.chap01_poly.test.controller;

import com.kh.example.chap01_poly.test.model.vo.Child1;
import com.kh.example.chap01_poly.test.model.vo.Child2;
import com.kh.example.chap01_poly.test.model.vo.Parent;

public class PolyController {
	// ������
	// �θ� ���۷��� ������ �ڽ� ��ü�� ���� ��

	public void method() {
		// 1. �θ� Ÿ�� ���۷����� �θ� ��ü�� �ٷ� ��
		System.out.println("1. �θ�Ÿ�� ���۷����� �θ� ��ü�� �ٷ�� ���");
		Parent p = new Parent();
		// p : �θ�Ÿ�� ���۷��� // new Parent() : �θ� ��ü
		p.printParent();
		System.out.println();
		// 2. �ڽ� Ÿ�� ���۷����� �ڽ� ��ü�� �ٷ� ��
		System.out.println("2. �ڽ�Ÿ�� ���۷����� �ڽ� ��ü�� �ٷ�� ���");
		Child1 c1 = new Child1();
		// c1 : �ڽ�Ÿ�� ���۷��� // new Child1() : �ڽ� ��ü
		c1.printChild1();
		c1.printParent();
		System.out.println();
		// 3. �θ� Ÿ�� ���۷����� �ڽ� ��ü�� �ٷ� ��
		System.out.println("3. �θ�Ÿ�� ���۷����� �ڽ� ��ü�� �ٷ�� ���");
		Parent p2 = new Child2(); // ������
		// p2 : �θ�Ÿ�� ���۷��� // new Child2() : �ڽ� ��ü
		// �� ĳ����
		// : �θ� Ÿ���� ������ ������ ��� �ڽİ�ü�� ���� �� �ִ� ��
		p2.printParent();
		((Child2) p2).printChild2();
		System.out.println();
		// 4. �ڽ� Ÿ�� ���۷����� �θ� ��ü�� �ٷ궧
		System.out.println("4. �ڽ�Ÿ�� ���۷����� �θ� ��ü�� �ٷ�� ���");
//		Child2 c2 = new Parent();
//		Child2 c2 = (Child2) new Parent();
//		Child2 c2 = (Child2) p;
		System.out.println("�Ұ���");
		System.out.println();

		Parent[] pArr = new Parent[4];
		pArr[0] = new Child1();
		pArr[1] = new Child2();
		pArr[2] = new Child2();
		pArr[3] = new Child1();
		
		for (int i = 0; i < pArr.length; i++) {
//			pArr[i].printParent();
//			if (pArr[i] instanceof Child1) {
//				((Child1) pArr[i]).printChild1();
//			} else if (pArr[i] instanceof Child2) {
//				((Child2) pArr[i]).printChild2();
//			}
			
			pArr[i].print();
		}
	}

}
