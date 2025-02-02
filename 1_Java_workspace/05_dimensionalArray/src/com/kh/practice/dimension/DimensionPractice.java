package com.kh.practice.dimension;

import java.util.Scanner;

public class DimensionPractice {

	public void practice1() {
		String[][] sArr = new String[3][3];

		for (int i = 0; i < sArr.length; i++) {
			for (int j = 0; j < sArr[i].length; j++) {
				sArr[i][j] = "(" + i + ", " + j + ")";
			}
		}

		for (int i = 0; i < sArr.length; i++) {
			for (int j = 0; j < sArr[i].length; j++) {
				System.out.print(sArr[i][j]);
			}
			System.out.println();
		}

	}

	public void practice2() {
		int[][] iArr = new int[4][4];

		for (int i = 0; i < iArr.length; i++) {
			for (int j = 0; j < iArr[i].length; j++) {
				iArr[i][j] = (i * iArr[i].length) + j + 1; // 정형배열만
			}
		}

		for (int i = 0; i < iArr.length; i++) {
			for (int j = 0; j < iArr[i].length; j++) {
				System.out.printf("%2d ", iArr[i][j]);
			}
			System.out.println();
		}
	}

	public void practice3() {
		int[][] iArr = new int[4][4];

		int value = 16;
		for (int i = 0; i < iArr.length; i++) {
			for (int j = 0; j < iArr[i].length; j++) {
				iArr[i][j] = value--;
			}
		}

		for (int i = 0; i < iArr.length; i++) {
			for (int j = 0; j < iArr[i].length; j++) {
				System.out.printf("%2d ", iArr[i][j]);
			}
			System.out.println();
		}
	}

	public void practice4() {
		int[][] iArr = new int[4][4];

		for (int i = 0; i < iArr.length; i++) {
			for (int j = 0; j < iArr[i].length - 1; j++) {
				iArr[i][j] = (int) (Math.random() * 10) + 1;
				iArr[i][3] += iArr[i][j];
			}
		}

		for (int i = 0; i < iArr.length; i++) {
			for (int j = 0; j < iArr[i].length; j++) {
				System.out.printf("%2d ", iArr[i][j]);
			}
			System.out.println();
		}
	}

	public void practice5() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("행 크기 : ");
			int num1 = sc.nextInt();
			System.out.print("열 크기 : ");
			int num2 = sc.nextInt();

