package com.kh.example.chap02_layout.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class D_CardLayout extends JFrame {

	public D_CardLayout() {
		super("CardLayout");
		setBounds(300, 200, 800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// CardLayout
		// Panel�� �̿��ؼ� ī�� ���� ���ĳ���(�̺�Ʈ�� �ٸ� ���� ���̰� �����ؾ���)
		CardLayout card = new CardLayout();
		setLayout(card);

		// �г�(Panel) �����
		// �г��� ������Ʈ���� �ٸ� ������Ʈ�� ���� �� �� �־� �����̳��� ������ ���ϰ� ����
		JPanel card1 = new JPanel();
		JPanel card2 = new JPanel();
		JPanel card3 = new JPanel();

		// �гο� ���� ����
		card1.setBackground(Color.RED);
		card2.setBackground(Color.GREEN);
		card3.setBackground(Color.BLUE);

		// �гο� ��(���̺�) �߰�
		card1.add(new JLabel("Card1"));
		card2.add(new JLabel("Card2"));
		card3.add(new JLabel("Card3"));

		add(card1);
		add(card2);
		add(card3);
		
		card1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) { // ��Ŭ��
					card.next(card1.getParent());
				} else if (e.getButton() == 3) { // ��Ŭ��
					card.previous(card1.getParent());
				}
			}
		});

		card2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) { // ��Ŭ��
					card.next(card2.getParent());
				} else if (e.getButton() == 3) { // ��Ŭ��
					card.previous(card2.getParent());
				}
			}
		});

		card3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) { // ��Ŭ��
					card.next(card3.getParent());
				} else if (e.getButton() == 3) { // ��Ŭ��
					card.previous(card3.getParent());
				}
			}
		});


		setVisible(true);
	}
}
