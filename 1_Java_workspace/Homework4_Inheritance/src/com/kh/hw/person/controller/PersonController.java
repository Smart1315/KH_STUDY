package com.kh.hw.person.controller;

import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonController {
	private Student[] s = new Student[3];
	private Employee[] e = new Employee[10];

	public int[] personCount() {
		int count = 0;
		int[] pcount = new int[2];
		for (int i = 0; i < s.length; i++) {
			if (s[i] != null) {
				count++;
			}
		}
		pcount[0] = count;
		
		count = 0;
		for (int i = 0; i < e.length; i++) {
			if (e[i] != null) {
				count++;
			}
		}
		pcount[1] = count;

		return pcount;
	}

	public void insertStudent(String name, int age, double height, double weight, int grade, String major) {
		for (int i = 0; i < s.length; i++) {
			if (s[i] == null) {
				s[i] = new Student(name, age, height, weight, grade, major);
				break;
			}
		}
	}

	public Student[] printStudent() {
		int count = 0;
		int[] sindex = new int[3];
		for (int i = 0; i < s.length; i++) {
			if (s[i] != null) {
				sindex[count++] = i;
			}
		}

		Student[] ss = new Student[count];
		for (int i = 0; i < ss.length; i++) {
			ss[i] = s[sindex[i]];
		}

		return ss;
	}

	public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {
		for (int i = 0; i < e.length; i++) {
			if (e[i] == null) {
				e[i] = new Employee(name, age, height, weight, salary, dept);
				break;
			}
		}
	}

	public Employee[] printEmployee() {
		int count = 0;
		int[] eindex = new int[10];
		for (int i = 0; i < e.length; i++) {
			if (e[i] != null) {
				eindex[count++] = i;
			}
		}

		Employee[] ee = new Employee[count];
		for (int i = 0; i < ee.length; i++) {
			ee[i] = e[eindex[i]];
		}

		return ee;
	}
}
