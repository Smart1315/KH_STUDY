package ncs.test7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ScoreFrame extends JFrame {
	private static final long serialVersionUID = -6310652429994784176L;

	private JTextField javaScore;
	private JTextField sqlScore;
	private JTextField total;
	private JTextField average;
	private JButton calcBtn;

	public ScoreFrame() {
		super("문제 7");
		setLayout(new BorderLayout());
		setSize(435, 379);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel titleLabel = new JLabel("점수를 입력하세요");
		titleLabel.setFont(new Font("굴림", Font.BOLD, 45));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 40, 20));
		panel.setLayout(new BorderLayout());

		JPanel nPanel = new JPanel();
		nPanel.setLayout(new BorderLayout());

		JPanel nwPanel = new JPanel();
		JLabel javaLabel = new JLabel("자바 : ");
		javaScore = new JTextField(10);

		JPanel nePanel = new JPanel();
		JLabel sqlLabel = new JLabel("SQL : ");
		sqlScore = new JTextField(10);

		JPanel ccPanel = new JPanel();
		ccPanel.setBorder(BorderFactory.createEmptyBorder(65, 0, 0, 0));
		calcBtn = new JButton("계산하기");

		JPanel sPanel = new JPanel();
		sPanel.setLayout(new BorderLayout());

		JPanel swPanel = new JPanel();
		JLabel totalLabel = new JLabel("총점 : ");
		total = new JTextField(10);
		total.setEditable(false);
		total.setBackground(Color.WHITE);

		JPanel sePanel = new JPanel();
		JLabel averageLabel = new JLabel("평균 : ");
		average = new JTextField(10);
		average.setEditable(false);
		average.setBackground(Color.WHITE);

		nwPanel.add(javaLabel);
		nwPanel.add(javaScore);

		nePanel.add(sqlLabel);
		nePanel.add(sqlScore);

		nPanel.add(nwPanel, BorderLayout.WEST);
		nPanel.add(nePanel, BorderLayout.EAST);

		ccPanel.add(calcBtn);

		swPanel.add(totalLabel);
		swPanel.add(total);

		sePanel.add(averageLabel);
		sePanel.add(average);

		sPanel.add(swPanel, BorderLayout.WEST);
		sPanel.add(sePanel, BorderLayout.EAST);

		panel.add(nPanel, BorderLayout.NORTH);
		panel.add(ccPanel, BorderLayout.CENTER);
		panel.add(sPanel, BorderLayout.SOUTH);

		add(titleLabel, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);

		setVisible(true);

		calcBtn.addActionListener(new ActionHandler());
	}

	class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int java = Integer.parseInt(javaScore.getText());
				int sql = Integer.parseInt(sqlScore.getText());

				int totalNum = java + sql;
				int averageNum = (java + sql) / 2;

				total.setText(String.valueOf(totalNum));
				average.setText(String.valueOf(averageNum));

				total.setText(String.valueOf(totalNum));
				average.setText(String.valueOf(averageNum));
				
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "숫자만 입력하세요", "입력값 오류", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}

}
