package com.kh.practice.set.model.compare;

import java.util.Comparator;

import com.kh.practice.set.model.vo.Lottery;

public class SortedLottery implements Comparator<Lottery> {

	@Override
	public int compare(Lottery o1, Lottery o2) {
		String standard = o1.getName();
		String object = o2.getName();

		int res = standard.compareTo(object);
		if (res != 0) {
			return res;
		} else {
			return o1.getPhone().compareTo(o2.getPhone());
		}

	}

}
