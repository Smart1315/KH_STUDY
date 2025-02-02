package com.kh.mini.controller;

import java.util.StringTokenizer;

import com.kh.mini.model.vo.Communication;
import com.kh.mini.model.vo.Member;

public class MemberController {

	private CommunicationController cc = new CommunicationController();

	public int signUp(Member member) {
		Communication result = cc.connect("signUp", member);
		
		if(result.getData() == null) {
			return -2;
		}

		return (int) result.getData();
	}

	public Object login(Member input) {
		Communication result = cc.connect("login", input);

		return result.getData();
	}

	public Object editMember(Member member) {
		StringTokenizer phoneToken = new StringTokenizer(member.getPhone(), "-");
		if (member.getPw().equals("") || member.getDept().equals("") || member.getAddress().equals("")
				|| phoneToken.countTokens() != 3) {
			return true;
		}

		Communication result = cc.connect("editMember", member);

		return result.getData();
	}

	public Object[][] loadStudent() {
		Communication result = cc.connect("loadStudent", null);

		return (Object[][]) result.getData();
	}

	public Member loadStudent(Member m) {
		Communication result = cc.connect("loadStudent", m);

		return (Member) result.getData();
	}

}
