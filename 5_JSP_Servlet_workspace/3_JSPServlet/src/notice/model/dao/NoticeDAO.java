package notice.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import notice.model.vo.Notice;

public class NoticeDAO {
	private Properties prop = new Properties();

	public NoticeDAO() {
		String fileName = NoticeDAO.class.getResource("/sql/notice/notice-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Notice> selectList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = new ArrayList<Notice>();

		String query = prop.getProperty("selectList");

		try {
			stmt = conn.createStatement();

			rset = stmt.executeQuery(query);

			while (rset.next()) {
				Notice no = new Notice(rset.getInt("NOTICE_NO"), rset.getString("NOTICE_TITLE"),
						rset.getString("NOTICE_CONTENT"), null, rset.getString("NICKNAME"), rset.getInt("NOTICE_COUNT"),
						rset.getDate("NOTICE_DATE"));
				list.add(no);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}

	public int insertNotice(Connection conn, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertNotice");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setString(3, n.getNoticeWriter());
			pstmt.setDate(4, n.getNoticeDate());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public Notice seleteNotice(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice n = null;

		String query = prop.getProperty("selectDetail");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				n = new Notice(rset.getInt("NOTICE_NO"), rset.getString("NOTICE_TITLE"),
						rset.getString("NOTICE_CONTENT"), rset.getString("NOTICE_WRITER"), rset.getString("NICKNAME"),
						rset.getInt("NOTICE_COUNT"), rset.getDate("NOTICE_DATE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return n;
	}

	public int updateCount(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateCount");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateNotice(Connection conn, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateNotice");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setDate(3, n.getNoticeDate());
			pstmt.setInt(4, n.getNoticeNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteNotice(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("deleteNotice");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}
