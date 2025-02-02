package com.kh.example.chap02.loop;

import java.util.Scanner;

public class B_While {
	// while(조건식) {
	// 		실행문장;
	// 		[증감식 or 분기문];
	// }
	// 조건식 확인 -> (조건식이 true일 때) 실행문장 수행 -> 조건식 확인 -> (반복)
	// 조건식의 결과가 false가 될 때까지 반복

	public void method1() {
		// 1부터 5까지 출력

		int i = 1;

		while (i <= 5) {
			System.out.println(i);
			i++;
		}
	}

	public void method1_1() {
		// 자기소개 5번 하기

		int i = 0;

		while (i < 5) {
			System.out.println("내 이름은 안영재다.");
			i++;
		}
	}

	public void method2() {
		// 5부터 1까지 출력하기

		int i = 5;

		while (i > 0) {
			System.out.println(i--);
		}
	}

	public void method2_1() {
		// 8부터 3까지 출력
		int i = 8;

		while (i >= 3) {
			System.out.println(i--);
		}
	}

	public void method3() {
		// 1에서 10 사이의 홀수만 출력
		int i = 1;

		while (i <= 10) {
			System.out.println(i);
			i += 2;
		}
	}

	public void method4() {
		// 정수 두 개를 입력받아 그 사이 숫자 출력
		Scanner sc = new Scanner(System.in);

		System.out.println("정수 두 개를 입력하세요.");

		System.out.print("첫 번째 숫자 : ");
		int start = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int end = sc.nextInt();

		int max = 0; // 두 숫자 중 큰 숫자를 저장할 공간
		int min = 0; // 두 숫자 중 작은 숫자를 저장할 공간

		if (start > end) {
			max = start;
			min = end;
		} else {
			max = end;
			min = start;
		}

		while (min <= max) {
			System.out.print((min++) + " ");
		}

		sc.close();
	}

	public void method4_1() {
		// 정수를 하나 입력 받아 그 수가 1~9사이의 숫자일때문 그 수의 구구단 출력

		Scanner sc = new Scanner(System.in);

		System.out.print("1~9 사이의 양수를 하나 입력하세요 : ");
		int dan = sc.nextInt();

		if (dan >= 1 && dan <= 9) {
			int i = 1;
			while (i <= 9) {
				System.out.println(dan + " X " + i + " = " + (dan * i++));
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

		double r = Math.random();
		System.out.println("Math.random() : " + r);

		int random = (int) (r * 10 + 1);
		System.out.println("난수 : " + random);
		int sum = 0;

		int i = 1;
		while (i <= random) {
			sum += i++;
		}

		System.out.println("1부터 " + random + "까지의 합 : " + sum);

	}

	public void method6() {
		// 문자열을 입력 받아 인덱스 별로 문차 출력

		Scanner sc = new Scanner(System.in);

		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();

		System.out.println("내가 입력한 문자열 : " + str);

		int i = 0;
		// String 클래스의 length() 메소드 : 문자열의 길이 반환(int)
		while (i < str.length()) {
			System.out.println(i + " : " + str.charAt(i++));
		}

		sc.close();

	}

	public void method7() {
		// 중첩 while문 : while문 내부에 while문 사용
		// 2~9단 구구단

		int i = 1;
		while (i <= 9) {
			int j = 2;
			while (j <= 9) {
				System.out.print(j + " X " + i + " = " + (j * i) + "\t");
				j++;
			}
			System.out.println();
			i++;
		}

	}

	public void method8() {
		// 아날로그 시계 : 0시 0분 ~ 23시59분 까지 출력

		int hour = 0;
		while (hour <= 23) {
			int min = 0;
			while (min <= 59) {
				System.out.printf("%02d시%02d분\t", hour, min);
				min++;
			}
			System.out.println();
			hour++;
		}
	}

	public void method9() {
		// 한 줄에 별 표(*)가 5번 출력되는데 그 줄은 사용자가 입력한 수 만큼 출력

		Scanner sc = new Scanner(System.in);

		System.out.print("출력할 줄 수 : ");
		int row = sc.nextInt();

		int i = 0;
		while (i < row) {
			int j = 0;
			while (j < 5) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}

		sc.close();
	}

	public void method10() {
		// 한 줄에 별표 문자를 입력한 줄 수와 칸 수만큼 입력
		// 단, 줄 수와 칸 수가 일치하는 위치에는 줄 번호에 대한 정수 출력

		Scanner sc = new Scanner(System.in);

		System.out.print("줄 수 : ");
		int row = sc.nextInt();
		System.out.print("칸 수 : ");
		int col = sc.nextInt();

		int i = 1;
		while (i <= row) {
			int j = 1;
			while (j <= col) {
				if (i != j) {
					System.out.print("*");
				} else {
					System.out.print(i);
				}
				j++;
			}
			System.out.println();
			i++;
		}

		sc.close();
	}

	public void method11() {
		Scanner sc = new Scanner(System.in);

		int menu = 0;
//		while (menu != 9) {
//
//			System.out.println("1. 1~5 출력");
//			System.out.println("2. 5~1 출력");
//			System.out.println("3. 1~10사이 홀수 출력");
//			System.out.println("9. 종료");
//			System.out.print("메뉴 번호 : ");
//			menu = sc.nextInt();
//
//			switch (menu) {
//			case 1:
//				method1();
//				break;
//			case 2:
//				method2();
//				break;
//			case 3:
//				method3();
//				break;
//			case 9:
//				System.out.println("종료합니다.");
//				break;
//			default:
//				System.out.println("입력 오류");
//				break;
//			}
//		}
		
		
		do {
			System.out.println("1. 1~5 출력");
			System.out.println("2. 5~1 출력");
			System.out.println("3. 1~10 중 홀수 출력");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				method1();
				break;
			case 2:
				method2();
				break;
			case 3:
				method3();
				break;
			case 9:
				System.out.println("종료합니다.");
				sc.close();
				return;
			default:
				System.out.println("입력 오류");
				break;
			}

		} while (menu != 9);

		sc.close();
	}

	public void method12() {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("1. 1~5 출력");
			System.out.println("2. 5~1 출력");
			System.out.println("3. 1~10 중 홀수 출력");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				method1();
				break;
			case 2:
				method2();
				break;
			case 3:
				method3();
				break;
			case 9:
				System.out.println("종료합니다.");
				sc.close();
				return;
			default:
				System.out.println("입력 오류");
				break;
			}
			
		}

	}
}
