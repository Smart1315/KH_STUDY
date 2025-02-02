package com.kh.member.controller;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.view.View;

public class MemberController {
	private View menu = new View();
	private MemberService mService = new MemberService();

	public void login() {
		Member mem = menu.inputLogin();

		int result = mService.inputLogin(mem);
		
		if(result > 0) {
			menu.displayLoginSuccess();
		} else {
			menu.displayLoginError();
		}
	}

	public void exitProgram() {
		mService.exitProgram();
	}

}
