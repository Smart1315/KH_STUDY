package com.kh.practice.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import com.kh.practice.set.model.compare.SortedLottery;
import com.kh.practice.set.model.vo.Lottery;

public class LotteryController {
	private HashSet<Lottery> lottery = new HashSet<Lottery>();
	private HashSet<Lottery> win = new HashSet<Lottery>();

	public boolean insertObject(Lottery l) {
		return lottery.add(l);
	}

	public boolean deleteobject(Lottery l) {
		if (lottery.remove(l)) {
			if (win != null) {
				win.remove(l);
			}
			return true;
		} else {
			return false;
		}
	}

	public HashSet<Lottery> winObject() {
		if (!(lottery.size() >= 4)) {
			return null;
		}

		if (win.size() == 4) {
			return win;
		}

		ArrayList<Lottery> lList = new ArrayList<Lottery>(lottery);

		while (win.size() != 4) {
			int randomNum = (int) (Math.random() * lList.size());
			if (!win.contains(lList.get(randomNum))) {
				win.add(lList.get(randomNum));
			}
		}

		return win;
	}

	public TreeSet<Lottery> sortedWinObject() {
		winObject();
		TreeSet<Lottery> t = new TreeSet<Lottery>(new SortedLottery());
		t.addAll(win);

		return t;
	}

	public boolean searchWinner(Lottery l) {
		winObject();
		return win.contains(l);
	}
}
