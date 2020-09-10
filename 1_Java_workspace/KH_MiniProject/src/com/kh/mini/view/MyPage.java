package com.kh.mini.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class MyPage extends JPanel {
	private static final long serialVersionUID = -3947398412981442203L;

	private JPanel mainPanel, mPanel;
	private JButton profileEditBtn, logoutBtn;
	private JSplitPane splitPane;

	public MyPage() {
		setLayout(new BorderLayout());

		JPanel subPanel = subMenu();

		mPanel = new ProfileEdit();

		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		mainPanel.add(mPanel);

//		add(subPanel, BorderLayout.WEST);
//		add(mainPanel, BorderLayout.CENTER);

		splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.1);
		splitPane.setEnabled(false);
		add(splitPane, BorderLayout.CENTER);

		splitPane.setLeftComponent(subPanel);
		splitPane.setRightComponent(mainPanel);

		profileEditBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.remove(mPanel);

				mPanel = new ProfileEdit();

				mainPanel.add(mPanel);
				mainPanel.revalidate();
				mainPanel.repaint();
			}
		});

		logoutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.frame.dispose();
				new Login();
			}
		});

	}

	public JPanel subMenu() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "SubMenu"));
		
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new GridLayout(0, 1, 25, 25));

		profileEditBtn = new JButton("회원정보 수정");
		logoutBtn = new JButton("로그아웃");

		subPanel.add(profileEditBtn);
		subPanel.add(logoutBtn);
		
		panel.add(subPanel, BorderLayout.NORTH);

		return panel;

	}
}
