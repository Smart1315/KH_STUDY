package com.kh.practice.list.music.view;

import java.util.Scanner;

import com.kh.practice.list.music.controller.MusicController;
import com.kh.practice.list.music.model.vo.Music;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();

	public void mainMenu() {
		do {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 정보 수정");
			System.out.println("7. 곡명 오름차순 정렬");
			System.out.println("8. 가수명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				addList();
				break;
			case 2:
				addAtZero();
				break;
			case 3:
				printAll();
				break;
			case 4:
				searchMusic();
				break;
			case 5:
				removeMusic();
				break;
			case 6:
				setMusic();
				break;
			case 7:
				ascTitle();
				break;
			case 8:
				descSinger();
				break;
			case 9:
				System.out.println("종료");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		} while (true);
	}

	public void addList() {
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();

		if (mc.addList(new Music(title, singer)) == 1) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}

	}

	public void addAtZero() {
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();

		if (mc.addAtZero(new Music(title, singer)) == 1) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}

	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		System.out.println(mc.printAll());
	}

	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();

		Music m = mc.searchMusic(title);

		if (m == null) {
			System.out.println("검색한 곡이 없습니다.");
		} else {
			System.out.println(m);
		}
	}

	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();

		Music m = mc.removeMusic(title);

		if (m == null) {
			System.out.println("삭제할 곡이 없습니다.");
		} else {
			System.out.println(m + "을(를) 삭제 했습니다.");
		}
	}

	public void setMusic() {
		System.out.print("검색할 곡 명 : ");
		String title = sc.nextLine();
		System.out.print("수정할 곡 명 : ");
		String editTitle = sc.nextLine();
		System.out.print("수정할 가수 명 : ");
		String editSinger = sc.nextLine();

		Music m = mc.searchMusic(title);
		if (m == null) {
			System.out.println("수정할 곡이 없습니다.");
			return;
		}
		
		String s = m.getSinger();

		m.setTitle(editTitle);
		m.setSinger(editSinger);

		mc.setMusic(title, m);

		System.out.println(s + " - " + title + "가 값이 변경되었습니다.");

	}

	public void ascTitle() {
		if (mc.ascTitle() == 1) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}
	}

	public void descSinger() {
		if (mc.descSinger() == 1) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}
	}
}
