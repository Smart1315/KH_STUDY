package com.kh.example.chap01_use.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class B_Other {

	public B_Other() {
		JFrame frame = new JFrame();
		frame.setSize(250, 200);

		JPanel panel = new JPanel();
		JButton button1 = new JButton("버튼1");
		JButton button2 = new JButton("버튼2");
		JLabel label = new JLabel("아직 버튼이 눌리지 않았습니다.");

		panel.add(button1);
		panel.add(button2);
		panel.add(label);

		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		button1.addActionListener(new MyEvent(label));
		button2.addActionListener(new MyEvent(label));
	}

}

class MyEvent implements ActionListener {
	private JLabel label;
	
	public MyEvent(JLabel label) {
		this.label = label;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		System.out.println(button);
		if(button.equals("버튼1")) {
			label.setText("버튼1이 눌렸습니다.");
		} else if(button.equals("버튼2")) {
			label.setText("버튼2가 눌렸습니다.");
		}
	}
	
}
