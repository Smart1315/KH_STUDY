package com.kh.example.chap01_use.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class A_Anonymous {

	public void anonymousMethod() {
		JFrame frame = new JFrame();
		frame.setSize(250, 200);
		
		JPanel panel = new JPanel();
		JButton button1 = new JButton("버튼 1");
		JButton button2 = new JButton("버튼 2");
		JLabel label = new JLabel("아직 버튼이 눌리지 않았습니다.");
	
		panel.add(button1);
		panel.add(button2);
		panel.add(label);
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("버튼 1이 눌렸습니다.");
				System.out.println(e.getSource());
			}
		});
		
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("버튼 2가 눌렸습니다.");
				System.out.println(e.getSource());
			}
		});
	}
}
