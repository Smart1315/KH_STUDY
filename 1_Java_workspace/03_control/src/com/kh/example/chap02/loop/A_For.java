package com.kh.example.chap02.loop;

import java.util.Scanner;

public class A_For {
	// for(초기식; 조건식; 증감식) {
	// 		실행 문장;
	// }
	// 초기식 -> 조건식 -> (조건식이 true일 때)실행문장 수행 -> 증감식 -> 조건식 확인 -> (반복)
	// 조건식의 결과가 false가 될 때까지 반복

	// for문 안에 있는 초기식, 조건식, 증감식 생략 가능
	// 초기식은 무엇인지, 조건은 무엇인지, 증감은 얼마나 되는지 소괄호 안은 아니어도 어딘가에는 표기해야함
	// 결국 for() 안에서만 생략될 뿐 모두 필요한 요소

	public void method1() {
		// 1부터 5까지 출력

		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "번째 반복문 수행");
		}
	}

	public void method1_1() {
		// 자기소개 5번 하기

		for (int i = 0; i < 5; i++) {
			System.out.println("내 이름은 안영재다.");
		}

	}

	public void method2() {
		// 5부터 1까지 출력

//		for(int i = 5; i > 0; i--) {
//			System.out.println(i);
//		}

		for (int i = 0; i < 5; i++) {
			System.out.println(5 - i);
		}
	}

	public void method2_1() {
		// 8부터 3까지 출력

		for (int i = 8; i > 2; i--) {
			System.out.print(i + " ");
		}
	}

	public void method3() {
		// 1에서 10 사이의 홀수만 출력

//		for (int i = 1; i < 11; i++) {
//			if (i % 2 == 1) {
//				System.out.print(i + " ");
//			}
//		}

		for (int i = 1; i < 11; i += 2) {
			System.out.print(i + " ");
		}
	}

	public void method4() {
		// 정수 두 개를 입력받아 그 사이 숫자 출력

		Scanner sc = new Scanner(System.in);

		System.out.println("정수 두 개를 입력하세요.");
//		System.out.println("단, 첫 번째 숫자를 두 번째 숫자보다 작게 입력해주세요");

		System.out.print("첫 번째 숫자 : ");
		int start = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int end = sc.nextInt();

		sc.close();

//		for (; start <= end; start++) {
//			System.out.print(start + " ");
//		}

		int max = 0; // 두 숫자 중 큰 숫자를 저장할 공간
		int min = 0; // 두 숫자 중 작은 숫자를 저장할 공간

		if (start > end) {
			max = start;
			min = end;
		} else {
			max = end;
			min = start;
		}

		for (; min <= max; min++) {
			System.out.print(min + " ");
		}
		
		
	}

	public void method4_1() {
		// 정수를 하나 입력 받아 그 수가 1~9사이의 숫자일때문 그 수의 구구단 출력

		Scanner sc = new Scanner(System.in);

		System.out.print("1~9 사이의 양수를 하나 입력하세요 : ");
		int dan = sc.nextInt();

		if (dan >= 1 && dan <= 9) {
			for (int i = 1; i <= 9; i++) {
				System.out.println(dan + " X " + i + " = " + (dan * i));
			}
		} else {
			System.out.println("1~9 사이의 양수를 입력해야합니다");
		}

		sc.close();
	}

	public void method5() {
		// 1부터 10 사이의 임의의 난수를 정해 1부터 난수까지의 합
		// 랜덤 값 생성 메소드 : Math.random()
		// 0 이상 1 미만의 실수를 랜덤으로 반환
		// System.out.println(Math.random());
		// (0 단계) 0 <= Math.random() < 1 : 실수
		// (1 단계) Math.random() * 10 : 0 ~ 9.9999999999
		// (2 단계) Math.random() * 10 + 1 : 1 ~ 10.99999999999
		// (3 단계 ) (int) (Math.random() * 10 + 1) : 1 ~ 10
		double r = Math.random();
		System.out.println("Math.random() : " + r);

		int random = (int) (r * 10 + 1);
		System.out.println("난수 : " + random);
		int sum = 0;

		for (int i = 1; i <= random; i++) {
			sum += i;
		}

		System.out.println("1부터 " + random + "까지의 합 : " + sum);

	}

	public void method6() {
		// 중첩 for문 : for문 내부에 for문 사용
		// 2~9단 구구단

		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.print(j + " X " + i + " = " + (j * i) + "\t");
			}
			System.out.println();
		}
	}

	public void method7() {
		// 아날로그 시계 : 0시 0분 ~ 23시59분 까지 출력

		for (int i = 0; i <= 23; i++) {
			for (int j = 0; j <= 59; j++) {
				System.out.printf("%2d시%2d분\t", i, j);
			}
			System.out.println();
		}

	}

	public void method8() {
		// 한 줄에 별 표(*)가 5번 출력되는데 그 줄은 사용자가 입력한 수 만큼 출력
		// ex
		// 출력할 줄 수 : 3
		// *****
		// *****
		// *****

		Scanner sc = new Scanner(System.in);

		System.out.print("출력할 줄 수 : ");
		int row = sc.nextInt();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		sc.close();
	}

	public void method9() {
		// 한 줄에 별표 문자를 입력한 줄 수와 칸 수만큼 입력
		// 단, 줄 수와 칸 수가 일치하는 위치에는 줄 번호에 대한 정수 출력
		Scanner sc = new Scanner(System.in);

		System.out.print("줄 수 : ");
		int row = sc.nextInt();
		System.out.print("칸 수 : ");
		int col = sc.nextInt();

		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (i != j) {
					System.out.print("*");
				} else {
					System.out.print(i);
				}
			}
			System.out.println();
		}

		sc.close();
	}

}
