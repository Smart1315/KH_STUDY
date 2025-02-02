package com.kh.board.model.service;

import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDAO;
import com.kh.board.model.vo.Board;

public class BoardService {

	public ArrayList<Board> selectAll() {
		Connection conn = getConnection();

		BoardDAO bDAO = new BoardDAO();

		ArrayList<Board> blist = bDAO.selectAll(conn);

		return blist;
	}

	public Board selectOne(int bNo) {
		Connection conn = getConnection();

		BoardDAO bDAO = new BoardDAO();

		Board board = bDAO.selectOne(conn, bNo);

		return board;
	}

	public int insertBoard(Board board) {
		Connection conn = getConnection();

		BoardDAO bDAO = new BoardDAO();

		int result = bDAO.insertBoard(conn, board);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}

	public int updateBoard(int bNo, int sel, String input) {
		Connection conn = getConnection();

		BoardDAO bDAO = new BoardDAO();

		int result = bDAO.updateBoard(conn, bNo, sel, input);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}


	public int deleteBoard(int bNo) {
		Connection conn = getConnection();

		BoardDAO bDAO = new BoardDAO();
		
		int result = bDAO.deleteBoard(conn, bNo);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
		
	}
	
	public int checkBoard(int bNo, String loginId) {
		Connection conn = getConnection();

		BoardDAO bDAO = new BoardDAO();
		
		int result = bDAO.checkBoard(conn, bNo, loginId);
		
		return result;
	}

}
