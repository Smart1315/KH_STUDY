package com.kh.example.chap03_component.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class F_List {

	public F_List() {
		JFrame frame = new JFrame();
		frame.setSize(300, 230);

		String[] cities = { "����", "����", "�뱸", "�λ�", "���", "��õ", "����", "����" };
		JList<String> list = new JList<String>(cities);

		JPanel resultPanel = new JPanel();

		JLabel label = new JLabel("���õ� �׸� :");
		JTextField selected = new JTextField(10);
		selected.setEditable(false);

		resultPanel.add(label);
		resultPanel.add(selected);

//		frame.add(list, BorderLayout.NORTH);
		frame.add(resultPanel, BorderLayout.CENTER);


		JScrollPane scroller = new JScrollPane(list);
		scroller.setPreferredSize(new Dimension(200, 100));

		frame.add(scroller, BorderLayout.NORTH);

		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				List<String> l = list.getSelectedValuesList();
				String result = "";
				for (int i = 0; i < l.size(); i++) {
					result += l.get(i) + " ";
				}
				selected.setText(result);
			}
		});
		
//		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // default
//		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); // ������ �׸� ������ ���� ����
		
		list.setBorder(BorderFactory.createLineBorder(Color.RED, 10));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
