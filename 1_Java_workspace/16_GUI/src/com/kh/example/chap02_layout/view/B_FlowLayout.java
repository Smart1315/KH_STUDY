package com.kh.example.chap02_layout.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class B_FlowLayout extends JFrame {

	public B_FlowLayout() {
		super("FlowLayout");
		setBounds(300, 200, 800, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// FlowLayout
		// 컴포넌트를 왼쪽에서 오른쪽으로 배치하며
		// 왼쪽, 가운데, 오른쪽 정렬 가능
		setLayout(new FlowLayout());

		add(new JButton("1번"));
		add(new JButton("2번"));
		add(new JButton("3번"));
		add(new JButton("4번"));
		add(new JButton("5번"));
		add(new JButton("6번"));
		add(new JButton("7번"));
		add(new JButton("8번"));
		add(new JButton("9번"));
		add(new JButton("10번"));
		add(new JButton("11번"));
		add(new JButton("12번"));
		add(new JButton("13번"));
		add(new JButton("14번"));
		add(new JButton("15번"));
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setLayout(new FlowLayout(FlowLayout.LEADING));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setLayout(new FlowLayout(FlowLayout.TRAILING));



	}
}
