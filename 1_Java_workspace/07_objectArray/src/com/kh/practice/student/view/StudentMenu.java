package com.kh.practice.student.view;

import com.kh.practice.student.controller.StudentController;
import com.kh.practice.student.model.vo.Student;

public class StudentMenu {
	private StudentController ssm = new StudentController();

	public StudentMenu() {
		System.out.println("========== �л� ���� ��� ==========");
		Student[] stdArr = ssm.printStudent();
//		for (int i = 0; i < stdArr.length; i++) {
//			System.out.println(stdArr[i].inform());
//		}
		for (Student student : stdArr) { // forEach��(���� for��)
			System.out.println(student.inform());
		}
		System.out.println("========== �л� ���� ��� ==========");
		double[] aScore = ssm.avgScore();
		System.out.println("�л� ���� �հ� : " + (int) aScore[0]);
		System.out.println("�л� ���� ��� : " + aScore[1]);
		System.out.println("========== ���� ��� ��� ==========");
//		for (int i = 0; i < stdArr.length; i++) {
//			if (stdArr[i].getScore() >= StudentController.CUT_LINE) {
//				System.out.println(stdArr[i].getName() + " �л��� ����Դϴ�.");
//			} else {
//				System.out.println(stdArr[i].getName() + " �л��� ����� ����Դϴ�.");
//			}
//		}
		for (Student student : stdArr) {
			if (student.getScore() >= StudentController.CUT_LINE) {
				System.out.println(student.getName() + " �л��� ����Դϴ�.");
			} else {
				System.out.println(student.getName() + " �л��� ����� ����Դϴ�.");
			}
		}
	}
}
