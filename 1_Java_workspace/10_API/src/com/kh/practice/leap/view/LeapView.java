package com.kh.practice.leap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.kh.practice.leap.controller.LeapController;

public class LeapView {

	public LeapView() {
		Calendar c = new GregorianCalendar();
		LeapController lc = new LeapController();

		int year = c.get(Calendar.YEAR);
		if (lc.isLeapYear(year)) {
			System.out.println(year + "���� �����Դϴ�.");
		} else {
			System.out.println(year + "���� ����Դϴ�.");
		}
		
		System.out.println("�� ��¥ �� : " + lc.leapDate(c));
	}
}