			if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
				System.out.println("반드시 1~10 사이의 정수를 입력해야합니다.");
				continue;
			}

			char[][] cArr = new char[num1][num2];

			for (int i = 0; i < cArr.length; i++) {
				for (int j = 0; j < cArr[i].length; j++) {
					cArr[i][j] = (char) (Math.random() * 26 + 65);
				}
			}

			for (int i = 0; i < cArr.length; i++) {
				for (int j = 0; j < cArr[i].length; j++) {
					System.out.print(cArr[i][j]);
				}
				System.out.println();
			}
			break;
		}

		sc.close();
	}

	public void practice6() {
		String[][] strArr = new String[][] { { "이", "까", "왔", "앞", "힘" }, { "차", "지", "습", "으", "냅" },
				{ "원", "열", "니", "로", "시" }, { "배", "심", "다", "좀", "다" }, { "열", "히", "! ", "더", "!! " } };

		for (int i = 0; i < strArr.length; i++) {
			for (int j = 0; j < strArr[i].length; j++) {
				System.out.print(strArr[j][i] + " ");
			}
		}

	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);

		System.out.print("행의 크기 : ");
		int num = sc.nextInt();

		char[][] cArr = new char[num][];

		for (int i = 0; i < cArr.length; i++) {
			System.out.print(i + "행의 열 크기 : ");
			cArr[i] = new char[sc.nextInt()];
		}

		char value = 97;
		for (int i = 0; i < cArr.length; i++) {
			for (int j = 0; j < cArr[i].length; j++) {
				cArr[i][j] = value++;
			}
		}

		for (int i = 0; i < cArr.length; i++) {
			for (int j = 0; j < cArr[i].length; j++) {
				System.out.printf("%c ", cArr[i][j]);
			}
			System.out.println();
		}

		sc.close();
	}

	public void practice8() {
		String[] sArr = { "강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하" };

		String[][][] ssArr = new String[2][3][2];

		int count = 0;
		for (int i = 0; i < ssArr.length; i++) {
			for (int j = 0; j < ssArr[i].length; j++) {
				for (int k = 0; k < ssArr[i][j].length; k++) {
					ssArr[i][j][k] = sArr[count++];
				}
			}
		}

		for (int i = 0; i < ssArr.length; i++) {
			System.out.println("=== " + (i + 1) + "분단 ===");
			for (int j = 0; j < ssArr[i].length; j++) {
				for (int k = 0; k < ssArr[i][j].length; k++) {
					System.out.print(ssArr[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}

	}

	public void practice9() {
		String[] sArr = { "강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하" };

		String[][][] ssArr = new String[2][3][2];

		int count = 0;
		for (int i = 0; i < ssArr.length; i++) {
			for (int j = 0; j < ssArr[i].length; j++) {
				for (int k = 0; k < ssArr[i][j].length; k++) {
					ssArr[i][j][k] = sArr[count++];
				}
			}
		}

		for (int i = 0; i < ssArr.length; i++) {
			System.out.println("=== " + (i + 1) + "분단 ===");
			for (int j = 0; j < ssArr[i].length; j++) {
				for (int k = 0; k < ssArr[i][j].length; k++) {
					System.out.print(ssArr[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}

		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 학생 이름을 입력하세요  : ");
		String name = sc.nextLine();

		char[] line = new char[2];
		line[0] = '첫';
		line[1] = '두';
		String[] lr = new String[2];
		lr[0] = "왼";
		lr[1] = "오른";

		for (int i = 0; i < ssArr.length; i++) {
			for (int j = 0; j < ssArr[i].length; j++) {
				for (int k = 0; k < ssArr[i][j].length; k++) {
					if (ssArr[i][j][k].equals(name)) {
						System.out.println(
								"검색하신 " + name + " 학생은 " + (i + 1) + "분단 " + line[j] + " 번째 줄 " + lr[k] + "쪽에 있습니다.");
					}
				}
			}
		}

		sc.close();
	}

	public void practice10() {
		String[][] sArr = new String[6][6];

		Scanner sc = new Scanner(System.in);

		System.out.print("행 인덱스 입력 : ");
		int num1 = sc.nextInt() + 1;
		System.out.print("열 인덱스 입력 : ");
		int num2 = sc.nextInt() + 1;

		if (num1 < 1 || num1 > 5 || num2 < 1 || num2 > 5) {
			System.out.println("잘못된 범위");
			sc.close();
			return;
		}
		

		for (int i = 0; i < sArr.length; i++) {
			for (int j = 0; j < sArr[i].length; j++) {
				if (i == 0 && j > 0) {
					sArr[i][j] = String.valueOf(j - 1);
				} else if (j == 0 && i > 0) {
					sArr[i][j] = String.valueOf(i - 1);
				} else {
					sArr[i][j] = "";
				}
			}
		}
		
		sArr[num1][num2] = "X";
		
		for (int i = 0; i < sArr.length; i++) {
			for (int j = 0; j < sArr[i].length; j++) {
				System.out.printf("%2s", sArr[i][j]);
			}
			System.out.println();
		}

		sc.close();

	}

	public void practice11() {
		String[][] sArr = new String[6][6];

		for (int i = 0; i < sArr.length; i++) {
			for (int j = 0; j < sArr[i].length; j++) {
				if (i == 0 && j > 0) {
					sArr[i][j] = String.valueOf(j - 1);
				} else if (j == 0 && i > 0) {
					sArr[i][j] = String.valueOf(i - 1);
				} else {
					sArr[i][j] = "";
				}
			}
		}

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("행 인덱스 입력 : ");
			int num1 = sc.nextInt() + 1;

			if (num1 == 99 + 1) {
				System.out.println("프로그램 종료");
				break;
			}

			System.out.print("열 인덱스 입력 : ");
			int num2 = sc.nextInt() + 1;

			if (num1 < 1 || num1 > 5 || num2 < 1 || num2 > 5) {
				System.out.println("잘못된 범위");
				continue;
			}

			sArr[num1][num2] = "X";
			
			for (int i = 0; i < sArr.length; i++) {
				for (int j = 0; j < sArr[i].length; j++) {
					System.out.printf("%2s", sArr[i][j]);
				}
				System.out.println();
			}
		}

		sc.close();
	}

}
