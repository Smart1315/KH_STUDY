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
			System.out.println("=====***** 메인 메뉴 *****=====");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색 조회");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 도서 명 오름차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
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
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		} while (true);
	}

	public void insertBook() {
		System.out.print("도서명 입력 : ");
		String title = sc.nextLine();
		System.out.print("저자명 입력 : ");
		String author = sc.nextLine();
		String category = "";
		do {
			System.out.print("장르 입력 (1.인문 / 2.자연과학 / 3.의료 / 4.기타) : ");
			int c = sc.nextInt();
			if (c > 0 && c < 5) {
				switch (c) {
				case 1:
					category = "인문";
					break;
				case 2:
					category = "자연과";
					break;
				case 3:
					category = "의료";
					break;
				case 4:
					category = "기타";
					break;
				}
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			}
		} while (true);
		System.out.print("가격 입력 : ");
		int price = sc.nextInt();
		sc.nextLine();

		bc.insertBook(new Book(title, author, category, price));
	}

	public void selectList() {
		ArrayList<Book> bookList = bc.selectList();
		
		if(bookList.isEmpty()) {
			System.out.println("존재하는 도서가 없습니다.");
		} else {
			for(int i = 0; i < bookList.size(); i++) {
				System.out.println(bookList.get(i));
			}
		}
	}

	public void searchBook() {
		System.out.print("검색할 도서명 : ");
		String keyword = sc.nextLine();
		ArrayList<Book> bookList = bc.searchBook(keyword);
		
		if(bookList.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			for(int i = 0; i < bookList.size(); i++) {
				System.out.println(bookList.get(i));
			}
		}
	}

	public void deleteBook() {
		System.out.print("삭제할 도서명 : ");
		String title = sc.nextLine();
		System.out.print("삭제할 저자명 : ");
		String author = sc.nextLine();
		
		Book b = bc.deleteBook(title, author);
		
		if(b != null) {
			System.out.println("성공적으로 삭제되었습니다.");
		} else {
			System.out.println("삭제할 도서를 찾지 못했습니다.");
		}
	}

	public void ascBook() {
		if(bc.ascBook() == 1) {
			System.out.println("정렬에 성공하였습니다.");
		}
	}
}
