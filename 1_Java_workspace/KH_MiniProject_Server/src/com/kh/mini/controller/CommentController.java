package com.kh.mini.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.mini.model.dao.CommentDAO;
import com.kh.mini.model.vo.Comment;

public class CommentController {
	private CommentDAO cd = new CommentDAO();

	public void writeComment(Comment c) {
		ArrayList<Comment> list = readComment(c.getBoardNo());

		if (list.size() == 0) {
			c.setNum(1);
		} else {
			int num = 0;
			for (int i = 0; i < list.size(); i++) {
				int cNum = list.get(i).getNum();
				if (cNum > num) {
					num = cNum;
				}
			}
			c.setNum(num + 1);
		}

		cd.writeComment(c);
	}

	public ArrayList<Comment> readComment(int boardNo) {
		ArrayList<Comment> comments = cd.readComment(boardNo);
		
		Collections.sort(comments);
		
		return comments;
	}
	
	public void editComment(Comment c) {
		cd.editComment(c);
	}
	
	public void deleteComment(Comment c) {
		cd.deleteComment(c);
	}
}
