package com.kh.mini.model.vo;

import java.io.Serializable;

public class Communication implements Serializable {
	private static final long serialVersionUID = 5762843446680646461L;
	
	private String command;
	private Object data;
	
	public Communication() {
	}
	
	public Communication(String command, Object data) {
		this.command = command;
		this.data = data;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
