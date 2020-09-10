package com.kh.example.run;

import java.util.ArrayList;
import java.util.List;

public class Run {
	

	public static void main(String[] args) {
//		new ThreadTestView().menu();
		
//		new ConvertView().menu();
		
		List list = new ArrayList();
		
		list.add(5);
		list.add("string");
		
		System.out.println(list.get(0) instanceof Object);
		System.out.println(list.get(1) instanceof String);
	}

}