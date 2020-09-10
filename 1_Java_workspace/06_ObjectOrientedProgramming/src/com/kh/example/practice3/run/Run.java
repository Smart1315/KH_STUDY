package com.kh.example.practice3.run;

import com.kh.example.practice3.model.vo.Circle;

public class Run {

	public static void main(String[] args) {
		Circle c = new Circle();
		
		System.out.println("반지름 1 증가 전의 넓이 밑 둘레");
		c.getAreaOfCircle();
		c.getSizeOfCircle();
		
		c.incrementRadius();
		
		System.out.println("반지름 1 증가 후의 넓이 밑 둘레");
		c.getAreaOfCircle();
		c.getSizeOfCircle();
		
	}

}
