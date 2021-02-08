package com.kh.spring.board.model.service;

import java.util.List;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.PageInfo;
import com.kh.spring.board.model.vo.Reply;

public interface BoardService {

	int getListCount();

	List<Board> selectList(PageInfo pi);

	int insertBoard(Board b);

	Board selectBoard(int bId);

	int updateBoard(Board b);

	int deleteBoard(int bId);

	int insertReply(Reply r);

	List<Reply> selectReplyList(int bId);

	List<Board> selectTopList();

}
