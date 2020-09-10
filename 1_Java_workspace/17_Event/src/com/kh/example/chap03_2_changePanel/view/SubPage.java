package com.kh.example.chap03_2_changePanel.view;

import java.awt.Color;

import javax.swing.JPanel;

public class SubPage extends JPanel {

	public SubPage(MainFrame frame) {
		setSize(300, 200);
		setBackground(Color.RED);
		
		frame.add(this);
	}
}
