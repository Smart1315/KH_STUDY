package com.kh.example.chap02_layout.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class F_PanelLayout extends JFrame {

	public F_PanelLayout() {
		super("PanelLayout");
		setBounds(300, 200, 800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(null);

		JLabel lb = new JLabel("�̸� : ");
		lb.setLocation(50, 100);
		lb.setSize(150, 50);

		JTextField tf = new JTextField(20);
		tf.setBounds(110, 100, 200, 50);
		
		JButton btn = new JButton("�߰�");
		btn.setBounds(350, 100, 100, 50);
		
		JPanel panel = new JPanel();
		panel.setSize(500, 500);
		panel.setLayout(null);
		
		panel.add(lb);
		panel.add(tf);
		panel.add(btn);

		add(panel);
		

		setVisible(true);
	}
}
