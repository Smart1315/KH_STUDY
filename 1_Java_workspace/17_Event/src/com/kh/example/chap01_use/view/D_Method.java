package com.kh.example.chap01_use.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class D_Method implements ActionListener {

	private JButton button1, button2;
	private JLabel label;

	public D_Method() {
		JFrame frame = new JFrame();
		frame.setSize(250, 200);

		JPanel panel = new JPanel();
		button1 = new JButton("버튼1");
		button2 = new JButton("버튼2");
		label = new JLabel("아직 버튼이 눌리지 않았습니다.");

		panel.add(button1);
		panel.add(button2);
		panel.add(label);

		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			label.setText("버튼1이 눌렸습니다.");
		} else if (e.getSource() == button2) {
			label.setText("버튼2가 눌렸습니다.");
		}
	}

}
