package com.kh.mini.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.kh.mini.controller.BoardController;
import com.kh.mini.model.vo.Board;

public class WriteBoard extends JFrame {
	private static final long serialVersionUID = 8317755074659903396L;

	private BoardController bc = new BoardController();

	public WriteBoard() {
		setTitle("글쓰기");

		setSize(500, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		JLabel titleLabel = new JLabel("제목");
		titleLabel.setBounds(23, 25, 50, 22);
		JTextField titleText = new JTextField();
		titleText.setBounds(77, 25, 374, 22);

		JLabel writeId = new JLabel("작성자");
		writeId.setBounds(23, 64, 50, 22);
		JTextField writeIdText = new JTextField();
		writeIdText.setEditable(false);
		writeIdText.setText(Main.loginInfo.getId());
		writeIdText.setBounds(77, 64, 374, 22);

		JLabel contentLabel = new JLabel("내용");
		contentLabel.setBounds(23, 109, 50, 22);
		JTextArea contentText = new JTextArea();
		JScrollPane contentScroll = new JScrollPane(contentText);
		contentScroll.setBounds(77, 109, 374, 444);

		JCheckBox noticeBox = new JCheckBox("공지사항");
		noticeBox.setBounds(77, 559, 94, 22);

		JButton writeBtn = new JButton("작성 완료");
		writeBtn.setBounds(328, 599, 140, 34);

		panel.add(titleLabel);
		panel.add(titleText);
		panel.add(writeId);
		panel.add(writeIdText);
		panel.add(contentLabel);
		panel.add(contentScroll);
		panel.add(noticeBox);
		panel.add(writeBtn);

		if (Main.loginInfo.getDist() == 0) {
			noticeBox.setVisible(false);
		}

		add(panel);

		writeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (titleText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "제목을 입력해주세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				Board b = new Board();
				Date date = Calendar.getInstance().getTime();

				b.setNotice(noticeBox.isSelected());
				b.setTitle(titleText.getText());
				b.setId(Main.loginInfo.getId());
				b.setContent(contentText.getText());
				b.setRegDate(date);

				bc.writeBoard(b);
				
				BoardView.view.loadBoardList();
				
				dispose();
			}
		});
	}

}
