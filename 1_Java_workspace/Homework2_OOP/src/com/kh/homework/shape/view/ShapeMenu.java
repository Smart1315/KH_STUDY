package com.kh.homework.shape.view;

import java.util.Scanner;

import com.kh.homework.shape.controller.ShapeController;

public class ShapeMenu {
	private Scanner sc = new Scanner(System.in);
	private ShapeController spr = new ShapeController();

	public void inputMenu() {
		while (true) {
			System.out.println("===== 도형 프로그램 =====");
			System.out.println("3. 삼각형");
			System.out.println("4. 사각형");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
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
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 번호입니다 . 다시입력하세요.");
				break;
			}
		}
	}

	public void triangleMenu() {
		while (true) {
			System.out.println("===== 삼각형 =====");
			System.out.println("1. 삼각형 면적");
			System.out.println("2. 삼각형 색칠");
			System.out.println("3. 삼격형 정보");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
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
				System.out.println("메인으로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못된 번호입니다 . 다시입력하세요.");
				break;
			}
		}
	}

	public void squareMenu() {
		while (true) {
			System.out.println("===== 사각형 =====");
			System.out.println("1. 사각형 둘레");
			System.out.println("2. 사각형 면적");
			System.out.println("3. 사각형 색칠");
			System.out.println("4. 사각형 정보");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
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
				System.out.println("메인으로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못된 번호입니다. 다시입력하세요.");
				break;
			}
		}
	}

	public void inputData(int type, int menuNum) {
		if (menuNum == 0) {
			System.out.print("색깔 : ");
			String color = sc.nextLine();
			spr.paintColor(color);
			System.out.println("색이 설정되었습니다.");
		} else if (menuNum == 1) {
			System.out.print("높이 : ");
			double height = sc.nextDouble();
			System.out.print("너비 : ");
			double width = sc.nextDouble();
			sc.nextLine();
			double area = spr.calcArea(type, height, width);
			System.out.println("면적 : " + area);
		} else if (menuNum == 2) {
			System.out.print("높이 : ");
			double height = sc.nextDouble();
			System.out.print("너비 : ");
			double width = sc.nextDouble();
			sc.nextLine();
			double perimeter = spr.calcPerimeter(type, height, width);
			System.out.println("둘레 : " + perimeter);
		}

	}

	public void printInform(int type) {
		System.out.println(spr.print(type));
	}

}
