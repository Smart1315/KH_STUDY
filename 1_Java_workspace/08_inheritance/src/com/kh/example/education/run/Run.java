package com.kh.example.education.run;

import com.kh.example.education.model.vo.Student;
import com.kh.example.education.model.vo.Teacher;

public class Run {

	public static void main(String[] args) {
		Teacher t = new Teacher("KH����������", "����� ������", "�ڽſ�", 'G', "�ڹ�", 5);
//		System.out.println(t.inform());
		System.out.println(t);
		System.out.println(t.toString());
		
		Student s = new Student("KH����������", "����� ������", "�ȿ���", 'G', "����Ʈ ������", 30);
//		System.out.println(s.inform());
		System.out.println(s);
		System.out.println(s.toString());

	}
}
