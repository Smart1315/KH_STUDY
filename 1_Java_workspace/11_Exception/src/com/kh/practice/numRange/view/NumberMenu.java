package com.kh.practice.numRange.view;

import java.util.Scanner;

import com.kh.practice.numRange.controller.NumberController;
import com.kh.practice.numRange.exception.NumRangeException;

public class NumberMenu {

	public void menu() {
		try (Scanner sc = new Scanner(System.in);) {
			NumberController nc = new NumberController();

			System.out.print("����1 : ");
			int num1 = sc.nextInt();
			System.out.print("����2 : ");
			int num2 = sc.nextInt();
			sc.nextLine();

			boolean cd = nc.checkDouble(num1, num2);
			System.out.println(num1 + "��(��) " + num2 + "�� ����ΰ� ? " + cd);
		} catch (NumRangeException e) {
			e.printStackTrace();
		}
	}
}
