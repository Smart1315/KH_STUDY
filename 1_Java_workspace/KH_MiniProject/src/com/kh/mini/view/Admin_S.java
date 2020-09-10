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

public class Admin_S extends JPanel {
	private static final long serialVersionUID = 9049887109123418643L;

	private JPanel mainPanel, mPanel;
	private JButton scoreBtn;
	private JSplitPane splitPane;

	public Admin_S() {
		setLayout(new BorderLayout());

		JPanel subPanel = subMenu();

		mPanel = new Score_S();

		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		mainPanel.add(mPanel);

		splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.1);
		splitPane.setEnabled(false);
		add(splitPane, BorderLayout.CENTER);

		splitPane.setLeftComponent(subPanel);
		splitPane.setRightComponent(mainPanel);


		scoreBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.remove(mPanel);

				mPanel = new Score_S();

				mainPanel.add(mPanel);
				mainPanel.revalidate();
				mainPanel.repaint();
			}
		});


	}

	public JPanel subMenu() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "SubMenu"));
		
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new GridLayout(0, 1, 25, 25));

		scoreBtn = new JButton("성적 조회");

		subPanel.add(scoreBtn);
		
		panel.add(subPanel, BorderLayout.NORTH);

		return panel;

	}
}
