package com.kh.example.test.controller;

import com.kh.example.test.model.vo.Child1;
import com.kh.example.test.model.vo.Child2;
import com.kh.example.test.model.vo.Parent;

public class InheritanceTest {

	public void method() {
		System.out.println("ParentŬ������ num�ʵ� ����");
		Parent p = new Parent();
		p.setNum(9);
		System.out.println("Parent �ȿ� �ִ� num : " + p.getNum());

		System.out.println("Child1Ŭ������ str�ʵ� ����");
		Child1 c1 = new Child1();
		c1.setStr("Hello World");
		System.out.println("Child1 �ȿ� �ִ� str : " + c1.getStr());

		System.out.println("Child1Ŭ������ num�ʵ� ����");
		c1.setNum(99);
		System.out.println("Chlid1 �ȿ� �ִ� num : " + c1.getNum());

		System.out.println("Child2Ŭ������ str�ʵ� ����");
		Child2 c2 = new Child2();
		c2.setStr("Hello");
		System.out.println("Child2 �ȿ� �ִ� str : " + c2.getStr());

		System.out.println("Child2Ŭ������ ��ӹ��� Parent�� �ʵ� ����");
//		c2.num; // The field Parent.num is not visible
		c2.setNum(999);
		System.out.println("Child2 �ȿ� �ִ� num : " + c2.getNum());
		System.out.println("Parent �ȿ� �ִ� num : " + p.getNum());
	}
}
