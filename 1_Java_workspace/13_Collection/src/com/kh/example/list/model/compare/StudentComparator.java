package com.kh.example.list.model.compare;

import java.util.Comparator;

import com.kh.example.list.model.vo.Student;

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		int standard = o1.getScore();
		int object = o2.getScore();
		
		if(standard > object) {
			return -1;
		} else if(standard == object) {
//			return 0;
			String standardName = o1.getName();
			String objectName = o2.getName();
			return standardName.compareTo(objectName);
		} else {
			return 1;
		}
		
	}

}
