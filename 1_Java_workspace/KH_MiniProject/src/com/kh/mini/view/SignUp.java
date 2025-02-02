package com.kh.mini.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.kh.mini.controller.MemberController;
import com.kh.mini.model.vo.Member;

public class SignUp {
	private MemberController mc = new MemberController();

	JTextField idText, nameText, deptText, addrText, phone1, phone2;
	JPasswordField pwText;

	public SignUp() {
		JFrame frame = new JFrame("회원가입");
		frame.setSize(347, 425);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(341, 395);
		panel.setLocation(0, 0);

		JLabel distLabel = new JLabel("가입구분");
		distLabel.setBounds(44, 39, 57, 15);

		JRadioButton studentRBtn = new JRadioButton("학생");
		studentRBtn.setBounds(106, 35, 60, 23);
		studentRBtn.setSelected(true);
		JRadioButton teacherRBtn = new JRadioButton("강사");
		teacherRBtn.setBounds(170, 35, 60, 23);

		ButtonGroup distGroup = new ButtonGroup();
		distGroup.add(studentRBtn);
		distGroup.add(teacherRBtn);

		JLabel idLabel = new JLabel("ID");
		idLabel.setSize(27, 26);
		idLabel.setLocation(44, 64);
		idText = new JTextField(20);
		idText.setSize(168, 26);
		idText.setLocation(106, 64);

		JLabel pwLabel = new JLabel("PW");
		pwLabel.setSize(27, 26);
		pwLabel.setLocation(44, 100);
		pwText = new JPasswordField(20);
		pwText.setSize(168, 26);
		pwText.setLocation(106, 100);

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setSize(27, 26);
		nameLabel.setLocation(44, 135);
		nameText = new JTextField(20);
		nameText.setSize(168, 26);
		nameText.setLocation(106, 136);

		JLabel deptLabel = new JLabel("과정");
		deptLabel.setSize(27, 26);
		deptLabel.setLocation(44, 171);
		deptText = new JTextField(20);
		deptText.setSize(168, 26);
		deptText.setLocation(106, 172);

		JLabel gradeLabel = new JLabel("학년");
		gradeLabel.setSize(27, 26);
		gradeLabel.setLocation(44, 207);
		Integer[] grade = { 1, 2, 3, 4 };
		JComboBox<Integer> gradeCBox = new JComboBox<Integer>(grade);
		gradeCBox.setSize(168, 26);
		gradeCBox.setLocation(106, 208);

		JLabel addrLabel = new JLabel("주소");
		addrLabel.setSize(27, 26);
		addrLabel.setLocation(44, 244);

		addrText = new JTextField(20);
		addrText.setSize(168, 26);
		addrText.setLocation(106, 244);

		JLabel phoneLabel = new JLabel("휴대전화");
		phoneLabel.setSize(60, 26);
		phoneLabel.setLocation(44, 280);

		String[] phone0 = { "010", "011", "016" };
		JComboBox<String> phoneBox = new JComboBox<String>(phone0);
		phoneBox.setSize(48, 26);
		phoneBox.setLocation(106, 280);

		JLabel phone_1 = new JLabel("-");
		phone_1.setSize(32, 26);
		phone_1.setLocation(157, 280);

		phone1 = new JTextField(4);
		phone1.setSize(48, 26);
		phone1.setLocation(166, 280);

		JLabel phone_2 = new JLabel("-");
		phone_2.setSize(48, 26);
		phone_2.setLocation(215, 280);

		phone2 = new JTextField(4);
		phone2.setSize(48, 26);
		phone2.setLocation(226, 280);

		JButton signupBtn = new JButton("회원가입");
		signupBtn.setSize(170, 26);
		signupBtn.setLocation(93, 342);

		panel.add(distLabel);
		panel.add(studentRBtn);
		panel.add(teacherRBtn);
		panel.add(idLabel);
		panel.add(idText);
		panel.add(pwLabel);
		panel.add(pwText);
		panel.add(nameLabel);
		panel.add(nameText);
		panel.add(deptLabel);
		panel.add(deptText);
		panel.add(gradeLabel);
		panel.add(gradeCBox);
		panel.add(addrLabel);
		panel.add(addrText);
		panel.add(phoneLabel);
		panel.add(phoneBox);
		panel.add(phone_1);
		panel.add(phone1);
		panel.add(phone_2);
		panel.add(phone2);
		panel.add(signupBtn);

		phone1.addKeyListener(new PhoneTextFieldEvent());
		phone2.addKeyListener(new PhoneTextFieldEvent());

		signupBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Member member = new Member();
				if (studentRBtn.isSelected()) {
					member.setDist(0);
				} else if (teacherRBtn.isSelected()) {
					member.setDist(1);
				}
				member.setId(idText.getText());
				member.setPw(String.valueOf(pwText.getPassword()));
				member.setName(nameText.getText());
				member.setDept(deptText.getText());
				member.setGrade(gradeCBox.getItemAt(gradeCBox.getSelectedIndex()));
				member.setAddress(addrText.getText());
				member.setPhone(phoneBox.getItemAt(phoneBox.getSelectedIndex()) + "-" + phone1.getText() + "-"
						+ phone2.getText());

				int res = mc.signUp(member);

				if (res == -1) {
					JOptionPane.showMessageDialog(null, "회원정보를 모두 입력하세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
				} else if (res == 0) {
					JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
				} else if (res == 1) {
					JOptionPane.showMessageDialog(null, "회원가입에 성공하였습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
				}

			}
		});

		frame.add(panel);

		frame.setVisible(true);
	}

	class PhoneTextFieldEvent extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();

			if (!(key >= KeyEvent.VK_0 && key <= KeyEvent.VK_9)
					&& !(key >= KeyEvent.VK_NUMPAD0 && key <= KeyEvent.VK_NUMPAD9) && key != KeyEvent.VK_BACK_SPACE
					&& key != KeyEvent.VK_DELETE) {
				e.setKeyCode(KeyEvent.VK_BACK_SPACE);

				JOptionPane.showMessageDialog(null, "숫자만 입력 가능합니다.", "경고", JOptionPane.WARNING_MESSAGE);
			}

		}

	}
}
