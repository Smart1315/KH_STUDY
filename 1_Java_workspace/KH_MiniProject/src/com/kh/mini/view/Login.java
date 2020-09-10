package com.kh.mini.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.mini.controller.MemberController;
import com.kh.mini.model.vo.Member;

public class Login {
	private MemberController sc = new MemberController();

	private JFrame frame;
	private JTextField idText;
	private JPasswordField pwText;
	
	public Login() {
		frame = new JFrame("학원관리시스템");
		frame.setLayout(null);
		frame.setSize(300, 180);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(294, 151);
		panel.setLocation(0, 0);

		JLabel idLabel = new JLabel("ID");
		idLabel.setSize(20, 21);
		idLabel.setLocation(60, 23);

		idText = new JTextField(20);
		idText.setSize(130, 21);
		idText.setLocation(90, 23);

		JLabel pwLabel = new JLabel("PW");
		pwLabel.setSize(20, 21);
		pwLabel.setLocation(58, 64);

		pwText = new JPasswordField(20);
		pwText.setSize(130, 21);
		pwText.setLocation(90, 64);

		JButton loginBtn = new JButton("로그인");
		loginBtn.setSize(92, 21);
		loginBtn.setLocation(39, 107);

		JButton signUpBtn = new JButton("회원가입");
		signUpBtn.setSize(92, 21);
		signUpBtn.setLocation(157, 107);

		panel.add(idLabel);
		panel.add(idText);
		panel.add(pwLabel);
		panel.add(pwText);
		panel.add(loginBtn);
		panel.add(signUpBtn);

		pwText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});

		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});

		signUpBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SignUp();
			}
		});

		frame.add(panel);
		frame.setVisible(true);
	}
	
	public void login() {
		String id = idText.getText();
		String pw = String.valueOf(pwText.getPassword());
		Member input = new Member(id, pw);
		Object res = sc.login(input);

		if (res instanceof Integer) {
			int result = (Integer) res;
			if (result == 0) {
				JOptionPane.showMessageDialog(null, "회원정보가 없습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			} else if (result == 1) {
				JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (res instanceof Member) {
			frame.dispose();
			new Main((Member) res);
		}
	}
}
