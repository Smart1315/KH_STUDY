package com.kh.mini.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.kh.mini.controller.MemberController;
import com.kh.mini.model.vo.Member;

public class ProfileEdit extends JPanel {
	private static final long serialVersionUID = 7669883481052980400L;

	private MemberController sc = new MemberController();

	private Member loginInfo;

	private JTextField noText, idText, nameText, deptText, addrText, phone1, phone2;
	private JPasswordField pwText;

	public ProfileEdit() {
		loginInfo = Main.loginInfo;


		JLabel noLabel = new JLabel("NO.");
		noText = new JTextField(20);
		noText.setEditable(false);
		noText.setText(String.valueOf(loginInfo.getNo()));

		JLabel idLabel = new JLabel("ID");
		idText = new JTextField(20);
		idText.setEditable(false);
		idText.setText(loginInfo.getId());

		JLabel pwLabel = new JLabel("PW");
		pwText = new JPasswordField(20);

		JLabel nameLabel = new JLabel("이름");
		nameText = new JTextField(20);
		nameText.setEditable(false);
		nameText.setText(loginInfo.getName());

		JLabel deptLabel = new JLabel("과정");
		deptText = new JTextField(20);
		deptText.setText(loginInfo.getDept());

		JLabel gradeLabel = new JLabel("학년");
		Integer[] grade = { 1, 2, 3, 4 };
		JComboBox<Integer> gradeCBox = new JComboBox<Integer>(grade);
		gradeCBox.setSelectedIndex(loginInfo.getGrade() - 1);

		JLabel addrLabel = new JLabel("주소");
		addrText = new JTextField(20);
		addrText.setText(loginInfo.getAddress());

		JPanel phonePanel = new JPanel();

		JLabel phoneLabel = new JLabel("휴대전화");
		String[] phone0 = { "010", "011", "016" };
		JComboBox<String> phoneBox = new JComboBox<String>(phone0);
		String[] phone = loginInfo.getPhone().split("-");

		if (phone[0].equals("010")) {
			phoneBox.setSelectedIndex(0);
		} else if (phone[0].equals("011")) {
			phoneBox.setSelectedIndex(1);
		} else if (phone[0].equals("016")) {
			phoneBox.setSelectedIndex(2);
		}

		JLabel phone_1 = new JLabel("-");
		phone_1.setFont(new Font("굴림", Font.BOLD, 20));
		phone_1.setHorizontalAlignment(SwingConstants.CENTER);
		phone1 = new JTextField(4);
		phone1.setText(phone[1]);

		JLabel phone_2 = new JLabel("-");
		phone_2.setFont(new Font("굴림", Font.BOLD, 20));
		phone_2.setHorizontalAlignment(SwingConstants.CENTER);
		phone2 = new JTextField(4);
		phone2.setText(phone[2]);
		phonePanel.setLayout(new GridLayout(0, 5, 0, 0));

		phonePanel.add(phoneBox);
		phonePanel.add(phone_1);
		phonePanel.add(phone1);
		phonePanel.add(phone_2);
		phonePanel.add(phone2);

		JButton editBtn = new JButton("수정하기");

		GroupLayout groupLayout = new GroupLayout(this);
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100), "회원정보"));

		setLayout(groupLayout);

		int hGap = 100;
		int vGap = 50;

		groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(hGap)
						.addComponent(noLabel).addComponent(idLabel).addComponent(pwLabel).addComponent(nameLabel)
						.addComponent(deptLabel).addComponent(gradeLabel).addComponent(addrLabel)
						.addComponent(phoneLabel))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(hGap)
						.addComponent(noText).addComponent(idText).addComponent(pwText).addComponent(nameText)
						.addComponent(deptText).addComponent(gradeCBox).addComponent(addrText).addComponent(phonePanel))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(hGap)
						.addComponent(editBtn)));

		groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addGap(vGap)
						.addComponent(noLabel).addComponent(noText))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addGap(vGap)
						.addComponent(idLabel).addComponent(idText))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addGap(vGap)
						.addComponent(pwLabel).addComponent(pwText))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addGap(vGap)
						.addComponent(nameLabel).addComponent(nameText))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addGap(vGap)
						.addComponent(deptLabel).addComponent(deptText))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addGap(vGap)
						.addComponent(gradeLabel).addComponent(gradeCBox))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addGap(vGap)
						.addComponent(addrLabel).addComponent(addrText))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addGap(vGap)
						.addComponent(phoneLabel).addComponent(phonePanel))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addGap(vGap)
						.addComponent(editBtn)));

//		groupLayout.setAutoCreateGaps(true);
//		groupLayout.setAutoCreateContainerGaps(true);

		groupLayout.linkSize(SwingConstants.HORIZONTAL, noLabel, idLabel, pwLabel, nameLabel, deptLabel, gradeLabel,
				addrLabel, phoneLabel);
		groupLayout.linkSize(SwingConstants.VERTICAL, noText, idText, pwText, nameText, deptText, gradeCBox, addrText,
				phonePanel);

		editBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loginInfo.setPw(String.valueOf(pwText.getPassword()));
				loginInfo.setDept(deptText.getText());
				loginInfo.setGrade(gradeCBox.getItemAt(gradeCBox.getSelectedIndex()));
				loginInfo.setAddress(addrText.getText());
				loginInfo.setPhone(phoneBox.getItemAt(phoneBox.getSelectedIndex()) + "-" + phone1.getText() + "-"
						+ phone2.getText());

				Object res = sc.editMember(loginInfo);

				if (res instanceof Boolean) {
					if ((Boolean) res) {
						JOptionPane.showMessageDialog(null, "모든 정보를 입력해 주세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "회원정보 수정에 실패하였습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
					}
				} else if (res instanceof Member) {
					Main.loginInfo = (Member) res;
					JOptionPane.showMessageDialog(null, "회원정보가 수정되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

	}
}
