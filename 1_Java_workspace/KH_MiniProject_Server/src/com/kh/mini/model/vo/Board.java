package com.kh.mini.model.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Board implements Comparable<Board>, Serializable {
	private static final long serialVersionUID = 6161805715291941075L;

	private boolean notice;
	private int num;
	private String title;
	private String content;
	private String id;
	private Date regDate;

	public Board() {
	}

	public Board(boolean notice, int num, String title, String content, String id, Date regDate) {
		this.notice = notice;
		this.num = num;
		this.title = title;
		this.content = content;
		this.id = id;
		this.regDate = regDate;
	}

	public boolean isNotice() {
		return notice;
	}

	public void setNotice(boolean notice) {
		this.notice = notice;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Object[] toArray() {
		Object[] o = { num, title, id, new SimpleDateFormat("yyyy/MM/dd a hh:mm:dd").format(regDate), notice };

		return o;
	}

	@Override
	public int compareTo(Board o) {
		return -Integer.compare(num, o.num);
	}

}
