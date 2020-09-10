package com.kh.example.chap03_assist.part02_object.model.vo;

import java.io.Serializable;

public class Member implements Serializable {
	/*
	 * - userId : String
	 * - userPwd : String
	 * - userName : String
	 * - email : String
	 * - age : int
	 * - gender : char
	 * - point : double
	 * 
	 * + Member()
	 * + Member(userId : String, userPwd : String, userName : String)
	 * + Member(userId : String, userPwd : String, userName : String, email : String, age : int, gender : char, point : double)
	 * 
	 * + getter/setter
	 * + toString : String
	 * 		형식 : userId, userPwd, userName, email, age, gender, point	
	 */

	private static final long serialVersionUID = -317919167845418272L;
	
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private int age;
	private char gender;
	private transient double point; // transient : 직렬화 제외
	
	public Member() {
		
	}

	public Member(String userId, String userPwd, String userName) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
	}

	public Member(String userId, String userPwd, String userName, String email, int age, char gender, double point) {
		this(userId, userPwd, userName);
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.point = point;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getPoint() {
		return point;
	}

	public void  setPoint(double point) {
		this.point = point;
	}
	
	@Override
	public String toString() {
		return userId + ", " + userPwd + ", " + userName + ", " + email + ", " + age + ", " + gender + ", " + point;
	}
	
}
