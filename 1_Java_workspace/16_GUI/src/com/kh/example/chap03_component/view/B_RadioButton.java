package com.kh.example.chap03_component.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class B_RadioButton {

	public B_RadioButton() {
		JFrame frame = new JFrame();
//		frame.setSize(300, 150);
		
		JPanel topPanel = new JPanel();
		JLabel label = new JLabel("어떤 크기의 음료를 주문하시겠습니까?");
		topPanel.add(label);
		frame.add(topPanel, BorderLayout.NORTH);
		
		JPanel sizePanel = new JPanel();
		JRadioButton small = new JRadioButton("Small Size");
		JRadioButton medium = new JRadioButton("Medium Size");
		JRadioButton large = new JRadioButton("Large Size");
		ButtonGroup sizeGroup = new ButtonGroup();
		sizeGroup.add(small);
		sizeGroup.add(medium);
		sizeGroup.add(large);
		
		sizePanel.add(small);
		sizePanel.add(medium);
		sizePanel.add(large);
		frame.add(sizePanel, BorderLayout.CENTER);
		
		JPanel resultPanel = new JPanel();
		JLabel text = new JLabel("크기가 선택되지 않았습니다.");
		resultPanel.add(text);
		frame.add(resultPanel, BorderLayout.SOUTH);
		
		frame.pack(); // 컴포넌트의 크기에 맞춰 자동으로 사이즈 지정
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		small.addActionListener(new RadioButtonEvent(text));
		medium.addActionListener(new RadioButtonEvent(text));
		large.addActionListener(new RadioButtonEvent(text));
		
//		small.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				text.setText(e.getActionCommand() + "가 선택되었습니다.");
//			}
//		});
//		
//		medium.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				text.setText(e.getActionCommand() + "가 선택되었습니다.");
//			}
//		});
//		
//		large.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				text.setText(e.getActionCommand() + "가 선택되었습니다.");
//			}
//		});
	}
	
	public class RadioButtonEvent implements ActionListener {
		private JLabel text;
		
		public RadioButtonEvent(JLabel text) {
			this.text = text;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			text.setText(e.getActionCommand() + "가 선택되었습니다.");
		}
	}
}
