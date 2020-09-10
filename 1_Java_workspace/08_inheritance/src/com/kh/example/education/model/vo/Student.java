package com.kh.example.education.model.vo;

public class Student extends Academy {
	/*
	 * - academy : String
	 * - acaAddr : String
	 * - name : String
	 * - classroom : char
	 * - course : String
	 * - money : int
	 * 
	 * + Student()
	 * + Student(academy : String, acaAddr : String, name : String, classroom : char, 
	 * 				course : String, money : int)
	 * 
	 * + setter/getter
	 * + inform() : String
	 * 		academy + " " + acaAddr + " " + name + " " + classroom + " " + course + " " + money
	 */
	
//	private String academy;
//	private String acaAddr;
//	private String name;
//	private char classroom;
	private String course;
	private int money;
	
	public Student() {
		
	}

	public Student(String academy, String acaAddr, String name, char classroom, String course, int money) {
//		this.academy = academy;
//		this.acaAddr = acaAddr;
//		this.name = name;
//		this.classroom = classroom;
		super(academy, acaAddr, name, classroom);
		this.course = course;
		this.money = money;
	}

//	public String getAcademy() {
//		return academy;
//	}
//
//	
//	public void setAcademy(String academy) {
//		this.academy = academy;
//	}
//
//
//	public String getAcaAddr() {
//		return acaAddr;
//	}
//
//
//	public void setAcaAddr(String acaAddr) {
//		this.acaAddr = acaAddr;
//	}
//
//
//	public String getName() {
//		return name;
//	}
//
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//	public char getClassroom() {
//		return classroom;
//	}
//
//
//	public void setClassroom(char classroom) {
//		this.classroom = classroom;
//	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


//	public String inform() {
////		return academy + " " + acaAddr + " " + name + " " + classroom + " " + course + " " + money;
//		return super.getAcademy() + " " + super.getAcaAddr() + " " + super.getName() + " " + super.getClassroom() + " " + course + " " + money;
//	}
	
//	@Override
//	public String inform() {
//		return super.inform() + " " + course + " " + money;
//	}

	@Override
	public String toString() {
		return super.toString() + " " + course + " " + money;
	}
}
