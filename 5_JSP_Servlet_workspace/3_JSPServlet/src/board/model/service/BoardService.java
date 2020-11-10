package board.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDAO;
import board.model.vo.Attachment;
import board.model.vo.Board;
import board.model.vo.PageInfo;
import board.model.vo.Reply;

public class BoardService {

	public int getListCount() {
		Connection conn = getConnection();
		
		int result = new BoardDAO().getListCount(conn);
		
		close(conn);
		
		return result;
	}

	public ArrayList<Board> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Board> list = new BoardDAO().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public Board selectDetail(int no) {
		Connection conn = getConnection();
		
		BoardDAO bDAO = new BoardDAO();
		
		int result = bDAO.updateCount(conn, no);
		
		Board b = null;
		if(result > 0) {
			b = bDAO.selectDetail(conn, no);
			
			if(b != null) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return b;
	}

	public int insertBoard(Board b) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().insertBoard(conn, b);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public int deleteBoard(int no) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().deleteBoard(conn, no);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public int updateBoard(int no, int category, Board b) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().updateBoard(conn, no, category, b);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public ArrayList selectTList(int i) {
		Connection conn = getConnection();
		
		ArrayList list = null;
		
		BoardDAO dao = new BoardDAO();
		
		if(i == 1) {
			list = dao.selectBList(conn);
		} else {
			list = dao.selectFList(conn);
		}
		
		close(conn);
		
		return list;
	}

	public int insertThumbnail(Board b, ArrayList<Attachment> fileList) {
		Connection conn = getConnection();
		
		BoardDAO dao = new BoardDAO();
		
		int result1 = dao.insertBoard(conn, b);
		int result2 = dao.insertAttachment(conn, fileList);
		
		if(result1 > 0 && result2 != 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1;
	}

	public Board selectBoard(int bId) {
		Connection conn = getConnection();
		
		BoardDAO bDAO = new BoardDAO();
		
		Board b = bDAO.selectDetail(conn, bId);
		
		close(conn);
		
		return b;
	}

	public ArrayList<Attachment> selectThumbnail(int bId) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().updateCount(conn, bId);
		
		ArrayList<Attachment> list = null;
		
		if(result > 0) { 
			list = new BoardDAO().selectThumbnail(conn, bId);
			
			if(list != null) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return list;
	}

	public ArrayList<Reply> selectReplyList(int no) {
		Connection conn = getConnection();
		
		ArrayList<Reply> list = new BoardDAO().selectReplyList(conn, no);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Reply> insertReply(Reply r) {
		Connection conn = getConnection();
		
		BoardDAO bDAO = new BoardDAO();
		
		int result = bDAO.insertReply(conn, r);
		
		ArrayList<Reply> list = null;
		if(result > 0) {
			commit(conn);
			
			list = bDAO.selectReplyList(conn, r.getRefBid());
			
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return list;
	}

}
