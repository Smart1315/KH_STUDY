package com.kh.mini.controller;

import java.util.ArrayList;
import java.util.StringTokenizer;

import com.kh.mini.model.dao.MemberDAO;
import com.kh.mini.model.vo.Member;

public class MemberController {
	private MemberDAO md = new MemberDAO();

	public int signUp(Member member) {
		int result = 0;

		StringTokenizer phoneToken = new StringTokenizer(member.getPhone(), "-");
		if (member.getId().equals("") || member.getPw().equals("")
				|| member.getName().equals("") || member.getDept().equals("")
				|| member.getAddress().equals("") || phoneToken.countTokens() != 3) {
			result = -1;
		} else {
			if (md.saveStudent(member)) {
				result = 1;
			} else {
				result = 0;
			}
		}

		return result;
	}

	public Object login(Member input) {
		Object result = 0;

		ArrayList<Member> list = md.readStudent();

		for (int i = 0; i < list.size(); i++) {
			Member temp = list.get(i);
			if (temp.getId().equals(input.getId())) {
				result = 1;
				if (temp.getPw().equals(input.getPw())) {
					result = temp;
					break;
				}
			}
		}

		return result;
	}

	public Object editMember(Member member) {
		StringTokenizer phoneToken = new StringTokenizer(member.getPhone(), "-");
		if (member.getPw().equals("") || member.getDept().equals("")
				|| member.getAddress().equals("") || phoneToken.countTokens() != 3) {
			return true;
		}

		return md.editStudent(member);
	}
	
	public Object[][] loadStudent() {
		ArrayList<Member> list = md.readStudent();
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getDist() == 1) {
				list.remove(i);
			}
		}
		
		Object[][] o = new Object[list.size()][];
		for(int i = 0; i < list.size(); i++) {
			o[i] = list.get(i).toArray();
		}
		
		return o;
	}
	
	public Member loadStudent(Member m) {
		ArrayList<Member> list = md.readStudent();
		
		Member member = new Member();
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(m)) {
				member = list.get(i);
				break;
			}
		}
		
		return member;
	}
	
	
}
