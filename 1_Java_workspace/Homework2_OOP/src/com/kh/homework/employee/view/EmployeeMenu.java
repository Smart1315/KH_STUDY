package com.kh.homework.employee.view;

import java.util.Scanner;

import com.kh.homework.employee.controller.EmployeeController;

public class EmployeeMenu {
	private Scanner sc = new Scanner(System.in);
	private EmployeeController ec = new EmployeeController();

	public EmployeeMenu() {
		while (true) {
			System.out.println("1. ��� �߰�");
			System.out.println("2. ��� ����");
			System.out.println("3. ��� ����");
			System.out.println("4. ��� ���");
			System.out.println("9. ���α׷� ����");
			System.out.print("�޴� ��ȣ�� �������� : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				insertEmp();
				break;
			case 2:
				updateEmp();
				break;
			case 3:
				deleteEmp();
				break;
			case 4:
				printEmp();
				break;
			case 9:
				System.out.println("���α׷��� �����մϴ�.");
				return;

			default:
				System.out.println("�߸��� ��ȣ�� �ԷµǾ����ϴ�.");
				break;
			}
		}
	}

	public void insertEmp() {
		System.out.print("��� ��ȣ : "); // int empNo, String name, char gender, String phone
		int empNo = sc.nextInt();
		sc.nextLine();
		System.out.print("��� �̸� : ");
		String name = sc.nextLine();
		System.out.print("��� ���� : ");
		char gender = sc.nextLine().charAt(0);
		System.out.print("��ȭ ��ȣ : ");
		String phone = sc.nextLine();
		while (true) {
			System.out.print("�ְ� ������ �� �Է��Ͻðڽ��ϱ�?(y/n) : ");
			char res = sc.nextLine().toLowerCase().charAt(0);

			if (res == 'y') {
				System.out.print("��� �μ� : "); // String dept, int salary, double bonus
				String dept = sc.nextLine();
				System.out.print("��� ���� : ");
				int salary = sc.nextInt();
				System.out.print("���ʽ� �� : ");
				double bonus = sc.nextDouble();
				sc.nextLine();
				ec.add(empNo, name, gender, phone, dept, salary, bonus);
				break;
			} else if (res == 'n') {
				ec.add(empNo, name, gender, phone);
				break;
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
			}
		}
	}

	public void updateEmp() {
		System.out.println("���� �ֽ��� ��� ������ �����ϰ� �˴ϴ�.");
		System.out.println("����� � ������ �����Ͻðڽ��ϱ�?");
		while (true) {
			System.out.println("1. ��ȭ ��ȣ");
			System.out.println("2. ��� ����");
			System.out.println("3. ���ʽ� ��");
			System.out.println("9. ���ư���");
			System.out.print("�޴� ��ȣ�� �������� : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				System.out.print("������ ��ȭ ��ȣ : ");
				String phone = sc.nextLine();
				ec.modify(phone);
				break;
			case 2:
				System.out.print("������ ��� ���� : ");
				int salary = sc.nextInt();
				ec.modify(salary);
				sc.nextLine();
				return;
			case 3:
				System.out.print("������ ���ʽ� �� : ");
				double bonus = sc.nextDouble();
				ec.modify(bonus);
				sc.nextLine();
				return;
			case 9:
				System.out.println("���� �޴��� ���ư��ϴ�.");
				return;

			default:
				System.out.println("�߸��� ��ȣ�� �ԷµǾ����ϴ�.");
				break;
			}
		}
	}

	public void deleteEmp() {
		while (true) {
			System.out.print("���� �����Ͻðڽ��ϱ�? (y/n) : ");
			char res = sc.nextLine().toLowerCase().charAt(0);

			if (res == 'y') {
				if (ec.remove() == null) {
					System.out.println("������ ������ �����Ͽ����ϴ�.");
				} else {
					System.out.println("������ ������ �����Ͽ����ϴ�.");
				}
				return;
			} else if (res == 'n') {
				return;
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
			}
		}
	}

	public void printEmp() {
		String print = ec.inform();
		if (print == null) {
			System.out.println("��� �����Ͱ� �����ϴ�.");
		} else {
			System.out.println(print);
		}
	}
}
