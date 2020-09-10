package com.kh.mini.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import com.kh.mini.model.compare.SortBoard;
import com.kh.mini.model.dao.BoardDAO;
import com.kh.mini.model.vo.Board;

public class BoardController {
	private BoardDAO bd = new BoardDAO();

	public void writeBoard(Board b) {
		ArrayList<Board> list = readBoard();

		if (list.size() == 0) {
			b.setNum(1);
		} else {
			int num = 0;
			for (int i = 0; i < list.size(); i++) {
				int cNum = list.get(i).getNum();
				if (cNum > num) {
					num = cNum;
				}
			}
			b.setNum(num + 1);
		}

		bd.writeBoard(b);
	}

	public ArrayList<Board> readBoard() {
		return bd.readBoard();
	}

	public Board readBoard(int boardNo) {
		return bd.readBoard(boardNo);
	}

	public Object[][] loadBoard() {
		ArrayList<Board> list = readBoard();
		ArrayList<Board> nlist = new ArrayList<Board>();

		for (int i = 0; i < list.size(); i++) {
			Board b = list.get(i);
			if (b.isNotice()) {
				Calendar c = Calendar.getInstance();
				c.setTimeInMillis(b.getRegDate().getTime() + 604800000);
				if (Calendar.getInstance().compareTo(c) == -1) {
					nlist.add(b);
					list.remove(i--);
				} else {
					b.setNotice(false);
					list.set(i, b);
				}
			}
		}

		nlist.sort(new SortBoard());
		Collections.sort(list);

		list.addAll(0, nlist);

		Object[][] o = new Object[list.size()][];

		for (int i = 0; i < o.length; i++) {
			Board b = list.get(i);
			o[i] = b.toArray();
		}

		return o;
	}

	public void editBoard(Board board) {
		bd.writeBoard(board);
	}

	public void deleteBoard(int boardNo) {
		bd.deleteBoard(boardNo);
	}

	public Object[][] searchBoard(int option, String data) {
		ArrayList<Board> list = readBoard();
		ArrayList<Board> nlist = new ArrayList<Board>();

		for (int i = 0; i < list.size(); i++) {
			Board b = list.get(i);
			if (b.isNotice()) {
				Calendar c = Calendar.getInstance();
				c.setTimeInMillis(b.getRegDate().getTime() + 604800000);
				if (Calendar.getInstance().compareTo(c) == -1) {
					nlist.add(b);
					list.remove(i--);
				} else {
					b.setNotice(false);
					list.set(i, b);
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			Board b = list.get(i);
			if (option == 0) {
				if (!b.getTitle().contains(data)) {
					list.remove(i--);
				}
			} else if (option == 1) {
				if (!b.getContent().contains(data)) {
					list.remove(i--);
				}
			} else if (option == 2) {
				if (!b.getId().contains(data)) {
					list.remove(i--);
				}
			}
		}

		nlist.sort(new SortBoard());
		Collections.sort(list);

		list.addAll(0, nlist);

		Object[][] o = new Object[list.size()][];
		for (int i = 0; i < o.length; i++) {
			o[i] = list.get(i).toArray();
		}

		return o;
	}

}
