package com.kh.mini.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.kh.mini.controller.BoardController;

public class BoardView extends JPanel {
	private static final long serialVersionUID = -3896436949112159120L;

	static BoardView view;

	private BoardController bc = new BoardController();

	private String[] boardHeader = { "번호", "제목", "작성자", "작성일" };
	private int noticeCount;
	private Object[][] boardList;
	private JComboBox<String> reqBox;
	private JTextField reqText;
	private DefaultTableModel dtm;
	private JTable table;

	public BoardView() {
		view = this;

		setLayout(new BorderLayout());

		add(northPanel(), BorderLayout.NORTH);
		add(centerPanel(), BorderLayout.CENTER);
		add(southPanel(), BorderLayout.SOUTH);

		JLayeredPane layeredPane = new JLayeredPane();
		add(layeredPane, BorderLayout.WEST);

	}

	public void loadBoardList() {

		boardList = bc.loadBoard();

		if (boardList == null) {
			return;
		}

		noticeCount = 0;
		for (int i = 0; i < boardList.length; i++) {
			if ((boolean) boardList[i][4]) {
				noticeCount++;
			}
		}

		dtm = new DefaultTableModel(boardList, boardHeader) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table.setModel(dtm);

		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				TableColumn column = table.getColumnModel().getColumn(j);

				column.setCellRenderer(new NoticeCellRenderer());

			}
		}
	}

	public void searchBoard() {
		int index = reqBox.getSelectedIndex();

		boardList = bc.searchBoard(index, reqText.getText());

		noticeCount = 0;
		for (int i = 0; i < boardList.length; i++) {
			if ((boolean) boardList[i][4]) {
				noticeCount++;
			}
		}

		dtm = new DefaultTableModel(boardList, boardHeader) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table.setModel(dtm);

		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				TableColumn column = table.getColumnModel().getColumn(j);

				column.setCellRenderer(new NoticeCellRenderer());

			}
		}
	}

	public JPanel northPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JPanel lPanel = new JPanel();
		lPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton refreshBtn = new JButton("새로고침");

		lPanel.add(refreshBtn);

		JPanel rPanel = new JPanel();

		rPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		JLabel reqLabel = new JLabel("검색 조건");

		String[] reqString = { "제목", "내용", "작성자" };

		reqBox = new JComboBox<String>(reqString);

		reqText = new JTextField(10);

		JButton reqBtn = new JButton("검색");

		rPanel.add(reqLabel);
		rPanel.add(reqBox);
		rPanel.add(reqText);
		rPanel.add(reqBtn);

		panel.add(lPanel, BorderLayout.WEST);
		panel.add(rPanel, BorderLayout.EAST);

		reqBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchBoard();
			}
		});

		reqText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchBoard();
				}
			}
		});

		refreshBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadBoardList();
			}
		});

		return panel;
	}

	public JPanel centerPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "게시글 목록"));

		table = new JTable(dtm);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		loadBoardList();
		JScrollPane scroll = new JScrollPane(table);

//		table.getColumn("번호").setPreferredWidth(5);
//		table.getColumn("제목").setPreferredWidth(20);
//		table.getColumn("작성자").setPreferredWidth(5);
//		table.getColumn("작성일").setPreferredWidth(5);

		panel.add(scroll);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectRow = table.getSelectedRow();
				if (e.getClickCount() == 2) {
					new BoardContentView((int) table.getValueAt(selectRow, 0));
				}
			}
		});

		return panel;
	}

	public JPanel southPanel() {
		JPanel panel = new JPanel();

		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		JButton writePostBtn = new JButton("글 작성");

		panel.add(writePostBtn);

		writePostBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new WriteBoard();
			}
		});

		return panel;
	}

	class NoticeCellRenderer extends DefaultTableCellRenderer {
		private static final long serialVersionUID = 1474645442791916423L;

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

			if (row < noticeCount) {
				comp.setFont(new Font("굴림", Font.BOLD, 12));
				if (!isSelected) {
					comp.setBackground(Color.CYAN);
				} else {
					comp.setBackground(new Color(200, 221, 242));
				}
			} else {
				if (!isSelected) {
					comp.setBackground(Color.WHITE);
				} else {
					comp.setBackground(new Color(200, 221, 242));
				}
			}

			return comp;
		}

	}

}
