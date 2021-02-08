package board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import board.model.exception.BoardException;
import board.model.vo.Board;
import board.model.vo.PageInfo;
import board.model.vo.SearchCondition;

public class BoardDAO {

	public int getListCount(SqlSession session) throws BoardException {

		int listCount = session.selectOne("boardMapper.listCount");

//		if(listCount <= 0) {
//			session.close();
//			throw new BoardException("게시물 조회에 실패하였습니다.");
//		}

		return listCount;
	}

	public ArrayList<Board> selectBoardList(SqlSession session, PageInfo pi) throws BoardException {
		
		// 몇 개의 게시글을 건너 뛸 건지
		// 1 --> 0
		// 2 --> 5
		// 3 --> 10
		// 4 --> 15
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardlimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardlimit());
		
		ArrayList<Board> list = (ArrayList) session.selectList("boardMapper.selectBoardList", null, rowBounds);
		
		if(list == null) {
			session.close();
			throw new BoardException("게시물 조회에 실패하였습니다.");
		}
		
		return list;
	}

	public void updateCount(SqlSession session, int bId) throws BoardException {
		
		int result = session.update("boardMapper.updateBoardCount", bId);
		
		if(result <= 0) {
			session.rollback();
			session.close();
			
			throw new BoardException("게시물 조회 증가에 실패하였습니다.");
		}
	}

	public Board selectBoardDetail(SqlSession session, int bId) throws BoardException {
		
		Board b = session.selectOne("boardMapper.selectBoardDetail", bId);
		
		if(b == null) {
			session.close();
			throw new BoardException("게시물 상세조회에 실패하였습니다.");
		}
		
		return b;
	}

	public int getSearchResultListCount(SqlSession session, SearchCondition sc) throws BoardException {
		
		int listCount = session.selectOne("boardMapper.selectSearchResultListCount", sc);
		
//		if(listCount <= 0) {
//			session.close();
//			throw new BoardException("검색 결과의 카운트 조회에 실패하였습니다.");
//		}
		
		return listCount;
	}

	public ArrayList<Board> selectSearchResultList(SqlSession session, SearchCondition sc, PageInfo pi) throws BoardException {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardlimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardlimit());
		
		ArrayList<Board> list = (ArrayList) session.selectList("boardMapper.selectSearchResultList", sc, rowBounds);
		
		if(list == null) {
			session.close();
			throw new BoardException("검색 결과 리스트 조회에 실패하였습니다.");
		}
		
		return list;
	}
}
