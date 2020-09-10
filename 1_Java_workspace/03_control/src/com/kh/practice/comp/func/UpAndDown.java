package com.kh.practice.comp.func;

import java.util.Scanner;

public class UpAndDown {

	public void upDown() {
		Scanner sc = new Scanner(System.in);

		int r = (int) (Math.random() * 100) + 1;
		System.out.println(r);

		int ans = -1;
		int count = 0;
		while (true) {
			System.out.print("1~100 사이의 임의의 난수를 맞춰보세요 : ");
			ans = sc.nextInt();

			if (ans > 0 && ans < 101) {
				if (ans == r) {
					System.out.println("정답입니다 !!");
					count++;
					break;
				} else if (ans < r) {
					System.out.println("UP !");
				} else {
					System.out.println("DOWN !");
				}
				count++;
			} else {
				System.out.println("1~100 사이의 숫자를 입력해주세요.");
			}
		}

		System.out.println(count + "회만에 맞추셨습니다.");

		sc.close();
	}
}
