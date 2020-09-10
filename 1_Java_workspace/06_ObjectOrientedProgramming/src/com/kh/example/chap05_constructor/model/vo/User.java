package com.kh.example.chap05_constructor.model.vo;

import java.util.Date;

public class User {
	private String userId;
	private String userPwd;
	private String userName;
	private Date enrollDate;

	// �������� ��� ����
	// 1. ��ü ����
	// 2. �Ű������� ���޹��� ������ �ʵ� �ʱ�ȭ

	// ������ ��� �� ���� ����
	// 1. �ݵ�� �̸��� Ŭ������ ����(��/�ҹ��� ����)
	// 2. ��ȯ�� �������� ����

	// �⺻ ������
	// �ƹ� �Ű������� ���� ������
	// JVM�� �⺻������ ��������
	// ��, �Ű����� �ִ� �����ڸ� ����ٸ� �ڵ������� ���� ����
	// ���� �ݵ�� ó���� ������ְ� ����
	public User() {

	}

	// �Ű����� �ִ� ������
	// ���� �̸��� �����ڸ� ������� �ϴ� ��� �����ε� ���� �ǰ� ����� ���
	public User(String userId, String userPwd, String userName, Date enrollDate) {
//		this.userId = userId;
//		this.userPwd = userPwd;
//		this.userName = userName;
		this(userId, userPwd, userName);
		this.enrollDate = enrollDate;
	}

	public User(String userId, String userPwd, String userName) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
	}


	public void inform() {
		System.out.println(userId + ", " + userPwd + ", " + userName + ", " + enrollDate);
	}

}
