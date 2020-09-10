package com.kh.practice.comp.func;

import java.util.Scanner;

public class RockPaperScissors {

	public void rps() {
		Scanner sc = new Scanner(System.in);

		System.out.print("당신의 이름을 입력해주세요 : ");
		String name = sc.nextLine();
		 
		int a = 0;
		int w = 0;
		int d = 0;
		int l = 0;

		while (true) {
			System.out.print("가위바위보 : ");
			String rps = sc.nextLine();

			String crps = "";

			if (rps.equals("exit")) {
				System.out.println(a + "전 " + w + "승 " + d + "무 " + l + "패");
				break;
			} else if (!rps.equals("가위") && !rps.equals("바위") && !rps.equals("보")) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}

			int r = (int) (Math.random() * 10);

			if (r <= 2) {
				crps = "가위";
			} else if (r <= 5) {
				crps = "바위";
			} else {
				crps = "보";
			}
			
			System.out.println("컴퓨터 : " + crps);
			System.out.println(name + " : " + rps);
			
			a++;
			if ((rps.equals("가위") && crps.equals("보")) || (rps.equals("바위") && crps.equals("가위")) || (rps.equals("보") && crps.equals("바위"))) {
				System.out.println("이겼습니다 !");
				w++;
			} else if (rps.equals(crps)) {
				System.out.println("비겼습니다.");
				d++;
			} else {
				System.out.println("졌습니다 ㅠㅠ");
				l++;
			}
		}

		sc.close();
	}
}
