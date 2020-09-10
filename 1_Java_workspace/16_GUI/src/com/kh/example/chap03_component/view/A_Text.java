package com.kh.example.chap03_component.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class A_Text {

	public A_Text() {
		JFrame frame = new JFrame();
		frame.setSize(800, 300);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));
		panel.setSize(800, 300);

		// TextField : �� ��¥�� ���� �Է��� �� �ִ� �ؽ�Ʈ ����
		JTextField id = new JTextField(30);
		panel.add(new JLabel("ID"));
		panel.add(id);

		// PasswordField : ��й�ȣ�� �Է��� �� �ִ� TextField
		// �Է��� ���� �� �� ������ �ѱ� �Է� �Ұ�
		JPasswordField password = new JPasswordField(30);
		panel.add(new JLabel("PASSWORD"));
		panel.add(password);

		// TextArea : ���� ���� �ؽ�Ʈ�� �Է� �� �� �ִ� ����
		JTextArea textArea = new JTextArea(10, 30);
		textArea.setEditable(false); // ���� ���� ����(read only)

		JButton btn = new JButton("������");

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = "ID = " + id.getText() + "\n";
				id.setText("");

				String showPwd = "";
				char[] pwdArr = password.getPassword();
				for (char c : pwdArr) {
					showPwd += c;
				}

				text += "password = " + showPwd + "\n";
				password.setText("");

				textArea.append(text);

				id.requestFocus();
			}
		});

		frame.add(panel, BorderLayout.NORTH);
		frame.add(textArea, BorderLayout.CENTER);
		frame.add(btn, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

//	public class Action1 implements ActionListener {
//		private JTextField id;
//		private JPasswordField password;
//		private JTextArea textArea;
//		private JButton btn;
//
//		public Action1() {
//		}
//
//		public Action1(JTextField id, JPasswordField password, JTextArea textArea, JButton btn) {
//			this.id = id;
//			this.password = password;
//			this.textArea = textArea;
//			this.btn = btn;
//		}
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			String text = "ID = " + id.getText() + "\n";
//			id.setText("");
//
//			String showPwd = "";
//			char[] pwdArr = password.getPassword();
//			for (char c : pwdArr) {
//				showPwd += c;
//			}
//
//			text += "password = " + showPwd + "\n";
//			password.setText("");
//
//			textArea.append(text);
//
//			id.requestFocus();
//		}
//	}
}
