package com.kh.example.chap03_component.view;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class C_CheckBox {

	public C_CheckBox() {
		JFrame frame = new JFrame();

		String[] fruits = { "apple", "orange", "banana" };

		JCheckBox[] buttons = new JCheckBox[fruits.length];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JCheckBox(fruits[i]);
		}

		JPanel checkPanel = new JPanel();
		for (JCheckBox checkBox : buttons) {
			checkPanel.add(checkBox);
		}

		JPanel resultPanel = new JPanel();
		JLabel text = new JLabel("선택한 과일이 없습니다.");
		resultPanel.add(text);

		frame.add(checkPanel, BorderLayout.NORTH);
		frame.add(resultPanel, BorderLayout.CENTER);

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					String result = "";
					int count = 0;

					for (int i = 0; i < buttons.length; i++) {
						if (buttons[i].isSelected()) {
							result += buttons[i].getText() + " ";
							count++;
						}
					}
					
					if (count == 0) {
						text.setText("선택한 과일이 없습니다.");
					} else {
						text.setText(result);
					}

				}
			});
		}
	}
}
