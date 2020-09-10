package com.kh.mini.controller;

import java.util.ArrayList;

import com.kh.mini.model.vo.Comment;
import com.kh.mini.model.vo.Communication;

public class CommentController {
	
	private CommunicationController cc = new CommunicationController();

	public void writeComment(Comment c) {
		cc.connect("writeComment", c);
	}

	public ArrayList<Comment> readComment(int boardNo) {
		Communication result = cc.connect("readComment", boardNo);
		
		return (ArrayList<Comment>) result.getData();
	}
	
	public void editComment(Comment c) {
		cc.connect("editComment", c);
	}
	
	public void deleteComment(Comment c) {
		cc.connect("deleteComment", c);
	}
}
