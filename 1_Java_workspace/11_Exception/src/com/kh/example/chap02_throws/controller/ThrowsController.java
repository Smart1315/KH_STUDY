package com.kh.example.chap02_throws.controller;

public class ThrowsController {

	public void method1() throws Exception {
		System.out.println("method1() »£√‚µ ...");
		method2();
		System.out.println("method1() ¡æ∑·µ ...");
	}

	public void method2() throws Exception {
		System.out.println("method2() »£√‚µ ...");
		method3();
		System.out.println("method2() ¡æ∑·µ ...");
	}

	public void method3() throws Exception {
		System.out.println("method3() »£√‚µ ...");

		throw new Exception();

//		System.out.println("method3() ¡æ∑·µ ...");
	}
}
