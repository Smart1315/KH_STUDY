package com.kh.mini.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Comparable<Comment>, Serializable {
	private static final long serialVersionUID = 445536749226163242L;

	private int boardNo;
	private int num;
	private String id;
	private Date date;
	private String comment;

	public Comment() {
	}

	public Comment(int boardNo, int num, String id, Date date, String comment) {
		this.num = num;
		this.id = id;
		this.date = date;
		this.comment = comment;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public int compareTo(Comment o) {
		return Integer.compare(num, o.num);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardNo;
		result = prime * result + num;
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
		Comment other = (Comment) obj;
		if (boardNo != other.boardNo) {
			return false;
		}
		if (num != other.num) {
			return false;
		}
		return true;
	}

}
