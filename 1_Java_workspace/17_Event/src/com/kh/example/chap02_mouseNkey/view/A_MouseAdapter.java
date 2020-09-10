package com.kh.example.chap02_mouseNkey.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A_MouseAdapter extends MouseAdapter {
	private JButton button;
	private int count = 0;

	public A_MouseAdapter() {
		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		button = new JButton("무지개 버튼");

		frame.add(button);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		button.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int num = count % 7;

		if (num == 0) {
			button.setBackground(Color.RED);
		} else if (num == 1) {
			button.setBackground(Color.ORANGE);
		} else if (num == 2) {
			button.setBackground(Color.YELLOW);
		} else if (num == 3) {
			button.setBackground(Color.GREEN);
		} else if (num == 4) {
			button.setBackground(Color.BLUE);
		} else if (num == 5) {
			button.setBackground(new Color(0,  0,  165));
		} else if (num == 6) {
			button.setBackground(new Color(149,  54,  255));
		}
		count++;
	}
}
