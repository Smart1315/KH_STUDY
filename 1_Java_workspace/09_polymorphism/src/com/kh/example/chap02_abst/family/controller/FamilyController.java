package com.kh.example.chap02_abst.family.controller;

import com.kh.example.chap02_abst.family.model.vo.Baby;
import com.kh.example.chap02_abst.family.model.vo.Basic;
import com.kh.example.chap02_abst.family.model.vo.Mother;

public class FamilyController {
	
	public void method() {
//		Family f = new Family(); // 추상 클래스는 객체 생성 불가능, 대신 참조변수 가능
		
//		Family m = new Mother("어머니", 50, 70, "출산");
//		Family b = new Baby("베이비", 3.5, 70);
//		
//		System.out.println(m);
//		System.out.println(b);
//		
//		m.eat();
//		b.eat();
//		
//		m.sleep();
//		b.sleep();
//		
//		System.out.println(m);
//		System.out.println(b);
		
//		Basic b = new Basic(); // 인터페이스는 객체 생성 불가능, 대신 참조 변수 가능
		Basic mother = new Mother();
		Basic baby = new Baby();
	}
}
