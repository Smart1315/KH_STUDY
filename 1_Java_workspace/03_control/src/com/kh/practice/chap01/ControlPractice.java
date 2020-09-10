package com.kh.practice.chap01;

import java.util.Scanner;

public class ControlPractice {

	public void practice1() {
		Scanner sc = new Scanner(System.in);

		System.out.println("1. �Է�");
		System.out.println("2. ����");
		System.out.println("3. ��ȸ");
		System.out.println("4. ����");
		System.out.println("7. ����");
		System.out.print("�޴� ��ȣ�� �Է��ϼ��� : ");
		int num = sc.nextInt();

		switch (num) {
		case 1:
			System.out.println("�Է� �޴��Դϴ�.");
			break;
		case 2:
			System.out.println("���� �޴��Դϴ�.");
			break;
		case 3:
			System.out.println("��ȸ �޴��Դϴ�.");
			break;
		case 4:
			System.out.println("���� �޴��Դϴ�.");
			break;
		case 7:
			System.out.println("���� �޴��Դϴ�.");
			break;

		default:
			System.out.println("�Է� ����");
			break;
		}

		sc.close();
	}

	public void practice2() {
		Scanner sc = new Scanner(System.in);

		System.out.print("���ڸ� �� �� �Է��ϼ��� : ");
		int num = sc.nextInt();

		if (num > 0) {
			if (num % 2 == 0) {
				System.out.print("¦����");
			} else {
				System.out.print("Ȧ����");
			}
		} else {
			System.out.print("����� �Է����ּ���.");
		}
		sc.close();
	}

	public void practice3() {
		Scanner sc = new Scanner(System.in);

		System.out.print("�������� : ");
		int num1 = sc.nextInt();
		System.out.print("�������� : ");
		int num2 = sc.nextInt();
		System.out.print("�������� : ");
		int num3 = sc.nextInt();

		int hap = num1 + num2 + num3;
		double result = hap / 3;

		if (num1 >= 40 && num2 >= 40 && num3 >= 40 && result >= 60) {
			System.out.println("���� : " + num1);
			System.out.println("���� : " + num2);
			System.out.println("���� : " + num3);
			System.out.println("�հ� : " + hap);
			System.out.println("��� : " + result);
			System.out.println("�����մϴ�, �հ��Դϴ�!");
		} else {
			System.out.println("���հ��Դϴ�.");
		}

		sc.close();
	}

	public void practice4() {
		Scanner sc = new Scanner(System.in);

		System.out.print("1~12 ������ ���� �Է� : ");
		int num = sc.nextInt();

		switch (num) {
		case 3:
		case 4:
		case 5:
			System.out.println(num + "���� ���Դϴ�.");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println(num + "���� �����Դϴ�.");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println(num + "���� �����Դϴ�.");
			break;
		case 12:
		case 1:
		case 2:
			System.out.println(num + "���� �ܿ��Դϴ�.");
			break;
		default:
			System.out.println(num + "���� �߸� �Էµ� ���Դϴ�.");
			break;
		}

		sc.close();
	}

