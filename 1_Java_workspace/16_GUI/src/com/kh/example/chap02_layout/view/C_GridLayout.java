package com.kh.example.chap02_layout.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class C_GridLayout extends JFrame {

	public C_GridLayout() {
		super("GridLayout");
		setBounds(300, 200, 800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// GridLayout
		// ����, ���θ� ���� ����ŭ ��ġ�ϰ��� �� �� ���
		setLayout(new GridLayout(5, 5, 10, 20));
		
		for(int i = 0; i < 26; i++) {
			String str = Integer.toString(i + 1);
			add(new JButton(str));
		}
		
		
		
		setVisible(true); // setVisible�� ���� ������ ���� �ؿ��ִ� ������Ʈ�� �� ���� ���� ����
	}
}
