package com.kh.practice.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

	public void practice1() {
		int[] iArr = new int[10];

		for (int i = 0; i < iArr.length; i++) {
			iArr[i] = i + 1;
		}

		for (int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
	}

	public void practice2() {
		int[] iArr = new int[10];

		for (int i = 0; i < iArr.length; i++) {
			iArr[i] = 10 - i;
		}

		for (int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
	}

	public void practice3() {
		Scanner sc = new Scanner(System.in);

		System.out.print("양의 정수 : ");
		int num = sc.nextInt();

		if (num < 1) {
			System.out.println("양의 정수를 입력하세요.");
			sc.close();
			return;
		}

		int[] iArr = new int[num];

		for (int i = 0; i < iArr.length; i++) {
			iArr[i] = i + 1;
		}

		for (int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}

		sc.close();
	}

	public void practice4() {
		String[] fruit = { "사과", "귤", "포도", "복숭아", "참외" };

		System.out.println(fruit[1]);
	}

	public void practice5() {
		Scanner sc = new Scanner(System.in);

		System.out.print("문자열 : ");
		String text = sc.nextLine();
		char[] t = new char[text.length()];
		for (int i = 0; i < text.length(); i++) {
			t[i] = text.charAt(i);
		}

		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);

		System.out.print(text + "에 " + ch + "가 존재하는 위치(인덱스) : ");

		int count = 0;
		for (int i = 0; i < t.length; i++) {
			if (t[i] == ch) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println();
		System.out.println(ch + " 개수 : " + count);

		sc.close();
	}

	public void practice6() {
		String[] dow = { "월", "화", "수", "목", "금", "토", "일" };

		Scanner sc = new Scanner(System.in);

		System.out.print("0 ~ 6 사이 숫자 입력 : ");
		int num = sc.nextInt();

		if (num < 0 || num >= dow.length) {
			System.out.println("잘못 입력하셨습니다.");
			sc.close();
			return;
		}

		System.out.println(dow[num] + "요일");

		sc.close();
	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 : ");
		int num = sc.nextInt();

		int[] iArr = new int[num];

		for (int i = 0; i < iArr.length; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
			iArr[i] = sc.nextInt();
		}

		int total = 0;
		for (int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
			total += iArr[i];
		}
		System.out.println();
		System.out.println("총 합 : " + total);

		sc.close();
	}

	public void practice8() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("정수 : ");
			int num = sc.nextInt();

			if (num < 3 || num % 2 == 0) {
				System.out.println("다시 입력하세요.");
				continue;
			}

			int[] iArr = new int[num];

			int value = 1;
			for (int i = 0; i < iArr.length; i++) {
				if (i < iArr.length / 2) {
					iArr[i] = value++;
				} else {
					iArr[i] = value--;
				}
			}

			for (int i = 0; i < iArr.length; i++) {
				if (i == iArr.length - 1) {
					System.out.print(iArr[i]);
				} else {
					System.out.print(iArr[i] + ", ");
				}
			}
			break;
		}

		sc.close();
	}

	public void practice9() {
		Scanner sc = new Scanner(System.in);

		String[] ch = { "양념", "간장", "후라이드" };

		System.out.print("치킨 이름을 입력하세요 : ");
		String cname = sc.nextLine();

		boolean res = false;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i].equals(cname)) {
				res = true;
				break;
			}
		}

		if (res) {
			System.out.println(cname + "치킨 배달 가능");
		} else {
			System.out.println(cname + "치킨은 없는 메뉴입니다.");
		}

		sc.close();
	}

	public void practice10() {
		Scanner sc = new Scanner(System.in);

		System.out.print("주민등록번호(-포항) : ");
		String pnum = sc.nextLine();

		char[] onum = new char[pnum.length()];

		for (int i = 0; i < pnum.length(); i++) {
			onum[i] = pnum.charAt(i);
		}

		char[] copynum = Arrays.copyOf(onum, onum.length);

		boolean dis = false;

		for (int i = 0; i < copynum.length; i++) {
			if (dis) {
				copynum[i] = '*';
			}
			if (copynum[i] == '-') {
				dis = true;
				i++;
			}
		}

		for (int i = 0; i < copynum.length; i++) {
			System.out.print(copynum[i]);
		}

		sc.close();
	}

	public void practice11() {
		int[] iArr = new int[10];

		for (int i = 0; i < iArr.length; i++) {
			iArr[i] = (int) (Math.random() * 10) + 1;
		}

		for (int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
	}

	public void practice12() {
		int[] iArr = new int[10];

		for (int i = 0; i < iArr.length; i++) {
			iArr[i] = (int) (Math.random() * 10) + 1;
		}

		int min = iArr[0];
		int max = iArr[0];

		for (int i = 0; i < iArr.length; i++) {
			if (iArr[i] > max) {
				max = iArr[i];
				continue;
			}
			if (iArr[i] < min) {
				min = iArr[i];
				continue;
			}
		}

		for (int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
		System.out.println();
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}

	public void practice13() {
		int[] iArr = new int[10];

		for (int i = 0; i < iArr.length; i++) {
			iArr[i] = (int) (Math.random() * 10) + 1;

			for (int j = 0; j < i; j++) {
				if (iArr[i] == iArr[j]) {
					i--;
					break;
				}
			}
		}

		for (int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
	}

	public void practice14() {
		int[] iArr = new int[10];

		for (int i = 0; i < iArr.length; i++) {
			iArr[i] = (int) (Math.random() * 45) + 1;

			for (int j = 0; j < i; j++) {
				if (iArr[i] == iArr[j]) {
					i--;
					break;
				}
			}
		}

		for (int i = 0; i < iArr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (iArr[i] < iArr[j]) {
					int temp = iArr[i];
					iArr[i] = iArr[j];
					iArr[j] = temp;
				}
			}
		}

		for (int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
	}

	public void practice15() {
		Scanner sc = new Scanner(System.in);

		System.out.print("문자열 : ");
		String text = sc.nextLine();
		char[] t = new char[text.length()];

		for (int i = 0; i < text.length(); i++) {
			t[i] = text.charAt(i);
		}

		int count = 0;
		for (int i = 0; i < t.length; i++) {
			boolean res = false;
			for (int j = 0; j < i; j++) {
				if (t[i] == t[j]) {
					t[i] = ' ';
					res = true;
				}
			}
			if (!res) {
				count++;
			}
		}
		char[] t1 = new char[count];
		int index = 0;
		for (int i = 0; i < t.length; i++) {
			if (t[i] != ' ') {
				t1[index] = t[i];
				index++;
			}
		}

		System.out.print("문자열에 있는 문자 : ");
		for (int i = 0; i < t1.length; i++) {
			if (i == t1.length - 1) {
				System.out.print(t1[i]);
			} else {
				System.out.print(t1[i] + ", ");
			}
		}
		System.out.println();
		System.out.println("문자 개수 : " + t1.length);

		sc.close();
	}

	public void practice16() {
		Scanner sc = new Scanner(System.in);

		System.out.print("배열의 크기를 입력하세요 : ");
		int num = sc.nextInt();
		sc.nextLine();
		String[] tArr = new String[num];

		for (int i = 0; i < tArr.length; i++) {
			System.out.print((i + 1) + "번째 문자열 : ");
			tArr[i] = sc.nextLine();
		}

		while (true) {
			System.out.print("더 값을 입력하시겠습니까(Y/N) : ");
			char ch = sc.nextLine().charAt(0);
			num = 0;
			if (ch == 'Y' || ch == 'y') {
				System.out.print("더 입력하고 싶은 개수 : ");
				num = sc.nextInt();
				sc.nextLine();
			} else if (ch == 'N' || ch == 'n') {
				break;
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
			}

			String[] temp = Arrays.copyOf(tArr, tArr.length);

			tArr = new String[temp.length + num];

			for (int i = 0; i < tArr.length; i++) {
				if (i < temp.length) {
					tArr[i] = temp[i];
				} else {
					System.out.print((i + 1) + "번째 문자열 : ");
					tArr[i] = sc.nextLine();
				}
			}
		}

		System.out.print("[");
		for (int i = 0; i < tArr.length; i++) {
			if(i == tArr.length - 1) {
				System.out.print(tArr[i]);
			} else {
				System.out.print(tArr[i] + ", ");
			}
		}
		System.out.println("]");
		
		sc.close();
	}

}
