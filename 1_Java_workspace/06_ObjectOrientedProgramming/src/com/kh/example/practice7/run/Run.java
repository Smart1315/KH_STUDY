package com.kh.example.practice7.run;

import com.kh.example.practice7.model.vo.Employee;

public class Run {

	public static void main(String[] args) {
		Employee e = new Employee();
		e.setEmpNo(100);
		e.setEmpName("ȫ�浿");
		e.setDept("������");
		e.setJob("����");
		e.setAge(25);
		e.setGender('��');
		e.setSalary(2500000);
		e.setBonusPoint(0.05);
		e.setPhone("010-1234-5678");
		e.setAddress("����� ������");
		
		System.out.println("��� : " + e.getEmpNo());
		System.out.println("�̸� : " + e.getEmpName());
		System.out.println("�μ� : " + e.getDept());
		System.out.println("��å : " + e.getJob());
		System.out.println("���� : " + e.getAge());
		System.out.println("���� : " + e.getGender());
		System.out.println("�޿� : " + e.getSalary());
		System.out.println("���ʽ��� : " + e.getBonusPoint());
		System.out.println("��ȭ��ȣ : " + e.getPhone());
		System.out.println("�ּ� : " + e.getAddress());
	}

}
