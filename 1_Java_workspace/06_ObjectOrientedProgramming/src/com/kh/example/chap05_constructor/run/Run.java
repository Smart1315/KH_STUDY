package com.kh.example.chap05_constructor.run;

import java.util.Date;

import com.kh.example.chap05_constructor.model.vo.User;

public class Run {

	public static void main(String[] args) {
		User u1 = new User();
		// 		------ �⺻������
		u1.inform();

		// The constructor User() is undefined
		
		User u2 = new User("ayj1996", "pw1234", "�ȿ���", new Date());
		u2.inform();
		
		User u3 = new User("ayj1996", "pw1234", "�ȿ���");
		u3.inform();
		
	}

}
