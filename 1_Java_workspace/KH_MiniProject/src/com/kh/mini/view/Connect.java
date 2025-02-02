package com.kh.mini.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Connect extends JFrame {
	private static final long serialVersionUID = -5931461049398107220L;

	public static String ip;
	public static int port;

	public Connect() {
		super("학원관리시스템");
		setLayout(null);
		setSize(374, 161);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setLocation(0, 0);
		panel.setSize(368, 132);

		JLabel ipLabel = new JLabel("IP");
		ipLabel.setBounds(46, 10, 44, 21);
		JTextField aClassText = new JTextField();
		aClassText.setBounds(84, 10, 50, 21);
		JTextField bClassText = new JTextField();
		bClassText.setBounds(146, 10, 50, 21);
		JTextField cClassText = new JTextField();
		cClassText.setBounds(208, 10, 50, 21);
		JTextField dClassText = new JTextField();
		dClassText.setBounds(270, 10, 50, 21);

		JLabel portLabel = new JLabel("Port");
		portLabel.setBounds(46, 41, 44, 21);
		JTextField portText = new JTextField();
		portText.setBounds(84, 39, 50, 23);

		JButton connectBtn = new JButton("연결");
		connectBtn.setBounds(117, 86, 141, 36);

		panel.add(ipLabel);
		panel.add(aClassText);
		panel.add(bClassText);
		panel.add(cClassText);
		panel.add(dClassText);

		panel.add(portLabel);
		panel.add(portText);

		panel.add(connectBtn);

		add(panel);

		setVisible(true);

		connectBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ip = Integer.parseInt(aClassText.getText()) + "." + Integer.parseInt(bClassText.getText()) + "."
							+ Integer.parseInt(cClassText.getText()) + "." + Integer.parseInt(dClassText.getText());
					port = Integer.parseInt(portText.getText());

					Socket socket = new Socket(ip, port);

					if (socket != null) {
						socket.close();

						dispose();

						new Login();
					}

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "입력값 오류", "알림", JOptionPane.INFORMATION_MESSAGE);
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (ConnectException e1) {
					JOptionPane.showMessageDialog(null, "서버 응답없음", "알림", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
