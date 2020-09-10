package com.kh.example.education.model.vo;

public class Teacher extends Academy {
	/*
	 * - academy : String 
	 * - acaAddr : String 
	 * - name : String 
	 * - classroom : char 
	 * - subject : String 
	 * - career : int
	 * 
	 * + Teacher() 
	 * + Teacher(academy : String, acaAddr : String, name : String, classroom : char, 
	 * 				subject : String, career : int)
	 * 
	 * + setter/getter 
	 * + inform() : String 
	 * 		academy + " " + acaAddr + " " + name + " " + classroom + " " + subject + " " + career
	 */

//	private String academy;
//	private String acaAddr;
//	private String name;
//	private char classroom;
	private String subject;
	private int career;

	public Teacher() {
		
	}

	public Teacher(String academy, String acaAddr, String name, char classroom, String subject, int career) {
//		this.academy = academy;
//		this.acaAddr = acaAddr;
//		this.name = name;
//		this.classroom = classroom;
		super(academy, acaAddr, name, classroom);
		this.subject = subject;
		this.career = career;
	}

//	public String getAcademy() {
//		return academy;
//	}
//
//	public void setAcademy(String academy) {
//		this.academy = academy;
//	}
//
//	public String getAcaAddr() {
//		return acaAddr;
//	}
//
//	public void setAcaAddr(String acaAddr) {
//		this.acaAddr = acaAddr;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public char getClassroom() {
//		return classroom;
//	}
//
//	public void setClassroom(char classroom) {
//		this.classroom = classroom;
//	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}
	
//	@Override
//	public String inform() {
//		return super.inform() + " " + subject + " " + career;
//	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " " + subject + " " + career;
	}

}
