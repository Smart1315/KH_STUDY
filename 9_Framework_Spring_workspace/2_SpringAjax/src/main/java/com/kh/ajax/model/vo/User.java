package com.kh.ajax.model.vo;

public class User {
	private String userId;
	private String uesrPwd;
	private String userName;
	private int age;
	private String email;
	private String phone;
	
	public User() {}

	public User(String userId, String uesrPwd, String userName, int age, String email, String phone) {
		super();
		this.userId = userId;
		this.uesrPwd = uesrPwd;
		this.userName = userName;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUesrPwd() {
		return uesrPwd;
	}

	public void setUesrPwd(String uesrPwd) {
		this.uesrPwd = uesrPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", uesrPwd=" + uesrPwd + ", userName=" + userName + ", age=" + age
				+ ", email=" + email + ", phone=" + phone + "]";
	}
}
