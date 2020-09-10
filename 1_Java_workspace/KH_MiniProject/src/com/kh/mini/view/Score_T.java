package com.kh.mini.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.controller.MemberController;
import com.kh.mini.controller.ScoreController;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.StudentScore;

public class Score_T extends JPanel {
	private static final long serialVersionUID = 3242476158409447592L;

	private MemberController mc = new MemberController();
	private ScoreController sc = new ScoreController();

	private DefaultTableModel dtmStudent;
	private JTable studentTable;
	private DefaultTableModel dtmScore;
	private String[] scoreHeader = { "번호", "과정", "점수", "평가자", "학생 확인" };
	private JTable scoreTable;
	private JScrollPane scoreScroll;

	private JTextField noText, subText, scoreText;
	
	private Object[][] student;
	private Member selectedStudent;
	private Object[][] score;
	private int selectedScoreRow;
	private StudentScore selectedScore;

	public Score_T() {
		setLayout(new BorderLayout());

		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setEnabled(false);

		JPanel tPanel = topPanel();
		JPanel bPanel = bottomPanel();

		splitPane.setTopComponent(tPanel);
		splitPane.setBottomComponent(bPanel);

		add(splitPane, BorderLayout.CENTER);
	}

	public void loadStudent() {
		student = mc.loadStudent();
	}

	public void loadScore(Member m) {
		score = sc.loadScore(m);
	}

