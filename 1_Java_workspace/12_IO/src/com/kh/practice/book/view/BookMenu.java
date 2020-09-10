package com.kh.practice.book.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.kh.practice.book.controller.BookController;
import com.kh.practice.book.model.vo.Book;

public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	private Book[] bArr;

	public BookMenu() {
		bc.makeFile();
		bArr = bc.fileRead();
	}

	public void mainMenu() {
		do {
			System.out.println("1. ���� �߰� ����");
			System.out.println("2. ���� ���� ���");
			System.out.println("9. ���α׷� ������");
			System.out.print("�޴� ��ȣ : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				fileSave();
				break;
			case 2:
				fileRead();
				break;
			case 9:
				System.out.println("���α׷� ����");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				break;
			}
		} while (true);
	}

	public void fileSave() {
		// String title, String author, int price, Calendar date, double discount
		System.out.print("���� �� : ");
		String title = sc.nextLine();
		System.out.print("���� �� : ");
		String author = sc.nextLine();
		System.out.print("���� ���� : ");
		int price = sc.nextInt();
		sc.nextLine();

		System.out.print("���� ��¥(yyyy-mm-dd) : ");
		String cal = sc.nextLine();
		String[] temp = cal.split("-");
		int year = Integer.parseInt(temp[0]);
		int month = Integer.parseInt(temp[1]);
		int dayOfMonth = Integer.parseInt(temp[2]);
		Calendar date = new GregorianCalendar(year, month, dayOfMonth);

		System.out.print("������ : ");
		double discount = sc.nextDouble();
		sc.nextLine();

		for (int i = 0; i < bArr.length; i++) {
			if (bArr[i] == null) {
				bArr[i] = new Book(title, author, price, date, discount);
				break;
			}
		}

		bc.fileSave(bArr);
	}

	public void fileRead() {
		bArr = bc.fileRead();

		for (Book b : bArr) {
			if (b != null) {
				System.out.println(b);
			}
		}
	}
}
