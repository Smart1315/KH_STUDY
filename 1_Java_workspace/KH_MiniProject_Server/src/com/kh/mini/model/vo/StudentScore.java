package com.kh.mini.model.vo;

import java.io.Serializable;

public class StudentScore implements Serializable {
	private static final long serialVersionUID = -200225316136867426L;

	private int no;
	private String subject;
	private double score;
	private String evaluator;
	private boolean confirm;

	public StudentScore() {
	}

	public StudentScore(int no, String subject, double score, String evaluator, boolean confirm) {
		this.no = no;
		this.subject = subject;
		this.score = score;
		this.evaluator = evaluator;
		this.confirm = confirm;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getEvaluator() {
		return evaluator;
	}

	public void setEvaluator(String evaluator) {
		this.evaluator = evaluator;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	public Object[] toArray() {
		Object[] o = { no, subject, score, evaluator, confirm };

		return o;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		StudentScore other = (StudentScore) obj;
		if (no != other.no) {
			return false;
		}
		return true;
	}

}
