package com.kh.example.chap03_component.view;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class J_Table {

	public J_Table() {
		JFrame frame = new JFrame();

		String[] header = { "�̸�", "�ڹ�", "���", "ȭ��" };
		Object[][] data = { { "���ǰ�", 100, 95, 85 }, { "������", 58, 95, 78 }, { "�����", 42, 14, 100 },
				{ "�����", 65, 72, 55 } };

		// 1. �⺻���� ���̺� �����
//		JTable table = new JTable(data, header);
////		frame.add(table);
//		JScrollPane scroll = new JScrollPane(table);
//		scroll.setPreferredSize(new Dimension(200, 80));
//		frame.add(scroll);

		// 2. DefaultTableModel ���
//		DefaultTableModel dtm = new DefaultTableModel(data, header);
		DefaultTableModel dtm = new DefaultTableModel(data, header) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JTable table = new JTable(dtm);
		JScrollPane scroll = new JScrollPane(table);
		frame.add(scroll, BorderLayout.NORTH);

		// ������ �߰�
		Object[] addArr = { "���̹�", 58, 75, 17 };
		dtm.addRow(addArr);

		// ��� �� ���� ���ϱ�
		System.out.println(dtm.getRowCount());
		System.out.println(dtm.getColumnCount());

		System.out.println(dtm.getColumnName(0));

		dtm.removeRow(0);

		System.out.println(dtm.getValueAt(1, 2));

		dtm.setValueAt(5000, 2, 2);

		table.setRowSelectionInterval(0, 1);

		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

//		table.setEnabled(false); // ������ �������� ���õ� ����

		JPanel select = new JPanel();
		JTextArea ta = new JTextArea(10, 30);
		ta.setEditable(false);
		select.add(ta);
		frame.add(select, BorderLayout.SOUTH);

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int selectRow = table.getSelectedRow();
				int colNum = dtm.getColumnCount();
				Object[] objArr = new Object[colNum];
				for (int i = 0; i < colNum; i++) {
					objArr[i] = table.getValueAt(selectRow, i);
					
					if (i == colNum - 1) {
						ta.append(objArr[i] + "\n");
					} else {
						ta.append(objArr[i] + " ");
					}
				}
			}
		});

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
