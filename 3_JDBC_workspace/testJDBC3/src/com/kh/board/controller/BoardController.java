package com.kh.board.controller;

import java.util.ArrayList;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.member.controller.MemberController;
import com.kh.view.View;

public class BoardController {
	private View menu = new View();
	private BoardService bService = new BoardService();

	public void selectAll() {
		ArrayList<Board> bList = bService.selectAll();

		if (!bList.isEmpty()) {
			menu.selectAll(bList);
		} else {
			menu.displayError("조회 결과가 없습니다.");
		}
	}

	public void selectOne() {
		int bNo = menu.inputBNo();

		Board board = bService.selectOne(bNo);

		if (board != null) {
			menu.selectOne(board);
		} else {
			menu.displayError("조회 결과가 없습니다.");
		}
	}

	public void insertBoard() {
		Board board = menu.insertBoard();

		int result = bService.insertBoard(board);

		if (result > 0) {
			menu.displaySuccess("Board에 " + result + "개의 행이 추가되었습니다.");
		} else {
			menu.displayError("Board 데이터 삽입 과정 중 오류 발생");
		}

	}

	public void updateBoard() {
		int bNo = menu.inputBNo();

		Board board = bService.selectOne(bNo);

		if (board != null) {
			String loginId = menu.getMemberId();
			int check = bService.checkBoard(bNo, loginId);

			if (check < 1) {
				menu.displayError("권한이 없습니다.");
				return;
			}

			menu.selectOne(board);
			int sel = menu.updateMenu();

			if (sel == 0) {
				return;
			}

			String input = null;

			switch (sel) {
			case 1:
				input = menu.updateTitle();
				break;
			case 2:
				input = menu.updateContent();
				break;
			}

			int result = bService.updateBoard(bNo, sel, input);

			if (result > 0) {
				menu.displaySuccess("Board에 " + result + "개의 행이 수정되었습니다.");
			} else {
				menu.displayError("Board 데이터 수정 과정 중 오류 발생");
			}

		} else {
			menu.displayError("조회 결과가 없습니다.");
		}
	}

	public void deleteBoard() {
		int bNo = menu.inputBNo();

		Board board = bService.selectOne(bNo);

		if (board != null) {
			String loginId = menu.getMemberId();
			int check = bService.checkBoard(bNo, loginId);

			if (check < 1) {
				menu.displayError("권한이 없습니다.");
				return;
			}

			menu.selectOne(board);

			char yn = menu.deleteBoard();

			if (yn != 'Y') {
				return;
			}

			int result = bService.deleteBoard(bNo);

			if (result > 0) {
				menu.displaySuccess("Board에 " + result + "개의 행이 삭제되었습니다.");
			} else {
				menu.displayError("Board 데이터 삭제 과정 중 오류 발생");
			}

		} else {
			menu.displayError("조회 결과가 없습니다.");
		}
	}

	public void exitProgram() {
		new MemberController().exitProgram();
	}

}
