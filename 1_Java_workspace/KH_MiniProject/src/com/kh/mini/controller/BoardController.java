package com.kh.mini.controller;

import java.util.ArrayList;

import com.kh.mini.model.vo.Board;
import com.kh.mini.model.vo.Communication;

public class BoardController {

	private CommunicationController cc = new CommunicationController();

	public void writeBoard(Board b) {
		cc.connect("writeBoard", b);
	}

	public ArrayList<Board> readBoard() {
		Communication result = cc.connect("readBoard", null);
		return (ArrayList<Board>) result.getData();
	}

	public Board readBoard(int boardNo) {
		Communication result = cc.connect("readBoard", boardNo);
		return (Board) result.getData();
	}

	public Object[][] loadBoard() {
		Communication result = cc.connect("loadBoard", null);
		return (Object[][]) result.getData();
	}

	public void editBoard(Board board) {
		cc.connect("editBoard", board);
	}

	public void deleteBoard(int boardNo) {
		cc.connect("deleteBoard", boardNo);
	}

	public Object[][] searchBoard(int option, String data) {
		Object[] o = { option, data };
		Communication result = cc.connect("searchBoard", o);

		return (Object[][]) result.getData();
	}

}
