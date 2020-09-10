package com.kh.test.controller;

public class TestController {
	public int count = 0;

	public void methodA() {
		printTab();
		System.out.println("methodA() »£√‚µ ...");
		count++;
		
		methodB();
		
		count--;
		printTab();
		System.out.println("methodA() ¡æ∑·µ ...");
		//return
	}

	public void methodB() {
		printTab();
		System.out.println("methodB() »£√‚µ ...");
		count++;
		
		methodC();
		
		count--;
		printTab();
		System.out.println("methodB() ¡æ∑·µ ...");
		//return
	}

	public void methodC() {
		printTab();
		System.out.println("methodC() »£√‚µ ...");
		count++;
		
		// Ω««‡ ±∏πÆ
		
		count--;
		printTab();
		System.out.println("methodC() ¡æ∑·µ ...");
		//return
	}

	public void printTab() {
		for (int i = 0; i < count; i++) {
			System.out.print("\t");
		}
		//return
	}
}
