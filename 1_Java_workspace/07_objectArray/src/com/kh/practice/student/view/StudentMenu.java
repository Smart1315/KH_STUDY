package com.kh.practice.student.view;

import com.kh.practice.student.controller.StudentController;
import com.kh.practice.student.model.vo.Student;

public class StudentMenu {
	private StudentController ssm = new StudentController();

	public StudentMenu() {
		System.out.println("========== 학생 정보 출력 ==========");
		Student[] stdArr = ssm.printStudent();
//		for (int i = 0; i < stdArr.length; i++) {
//			System.out.println(stdArr[i].inform());
//		}
		for (Student student : stdArr) { // forEach문(향상된 for문)
			System.out.println(student.inform());
		}
		System.out.println("========== 학생 성적 출력 ==========");
		double[] aScore = ssm.avgScore();
		System.out.println("학생 점수 합계 : " + (int) aScore[0]);
		System.out.println("학생 점수 평균 : " + aScore[1]);
		System.out.println("========== 성적 결과 출력 ==========");
//		for (int i = 0; i < stdArr.length; i++) {
//			if (stdArr[i].getScore() >= StudentController.CUT_LINE) {
//				System.out.println(stdArr[i].getName() + " 학생은 통과입니다.");
//			} else {
//				System.out.println(stdArr[i].getName() + " 학생은 재시험 대상입니다.");
//			}
//		}
		for (Student student : stdArr) {
			if (student.getScore() >= StudentController.CUT_LINE) {
				System.out.println(student.getName() + " 학생은 통과입니다.");
			} else {
				System.out.println(student.getName() + " 학생은 재시험 대상입니다.");
			}
		}
	}
}
