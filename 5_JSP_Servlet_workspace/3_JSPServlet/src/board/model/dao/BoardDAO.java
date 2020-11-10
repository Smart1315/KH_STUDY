package board.model.dao;

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

import board.model.vo.Attachment;
import board.model.vo.Board;
import board.model.vo.PageInfo;
import board.model.vo.Reply;

public class BoardDAO {
	private Properties prop = new Properties();

	public BoardDAO() {
		String fileName = BoardDAO.class.getResource("/sql/board/board-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getListCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getListCount");

		try {
			stmt = conn.createStatement();

			rset = stmt.executeQuery(query);

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return result;
	}

	public ArrayList<Board> selectList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();

		String query = prop.getProperty("selectList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				Board b = new Board(rset.getInt("BOARD_ID"), 
									rset.getInt("BOARD_TYPE"),
									rset.getString("CATE_NAME"),
									rset.getString("BOARD_TITLE"),
									rset.getString("BOARD_CONTENT"),
									rset.getString("BOARD_WRITER"),
									rset.getString("NICKNAME"),
									rset.getInt("BOARD_COUNT"),
									rset.getDate("CREATE_DATE"),
									rset.getDate("MODIFY_DATE"),
									rset.getString("STATUS"));
				list.add(b);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
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

	public Board selectDetail(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		
		String query = prop.getProperty("selectDetail");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board(rset.getInt("BOARD_ID"), 
							  rset.getInt("BOARD_TYPE"),
							  rset.getString("CATE_NAME"),
							  rset.getString("BOARD_TITLE"),
							  rset.getString("BOARD_CONTENT"),
							  rset.getString("BOARD_WRITER"),
							  rset.getString("NICKNAME"),
							  rset.getInt("BOARD_COUNT"),
							  rset.getDate("CREATE_DATE"),
							  rset.getDate("MODIFY_DATE"),
							  rset.getString("STATUS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
	}

	public int insertBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b.getBoardType());
			pstmt.setInt(2, Integer.parseInt(b.getCategory()));
			pstmt.setString(3, b.getBoardTitle());
			pstmt.setString(4, b.getBoardContent());
			pstmt.setString(5, b.getBoardWriter());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateBoard(Connection conn, int no, int category, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, category);
			pstmt.setString(2, b.getBoardTitle());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setInt(4, no);
			pstmt.setString(5, b.getBoardWriter());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteBoard(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBoard");
		
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

	public ArrayList selectBList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("selectBList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Board>();
			
			while (rset.next()) {
				list.add(new Board(rset.getInt("BOARD_ID"),
								   rset.getInt("BOARD_TYPE"),
								   rset.getString("CATE_NAME"),
								   rset.getString("BOARD_TITLE"),
								   rset.getString("BOARD_CONTENT"),
								   rset.getString("BOARD_WRITER"),
								   rset.getString("NICKNAME"),
								   rset.getInt("BOARD_COUNT"),
								   rset.getDate("CREATE_DATE"),
								   rset.getDate("MODIFY_DATE"),
								   rset.getString("STATUS")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public ArrayList selectFList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Attachment> list = null;

		String query = prop.getProperty("selectFList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Attachment>();
			
			while (rset.next()) {
				list.add(new Attachment(rset.getInt("BOARD_ID"),
										rset.getString("CHANGE_NAME")));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public int insertAttachment(Connection conn, ArrayList<Attachment> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAttachment");
		
		try {
			for(int i = 0; i < fileList.size(); i++) {
				Attachment at = fileList.get(i);
				
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				pstmt.setInt(4, at.getFileLevel());
				
				result += pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Attachment> selectThumbnail(Connection conn, int bId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Attachment> list = null;
		
		String query = prop.getProperty("selectThumbnail");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Attachment>();
			
			while (rset.next()) {
				Attachment at = new Attachment();
				at.setFileId(rset.getInt("FILE_ID"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setFilePath(rset.getString("FILE_PATH"));
				at.setUploadTime(rset.getDate("UPLOAD_DATE"));
						
				list.add(at);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Reply> selectReplyList(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Reply> list = null;
		
		String query = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Reply>();
			while (rset.next()) {
				list.add(new Reply(rset.getInt("REPLY_ID"),
								   rset.getString("REPLY_CONTENT"),
								   rset.getInt("REF_BID"),
								   rset.getString("NICKNAME"),
								   rset.getDate("CREATE_DATE"),
								   rset.getDate("MODIFY_DATE"),
								   rset.getString("STATUS")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertReply(Connection conn, Reply r) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReply");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, r.getReplyContent());
			pstmt.setInt(2, r.getRefBid());
			pstmt.setString(3, r.getReplyWriter());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}



}
