package com.kh.example.chap03_component.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class G_Spinner {

	public G_Spinner() {
		JFrame frame = new JFrame();
		frame.setSize(500, 120);

		JPanel panel = new JPanel();

		// ListModel
		String[] items = { "소설", "잡지", "전공서적", "취미" };
		SpinnerListModel listModel = new SpinnerListModel(items);
		JSpinner listSpinner = new JSpinner(listModel);
		panel.add(listSpinner);

		// NumberModel
		SpinnerNumberModel numberModel = new SpinnerNumberModel(1, 0, 9, 1);
		JSpinner numberSpinner = new JSpinner(numberModel);
		panel.add(numberSpinner);

		// DateModel
		Calendar calender = Calendar.getInstance();

		Date today = calender.getTime();

		calender.add(Calendar.YEAR, -50);
		Date start = calender.getTime();

		calender.add(Calendar.YEAR, 100);
		Date end = calender.getTime();

		SpinnerDateModel dateModel = new SpinnerDateModel(today, start, end, Calendar.YEAR);
		JSpinner dateSpinner = new JSpinner(dateModel);
		dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "yyyy/MM/dd HH:mm:ss"));
		panel.add(dateSpinner);

		JButton button = new JButton("전송");
		panel.add(button);

		JPanel resultPanel = new JPanel();
		JLabel text = new JLabel();
		resultPanel.add(text);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText(listSpinner.getValue() + ", " + numberSpinner.getValue() + ", "
						+ new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(dateSpinner.getValue()));

			}
		});

		frame.add(panel, BorderLayout.NORTH);
		frame.add(resultPanel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
