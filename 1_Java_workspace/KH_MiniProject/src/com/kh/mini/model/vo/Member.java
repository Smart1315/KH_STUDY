package com.kh.mini.model.vo;

import java.io.Serializable;

public class Member implements Serializable {
	private static final long serialVersionUID = -7976849759872118251L;

	private int dist;
	private String no;
	private String id;
	private String pw;
	private String name;
	private String dept;
	private int grade;
	private String address;
	private String phone;

	public Member() {
	}

	public Member(String id) {
		this.id = id;
	}

	public Member(String id, String pw) {
		this(id);
		this.pw = pw;
	}

	public Member(int dist, String no, String id, String pw, String name, String dept, int grade, String address,
			String phone) {
		this(id, pw);
		this.dist = dist;
		this.no = no;
		this.name = name;
		this.dept = dept;
		this.grade = grade;
		this.address = address;
		this.phone = phone;
	}

	public int getDist() {
		return dist;
	}

	public void setDist(int dist) {
		this.dist = dist;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String studentNo) {
		this.no = studentNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String studentId) {
		this.id = studentId;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String studentPw) {
		this.pw = studentPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String studentName) {
		this.name = studentName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String studentDept) {
		this.dept = studentDept;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int studentGrade) {
		this.grade = studentGrade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String studentAddress) {
		this.address = studentAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String studentPhone) {
		this.phone = studentPhone;
	}

	@Override
	public String toString() {
		return no + " / " + id + " / " + pw + " / " + name + " / " + dept + " / " + grade + " / " + address + " / "
				+ phone;
	}

	public Object[] toArray() {
		Object[] o = { no, id, name, dept, grade };

		return o;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Member other = (Member) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
