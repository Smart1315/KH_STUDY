package com.kh.mini.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.kh.mini.controller.BoardController;
import com.kh.mini.controller.CommentController;
import com.kh.mini.model.vo.Board;
import com.kh.mini.model.vo.Comment;

public class BoardContentView extends JFrame {
	private static final long serialVersionUID = -4757810749504330795L;

	private BoardController bc = new BoardController();
	private CommentController cc = new CommentController();

	private int boardNo;
	private Board board;
	private JPanel commentBackPanel;
	private JPanel commentPanel;
	private JScrollPane commentScroll;
	private ArrayList<Comment> comments;

	public BoardContentView(int boardNo) {
		this.boardNo = boardNo;
		loadBoard();
		
		if(board == null) {
			return;
		}

		setTitle("게시글");

		setSize(916, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(500, 671);
		JLabel titleLabel = new JLabel("제목");
		titleLabel.setBounds(23, 25, 50, 22);
		JTextField titleText = new JTextField();
		titleText.setBounds(77, 25, 374, 22);

		JLabel writeId = new JLabel("작성자");
		writeId.setBounds(23, 64, 50, 22);
		JTextField writeIdText = new JTextField();
		writeIdText.setEditable(false);
		writeIdText.setBounds(77, 64, 374, 22);

		JLabel contentLabel = new JLabel("내용");
		contentLabel.setBounds(23, 109, 50, 22);
		JTextArea contentText = new JTextArea();
		JScrollPane contentScroll = new JScrollPane(contentText);
		contentScroll.setBounds(77, 109, 374, 444);

		titleText.setText(board.getTitle());
		writeIdText.setText(board.getId());
		contentText.setText(board.getContent());

		JCheckBox noticeBox = new JCheckBox("공지사항");
		noticeBox.setBounds(77, 559, 94, 22);
		noticeBox.setSelected(board.isNotice());

		JButton editBtn = new JButton("수정");
		editBtn.setBounds(219, 609, 110, 38);
		JButton delBtn = new JButton("삭제");
		delBtn.setBounds(341, 609, 110, 38);

		if (!Main.loginInfo.getId().equals(board.getId())) {
			titleText.setEditable(false);
			contentText.setEditable(false);
			noticeBox.setVisible(false);
			editBtn.setVisible(false);
			delBtn.setVisible(false);
		} else if (Main.loginInfo.getDist() != 1) {
			noticeBox.setVisible(false);
		}

		panel.add(titleLabel);
		panel.add(titleText);
		panel.add(writeId);
		panel.add(writeIdText);
		panel.add(contentLabel);
		panel.add(contentScroll);
		panel.add(noticeBox);
		panel.add(editBtn);
		panel.add(delBtn);

		add(panel);
		add(commentPanel());

		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (titleText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "제목을 입력해주세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				board.setNotice(noticeBox.isSelected());
				board.setTitle(titleText.getText());
				board.setContent(contentText.getText());
				board.setRegDate(Calendar.getInstance().getTime());

				bc.editBoard(board);

				BoardView.view.loadBoardList();

				dispose();
			}
		});

		delBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bc.deleteBoard(boardNo);

				BoardView.view.loadBoardList();

