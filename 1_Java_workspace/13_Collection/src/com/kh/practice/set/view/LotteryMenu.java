package com.kh.practice.set.view;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import com.kh.practice.set.controller.LotteryController;
import com.kh.practice.set.model.vo.Lottery;

public class LotteryMenu {
	private Scanner sc = new Scanner(System.in);
	private LotteryController lc = new LotteryController();

	public void mainMenu() {
		do {
			System.out.println("========== KH ��÷ ���α׷� ==========");
			System.out.println("******* ���� �޴� *******");
			System.out.println("1. ��÷ ��� �߰�");
			System.out.println("2. ��÷ ��� ����");
			System.out.println("3. ��÷ ��� Ȯ��");
			System.out.println("4. ���ĵ� ��÷ ��� Ȯ��");
			System.out.println("5. ��÷ ��� �˻�");
			System.out.println("9. ����");
			System.out.print("�޴� ��ȣ ���� : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch (num) {
			case 1:
				insertObject();
				break;
			case 2:
				deleteObject();
				break;
			case 3:
				winObject();
				break;
			case 4:
				sortedWinObject();
				break;
			case 5:
				searchWinner();
				break;
			case 9:
				System.out.println("���α׷� ����");
				return;
			default:
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				break;
			}
		} while (true);
	}

	public void insertObject() {
		System.out.print("�߰��� ��÷ ��� �� : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < num; i++) {
			System.out.print("�̸� : ");
			String name = sc.nextLine();
			System.out.print("�ڵ��� ��ȣ('-'����) : ");
			String phone = sc.nextLine();
			
			if(!lc.insertObject(new Lottery(name, phone))) {
				System.out.println("�����ϴ� ����Դϴ�. �ٽ� �Է��ϼ���.");
				i--;
			}
		}
		
		System.out.println(num + "�� �߰� �Ϸ�Ǿ����ϴ�.");
	}

	public void deleteObject() {
		System.out.println("������ ����� �̸��� �ڵ��� ��ȣ�� �Է��ϼ���.");
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("�ڵ��� ��ȣ('-'����) : ");
		String phone = sc.nextLine();
		
		if(lc.deleteobject(new Lottery(name, phone))) {
			System.out.println("���� �Ϸ� �Ǿ����ϴ�.");
		} else {
			System.out.println("�������� �ʴ� ����Դϴ�.");
		}
	}

	public void winObject() {
		HashSet<Lottery> hs = lc.winObject();
		if(hs == null) {
			System.out.println("��÷ ��� 4�� ����");
			return;
		}
		System.out.println(hs);
	}

	public void sortedWinObject() {
		TreeSet<Lottery> ts = lc.sortedWinObject();
		if(ts.isEmpty()) {
			System.out.println("��÷ ��� 4�� ����");
			return;
		}
		Iterator<Lottery> it = ts.iterator();

		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public void searchWinner() {
		System.out.println("�˻��� ����� �̸��� �ڵ��� ��ȣ�� �Է��ϼ���.");
		System.out.print("������ ����� �̸��� �ڵ��� ��ȣ�� �Է��ϼ���.");
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("�ڵ��� ��ȣ('-'����) : ");
		String phone = sc.nextLine();
		
		if(lc.searchWinner(new Lottery(name, phone))) {
			System.out.println("�����մϴ�. ��÷ ��Ͽ� �����մϴ�.");
		} else {
			System.out.println("��Ÿ������ ��÷ ��Ͽ� �������� �ʽ��ϴ�.");
		}
	}

}
