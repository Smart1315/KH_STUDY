package com.kh.example.chap02_layout.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A_BorderLayout extends JFrame {

	public A_BorderLayout() {
		super("BorderLayout");	
		setBounds(300, 200, 800, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// BorderLayout : ������ 5���� ���� ��ġ�ϴ� ���̾ƿ�
		setLayout(new BorderLayout());
		
		// ��ư(������Ʈ) ����
		JButton northB = new JButton("��");
		JButton southB = new JButton("��");
		JButton eastB = new JButton("��");
		JButton westB = new JButton("��");
		JButton centerB = new JButton("���");
		
		add(northB, "North");
		add(southB, "South");
		add(eastB, "East");
		add(westB, "West");
		add(centerB, "Center");
		
		
	}
}
