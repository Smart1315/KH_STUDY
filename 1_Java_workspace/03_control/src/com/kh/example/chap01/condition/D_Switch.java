package com.kh.example.chap01.condition;

import java.util.Scanner;

public class D_Switch {
	// 조건식의 결과 값을 case에서 찾아 명령을 수행하는 조건문
	// 해당하는 값이 case에 없을 경우에는 default의 명령문 수행

	// case와 수행문 사이에는 콜론(:)을 써야 함
	// break가 없으면 멈추지 않고 계속 수행

	// switch(변수) {
	// case 값1: 실행문1; break;
	// case 값2: 실행문2; break;
	// default: 실행문3;
	// }

	public void method1() {
		// 정수 두 개와 연산기호 문자 1개를 입력받아
		// 연산 기호 문자에 해당하는 계산을 수행하고 출력하시오
		Scanner sc = new Scanner(System.in);

		System.out.print("첫 번째 값 : ");
		int first = sc.nextInt();
		System.out.print("두 번째 값 : ");
		int second = sc.nextInt();

		sc.nextLine();
		System.out.print("연산자(+, -, *, /) : ");
		char op = sc.nextLine().charAt(0);

		int result = 0;

		switch (op) {
		case '+':
			result = first + second;
			break;
		case '-':
			result = first - second;
			break;
		case '*':
			result = first * second;
			break;
		case '/':
			result = first / second;
			break;

		default:
			System.out.println("입력 오류");
			break;
		}

		System.out.println(result);

		sc.close();
	}

	public void method2() {
		Scanner sc = new Scanner(System.in);

		System.out.println("***********과일가게***********");
		System.out.println("사과, 바나나 , 복숭아, 키위 있습니다.");
		System.out.print("어떤 과일의 가격이 궁금하세요? : ");
		String fruit = sc.nextLine();

		int price = 0;

		switch (fruit) {
		case "사과":
			price = 1000;
			break;
		case "바나나":
			price = 3000;
			break;
		case "복숭아":
			price = 2000;
			break;
		case "키위":
			price = 5000;
			break;
		default:
			System.out.println("그 과일은 취급하지 않습니다.");
			break;
		}

		System.out.println(fruit + "의 가격은 " + price + "원 입니다.");

		sc.close();
	}

	public void method3() {
		// 1월부터 12월까지 입력받아 해당하는 달의 마지막 날짜를 출력하세요
		Scanner sc = new Scanner(System.in);

		System.out.print("1월~12월까지 중 하나를 입력하세요 : ");
		int num = sc.nextInt();


//		switch (num) {
//		case 1:
//			System.out.println("31일 까지입니다.");
//			break;
//		case 2:
//			System.out.println("28일 까지입니다.");
//			break;
//		case 3:
//			System.out.println("31일 까지입니다.");
//			break;
//		case 4:
//			System.out.println("30일 까지입니다.");
//			break;
//		case 5:
//			System.out.println("31일 까지입니다.");
//			break;
//		case 6:
//			System.out.println("30일 까지입니다.");
//			break;
//		case 7:
//			System.out.println("31일 까지입니다.");
//			break;
//		case 8:
//			System.out.println("31일 까지입니다.");
//			break;
//		case 9:
//			System.out.println("30일 까지입니다.");
//			break;
//		case 11:
//			System.out.println("30일 까지입니다.");
//			break;
//		case 10:
//			System.out.println("31일 까지입니다.");
//			break;
//		case 12:
//			System.out.println("31일 까지입니다.");
//			break;
//		default:
//			System.out.println("입력 오류");
//			break;
//		}

		switch (num) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("31일 까지입니다.");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30일 까지입니다.");
			break;
		case 2:
			System.out.println("28일 까지입니다.");
			break;
		default:
			System.out.println("입력 오류");
			break;
		}

		sc.close();
	}
	
	public void method4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("***** G클래스 우리의 메뉴입니다. *****");
		System.out.println("1. 간단하게 계산하기");
		System.out.println("2. 과일 가게");
		System.out.println("3. 월의 마지막 날 출력");
		System.out.print("메뉴 번호 : ");
		int menu = sc.nextInt();
		
		switch (menu) {
		case 1:
			System.out.println("간단 계산");
			method1();
			break;
		case 2:
			System.out.println("과일 가게");
			method2();
			break;
		case 3:
			System.out.println("월의 마지막날");
			method3();
			break;
		default:
			System.out.println("입력 오류");
			break;
		}
		
		sc.close();
	}
}
