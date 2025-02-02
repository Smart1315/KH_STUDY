package com.kh.example.chap03_component.view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class D_ImageLabel {

	public D_ImageLabel() {
		JFrame frame = new JFrame();
		frame.setSize(250, 300);

		JPanel panel = new JPanel();

//		ImageIcon ii = new ImageIcon("image/user.PNG");
		Image icon = new ImageIcon("image/user.PNG").getImage().getScaledInstance(150, 150, 0);
		JLabel label = new JLabel(new ImageIcon(icon));

		JButton button = new JButton("이미지 보기");

		panel.add(label, BorderLayout.NORTH);
		panel.add(button, BorderLayout.CENTER);

		frame.add(panel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JLabel text = new JLabel("user");
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Image icon;
				if(!text.getText().equals("user")) {
					icon = new ImageIcon("image/user.PNG").getImage().getScaledInstance(150, 150, 0);
					text.setText("user");
				} else {
					icon = new ImageIcon("image/dog.PNG").getImage().getScaledInstance(150, 150, 0);
					text.setText("dog");
				}

				label.setIcon(new ImageIcon(icon));
			}
		});
	}
}
