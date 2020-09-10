package com.kh.practice.snack.view;

import java.util.Scanner;

import com.kh.practice.snack.controller.SnackController;

public class SnackMenu {
	private Scanner sc = new Scanner(System.in);
	private SnackController scr = new SnackController();

	public void menu() {
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : "); // String kind, String name, String flavor, int numOf, int price
		String kind = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("맛 : ");
		String flavor = sc.nextLine();
		System.out.print("개수 : ");
		int numOf = sc.nextInt();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();

		String result = scr.saveData(kind, name, flavor, numOf, price);

		if (result.equals("저장완료")) {
			System.out.println("저장 완료되었습니다.");
			char res = 0;
			while (res != 'y' || res != 'n') {
				System.out.print("저장한 정보를 확인하시겠습니까?(y/n) : ");
				res = sc.nextLine().toLowerCase().charAt(0);
				if (res == 'y') {
					System.out.println(scr.confirmData());
				} else if (res == 'n') {
					return;
				} else {
					System.out.println("잘못된 입력입니다 다시 입력하세요.");
				}
			}
		} else {
			System.out.println("저장에 실패하였습니다.");
		}
	}
}
