package com.kh.example.practice2.model.vo;

public class Product {
	private String pName;
	private int price;
	private String brand;
	
	public Product() {
		
	}
	
	public void information() {
		System.out.println("pName : " + pName);
		System.out.println("price : " + price);
		System.out.println("brand : " + brand);
	}

}
