package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		MemberController mc = new MemberController();
		int select = 0;

		do {
			System.out.println("\n *** 회원 관리 프로그램 *** \n");
			System.out.println("1. 새 회원 등록");
			System.out.println("2. 모든 회원 조회");
			System.out.println("3. 특정 조건 회원 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원탈퇴");
			System.out.println("0. 프로그램 종료");
			System.out.print("번호 선택 : ");
			select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1:
				mc.insertMember();
				break;
			case 2:
				mc.selectAll();
				break;
			case 3:
				mc.selectMember();
				break;
			case 4:
				mc.updateMember();
				break;
			case 5:
				mc.deleteMember();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				mc.exitProgram();
				break;
			default:
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
				break;
			}

		} while (select != 0);
	}

	public Member insertMember() {
		System.out.print("회원 아이디 : ");
		String memberId = sc.nextLine();

		System.out.print("비밀번호 : ");
		String memberPwd = sc.nextLine();

		System.out.print("이름 : ");
		String memberName = sc.nextLine();

		System.out.print("성별(남:M/여:F) : ");
		char gender = sc.nextLine().toUpperCase().charAt(0);

		System.out.print("이메일 : ");
		String email = sc.nextLine();

		System.out.print("전화변호(- 포함) : ");
		String phone = sc.nextLine();

		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());

		System.out.print("주소 : ");
		String address = sc.nextLine();

		Member mem = new Member(memberId, memberPwd, memberName, gender, email, phone, age, address);

		return mem;
	}

	public void displaySuccess(String string) {
		System.out.println("서비스 요청 성공 : " + string);
	}

	public void displayError(String string) {
		System.out.println("서비스 요청 실패 : " + string);
	}

	public void selectAll(ArrayList<Member> list) {
		System.out.printf("%-10s %-10s %-5s %-5s %-20s %-15s %-4s %-20s %-15s\n", "ID", "PWD", "NAME", "GENDER",
				"EMAIL", "PHONE", "AGE", "ADDRESS", "EROLLDATE");

		for (Member m : list) {
			System.out.printf("%-10s %-10s %-8s %-5c %-20s %-15s %-4d %-20s %-15s\n", m.getMemberId(), m.getMemberPwd(),
					m.getMemberName(), m.getGender(), m.getEmail(), m.getPhone(), m.getAge(), m.getAddress(),
					m.getEnrollDate());
		}

	}

	public int selectMember() {
		int sel = 0;

		while (true) {
			System.out.println("1. 아이디로 회원 조회");
			System.out.println("2. 성별로 회원조회");
			System.out.println("0. 메인 메뉴로 돌아가기");
			System.out.print("번호 선택 : ");
			sel = Integer.parseInt(sc.nextLine());

			switch (sel) {
			case 1:
			case 2:
			case 0:
				return sel;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		}

	}

	public String inputMemberId() {
		System.out.print("회원 아이디 : ");
		String id = sc.nextLine();

		return id;
	}

	public char inputGender() {
		System.out.print("조회할 성별 입력(남:M / 여:F) : ");
		char gender = sc.nextLine().toUpperCase().charAt(0);

		return gender;
	}

	public int updateMember() {
		System.out.println("\n*** ID가 확인되었습니다. ***\n");

		int sel = 0;
		while (true) {
			System.out.println("1. 비밀번호 변경");
			System.out.println("2. 이메일 변경");
			System.out.println("3. 전화번호 변경");
			System.out.println("4. 주소 변경");
			System.out.println("0. 메인 메뉴로 돌아가기");
			System.out.print("번호 선택 : ");
			sel = Integer.parseInt(sc.nextLine());

			switch (sel) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 0:
				return sel;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	public String inputUpdate() {
		System.out.print("수정 값 입력 : ");
		String input = sc.nextLine();
		
		return input;
	}

	public char checkDelete() {
		System.out.println("\n*** ID가 확인되었습니다. ***\n");
		
		System.out.print("정말 삭제하시겠습니까?(Y/N) : ");
		char yn = sc.nextLine().toUpperCase().charAt(0);
		
		return yn;
	}

}
