package com.kh.example.chap03_component.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class H_Slider {

	public H_Slider() {
		JFrame frame = new JFrame();
		
		JPanel panel1 = new JPanel();
		JLabel label = new JLabel("슬라이더를 움직여보세요", JLabel.CENTER);
		panel1.add(label);
		
		JPanel panel2 = new JPanel();
		JSlider slider = new JSlider(0, 30, 15);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		JButton button = new JButton("전송");
		
		panel2.add(slider);
		panel2.add(button);
		
		JPanel resultPanel = new JPanel();
		JLabel text = new JLabel("결과값 : ");
		JLabel result = new JLabel();
		resultPanel.add(text);
		resultPanel.add(result);	
		
		frame.add(panel1, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.CENTER);
		frame.add(resultPanel, BorderLayout.SOUTH);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setText(slider.getValue() + "");
			}
		});
		
//		slider.addChangeListener(new ChangeListener() {
//			
//			@Override
//			public void stateChanged(ChangeEvent e) {
//				result.setText(slider.getValue() + "");
//				
//			}
//		});
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