				dispose();
			}
		});
	}

	public void loadBoard() {
		board = bc.readBoard(boardNo);
	}

	public void loadComment() {

		commentPanel = new JPanel();
		commentPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;

		comments = cc.readComment(boardNo);
		
		if(comments == null) {
			return;
		}

		for (int i = 0; i < comments.size(); i++) {
			gbc.gridy = i;
			commentPanel.add(comment(comments.get(i)), gbc);
		}

		commentScroll = new JScrollPane(commentPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		commentScroll.setLocation(0, 0);
		commentScroll.setSize(409, 590);

	}

	public JPanel commentPanel() {
		commentBackPanel = new JPanel();
		commentBackPanel.setLocation(501, 0);
		commentBackPanel.setSize(409, 671);
		commentBackPanel.setLayout(new BorderLayout());
		commentBackPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		loadComment();

		JPanel writePanel = new JPanel();
		writePanel.setLayout(new BorderLayout());
		writePanel.setBorder(BorderFactory.createEmptyBorder(25, 10, 25, 10));

		JTextField commentText = new JTextField(20);
		writePanel.add(commentText, BorderLayout.CENTER);

		JButton writeBtn = new JButton("comment");
		writePanel.add(writeBtn, BorderLayout.EAST);

		commentBackPanel.add(commentScroll, BorderLayout.CENTER);
		commentBackPanel.add(writePanel, BorderLayout.SOUTH);

		writeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(commentText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "내용을 입력하세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				Comment c = new Comment();

				c.setBoardNo(boardNo);
				c.setId(Main.loginInfo.getId());
				c.setDate(Calendar.getInstance().getTime());
				c.setComment(commentText.getText());

				cc.writeComment(c);

				commentText.setText("");

				commentBackPanel.remove(commentScroll);
				loadComment();
				commentBackPanel.add(commentScroll, BorderLayout.CENTER);

				commentBackPanel.revalidate();
				commentBackPanel.repaint();
			}
		});

		commentText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(commentText.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "내용을 입력하세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					Comment c = new Comment();

					c.setBoardNo(boardNo);
					c.setId(Main.loginInfo.getId());
					c.setDate(Calendar.getInstance().getTime());
					c.setComment(commentText.getText());

					cc.writeComment(c);

					commentText.setText("");

					commentBackPanel.remove(commentScroll);
					loadComment();
					commentBackPanel.add(commentScroll, BorderLayout.CENTER);

					commentBackPanel.revalidate();
					commentBackPanel.repaint();
				}
			}
		});

		return commentBackPanel;
	}

	public JPanel comment(Comment c) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JPanel npanel = new JPanel();
		npanel.setLayout(new BorderLayout());

		JPanel nLPanel = new JPanel();
		nLPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		JLabel id = new JLabel("id");
		id.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		id.setText(c.getId());
		JLabel date = new JLabel("Date");
		date.setText(new SimpleDateFormat("yyyy/MM/dd a HH:mm:ss").format(c.getDate()));
		date.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		nLPanel.add(id);
		nLPanel.add(date);

		JPanel nRPanel = new JPanel();
		nRPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		JButton editBtn = new JButton("수정");
		JButton deleteBtn = new JButton("삭제");

		if (c.getId().equals(Main.loginInfo.getId())) {
			nRPanel.add(editBtn);
			nRPanel.add(deleteBtn);
		}

		npanel.add(nLPanel, BorderLayout.WEST);
		npanel.add(nRPanel, BorderLayout.EAST);

		JPanel cPanel = new JPanel();
		cPanel.setLayout(new BorderLayout());

		JPanel cardPanel = new JPanel();
		CardLayout card = new CardLayout();
		cardPanel.setLayout(card);
		JLabel word = new JLabel("댓글 내용");
		word.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
		word.setText(c.getComment());
		JTextField commentText = new JTextField(20);
		commentText.setText(c.getComment());

		cardPanel.add(word);
		cardPanel.add(commentText);

		cPanel.add(cardPanel, BorderLayout.CENTER);

		panel.add(npanel, BorderLayout.NORTH);
		panel.add(cPanel, BorderLayout.CENTER);

		editBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (deleteBtn.getText().equals("삭제")) {
					card.next(word.getParent());
					deleteBtn.setText("취소");
				} else {
					c.setComment(commentText.getText());
					cc.editComment(c);
					
					commentBackPanel.remove(commentScroll);
					loadComment();
					commentBackPanel.add(commentScroll, BorderLayout.CENTER);

					commentBackPanel.revalidate();
					commentBackPanel.repaint();
				}

			}
		});

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (deleteBtn.getText().equals("삭제")) {
					cc.deleteComment(c);
					
					commentBackPanel.remove(commentScroll);
					loadComment();
					commentBackPanel.add(commentScroll, BorderLayout.CENTER);

					commentBackPanel.revalidate();
					commentBackPanel.repaint();
				} else {
					card.next(word.getParent());
					deleteBtn.setText("삭제");
				}
			}
		});

		return panel;
	}
}
