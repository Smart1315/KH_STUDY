package com.kh.example.array;

import java.util.Arrays;

public class B_ArrayCopy {
	// 얕은 복사 : 배열의 주소만 복사
	// 깊은 복사 : 새로운 배열을 만들어 실제 내부 값 복사

	public void method1() {
		int[] originArr = { 1, 2, 3, 4, 5 };
		int[] copyArr = originArr; // 얕은 복사

		for (int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();

		originArr[0] = 99;

		for (int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();

		System.out.println("originArr의 주소 : " + originArr);
		System.out.println("copyArr의 주소 : " + copyArr);
	}

	public void method2() {
		int[] originArr = { 1, 2, 3, 4, 5 };
		int[] copyArr = new int[5];

		// 1. for문을 이용한 복사
		for (int i = 0; i < originArr.length; i++) {
			copyArr[i] = originArr[i];
		}

		for (int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();

		originArr[0] = 99;

		for (int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();

		System.out.println("originArr의 주소 : " + originArr);
		System.out.println("copyArr의 주소 : " + copyArr);

	}

	public void method3() {
		int[] originArr = { 1, 2, 3, 4, 5 };
		int[] copyArr = new int[10];

		System.out.println("=== 복사 전 ===");
		for (int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();
		// 2.System클래스의 arraycopy() 메소드를 이용한 복사
//						매개변수(인자) : 해당 메소드에 값 전달
//		System.arraycopy(src, srcPos, dest, destPos, length);
//		src : 원본 배열
//		serPos : 원본 배열에서 복사를 시작할 위치
//		dest : 복사 배열
//		destPos : 복사 배열에서 붙여넣기를 시작할 위치
//		length : 복사 길이

		// originArr배열의 모든 데이터를 copyArr에 복사하는데
		// copyArr의 3 인덱스부터 붙여넣기
		System.arraycopy(originArr, 0, copyArr, 3, originArr.length);

		System.out.println("=== 복사 후 ===");
		for (int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();

	}

	public void method4() {
		int[] originArr = { 1, 2, 3, 4, 5 };
		int[] copyArr = new int[10];

		System.out.println("=== 복사 전 ===");
		for (int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();

		// 3. Arrays클래스의 copyOf() 메소드 이용
//		Arrays.copyOf(original, newLength);
//		original : 원본 배열
//		newLength : 새로운 길이
		copyArr = Arrays.copyOf(originArr, originArr.length);

		System.out.println("=== 복사 후 ===");
		for (int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();
	}
}
