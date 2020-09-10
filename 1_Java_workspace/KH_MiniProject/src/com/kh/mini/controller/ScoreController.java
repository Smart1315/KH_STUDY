package com.kh.mini.controller;

import java.util.ArrayList;

import com.kh.mini.model.vo.Communication;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.StudentScore;

public class ScoreController {

	private CommunicationController cc = new CommunicationController();

	public void confirmScore(Member student) {
		Communication result = cc.connect("confirmScore", student);
	}

	public Object[][] loadScore(Member student) {
		Communication result = cc.connect("loadScore", student);

		return (Object[][]) result.getData();

	}

	public boolean saveScore(Member student, StudentScore score) {
		Object[] o = { student, score };
		Communication result = cc.connect("saveScore", o);

		return (boolean) result.getData();
	}

	public void editScore(Member student, ArrayList<StudentScore> score) {
		Object[] o = { student, score };
		cc.connect("editScore", o);
	}

}
