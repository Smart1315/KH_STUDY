package com.kh.homework.shape.controller;

import com.kh.homework.shape.model.vo.Shape;

public class ShapeController {
	private Shape s = new Shape();

	public ShapeController() {

	}

	public double calcPerimeter(int type, double height, double width) {
		s.setType(type);
		s.setHeight(height);
		s.setWidth(width);

		return (width + height) * 2;
	}

	public double calcArea(int type, double height, double width) {
		s.setType(type);
		s.setHeight(height);
		s.setWidth(width);

		if (type == 3) {
			return width * height * 0.5;
		} else if (type == 4) {
			return width * height;
		} else {
			return 0;
		}
	}

	public void paintColor(String color) {
		s.setColor(color);
	}

	public String print(int type) {
		String shape = "";
		if (type == 3) {
			shape = "�ﰢ��";
		} else if (type == 4) {
			shape = "�簢��";
		}

		if (s.getHeight() <= 0 || s.getWidth() <= 0) {
			System.out.print(shape + "�� ���� �Ǵ� �ʺ� �������� �ʾҽ��ϴ�.");
			return "";
		}

		return shape + " / " + s.inform();
	}

	public String print() {
		return s.inform();
	}

}
