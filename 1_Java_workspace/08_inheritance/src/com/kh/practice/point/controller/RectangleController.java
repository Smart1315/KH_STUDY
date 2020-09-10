package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Rectangle;

public class RectangleController {
	private Rectangle r = new Rectangle();

	public String calcArea(int x, int y, int width, int height) {
		r.setX(x);
		r.setY(y);
		r.setWidth(width);
		r.setHeight(height);

		return r + " / " + (r.getHeight() * r.getWidth());
	}

	public String calcPerimeter(int x, int y, int width, int height) {
		r.setX(x);
		r.setY(y);
		r.setWidth(width);
		r.setHeight(height);

		return r + " / " + (2 * (r.getHeight() + r.getWidth()));
	}
}
