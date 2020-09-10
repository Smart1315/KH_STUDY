package com.kh.practice.chap02_abstractNInterface.run;

import com.kh.practice.chap02_abstractNInterface.controller.PhoneController;

public class Run {

	public static void main(String[] args) {
		String[] info = new PhoneController().method();

		for(int i = 0; i < info.length; i++) {
			System.out.println(info[i]);
			System.out.println();
		}
	}

}
