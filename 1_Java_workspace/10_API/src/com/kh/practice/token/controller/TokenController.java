package com.kh.practice.token.controller;

import java.util.StringTokenizer;

public class TokenController {

	public TokenController() {
		
	}
	
	public String afterToken(String str) {
		StringTokenizer st = new StringTokenizer(str, " ");
		String res = "";
		
		while(st.hasMoreTokens()) {
			res += st.nextToken();
		}
		
		return res;
	}
	
	public String firstCap(String input) {
		input = input.toUpperCase().charAt(0) + input.substring(1);
		
		return input;
	}
	
	public int findChar(String input, char one) {
		int count = 0;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == one) {
				count++;
			}
		}
		
		return count;
	}
}
