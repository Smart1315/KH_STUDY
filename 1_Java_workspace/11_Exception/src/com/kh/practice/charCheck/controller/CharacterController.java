package com.kh.practice.charCheck.controller;

import com.kh.practice.charCheck.exception.CharCheckException;

public class CharacterController {

	public CharacterController() {

	}

	public int countAlpha(String s) throws CharCheckException {
		if (s.contains(" ")) {
			throw new CharCheckException("üũ�� ���ڿ� �ȿ� ������ ���ԵǾ� �ֽ��ϴ�.");
		} else {
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
					count++;
				}
			}

			return count;
		}
	}
}
