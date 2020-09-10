package com.kh.mini.model.compare;

import java.util.Comparator;

import com.kh.mini.model.vo.Board;

public class SortBoard implements Comparator<Board> {

	@Override
	public int compare(Board o1, Board o2) {
		int num1 = o1.getNum();
		int num2 = o2.getNum();

		return Integer.compare(num1, num2);
	}

}
