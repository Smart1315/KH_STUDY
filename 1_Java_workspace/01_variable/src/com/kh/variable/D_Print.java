package com.kh.variable;

public class D_Print {
	
	public void printlnExample() {
		System.out.println("�ȳ��ϼ���");
		System.out.println("�ݰ����ϴ�");
		System.out.println(); // �ٹٲ޸� �ϴ� ��
	}
	
	public void printExample() {
		System.out.print("�ȳ��ϼ���");
		System.out.print("�ݰ����ϴ�");
//		System.out.print(); // The method print(boolean) in the type PrintStream is not applicable for the arguments ()
	}
	
	public void printfExample() {
		String str1 = "�ȳ��ϼ���";
		String str2 = "�ݰ����ϴ�";
//		System.out.printf(format, args); // format : ������ ����, args : �����Ϳ� �°� �� ����
		
		System.out.printf("%s, �ȿ����Դϴ�. %s.\n", str1, str2);
		System.out.printf("%s, ģ�ϰ� ������!", str2);
		
		System.out.println();
		
		// �̴� ����
		// �ȳ��ϼ���, ���� 25�� �ȿ����Դϴ�. ������ �ݰ����ϴ�.
		int age = 25;
		String name = "�ȿ���";
		String job = "�л�";
		
		System.out.printf("%s, ���� %d�� %s %s�Դϴ�. ������ %s.", str1, age, name, job, str2);
	}
}
