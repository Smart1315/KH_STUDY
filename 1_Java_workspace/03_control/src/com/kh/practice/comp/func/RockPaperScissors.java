package com.kh.practice.comp.func;

import java.util.Scanner;

public class RockPaperScissors {

	public void rps() {
		Scanner sc = new Scanner(System.in);

		System.out.print("����� �̸��� �Է����ּ��� : ");
		String name = sc.nextLine();
		 
		int a = 0;
		int w = 0;
		int d = 0;
		int l = 0;

		while (true) {
			System.out.print("���������� : ");
			String rps = sc.nextLine();

			String crps = "";

			if (rps.equals("exit")) {
				System.out.println(a + "�� " + w + "�� " + d + "�� " + l + "��");
				break;
			} else if (!rps.equals("����") && !rps.equals("����") && !rps.equals("��")) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				continue;
			}

			int r = (int) (Math.random() * 10);

			if (r <= 2) {
				crps = "����";
			} else if (r <= 5) {
				crps = "����";
			} else {
				crps = "��";
			}
			
			System.out.println("��ǻ�� : " + crps);
			System.out.println(name + " : " + rps);
			
			a++;
			if ((rps.equals("����") && crps.equals("��")) || (rps.equals("����") && crps.equals("����")) || (rps.equals("��") && crps.equals("����"))) {
				System.out.println("�̰���ϴ� !");
				w++;
			} else if (rps.equals(crps)) {
				System.out.println("�����ϴ�.");
				d++;
			} else {
				System.out.println("�����ϴ� �Ф�");
				l++;
			}
		}

		sc.close();
	}
}
