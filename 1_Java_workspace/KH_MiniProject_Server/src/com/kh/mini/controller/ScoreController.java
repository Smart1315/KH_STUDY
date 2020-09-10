package com.kh.mini.controller;

import java.util.ArrayList;

import com.kh.mini.model.dao.ScoreDAO;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.StudentScore;

public class ScoreController {
	private ScoreDAO sd = new ScoreDAO();
	
	public void confirmScore(Member student) {
		ArrayList<StudentScore> sList = sd.loadScore(student);
		for(int i = 0; i < sList.size(); i++) {
			sList.get(i).setConfirm(true);
		}
		
		editScore(student, sList);
	}
	
	public Object[][] loadScore(Member student) {
		ArrayList<StudentScore> slist = sd.loadScore(student);
		
		Object[][] o = new Object[slist.size()][];
		
		for(int i = 0; i < o.length; i++) {
			o[i] = slist.get(i).toArray();
		}
		
		return o;
		
	}
	
	public boolean saveScore(Member student, StudentScore score) {
		return sd.saveScore(student, score);
	}
	
	public void editScore(Member student, ArrayList<StudentScore> score) {
		sd.editScore(student, score);
	}
	
}
