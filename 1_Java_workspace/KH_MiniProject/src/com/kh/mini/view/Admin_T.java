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

public class Admin_T extends JPanel {
	private static final long serialVersionUID = 9049887109123418643L;

	private JPanel mainPanel, mPanel;
	private JButton scoreBtn, managementBtn;
	private JSplitPane splitPane;

	public Admin_T() {
		setLayout(new BorderLayout());

		JPanel subPanel = subMenu();

		mPanel = new Score_T();
		
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

				mPanel = new Score_T();

				mainPanel.add(mPanel);
				mainPanel.revalidate();
				mainPanel.repaint();
			}
		});
		
		managementBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.remove(mPanel);

				mPanel = new Management();

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

		scoreBtn = new JButton("己利 殿废");
		managementBtn = new JButton("切积 包府");

		subPanel.add(scoreBtn);
		subPanel.add(managementBtn);
		
		panel.add(subPanel, BorderLayout.NORTH);

		return panel;

	}
}
