package com.kh.practice.generics.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.kh.practice.generics.controller.FarmController;
import com.kh.practice.generics.model.vo.Farm;
import com.kh.practice.generics.model.vo.Fruit;
import com.kh.practice.generics.model.vo.Nut;
import com.kh.practice.generics.model.vo.Vegetable;

public class FarmMenu {
	private Scanner sc = new Scanner(System.in);
	private FarmController fc = new FarmController();

	public void mainMenu() {
		do {
			System.out.println("========== KH ��Ʈ ==========");
			System.out.println("******* ���� �޴� *******");
			System.out.println("1. ���� �޴�");
			System.out.println("2. �մ� �޴�");
			System.out.println("9. ����");
			System.out.print("�޴� ��ȣ ���� : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				adminMenu();
				break;
			case 2:
				customerMenu();
				break;
			case 9:
				System.out.println("���α׷� ����");
				return;
			default:
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���");
				break;
			}
		} while (true);
	}

	public void adminMenu() {
		do {
			System.out.println("******* ���� �޴� *******");
			System.out.println("1. �� ��깰 �߰�");
			System.out.println("2. ���� ����");
			System.out.println("3. ���� ����");
			System.out.println("4. ��깰 ���");
			System.out.println("9. �������� ���ư���");
			System.out.print("�޴� ��ȣ ���� : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				addNewKind();
				break;
			case 2:
				removeKind();
				break;
			case 3:
				changeAmount();
				break;
			case 4:
				printFarm();
				break;
			case 9:
				System.out.println("�������� ���ư��ϴ�.");
				return;
			default:
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���");
				break;
			}
		} while (true);
	}

	public void customerMenu() {
		do {
			System.out.println("���� KH��Ʈ ��깰 ����");
			printFarm();

			System.out.println("******* �� �޴� *******");
			System.out.println("1. ��깰 ���");
			System.out.println("2. ��깰 ����");
			System.out.println("3. ������ ��깰 ����");
			System.out.println("9. �������� ���ư���");
			System.out.print("�޴� ��ȣ ���� : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				buyFarm();
				break;
			case 2:
				removeFarm();
				break;
			case 3:
				printBuyFarm();
				break;
			case 9:
				System.out.println("�������� ���ư��ϴ�.");
				return;
			default:
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���");
				break;
			}
		} while (true);
	}

	public void addNewKind() {
		do {
			System.out.println("1. ���� / 2. ä�� / 3. �߰�");
			System.out.print("�߰��� ���� ��ȣ : ");
			int num = sc.nextInt();

			if (num < 1 || num > 3) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			sc.nextLine();

			System.out.print("�̸� : ");
			String name = sc.nextLine();
			System.out.print("���� : ");
			int amount = sc.nextInt();
			sc.nextLine();

			Farm f = null;
			switch (num) {
			case 1:
				f = new Fruit("����", name);
				break;
			case 2:
				f = new Vegetable("ä��", name);
				break;
			case 3:
				f = new Nut("�߰�", name);
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				break;
			}

			if (fc.addNewKind(f, amount)) {
				System.out.println("�� ��깰�� �߰��Ǿ����ϴ�.");
				return;
			} else {
				System.out.println("�� ��깰 �߰��� �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			}

		} while (true);
	}

	public void removeKind() {
		do {
			System.out.println("1. ���� / 2. ä�� / 3. �߰�");
			System.out.print("������ ���� ��ȣ : ");
			int num = sc.nextInt();

			if (num < 1 || num > 3) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			sc.nextLine();

			System.out.print("�̸� : ");
			String name = sc.nextLine();

			Farm f = null;
			switch (num) {
			case 1:
				f = new Fruit("����", name);
				break;
			case 2:
				f = new Vegetable("ä��", name);
				break;
			case 3:
				f = new Nut("�߰�", name);
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				break;
			}

			if (fc.removeKind(f)) {
				System.out.println("��깰 ������ �����Ͽ����ϴ�.");
				return;
			} else {
				System.out.println("��깰 ������ �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			}

		} while (true);
	}

	public void changeAmount() {
		do {
			System.out.println("1. ���� / 2. ä�� / 3. �߰�");
			System.out.print("������ ���� ��ȣ : ");
			int num = sc.nextInt();

			if (num < 1 || num > 3) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			sc.nextLine();

			System.out.print("�̸� : ");
			String name = sc.nextLine();
			System.out.print("������ ���� : ");
			int amount = sc.nextInt();
			sc.nextLine();

			Farm f = null;
			switch (num) {
			case 1:
				f = new Fruit("����", name);
				break;
			case 2:
				f = new Vegetable("ä��", name);
				break;
			case 3:
				f = new Nut("�߰�", name);
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				break;
			}

			if (fc.changeAmount(f, amount)) {
				System.out.println("��깰 ������ �����Ǿ����ϴ�.");
				return;
			} else {
				System.out.println("��깰 ���� ������ �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			}

		} while (true);
	}

	public void printFarm() {
		HashMap<Farm, Integer> hm = fc.printFarm();

		Set<Farm> s = hm.keySet();

		Iterator<Farm> it = s.iterator();
		while (it.hasNext()) {
			Farm key = it.next();
			System.out.println(key + "(" + hm.get(key) + "��)");
		}
	}

	public void buyFarm() {
		do {
			System.out.println("1. ���� / 2. ä�� / 3. �߰�");
			System.out.print("������ ���� ��ȣ : ");
			int num = sc.nextInt();

			if (num < 1 || num > 3) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			sc.nextLine();

			System.out.print("�̸� : ");
			String name = sc.nextLine();

			Farm f = null;
			switch (num) {
			case 1:
				f = new Fruit("����", name);
				break;
			case 2:
				f = new Vegetable("ä��", name);
				break;
			case 3:
				f = new Nut("�߰�", name);
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				break;
			}

			if (fc.buyFarm(f)) {
				System.out.println("���ſ� �����Ͽ����ϴ�.");
				return;
			} else {
				System.out.println("��Ʈ�� ���� �����̰ų� ������ �����ϴ�. �ٽ� �Է����ּ���.");
			}

		} while (true);
	}

	public void removeFarm() {
		do {
			System.out.println("1. ���� / 2. ä�� / 3. �߰�");
			System.out.print("����� ���� ��ȣ : ");
			int num = sc.nextInt();

			if (num < 1 || num > 3) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			sc.nextLine();

			System.out.print("�̸� : ");
			String name = sc.nextLine();

			Farm f = null;
			switch (num) {
			case 1:
				f = new Fruit("����", name);
				break;
			case 2:
				f = new Vegetable("ä��", name);
				break;
			case 3:
				f = new Nut("�߰�", name);
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				break;
			}

			if (fc.removeFarm(f)) {
				System.out.println("���� ��ҿ� �����Ͽ����ϴ�.");
				return;
			} else {
				System.out.println("���� ��Ͽ� �������� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
			}

		} while (true);
	}

	public void printBuyFarm() {
		ArrayList<Farm> list = fc.printBuyFarm();
		Iterator<Farm> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
