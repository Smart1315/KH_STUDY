package com.kh.example.chap05_constructor.run;

import java.util.Date;

import com.kh.example.chap05_constructor.model.vo.User;

public class Run {

	public static void main(String[] args) {
		User u1 = new User();
		// 		------ 기본생성자
		u1.inform();

		// The constructor User() is undefined
		
		User u2 = new User("ayj1996", "pw1234", "안영재", new Date());
		u2.inform();
		
		User u3 = new User("ayj1996", "pw1234", "안영재");
		u3.inform();
		
	}

}