	public void practice5() {
		Scanner sc = new Scanner(System.in);

		System.out.print("���̵� : ");
		String id = sc.nextLine();
		System.out.print("��й�ȣ : ");
		String pw = sc.nextLine();

		String mid = "myId";
		String mpw = "myPassword12";

		if (id.equals(mid) && pw.equals(mpw)) {
			System.out.println("�α��� ����");
		} else {
			if (!id.equals(mid) && !pw.equals(mpw)) {
				System.out.println("���̵�� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			} else if (!id.equals(mid)) {
				System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
			} else {
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			}
		}

		sc.close();
	}

	public void practice6() {
		Scanner sc = new Scanner(System.in);

		System.out.print("������ Ȯ���ϰ��� �ϴ� ȸ�� ��� : ");
		String level = sc.nextLine();

		if (level.equals("��ȸ��")) {
			System.out.println("�Խñ� ��ȸ");
		} else if (level.equals("ȸ��")) {
			System.out.println("�Խñ� �ۼ�, �Խñ� ��ȸ, ��� �ۼ�");
		} else if (level.equals("������")) {
			System.out.println("ȸ������, �Խñ� ����, �Խñ� �ۼ�, �Խñ� ��ȸ, ��� �ۼ�, �Խñ� ��ȸ");
		} else {
			System.out.println("�Է� ����");
		}

		sc.close();
	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Ű(m)�� �Է��� �ּ��� : ");
		double height = sc.nextDouble();
		System.out.print("������(kg)�� �Է��� �ּ��� : ");
		double weight = sc.nextDouble();

		double bmi = weight / (height * height);
		System.out.println("BMI ���� : " + bmi);
		if (bmi >= 30) {
			System.out.println("�� ��");
		} else if (bmi >= 25) {
			System.out.println("��");
		} else if (bmi >= 23) {
			System.out.println("��ü��");
		} else if (bmi >= 18.5) {
			System.out.println("����ü��");
		} else {
			System.out.println("��ü��");
		}

		sc.close();

	}

	public void practice8() {
		Scanner sc = new Scanner(System.in);

		System.out.print("�ǿ�����1 �Է� : ");
		int num1 = sc.nextInt();
		System.out.print("�ǿ�����2 �Է� : ");
		int num2 = sc.nextInt();
		sc.nextLine();
		System.out.print("�����ڸ� �Է�(+, -, *, /, %) : ");
		char op = sc.nextLine().charAt(0);
		double result = 0.0;

		if (num1 > 0 && num2 > 0) {
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
				result = (double) num1 / num2;
				break;
			case '%':
				result = num1 % num2;
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.");
				break;
			}
			System.out.printf("%d %c %d = %.6f\n", num1, op, num2, result);
		} else {
			System.out.println("����� ��� �����մϴ�. ���α׷��� �����մϴ�.");
		}

		sc.close();
	}

	public void practice9() {
		Scanner sc = new Scanner(System.in);

		System.out.print("�߰� ��� ���� : ");
		int num1 = sc.nextInt();
		System.out.print("�⸻ ��� ���� : ");
		int num2 = sc.nextInt();
		System.out.print("���� ���� : ");
		int num3 = sc.nextInt();
		System.out.print("�⼮ ȸ�� : ");
		int num4 = sc.nextInt();

		double inum1 = num1 * 0.2;
		double inum2 = num2 * 0.3;
		double inum3 = num3 * 0.3;
		double inum4 = num4 * 1.0;

		double result = inum1 + inum2 + inum3 + inum4;

		System.out.println("============ ��� ============");
		if (inum4 > (20 * 0.7)) {
			System.out.println("�߰� ��� ����(20) : " + inum1);
			System.out.println("�⸻ ��� ����(30) : " + inum2);
			System.out.println("���� ����      (30) : " + inum3);
			System.out.println("�⼮ ����      (20) : " + inum4);
			System.out.println("���� : " + result);

			if (result >= 70) {
				System.out.println("PASS");
			} else {
				System.out.println("Fail [���� �̴�]");
			}
		} else {
			System.out.println("Fail [�⼮ ȸ�� ���� (" + num4 + "/" + 20 + ")]");
		}

		sc.close();
	}

	public void practice10() {
		Scanner sc = new Scanner(System.in);

		System.out.println("������ ����� �����ϼ���.");
		System.out.println("1. �޴� ���");
		System.out.println("2. ¦��/Ȧ��");
		System.out.println("3. �հ�/���հ�");
		System.out.println("4. ����");
		System.out.println("5. �α���");
		System.out.println("6. ���� Ȯ��");
		System.out.println("7. BMI");
		System.out.println("8. ����");
		System.out.println("9. P/F");
		System.out.print("���� : ");
		int select = sc.nextInt();

		switch (select) {
		case 1:
			practice1();
			break;
		case 2:
			practice2();
			break;
		case 3:
			practice3();
			break;
		case 4:
			practice4();
			break;
		case 5:
			practice5();
			break;
		case 6:
			practice6();
			break;
		case 7:
			practice7();
			break;
		case 8:
			practice8();
			break;
		case 9:
			practice9();
			break;
		default:
			System.out.println("�Է� ����");
			break;
		}

		sc.close();
	}

	public void practice11() {
		Scanner sc = new Scanner(System.in);

		System.out.print("��й�ȣ �Է�(1000~9999) : ");
		int pw = sc.nextInt();

		int a, b, c, d;

		if (pw >= 1000 && pw <= 9999) {
			a = pw / 1000;
			b = pw % 1000 / 100;
			c = pw % 100 / 10;
			d = pw % 10;

			if (a != b && b != c && c != d && d != a) {
				System.out.println("����");
			} else {
				System.out.println("����");
			}
		} else {
			System.out.println("�ڸ��� �ȸ���");
		}

		sc.close();
	}

}
