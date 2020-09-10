package com.kh.example.practice7.run;

import com.kh.example.practice7.model.vo.Employee;

public class Run {

	public static void main(String[] args) {
		Employee e = new Employee();
		e.setEmpNo(100);
		e.setEmpName("홍길동");
		e.setDept("영업부");
		e.setJob("과장");
		e.setAge(25);
		e.setGender('남');
		e.setSalary(2500000);
		e.setBonusPoint(0.05);
		e.setPhone("010-1234-5678");
		e.setAddress("서울시 강남구");
		
		System.out.println("사번 : " + e.getEmpNo());
		System.out.println("이름 : " + e.getEmpName());
		System.out.println("부서 : " + e.getDept());
		System.out.println("직책 : " + e.getJob());
		System.out.println("나이 : " + e.getAge());
		System.out.println("성별 : " + e.getGender());
		System.out.println("급여 : " + e.getSalary());
		System.out.println("보너스율 : " + e.getBonusPoint());
		System.out.println("전화번호 : " + e.getPhone());
		System.out.println("주소 : " + e.getAddress());
	}

}
