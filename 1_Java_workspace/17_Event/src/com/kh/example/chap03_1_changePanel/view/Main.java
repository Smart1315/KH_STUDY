package com.kh.example.chap03_1_changePanel.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {

	private JPanel panel;

	public Main() {
		setSize(300, 200);
		
		Panel1 panel1 = new Panel1();
		
		add(panel1);
		
		panel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				remove(panel1);
				
				Panel2 panel2 = new Panel2();
				add(panel2);
				revalidate(); // 다시 그리기
				repaint();
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}
