package com.kh.example.dimension;

public class DimensionalArray {

	public void method1() {
		// 2차원 배열 선언
		// 자료형[][] 배열명;
		// 자료형 배열명[][];
		// 자료형[] 배열명[];

		int[][] iArr1;
//		int iArr2[][];
//		int[] iArr3[];
		// 선언을 하게되면 stack에 공간이 만들어짐

		// 2차원 배열 할당
		// 크기지정은 행과 열 둘 다 해야 함
		iArr1 = new int[3][5]; // 정변배열

//		System.out.println("iArr1 : " + iArr1);
//		System.out.println("iArr1[0] : " + iArr1[0]);
//		System.out.println("iArr1[1] : " + iArr1[1]);
//		System.out.println("iArr1[2] : " + iArr1[2]);
//		
//		System.out.println("iArr1[0][0] : " + iArr1[0][0]);
//		System.out.println("iArr1[0][1] : " + iArr1[0][1]);
//		System.out.println("iArr1[0][2] : " + iArr1[0][2]);
//		System.out.println("iArr1[0][3] : " + iArr1[0][3]);
//		System.out.println("iArr1[0][4] : " + iArr1[0][4]);
//		
//		System.out.println("iArr1[1][0] : " + iArr1[1][0]);
//		System.out.println("iArr1[1][1] : " + iArr1[1][1]);
//		System.out.println("iArr1[1][2] : " + iArr1[1][2]);
//		System.out.println("iArr1[1][3] : " + iArr1[1][3]);
//		System.out.println("iArr1[1][4] : " + iArr1[1][4]);
//		
//		System.out.println("iArr1[2][0] : " + iArr1[2][0]);
//		System.out.println("iArr1[2][1] : " + iArr1[2][1]);
//		System.out.println("iArr1[2][2] : " + iArr1[2][2]);
//		System.out.println("iArr1[2][3] : " + iArr1[2][3]);
//		System.out.println("iArr1[2][4] : " + iArr1[2][4]);
//		System.out.println();
//		
		for (int i = 0; i < iArr1.length; i++) {
			for (int j = 0; j < iArr1[i].length; j++) {
//				iArr1[i][j] = (i * iArr1[i].length) + j; // 정변배열에 한해 0부터 순서대로 값이 대입됨
				System.out.println("iArr1[" + i + "][" + j + "] : " + iArr1[i][j]);
			}
			System.out.println();
		}
	}

	public void method2() {
		// 3행 5열짜리 int만 들어갈 수 있는 iArr 배열 생성
		int[][] iArr = new int[3][5];

		// 값 기록
		// 1. 배열 인덱스에 접근하여 값 기록
		iArr[0][0] = 1;
		iArr[0][1] = 2;
		iArr[0][2] = 3;
		iArr[0][3] = 4;
		iArr[0][4] = 5;

		iArr[1][0] = 6;
		iArr[1][1] = 7;
		iArr[1][2] = 8;
		iArr[1][3] = 9;
		iArr[1][4] = 10;

		iArr[2][0] = 11;
		iArr[2][1] = 12;
		iArr[2][2] = 13;
		iArr[2][3] = 14;
		iArr[2][4] = 15;

		// 2. 이중 for문을 이용하여 값 기록
		int value = 1;
		for (int i = 0; i < iArr.length; i++) {
			for (int j = 0; j < iArr[i].length; j++) {
//				iArr[i][j] = (i * iArr[i].length) + j + 1;
				iArr[i][j] = value++;
			}
		}

		// 3. 선언과 동시에 초기화
		int[][] iArr2 = { { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 } };

		for (int i = 0; i < iArr.length; i++) {
			for (int j = 0; j < iArr[i].length; j++) {
				System.out.printf("%2d ", iArr[i][j]);
			}
			System.out.println();
		}

		for (int i = 0; i < iArr2.length; i++) {
			for (int j = 0; j < iArr2[i].length; j++) {
				System.out.printf("%-2d", iArr2[i][j]);
			}
			System.out.println();
		}
	}

	public void method3() {
		// 가변 배열
		// 행은 정해져 있으나 각 행에 대한 열이 정해지지 않은 상태
		int[][] iArr = new int[3][]; // 가변배열 할당

//		for (int i = 0; i < iArr.length; i++) {
//			for (int j = 0; j < iArr[i].length; j++) { // NullPointerException
//				System.out.println(iArr[i][j]);
//			}
//		}

		iArr[0] = new int[2];
		iArr[1] = new int[4];
		iArr[2] = new int[3];

		for (int i = 0; i < iArr.length; i++) {
			for (int j = 0; j < iArr[i].length; j++) {
				System.out.printf("%d ", iArr[i][j]);
			}
			System.out.println();
		}

		// 값 기록
		// 1. 인덱스로 접근하여 값 기록

		iArr[0][0] = 1;
		iArr[0][1] = 2;

		iArr[1][0] = 3;
		iArr[1][1] = 4;
		iArr[1][2] = 5;
		iArr[1][3] = 6;

		iArr[2][0] = 7;
		iArr[2][1] = 8;
		iArr[2][2] = 9;

		// 2. 이중 for문을 이용하여 값 기록
		int value = 1;
		for (int i = 0; i < iArr.length; i++) {
			for (int j = 0; j < iArr[i].length; j++) {
				iArr[i][j] = value++;
			}
		}

		for (int i = 0; i < iArr.length; i++) {
			for (int j = 0; j < iArr[i].length; j++) {
				System.out.printf("%d ", iArr[i][j]);
			}
			System.out.println();
		}

		// 3. 선언과 동시에 초기화
		int[][] iArr2 = { { 1, 2, 3 }, { 4, 5 }, { 7, 8, 9, 10 } };

		for (int i = 0; i < iArr2.length; i++) {
			for (int j = 0; j < iArr2[i].length; j++) {
				System.out.printf("%d ", iArr2[i][j]);
			}
			System.out.println();
		}
	}
}
