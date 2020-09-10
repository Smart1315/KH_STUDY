package com.kh.practice.file.view;

import java.util.Scanner;

import com.kh.practice.file.controller.FileController;

public class FileMenu {
	private Scanner sc = new Scanner(System.in);
	private FileController fc = new FileController();

	public void mainMenu() {
		do {
			System.out.println("***** My Note *****");
			System.out.println("1. 노트 새로 만들기");
			System.out.println("2. 노트 열기");
			System.out.println("3. 노트 열어서 수정하기");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				fileSave();
				break;
			case 2:
				fileOpen();
				break;
			case 3:
				fileEdit();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		} while (true);
	}

	public void fileSave() {
		StringBuilder sb = new StringBuilder();
		do {
			System.out.println("파일에 저장할 내용을 입력하세요");
			System.out.println("ex끝it 를 입력하면 종료됩니다.");
			System.out.print("내용 : ");

			String temp = sc.nextLine();
			if (temp.equals("ex끝it")) {
				break;
			}
			sb.append(temp + "\n");
		} while (true);

		String file;
		char yn;
		do {
			System.out.print("저장할 파일 명을 입력해주세요(ex. myFile.txt) : ");
			file = sc.nextLine();

			if (fc.checkName(file)) {
				do {
					System.out.print("이미 존재하는 파일입니다. 덮어쓰시겠습니까?(y/n) : ");
					yn = sc.nextLine().toUpperCase().charAt(0);

					if (yn == 'Y' || yn == 'N') {
						break;
					} else {
						System.out.println("잘못된 선택입니다. 다시 입력하세요.");
					}
				} while (true);
			} else {
				break;
			}
		} while (yn != 'Y');

		fc.fileSave(file, sb);
	}

	public void fileOpen() {
		System.out.print("열 파일 명 : ");
		String file = sc.nextLine();

		if (!fc.checkName(file)) {
			System.out.println("없는 파일입니다.");
			return;
		}

		System.out.println(fc.fileOpen(file));

	}

	public void fileEdit() {
		System.out.print("수정할 파일 명 : ");
		String file = sc.nextLine();

		if (!fc.checkName(file)) {
			System.out.println("없는 파일입니다.");
			return;
		}

		StringBuilder sb = new StringBuilder(fc.fileOpen(file));

		do {
			System.out.println("파일에 저장할 내용을 입력하세요");
			System.out.println("ex끝it 를 입력하면 종료됩니다.");
			System.out.print("내용 : ");

			String temp = sc.nextLine();
			if (temp.equals("ex끝it")) {
				break;
			}
			sb.append(temp + "\n");
		} while (true);

		fc.fileSave(file, sb);
	}
}
