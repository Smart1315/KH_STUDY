package com.kh.board.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.Board;

public class BoardDAO {
	Properties prop = null;

	public BoardDAO() {
		prop = new Properties();
		try {
			prop.load(new FileReader("board.query.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Board> selectAll(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<Board> blist = new ArrayList<Board>();

		String query = prop.getProperty("selectAll");

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				int bNo = rs.getInt("BNO");
				String title = rs.getString("TITLE");
				Date createDate = rs.getDate("CREATE_DATE");
				String writer = rs.getString("WRITER");

				Board board = new Board(bNo, title, null, createDate, writer);

				blist.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return blist;
	}

	public Board selectOne(Connection conn, int bNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Board board = null;

		String query = prop.getProperty("selectOne");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				Date createDate = rs.getDate("CREATE_DATE");
				String writer = rs.getString("WRITER");

				board = new Board(bNo, title, content, createDate, writer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return board;
	}

	public int insertBoard(Connection conn, Board board) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertBoard");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateBoard(Connection conn, int bNo, int sel, String input) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateBoard" + sel);

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, input);
			pstmt.setInt(2, bNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteBoard(Connection conn, int bNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("deleteBoard");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	public int checkBoard(Connection conn, int bNo, String loginId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		String query = prop.getProperty("checkBoard");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNo);
			pstmt.setString(2, loginId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

}
