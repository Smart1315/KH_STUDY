package com.kh.mini.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.controller.ScoreController;

public class Score_S extends JPanel {
	private static final long serialVersionUID = 3242476158409447592L;

	private ScoreController sc = new ScoreController();

	private DefaultTableModel dtm;
	private Object[][] score;

	public Score_S() {
		JPanel tPanel = new JPanel();
		String[] studentHeader = { "번호", "과정", "점수", "평가자" };

		tPanel.setLayout(new BorderLayout());

		JPanel nPanel = new JPanel();
		FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT);
		nPanel.setLayout(flowLayout);

		JButton refreshBtn = new JButton("새로고침");
		nPanel.add(refreshBtn);

		loadScore();
		dtm = new DefaultTableModel(score, studentHeader) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JTable table = new JTable(dtm);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "학생 정보"));
		setLayout(new BorderLayout(0, 0));

		add(nPanel, BorderLayout.NORTH);
		add(scroll);

		refreshBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadScore();
				dtm = new DefaultTableModel(score, studentHeader) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				table.setModel(dtm);
			}
		});

	}

	public void loadScore() {
		sc.confirmScore(Main.loginInfo);
		score = sc.loadScore(Main.loginInfo);
	}

}
