package com.kh.example.chap03_component.view;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class I_Dialog {

	public I_Dialog() {
		JFrame frame = new JFrame();

		JPanel panel = new JPanel();
		JButton button1 = new JButton("Simple Dialog");
		panel.add(button1);

		Dialog dialog = new Dialog(frame, "새로운 창 이름");
		dialog.setBounds(150, 250, 200, 200);

		JLabel label = new JLabel("simple dialog test");
		label.setHorizontalAlignment(JLabel.CENTER);
		dialog.add(label, BorderLayout.NORTH);

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});

		JButton button2 = new JButton("close");
		dialog.add(button2, BorderLayout.CENTER);

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});

		JButton button3 = new JButton("Input dialog");
		panel.add(button3);

		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 1. 입력 다이어로그
//				String result = JOptionPane.showInputDialog("내용을 입력하세요");
//				System.out.println(result);

				// 2. 확인 다이어로그
//				int result = JOptionPane.showConfirmDialog(null, "확인하시겠습니까?", "확인창", JOptionPane.YES_NO_OPTION);
//				int result = JOptionPane.showConfirmDialog(null, "확인하시겠습니까?", "확인창", JOptionPane.YES_NO_CANCEL_OPTION);
//				System.out.println(result);

				// 3. 메세지 다이어로그
				JOptionPane.showMessageDialog(null, "위험합니다", "danger", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "위험합니다", "danger", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "위험합니다", "danger", JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(null, "위험합니다", "danger", JOptionPane.QUESTION_MESSAGE);
				JOptionPane.showMessageDialog(null, "위험합니다", "danger", JOptionPane.WARNING_MESSAGE);
			}
		});

		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dialog.dispose();
			}
		});

		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
