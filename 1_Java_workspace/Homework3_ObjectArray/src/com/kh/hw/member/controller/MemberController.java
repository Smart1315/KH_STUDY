package com.kh.hw.member.controller;

import com.kh.hw.member.model.vo.Member;

public class MemberController {
	Member[] m = new Member[SIZE];

	public static final int SIZE = 10;

	public int existMemberNum() {
		int count = 0;

		for (int i = 0; i < m.length; i++) {
			if (m[i] != null) {
				count++;
			}
		}

		return count;
	}

	public boolean checkId(String inputId) {

		for (int i = 0; i < m.length; i++) {
			if (m[i] == null) {
				continue;
			}
			if (inputId.equals(m[i].getId())) {
				return false;
			}
		}

		return true;
	}

	public void insertMember(String id, String name, String password, String email, char gender, int age) {
		for (int i = 0; i < m.length; i++) {
			if (m[i] == null) {
				m[i] = new Member(id, name, password, email, gender, age);
				break;
			}
		}
	}

	public String searchId(String id) {
		String inform = null;
		for (int i = 0; i < m.length; i++) {
			if (m[i] != null) {
				if (id.equals(m[i].getId())) {
					inform = m[i].inform();
					break;
				}
			}
		}

		return inform;
	}

	public Member[] searchName(String name) {
		int[] index = new int[SIZE];
		int icount = 0;
		for (int i = 0; i < m.length; i++) {
			if (m[i] != null) {
				if (name.equals(m[i].getName())) {
					index[icount++] = i;
				}
			}
		}

		if (icount <= 0) {
			return null;
		}

		Member[] member = new Member[icount];
		for (int i = 0; i < member.length; i++) {
			member[i] = m[index[i]];
		}

		return member;
	}

	public Member[] searchEmail(String email) {
		int[] index = new int[SIZE];
		int icount = 0;
		for (int i = 0; i < m.length; i++) {
			if (m[i] != null) {
				if (email.equals(m[i].getEmail())) {
					index[icount++] = i;
				}
			}
		}

		if (icount <= 0) {
			return null;
		}

		Member[] member = new Member[icount];
		for (int i = 0; i < member.length; i++) {
			member[i] = m[index[i]];
		}

		return member;
	}

	public boolean updatePassword(String id, String password) {
		for (int i = 0; i < m.length; i++) {
			if (m[i] != null) {
				if (id.equals(m[i].getId())) {
					m[i].setPassword(password);
					return true;
				}
			}
		}

		return false;
	}

	public boolean updateName(String id, String name) {
		for (int i = 0; i < m.length; i++) {
			if (m[i] != null) {
				if (id.equals(m[i].getId())) {
					m[i].setName(name);
					return true;
				}
			}
		}

		return false;
	}

	public boolean updateEmail(String id, String email) {
		for (int i = 0; i < m.length; i++) {
			if (m[i] != null) {
				if (id.equals(m[i].getId())) {
					m[i].setEmail(email);
					return true;
				}
			}
		}

		return false;
	}

	public boolean delete(String id) {
		for (int i = 0; i < m.length; i++) {
			if (m[i] != null) {
				if (id.equals(m[i].getId())) {
					m[i] = null;
					return true;
				}
			}
		}
		return false;
	}

	public void delete() {
		for (int i = 0; i < m.length; i++) {
			m[i] = null;
		}
	}

	public Member[] printAll() {
		return m;
	}
}
