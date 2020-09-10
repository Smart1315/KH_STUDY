package com.kh.practice.list.library.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice.list.library.controller.BookController;
import com.kh.practice.list.library.model.vo.Book;

public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();

	public void mainMenu() {
		do {
			System.out.println("==== Welcome KH Library ====");
			System.out.println("=====***** ���� �޴� *****=====");
			System.out.println("1. �� ���� �߰�");
			System.out.println("2. ���� ��ü ��ȸ");
			System.out.println("3. ���� �˻� ��ȸ");
			System.out.println("4. ���� ����");
			System.out.println("5. ���� �� �������� ����");
			System.out.println("9. ����");
			System.out.print("�޴� ��ȣ ���� : ");
			int num = sc.nextInt();
			sc.nextLine();
			switch (num) {
			case 1:
				insertBook();
				break;
			case 2:
				selectList();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				deleteBook();
				break;
			case 5:
				ascBook();
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

	public void insertBook() {
		System.out.print("������ �Է� : ");
		String title = sc.nextLine();
		System.out.print("���ڸ� �Է� : ");
		String author = sc.nextLine();
		String category = "";
		do {
			System.out.print("�帣 �Է� (1.�ι� / 2.�ڿ����� / 3.�Ƿ� / 4.��Ÿ) : ");
			int c = sc.nextInt();
			if (c > 0 && c < 5) {
				switch (c) {
				case 1:
					category = "�ι�";
					break;
				case 2:
					category = "�ڿ���";
					break;
				case 3:
					category = "�Ƿ�";
					break;
				case 4:
					category = "��Ÿ";
					break;
				}
				break;
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
			}
		} while (true);
		System.out.print("���� �Է� : ");
		int price = sc.nextInt();
		sc.nextLine();

		bc.insertBook(new Book(title, author, category, price));
	}

	public void selectList() {
		ArrayList<Book> bookList = bc.selectList();
		
		if(bookList.isEmpty()) {
			System.out.println("�����ϴ� ������ �����ϴ�.");
		} else {
			for(int i = 0; i < bookList.size(); i++) {
				System.out.println(bookList.get(i));
			}
		}
	}

	public void searchBook() {
		System.out.print("�˻��� ������ : ");
		String keyword = sc.nextLine();
		ArrayList<Book> bookList = bc.searchBook(keyword);
		
		if(bookList.isEmpty()) {
			System.out.println("�˻� ����� �����ϴ�.");
		} else {
			for(int i = 0; i < bookList.size(); i++) {
				System.out.println(bookList.get(i));
			}
		}
	}

	public void deleteBook() {
		System.out.print("������ ������ : ");
		String title = sc.nextLine();
		System.out.print("������ ���ڸ� : ");
		String author = sc.nextLine();
		
		Book b = bc.deleteBook(title, author);
		
		if(b != null) {
			System.out.println("���������� �����Ǿ����ϴ�.");
		} else {
			System.out.println("������ ������ ã�� ���߽��ϴ�.");
		}
	}

	public void ascBook() {
		if(bc.ascBook() == 1) {
			System.out.println("���Ŀ� �����Ͽ����ϴ�.");
		}
	}
}
