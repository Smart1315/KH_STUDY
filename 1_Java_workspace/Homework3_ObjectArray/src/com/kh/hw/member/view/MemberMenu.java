package com.kh.hw.member.view;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;
import com.kh.hw.member.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();

	public MemberMenu() {

	}

	public void mainMenu() {
		while (true) {
			int emn = mc.existMemberNum();
			System.out.println("�ִ� ��� ������ ȸ�� ����" + MemberController.SIZE + "�� �Դϴ�.");
			System.out.println("���� ��ϵ� ȸ�� ���� " + emn + "�� �Դϴ�.");

			if (emn != MemberController.SIZE) {
				System.out.println("1. �� ȸ�� ���");
				System.out.println("2. ȸ�� �˻�");
				System.out.println("3. ȸ�� ���� ����");
				System.out.println("4. ȸ�� ����");
				System.out.println("5. ��� ���");
				System.out.println("9. ������");
				System.out.print("�޴� ��ȣ : ");
			} else {
				System.out.println("ȸ�� ���� ��� �� á�� ������ �Ϻ� �޴��� ���µ˴ϴ�.");
				System.out.println("2. ȸ�� �˻�");
				System.out.println("3. ȸ�� ���� ����");
				System.out.println("4. ȸ�� ����");
				System.out.println("5. ��� ���");
				System.out.println("9. ������");
				System.out.print("�޴� ��ȣ : ");
			}
			int num = sc.nextInt();
			sc.nextLine();
			switch (num) {
			case 1:
				if (emn != MemberController.SIZE) {
					insertMember();
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�. ���� �Է����ּ���.");
				}
				break;
			case 2:
				searchMember();
				break;
			case 3:
				updateMember();
				break;
			case 4:
				deleteMember();
				break;
			case 5:
				printAll();
				break;
			case 9:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. ���� �Է����ּ���.");
				break;
			}
		}
	}

	public void insertMember() {
		System.out.println("�� ȸ���� ����մϴ�.");
		String id;
		while (true) {
			System.out.print("���̵� : ");
			id = sc.nextLine();
			if (mc.checkId(id)) {
				break;
			} else {
				System.out.println("�ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
			}

		}
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("��й�ȣ : ");
		String password = sc.nextLine();
		System.out.print("�̸��� : ");
		String email = sc.nextLine();
		char gender = 0;
		while (true) {
			System.out.print("����(M/F) : ");
			gender = sc.nextLine().toUpperCase().charAt(0);

			if (gender != 'M' && gender != 'F') {
				System.out.println("������ �ٽ� �Է��ϼ���.");
			} else {
				break;
			}
		}
		System.out.print("���� : ");
		int age = sc.nextInt();
		sc.nextLine();

		mc.insertMember(id, name, password, email, gender, age);

	}

	public void searchMember() {
		System.out.println("1. ���̵�� �˻��ϱ�");
		System.out.println("2. �̸����� �˻��ϱ�");
		System.out.println("3. �̸��Ϸ� �˻��ϱ�");
		System.out.println("9. �������� ���ư���");
		System.out.print("�޴� ��ȣ : ");
		int num = sc.nextInt();
		sc.nextLine();

		switch (num) {
		case 1:
			searchId();
			break;
		case 2:
			searchName();
			break;
		case 3:
			searchEmail();
			break;
		case 9:
			System.out.println("�������� ���ư��ϴ�.");
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			break;
		}
	}

	public void searchId() {
		System.out.print("�˻��� ���̵� �Է� : ");
		String id = sc.nextLine();
		String inform = mc.searchId(id);
		if (inform != null) {
			System.out.println(inform);
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}

	public void searchName() {
		System.out.print("�˻��� �̸� �Է� : ");
		String name = sc.nextLine();
		Member[] m = mc.searchName(name);
		if (m != null) {
			for (Member member : m) {
				if (member == null) {
					continue;
				}
				System.out.println(member.inform());
			}
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}

	public void searchEmail() {
		System.out.print("�˻��� �̸��� �Է� : ");
		String email = sc.nextLine();
		Member[] m = mc.searchEmail(email);
		if (m != null) {
			for (Member member : m) {
				if (member == null) {
					continue;
				}
				System.out.println(member.inform());
			}
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}

	public void updateMember() {
		System.out.println("1. ��й�ȣ �����ϱ�");
		System.out.println("2. �̸� �����ϱ�");
		System.out.println("3. �̸��� �����ϱ�");
		System.out.println("9. �������� ���ư���");
		System.out.print("�޴� ��ȣ : ");
		int num = sc.nextInt();
		sc.nextLine();

		switch (num) {
		case 1:
			updatePassword();
			break;
		case 2:
			updateName();
			break;
		case 3:
			updateEmail();
			break;
		case 9:
			System.out.println("�������� ���ư��ϴ�.");
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			break;
		}
	}

	public void updatePassword() {
		System.out.print("������ ȸ���� ���̵� : ");
		String id = sc.nextLine();
		System.out.print("������ ��й�ȣ : ");
		String password = sc.nextLine();

		if (mc.updatePassword(id, password)) {
			System.out.println("������ ���������� �Ǿ����ϴ�.");
		} else {
			System.out.println("�������� �ʴ� ���̵��Դϴ�.");
		}
	}

	public void updateName() {
		System.out.print("������ ȸ���� ���̵� : ");
		String id = sc.nextLine();
		System.out.print("������ �̸� : ");
		String name = sc.nextLine();

		if (mc.updateName(id, name)) {
			System.out.println("������ ���������� �Ǿ����ϴ�.");
		} else {
			System.out.println("�������� �ʴ� ���̵��Դϴ�.");
		}
	}

	public void updateEmail() {
		System.out.print("������ ȸ���� ���̵� : ");
		String id = sc.nextLine();
		System.out.print("������ �̸��� : ");
		String email = sc.nextLine();

		if (mc.updateEmail(id, email)) {
			System.out.println("������ ���������� �Ǿ����ϴ�.");
		} else {
			System.out.println("�������� �ʴ� ���̵��Դϴ�.");
		}
	}

	public void deleteMember() {
		System.out.println("1. Ư�� ȸ�� �����ϱ�");
		System.out.println("2. ��� ȸ�� �����ϱ�");
		System.out.println("9. �������� ���ư���");
		System.out.print("�޴� ��ȣ : ");
		int num = sc.nextInt();
		sc.nextLine();

		switch (num) {
		case 1:
			deleteOne();
			break;
		case 2:
			deleteAll();
			break;
		case 9:
			System.out.println("�������� ���ư��ϴ�.");
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			break;
		}
	}

	public void deleteOne() {
		System.out.print("������ ȸ���� ���̵� : ");
		String id = sc.nextLine();

		while (true) {
			System.out.print("���� �����Ͻðڽ��ϱ�?(y/n) : ");
			char yn = sc.nextLine().toLowerCase().charAt(0);

			if (yn == 'y') {
				if (mc.delete(id)) {
					System.out.println("���������� �����Ͽ����ϴ�.");
				} else {
					System.out.println("������ ���̵� �������� �ʽ��ϴ�.");
				}
				break;
			} else if (yn == 'n') {
				System.out.println("����ȭ������ ���ư��ϴ�.");
				break;
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}

	}

	public void deleteAll() {
		while (true) {
			System.out.print("���� �����Ͻðڽ��ϱ�?(y/n) : ");
			char yn = sc.nextLine().toLowerCase().charAt(0);

			if (yn == 'y') {
				mc.delete();
				System.out.println("���������� �����Ͽ����ϴ�.");
				break;
			} else if (yn == 'n') {
				System.out.println("����ȭ������ ���ư��ϴ�.");
				break;
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}

	public void printAll() {
		if (mc.existMemberNum() == 0) {
			System.out.println("����� ȸ���� �����ϴ�.");
			return;
		}

		Member[] m = mc.printAll();

		for (Member member : m) {
			if (member == null) {
				continue;
			}

			System.out.println(member.inform());
		}

	}
}
