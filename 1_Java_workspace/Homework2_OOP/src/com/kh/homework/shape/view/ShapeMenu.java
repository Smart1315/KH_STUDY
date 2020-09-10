package com.kh.homework.shape.view;

import java.util.Scanner;

import com.kh.homework.shape.controller.ShapeController;

public class ShapeMenu {
	private Scanner sc = new Scanner(System.in);
	private ShapeController spr = new ShapeController();

	public void inputMenu() {
		while (true) {
			System.out.println("===== ���� ���α׷� =====");
			System.out.println("3. �ﰢ��");
			System.out.println("4. �簢��");
			System.out.println("9. ���α׷� ����");
			System.out.print("�޴� ��ȣ : ");
			int num = sc.nextInt();
			sc.nextLine();
			switch (num) {
			case 3:
				triangleMenu();
				break;
			case 4:
				squareMenu();
				break;
			case 9:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default:
				System.out.println("�߸��� ��ȣ�Դϴ� . �ٽ��Է��ϼ���.");
				break;
			}
		}
	}

	public void triangleMenu() {
		while (true) {
			System.out.println("===== �ﰢ�� =====");
			System.out.println("1. �ﰢ�� ����");
			System.out.println("2. �ﰢ�� ��ĥ");
			System.out.println("3. ����� ����");
			System.out.println("9. ��������");
			System.out.print("�޴� ��ȣ : ");
			int num = sc.nextInt();
			sc.nextLine();
			switch (num) {
			case 1:
				inputData(3, 1);
				break;
			case 2:
				inputData(3, 0);
				break;
			case 3:
				printInform(3);
				break;
			case 9:
				spr = new ShapeController();
				System.out.println("�������� ���ư��ϴ�.");
				return;
			default:
				System.out.println("�߸��� ��ȣ�Դϴ� . �ٽ��Է��ϼ���.");
				break;
			}
		}
	}

	public void squareMenu() {
		while (true) {
			System.out.println("===== �簢�� =====");
			System.out.println("1. �簢�� �ѷ�");
			System.out.println("2. �簢�� ����");
			System.out.println("3. �簢�� ��ĥ");
			System.out.println("4. �簢�� ����");
			System.out.println("9. ��������");
			System.out.print("�޴� ��ȣ : ");
			int num = sc.nextInt();
			sc.nextLine();
			switch (num) {
			case 1:
				inputData(4, 2);
				break;
			case 2:
				inputData(4, 1);
				break;
			case 3:
				inputData(4, 0);
				break;
			case 4:
				printInform(4);
				break;
			case 9:
				spr = new ShapeController();
				System.out.println("�������� ���ư��ϴ�.");
				return;
			default:
				System.out.println("�߸��� ��ȣ�Դϴ�. �ٽ��Է��ϼ���.");
				break;
			}
		}
	}

	public void inputData(int type, int menuNum) {
		if (menuNum == 0) {
			System.out.print("���� : ");
			String color = sc.nextLine();
			spr.paintColor(color);
			System.out.println("���� �����Ǿ����ϴ�.");
		} else if (menuNum == 1) {
			System.out.print("���� : ");
			double height = sc.nextDouble();
			System.out.print("�ʺ� : ");
			double width = sc.nextDouble();
			sc.nextLine();
			double area = spr.calcArea(type, height, width);
			System.out.println("���� : " + area);
		} else if (menuNum == 2) {
			System.out.print("���� : ");
			double height = sc.nextDouble();
			System.out.print("�ʺ� : ");
			double width = sc.nextDouble();
			sc.nextLine();
			double perimeter = spr.calcPerimeter(type, height, width);
			System.out.println("�ѷ� : " + perimeter);
		}

	}

	public void printInform(int type) {
		System.out.println(spr.print(type));
	}

}
