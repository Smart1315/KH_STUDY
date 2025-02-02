package com.kh.mini.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.kh.mini.controller.Server;

public class Information extends JFrame {
	private static final long serialVersionUID = 8003256519056817704L;
	
	private Server server;
	public static JTextArea logText;
	public static JScrollPane scroll;

	public Information() {
		setLayout(new BorderLayout());
		setSize(430, 506);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		logText = new JTextArea(20, 30);
		logText.setEditable(false);
		scroll = new JScrollPane(logText);
		scroll.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panel.add(scroll, BorderLayout.CENTER);

		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new BorderLayout());
		JPanel btnInPanel = new JPanel();
		JButton startBtn = new JButton("����");
		JButton stopBtn = new JButton("����");
		stopBtn.setVisible(false);

		btnInPanel.add(startBtn);
		btnInPanel.add(stopBtn);

		btnPanel.add(btnInPanel);

		panel.add(btnPanel, BorderLayout.SOUTH);

		add(panel, BorderLayout.CENTER);

		setVisible(true);
		
		
		startBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				server = new Server();
				Server.stop = false;
				server.start();
				startBtn.setVisible(false);
				stopBtn.setVisible(true);
			}

		});

		stopBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Server.server.close();
					Server.stop = true;
					Information.logText.append(InetAddress.getLocalHost().getHostAddress() + "/ server closed\n");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				startBtn.setVisible(true);
				stopBtn.setVisible(false);
			}
		});
	}

}
