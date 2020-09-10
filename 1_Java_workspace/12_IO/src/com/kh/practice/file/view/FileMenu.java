package com.kh.practice.file.view;

import java.util.Scanner;

import com.kh.practice.file.controller.FileController;

public class FileMenu {
	private Scanner sc = new Scanner(System.in);
	private FileController fc = new FileController();

	public void mainMenu() {
		do {
			System.out.println("***** My Note *****");
			System.out.println("1. ��Ʈ ���� �����");
			System.out.println("2. ��Ʈ ����");
			System.out.println("3. ��Ʈ ��� �����ϱ�");
			System.out.println("9. ������");
			System.out.print("�޴� ��ȣ : ");
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
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				break;
			}
		} while (true);
	}

	public void fileSave() {
		StringBuilder sb = new StringBuilder();
		do {
			System.out.println("���Ͽ� ������ ������ �Է��ϼ���");
			System.out.println("ex��it �� �Է��ϸ� ����˴ϴ�.");
			System.out.print("���� : ");

			String temp = sc.nextLine();
			if (temp.equals("ex��it")) {
				break;
			}
			sb.append(temp + "\n");
		} while (true);

		String file;
		char yn;
		do {
			System.out.print("������ ���� ���� �Է����ּ���(ex. myFile.txt) : ");
			file = sc.nextLine();

			if (fc.checkName(file)) {
				do {
					System.out.print("�̹� �����ϴ� �����Դϴ�. ����ðڽ��ϱ�?(y/n) : ");
					yn = sc.nextLine().toUpperCase().charAt(0);

					if (yn == 'Y' || yn == 'N') {
						break;
					} else {
						System.out.println("�߸��� �����Դϴ�. �ٽ� �Է��ϼ���.");
					}
				} while (true);
			} else {
				break;
			}
		} while (yn != 'Y');

		fc.fileSave(file, sb);
	}

	public void fileOpen() {
		System.out.print("�� ���� �� : ");
		String file = sc.nextLine();

		if (!fc.checkName(file)) {
			System.out.println("���� �����Դϴ�.");
			return;
		}

		System.out.println(fc.fileOpen(file));

	}

	public void fileEdit() {
		System.out.print("������ ���� �� : ");
		String file = sc.nextLine();

		if (!fc.checkName(file)) {
			System.out.println("���� �����Դϴ�.");
			return;
		}

		StringBuilder sb = new StringBuilder(fc.fileOpen(file));

		do {
			System.out.println("���Ͽ� ������ ������ �Է��ϼ���");
			System.out.println("ex��it �� �Է��ϸ� ����˴ϴ�.");
			System.out.print("���� : ");

			String temp = sc.nextLine();
			if (temp.equals("ex��it")) {
				break;
			}
			sb.append(temp + "\n");
		} while (true);

		fc.fileSave(file, sb);
	}
}
