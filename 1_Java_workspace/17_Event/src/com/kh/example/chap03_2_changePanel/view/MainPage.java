package com.kh.example.chap03_2_changePanel.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class MainPage extends JPanel {
	private MainFrame frame;

	public MainPage(MainFrame frame) {
		this.frame = frame;
		setSize(300, 200);
		setBackground(Color.BLUE);
		
		frame.add(this);
		
		addMouseListener(new MyMouseAdapter());
	}
	
	class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			SubPage page = new SubPage(frame);

			changePanel(page);
			
		}
	}
	
	public void changePanel(JPanel panel) {
		frame.remove(this);
		frame.revalidate();
		frame.repaint();
	}
}
