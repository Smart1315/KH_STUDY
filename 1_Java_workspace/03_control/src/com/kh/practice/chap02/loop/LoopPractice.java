package com.kh.practice.chap02.loop;

import java.util.Scanner;

public class LoopPractice {

	public void practice1() {
		Scanner sc = new Scanner(System.in);

		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();

		if (num < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {
			for (int i = 1; i <= num; i++) {
				System.out.print(i + " ");
			}
		}

		sc.close();
	}

	public void practice2() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("1이상의 숫자를 입력하세요 : ");
			int num = sc.nextInt();

			if (num < 1) {
				System.out.println("1 이상의 숫자를 입력해주세요.");
			} else {
				for (int i = 1; i <= num; i++) {
					System.out.print(i + " ");
				}
				sc.close();
				break;
			}
		}
	}

	public void practice3() {
		Scanner sc = new Scanner(System.in);

		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();

		if (num < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {
			for (int i = num; i > 0; i--) {
				System.out.print(i + " ");
			}
		}

		sc.close();
	}

	public void practice4() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("1이상의 숫자를 입력하세요 : ");
			int num = sc.nextInt();

			if (num < 1) {
				System.out.println("1 이상의 숫자를 입력해주세요.");
			} else {
				for (int i = num; i > 0; i--) {
					System.out.print(i + " ");
				}
				sc.close();
				break;
			}
		}

	}

	public void practice5() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수를 하나 입력하세요 : ");
		int num = sc.nextInt();

		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum += i;
			System.out.print(i);
			if (i == num) {
				System.out.print(" = ");
				continue;
			}
			System.out.print(" + ");
		}

		System.out.println(sum);

		sc.close();
	}

	public void practice6() {
		Scanner sc = new Scanner(System.in);

		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();

		if (num1 < 1 || num2 < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {

			if (num1 > num2) {
				int temp = num1;
				num1 = num2;
				num2 = temp;
			}

			for (int i = num1; i <= num2; i++) {
				System.out.print(i + " ");
			}
		}
		sc.close();
	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("첫 번째 숫자 : ");
			int num1 = sc.nextInt();
			System.out.print("두 번째 숫자 : ");
			int num2 = sc.nextInt();

			if (num1 < 1 || num2 < 1) {
				System.out.println("1 이상의 숫자를 입력해주세요.");
			} else {

				if (num1 > num2) {
					int temp = num1;
					num1 = num2;
					num2 = temp;
				}

				for (int i = num1; i <= num2; i++) {
					System.out.print(i + " ");
				}
				sc.close();
				break;
			}
		}
	}

	public void practice8() {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 : ");
		int num = sc.nextInt();

		System.out.println("========= " + num + "단 =========");
		for (int i = 1; i <= 9; i++) {
			System.out.println(num + " * " + i + " = " + (num * i));
		}

		sc.close();
	}

	public void practice9() {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 : ");
		int num = sc.nextInt();

		if (num > 9) {
			System.out.println("9 이하의 숫자만 입력해주세요.");
		} else {
			for (int i = num; i <= 9; i++) {
				System.out.println("========= " + i + "단 =========");
				for (int j = 1; j <= 9; j++) {
					System.out.println(i + " * " + j + " = " + (i * j));
				}
			}
		}

		sc.close();
	}

	public void practice10() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("숫자 : ");
			int num = sc.nextInt();

			if (num > 9) {
				System.out.println("9 이하의 숫자만 입력해주세요.");
			} else {
				for (int i = num; i <= 9; i++) {
					System.out.println("========= " + i + "단 =========");
					for (int j = 1; j <= 9; j++) {
						System.out.println(i + " * " + j + " = " + (i * j));
					}
				}
				sc.close();
				break;
			}
		}
	}

	public void practice11() {
		Scanner sc = new Scanner(System.in);

		System.out.print("시작 숫자 : ");
		int num1 = sc.nextInt();
		System.out.print("공차 : ");
		int num2 = sc.nextInt();

		for (int i = 0; i < 10; i++) {
			System.out.print(num1 + " ");
			num1 += num2;
		}

		sc.close();
	}

	public void practice12() {
		Scanner sc = new Scanner(System.in);

		String input = "";

		while (true) {
			System.out.print("연산자(+, -, *, /, %) : ");
			input = sc.nextLine();

			if (input.equals("exit")) {
				sc.close();
				System.out.println("프로그램을 종료합니다.");
				return;
			}

			char op = input.charAt(0);
			System.out.print("정수1 : ");
			int num1 = sc.nextInt();
			System.out.print("정수2 : ");
			int num2 = sc.nextInt();
			sc.nextLine();
			int result = 0;

			switch (op) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				if (num2 == 0) {
					System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
					continue;
				}
				result = num1 / num2;
				break;
			case '%':
				result = num1 % num2;
				break;
			default:
				System.out.println("없는 연산자입니다. 다시 입력해주세요.");
				continue;
			}

			System.out.println(num1 + " " + op + " " + num2 + " = " + result);

		}

	}

	public void practice13() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		sc.close();
	}

	public void practice14() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int num = sc.nextInt();

		for (int i = num; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		sc.close();
	}

	public void practice15() {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 : ");
		int num = sc.nextInt();

		boolean result = true;

		if (num < 2) {
			System.out.println("잘못 입력하셨습니다.");
		} else {
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					result = false;
					break;
				}
			}

			if (result) {
				System.out.println("소수입니다.");
			} else {
				System.out.println("소수가 아닙니다.");
			}
		}

		sc.close();
	}

	public void practice16() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("숫자 : ");
			int num = sc.nextInt();

			boolean result = true;

			if (num < 2) {
				System.out.println("잘못 입력하셨습니다.");
			} else {
				for (int i = 2; i < num; i++) {
					if (num % i == 0) {
						result = false;
						break;
					}
				}

				if (result) {
					System.out.println("소수입니다.");
				} else {
					System.out.println("소수가 아닙니다.");
				}
				break;
			}
		}

		sc.close();
	}

	public void practice17() {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 : ");
		int num = sc.nextInt();

		int count = 0;

		if (num < 2) {
			System.out.println("잘못 입력하셨습니다.");
		} else {
			for (int i = 2; i <= num; i++) {
				boolean result = true;
				for (int j = 2; j < i; j++) {
					if (i % j == 0) {
						result = false;
						break;
					}
				}
				if (result) {
					System.out.print(i + " ");
					count++;

				}
			}
			System.out.println();
			System.out.println("2부터 " + num + "까지의 소수의 개수는 " + count + "개입니다.");

		}

		sc.close();
	}

	public void practice18() {
		Scanner sc = new Scanner(System.in);

		System.out.print("자연수 하나를 입력하세요 : ");
		int num = sc.nextInt();

		int count = 0;

		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0 || i % 3 == 0) {
				System.out.print(i + " ");
			}
			if (i % 2 == 0 && i % 3 == 0) {
				count++;
			}
		}
		System.out.println();
		System.out.println("count : " + count);

		sc.close();
	}

	public void practice19() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {
			for (int k = num - 1; k > i; k--) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (num - i - 1 > j) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

		sc.close();
	}

	public void practice20() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = num - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 0; i < num * 2 - 1; i++) {
			if (i < num) {
				for (int j = 0; j <= i; j++) {
					System.out.print("*");
				}
			} else {
				for (int j = 0; j < num * 2 - 1 - i; j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}

		sc.close();
	}

	public void practice21() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {
			for (int k = num - 1; k > i; k--) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			for (int n = 0; n < i; n++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num + i; j++) {
				if (j < num - i - 1) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

		sc.close();
	}

	public void practice22() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (i == 0 || i == num - 1) {
					System.out.print("*");
				} else {
					if (j == 0 || j == num - 1) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}

		sc.close();

	}
}
