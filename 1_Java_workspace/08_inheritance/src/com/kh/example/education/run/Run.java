package com.kh.example.education.run;

import com.kh.example.education.model.vo.Student;
import com.kh.example.education.model.vo.Teacher;

public class Run {

	public static void main(String[] args) {
		Teacher t = new Teacher("KH정보교육원", "서울시 강남구", "박신우", 'G', "자바", 5);
//		System.out.println(t.inform());
		System.out.println(t);
		System.out.println(t.toString());
		
		Student s = new Student("KH정보교육원", "서울시 강남구", "안영재", 'G', "스마트 콘텐츠", 30);
//		System.out.println(s.inform());
		System.out.println(s);
		System.out.println(s.toString());

	}
}