	public JPanel topPanel() {
		JPanel tPanel = new JPanel();
		String[] studentHeader = { "번호", "아이디", "이름", "과정", "학년" };

		tPanel.setLayout(new BorderLayout());

		JPanel nPanel = new JPanel();
		nPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		JButton refreshBtn = new JButton("새로고침");
		nPanel.add(refreshBtn);

		loadStudent();
		dtmStudent = new DefaultTableModel(student, studentHeader) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		studentTable = new JTable(dtmStudent);
		studentTable.getTableHeader().setReorderingAllowed(false);
		studentTable.getTableHeader().setResizingAllowed(false);

		JScrollPane scroll = new JScrollPane(studentTable);
		scroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "학생 정보"));

		tPanel.add(nPanel, BorderLayout.NORTH);
		tPanel.add(scroll, BorderLayout.CENTER);

		studentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectRow = studentTable.getSelectedRow();
				selectedStudent = new Member(String.valueOf(studentTable.getValueAt(selectRow, 1)));

				scoreScroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),
						String.valueOf(studentTable.getValueAt(selectRow, 2)) + " 학생 성적 정보"));

				loadScore(selectedStudent);
				dtmScore = new DefaultTableModel(score, scoreHeader) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				scoreTable.setModel(dtmScore);
			}
		});

		refreshBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				scoreScroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "성적 정보"));

				selectedStudent = null;
				noText.setText("");
				subText.setText("");
				scoreText.setText("");

				loadStudent();
				dtmStudent = new DefaultTableModel(student, studentHeader) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				studentTable.setModel(dtmStudent);
				
				dtmScore = new DefaultTableModel(null, scoreHeader) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				scoreTable.setModel(dtmScore);
			}
		});

		return tPanel;
	}

	public JPanel bottomPanel() {
		JPanel bPanel = new JPanel();

		bPanel.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JPanel inputPanel = new JPanel();
		inputPanel.setBorder(new EmptyBorder(5, 20, 2, 20));
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
		
		JLabel noLabel = new JLabel("번호  ");
		noText = new JTextField();

		JLabel subLabel = new JLabel("   과정  ");
		subText = new JTextField();

		JLabel scoreLabel = new JLabel("   점수  ");
		scoreText = new JTextField();

		inputPanel.add(noLabel);
		inputPanel.add(noText);
		inputPanel.add(subLabel);
		inputPanel.add(subText);
		inputPanel.add(scoreLabel);
		inputPanel.add(scoreText);

		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		JButton addBtn = new JButton("추가");
		JButton edtBtn = new JButton("수정");
		JButton delBtn = new JButton("삭제");

		btnPanel.add(addBtn);
		btnPanel.add(edtBtn);
		btnPanel.add(delBtn);

		dtmScore = new DefaultTableModel(score, scoreHeader) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		scoreTable = new JTable(dtmScore);
		scoreTable.getTableHeader().setReorderingAllowed(false);
		scoreTable.getTableHeader().setResizingAllowed(false);

		scoreScroll = new JScrollPane(scoreTable);
		scoreScroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "성적 정보"));

		panel.add(inputPanel, BorderLayout.CENTER);
		panel.add(btnPanel, BorderLayout.EAST);
		bPanel.add(panel, BorderLayout.NORTH);
		bPanel.add(scoreScroll, BorderLayout.CENTER);

		scoreTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedScoreRow = scoreTable.getSelectedRow();
				StudentScore ss = new StudentScore();
				int no = Integer.parseInt(String.valueOf(scoreTable.getValueAt(selectedScoreRow, 0)));
				String subject = String.valueOf(scoreTable.getValueAt(selectedScoreRow, 1));
				double score = Double.parseDouble(String.valueOf(scoreTable.getValueAt(selectedScoreRow, 2)));

				ss.setNo(no);
				ss.setSubject(subject);
				ss.setScore(score);
				ss.setEvaluator(String.valueOf(scoreTable.getValueAt(selectedScoreRow, 3)));
				selectedScore = ss;

				noText.setText(String.valueOf(no));
				subText.setText(subject);
				scoreText.setText(String.valueOf(score));
			}
		});

		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (selectedStudent == null) {
					JOptionPane.showMessageDialog(null, "학생을 선택하세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				StudentScore ss = new StudentScore();
				try {
					ss.setNo(Integer.parseInt(noText.getText()));
					ss.setSubject(subText.getText());
					ss.setScore(Double.parseDouble(scoreText.getText()));
					ss.setEvaluator(Main.loginInfo.getName());
				} catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "잘못된 입력값입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				if (!sc.saveScore(selectedStudent, ss)) {
					JOptionPane.showMessageDialog(null, "번호를 바꾸세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				loadScore(selectedStudent);
				dtmScore = new DefaultTableModel(score, scoreHeader) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				scoreTable.setModel(dtmScore);
			}
		});

		edtBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedScore == null) {
					JOptionPane.showMessageDialog(null, "성적을 선택해주세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				ArrayList<StudentScore> sList = new ArrayList<StudentScore>();
				for (int i = 0; i < scoreTable.getRowCount(); i++) {
					StudentScore ss = new StudentScore();
					ss.setNo(Integer.parseInt(String.valueOf(scoreTable.getValueAt(i, 0))));
					ss.setSubject(String.valueOf(scoreTable.getValueAt(i, 1)));
					ss.setScore(Double.parseDouble(String.valueOf(scoreTable.getValueAt(i, 2))));
					ss.setEvaluator(String.valueOf(scoreTable.getValueAt(i, 3)));

					sList.add(ss);
				}

				StudentScore ss = new StudentScore();
				ss.setNo(Integer.parseInt(noText.getText()));
				ss.setSubject(subText.getText());
				ss.setScore(Double.parseDouble(scoreText.getText()));
				ss.setEvaluator(Main.loginInfo.getName());
				sList.set(selectedScoreRow, ss);

				sc.editScore(selectedStudent, sList);

				loadScore(selectedStudent);
				dtmScore = new DefaultTableModel(score, scoreHeader) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				scoreTable.setModel(dtmScore);
			}
		});

		delBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedScore == null) {
					JOptionPane.showMessageDialog(null, "성적을 선택해주세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				ArrayList<StudentScore> sList = new ArrayList<StudentScore>();
				for (int i = 0; i < scoreTable.getRowCount(); i++) {
					StudentScore ss = new StudentScore();
					ss.setNo(Integer.parseInt(String.valueOf(scoreTable.getValueAt(i, 0))));
					ss.setSubject(String.valueOf(scoreTable.getValueAt(i, 1)));
					ss.setScore(Double.parseDouble(String.valueOf(scoreTable.getValueAt(i, 2))));
					ss.setEvaluator(String.valueOf(scoreTable.getValueAt(i, 3)));

					sList.add(ss);
				}

				sList.remove(selectedScoreRow);

				sc.editScore(selectedStudent, sList);

				loadScore(selectedStudent);
				dtmScore = new DefaultTableModel(score, scoreHeader) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				scoreTable.setModel(dtmScore);
			}
		});

		return bPanel;
	}

	public JTable getStudentTable() {
		return studentTable;
	}

	public void setStudentTable(JTable studentTable) {
		this.studentTable = studentTable;
	}

	public Member getSelectedStudent() {
		return selectedStudent;
	}

	public void setSelectedStudent(Member selectedStudent) {
		this.selectedStudent = selectedStudent;
	}

}
