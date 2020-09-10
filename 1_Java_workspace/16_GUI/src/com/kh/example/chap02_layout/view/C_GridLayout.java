package com.kh.example.chap02_layout.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class C_GridLayout extends JFrame {

	public C_GridLayout() {
		super("GridLayout");
		setBounds(300, 200, 800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// GridLayout
		// 가로, 세로를 일정 수만큼 배치하고자 할 때 사용
		setLayout(new GridLayout(5, 5, 10, 20));
		
		for(int i = 0; i < 26; i++) {
			String str = Integer.toString(i + 1);
			add(new JButton(str));
		}
		
		
		
		setVisible(true); // setVisible이 위에 있으면 가끔 밑에있는 컴포넌트를 못 읽을 때가 있음
	}
}
