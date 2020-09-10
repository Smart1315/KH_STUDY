package com.kh.mini.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.controller.MemberController;
import com.kh.mini.model.vo.Member;

public class Management extends JPanel {
	private static final long serialVersionUID = 3705225118626980812L;

	private MemberController mc = new MemberController();

	private JPanel bPanel;

	private Member selectedStudent;

	private String[] studentHeader = { "번호", "아이디", "이름", "학과", "학년" };
	private DefaultTableModel dtmStudent;
	private JTable studentTable;

	private JTextField noText, nameText, deptText, addressText;
	private JComboBox<Integer> gradeCBox;

	public Management() {
		setLayout(new BorderLayout());

		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setEnabled(false);

		JPanel tPanel = topPanel();
		bPanel = bottomPanel();

		splitPane.setTopComponent(tPanel);
		splitPane.setBottomComponent(bPanel);

		add(splitPane, BorderLayout.CENTER);
	}

	public Object[][] loadStudent() {
		return mc.loadStudent();
	}

	public void editStudent(Member m) {
		mc.editMember(m);
	}

	public JPanel topPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JPanel nPanel = new JPanel();
		nPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		JButton refreshBtn = new JButton("새로고침");
		nPanel.add(refreshBtn);


		dtmStudent = new DefaultTableModel(loadStudent(), studentHeader) {
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

		panel.add(nPanel, BorderLayout.NORTH);
		panel.add(scroll, BorderLayout.CENTER);

		studentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectRow = studentTable.getSelectedRow();
				selectedStudent = mc.loadStudent(new Member(String.valueOf(studentTable.getValueAt(selectRow, 1))));

				bPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),
						selectedStudent.getName() + " 학생 개인정보"));

				noText.setText(selectedStudent.getNo());
				nameText.setText(selectedStudent.getName());
				deptText.setText(selectedStudent.getDept());
				gradeCBox.setSelectedIndex(selectedStudent.getGrade() - 1);
				addressText.setText(selectedStudent.getAddress());

			}
		});

		refreshBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bPanel.setBorder(
						BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "학생 개인정보"));

				selectedStudent = null;
				noText.setText("");
				nameText.setText("");
				deptText.setText("");
				gradeCBox.setSelectedIndex(0);
				addressText.setText("");

				dtmStudent = new DefaultTableModel(loadStudent(), studentHeader) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				studentTable.setModel(dtmStudent);
			}
		});

		return panel;
	}

	public JPanel bottomPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "학생 개인정보"));

		JPanel cPanel = new JPanel();
		cPanel.setLayout(new FlowLayout());

		Box verticalBox = Box.createVerticalBox();
		cPanel.add(verticalBox);

		Box hBox1 = Box.createHorizontalBox();
		hBox1.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		verticalBox.add(hBox1);

		Box hBox2 = Box.createHorizontalBox();
		verticalBox.add(hBox2);

		JLabel noLabel = new JLabel("번호");
		noLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		noText = new JTextField(10);
		hBox1.add(noLabel);
		hBox1.add(noText);

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 10));
		nameText = new JTextField(10);
		hBox1.add(nameLabel);
		hBox1.add(nameText);

		JLabel deptLabel = new JLabel("학과");
		deptLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 10));
		deptText = new JTextField(10);
		hBox1.add(deptLabel);
		hBox1.add(deptText);

		JLabel gradeLabel = new JLabel("학년");
		gradeLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 10));
		Integer[] grade = { 1, 2, 3, 4 };
		gradeCBox = new JComboBox<Integer>(grade);
		hBox1.add(gradeLabel);
		hBox1.add(gradeCBox);

		JLabel addressLabel = new JLabel("주소");
		addressLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		addressText = new JTextField(10);
		hBox2.add(addressLabel);
		hBox2.add(addressText);

		panel.add(cPanel, BorderLayout.CENTER);

		JPanel sPanel = new JPanel();
		sPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		JButton editBtn = new JButton("수정");

		sPanel.add(editBtn);

		panel.add(sPanel, BorderLayout.SOUTH);

		editBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedStudent == null) {
					JOptionPane.showMessageDialog(null, "수정할 학생을 선택하세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				selectedStudent.setNo(noText.getText());
				selectedStudent.setName(nameText.getText());
				selectedStudent.setDept(deptText.getText());
				selectedStudent.setGrade(gradeCBox.getSelectedIndex() + 1);
				selectedStudent.setAddress(addressText.getText());

				editStudent(selectedStudent);
				bPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),
						selectedStudent.getName() + " 학생 개인정보"));
				
				dtmStudent = new DefaultTableModel(loadStudent(), studentHeader) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				studentTable.setModel(dtmStudent);
				
			}
		});

		return panel;
	}
}
