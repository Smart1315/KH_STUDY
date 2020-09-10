package com.kh.test.run;

import com.kh.test.controller.TestController;

public class Run {

	public static void main(String[] args) {
		System.out.println("main() »£√‚µ ...");
		
		TestController tc = new TestController();
		tc.count++;
		tc.methodA();

		System.out.println("main() ¡æ∑·µ ...");
	}

}
