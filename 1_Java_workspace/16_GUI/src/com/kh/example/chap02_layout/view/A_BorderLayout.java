package com.kh.example.chap02_layout.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A_BorderLayout extends JFrame {

	public A_BorderLayout() {
		super("BorderLayout");	
		setBounds(300, 200, 800, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// BorderLayout : 구역을 5개로 나눠 배치하는 레이아웃
		setLayout(new BorderLayout());
		
		// 버튼(컴포넌트) 생성
		JButton northB = new JButton("북");
		JButton southB = new JButton("남");
		JButton eastB = new JButton("동");
		JButton westB = new JButton("서");
		JButton centerB = new JButton("가운데");
		
		add(northB, "North");
		add(southB, "South");
		add(eastB, "East");
		add(westB, "West");
		add(centerB, "Center");
		
		
	}
}
