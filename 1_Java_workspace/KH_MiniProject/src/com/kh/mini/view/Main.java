package com.kh.mini.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.kh.mini.model.vo.Member;

public class Main extends JFrame {
	private static final long serialVersionUID = -239411549064551783L;

	static JFrame frame;
	static Member loginInfo;

	public Main(Member loginInfo) {
		Main.loginInfo = loginInfo;
		Main.frame = this;

		setTitle(loginInfo.getName() + "님 환영합니다.");

		setSize(1024, 768);
		setResizable(false);
		setLocationRelativeTo(null);

		JTabbedPane tab = new JTabbedPane();
		tab.addTab("마이페이지", new MyPage());
		if (loginInfo.getDist() == 0) {
			tab.addTab("학사행정", new Admin_S());
		} else {
			tab.addTab("학사행정", new Admin_T());
		}
		tab.add("게시판", new BoardView());

		add(tab, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
