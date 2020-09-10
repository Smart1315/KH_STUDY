package com.kh.hw.person.view;

import java.util.Scanner;

import com.kh.hw.person.controller.PersonController;
import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonMenu {
	private Scanner sc = new Scanner(System.in);
	private PersonController pc = new PersonController();

	public void mainMenu() {
		while (true) {
			int[] pcount = pc.personCount();
			System.out.println("�л��� �ִ� 3����� ������ �� �ֽ��ϴ�.");
			System.out.println("���� ����� �л��� " + pcount[0] + "���Դϴ�.");
			System.out.println("����� �ִ� 10����� ������ �� �ֽ��ϴ�.");
			System.out.println("���� ����� ����� " + pcount[1] + "���Դϴ�.");

			System.out.println("1. �л� �޴�");
			System.out.println("2. ��� �޴�");
			System.out.println("9. ������");
			System.out.print("�޴� ��ȣ : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				studentMenu();
				break;
			case 2:
				employeeMenu();
				break;
			case 9:
				System.out.println("�����մϴ�.");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ� . �ٽ� �Է����ּ���.");
				break;
			}
		}
	}

	public void studentMenu() {
		while (true) {
			int scount = pc.personCount()[0];

			System.out.println("1. �л� �߰�");
			System.out.println("2. �л� ����");
			System.out.println("9. ��������");
			if (scount == 3) {
				System.out.println("�л��� ���� �� �ִ� ������ �� á�� ������ �л� �߰� �޴��� �� �̻� Ȱ��ȭ ���� �ʽ��ϴ�.");
			}
			System.out.print("�޴� ��ȣ : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				if (scount != 3) {
					insertStudent();
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ� . �ٽ� �Է����ּ���.");
				}
				break;
			case 2:
				printStudent();
				break;
			case 9:
				System.out.println("�������� ���ư��ϴ�.");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ� . �ٽ� �Է����ּ���.");
				break;
			}
		}
	}

	public void employeeMenu() {
		while (true) {
			int ecount = pc.personCount()[1];

			System.out.println("1. ��� �߰�");
			System.out.println("2. ��� ����");
			System.out.println("9. ��������");
			if (ecount == 10) {
				System.out.println("����� ���� �� �ִ� ������ �� á�� ������ �л� �߰� �޴��� �� �̻� Ȱ��ȭ ���� �ʽ��ϴ�.");
			}
			System.out.print("�޴� ��ȣ : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				if (ecount != 10) {
					insertEmployee();
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ� . �ٽ� �Է����ּ���.");
				}
				break;
			case 2:
				printEmployee();
				break;
			case 9:
				System.out.println("�������� ���ư��ϴ�.");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ� . �ٽ� �Է����ּ���.");
				break;
			}
		}
	}

	public void insertStudent() {
		// String name, int age, double height, double weight, int grade, String major
		while (true) {
			System.out.print("�л� �̸� : ");
			String name = sc.nextLine();
			System.out.print("�л� ���� : ");
			int age = sc.nextInt();
			System.out.print("�л� Ű : ");
			double height = sc.nextDouble();
			System.out.print("�л� ������ : ");
			double weight = sc.nextDouble();
			System.out.print("�л� �г� : ");
			int grade = sc.nextInt();
			sc.nextLine();
			System.out.print("�л� ���� : ");
			String major = sc.nextLine();

			pc.insertStudent(name, age, height, weight, grade, major);

			if (pc.personCount()[0] != 3) {
				do {
					System.out.print("�׸��Ͻ÷��� N(�Ǵ� n), �̾��Ͻ÷��� �ƹ� Ű�� �������� : ");
					char ans = sc.nextLine().toUpperCase().charAt(0);
					if (ans == 'N') {
						System.out.println("�л� �޴��� ���ư��ϴ�.");
						return;
					} else {
						break;
					}
				} while (true);
			} else {
				System.out.println("�л��� ���� �� �ִ� ������ �� á�� ������ �л� �߰��� �����ϰ� �л� �޴��� ���ư��ϴ�.");
				break;
			}
		}
	}

	public void printStudent() {
		if(pc.personCount()[0] == 0) {
			System.out.println("����� �л��� �����ϴ�.");
			return;
		}
		
		Student[] s = pc.printStudent();
		
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}

	public void insertEmployee() {
		// String name, int age, double height, double weight, int salary, String dept
		while (true) {
			System.out.print("��� �̸� : ");
			String name = sc.nextLine();
			System.out.print("��� ���� : ");
			int age = sc.nextInt();
			System.out.print("��� Ű : ");
			double height = sc.nextDouble();
			System.out.print("��� ������ : ");
			double weight = sc.nextDouble();
			System.out.print("��� �޿� : ");
			int salary = sc.nextInt();
			sc.nextLine();
			System.out.print("��� �μ� : ");
			String dept = sc.nextLine();

			pc.insertEmployee(name, age, height, weight, salary, dept);

			if (pc.personCount()[1] != 10) {
				do {
					System.out.print("�׸��Ͻ÷��� N(�Ǵ� n), �̾��Ͻ÷��� �ƹ� Ű�� �������� : ");
					char ans = sc.nextLine().toUpperCase().charAt(0);
					if (ans == 'N') {
						System.out.println("��� �޴��� ���ư��ϴ�.");
						return;
					} else {
						break;
					}
				} while (true);
			} else {
				System.out.println("����� ���� �� �ִ� ������ �� á�� ������ ��� �߰��� �����ϰ� ��� �޴��� ���ư��ϴ�.");
				break;
			}
		}
	}

	public void printEmployee() {
		if(pc.personCount()[1] == 0) {
			System.out.println("����� ����� �����ϴ�.");
			return;
		}
		
		Employee[] e = pc.printEmployee();

		for (int i = 0; i < e.length; i++) {
			System.out.println(e[i]);
		}
	}

}
