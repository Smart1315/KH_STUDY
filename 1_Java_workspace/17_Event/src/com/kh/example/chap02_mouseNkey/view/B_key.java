package com.kh.example.chap02_mouseNkey.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class B_key extends JFrame implements KeyListener {
	
	public B_key() {
		setSize(300, 200);
		
		JTextField tf = new JTextField(20);
		add(tf);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tf.addKeyListener(this);
	}
	
	public void display(String s, KeyEvent e) {
		char c = e.getKeyChar();
		
		boolean isAlt = e.isAltDown();
		boolean isControl = e.isControlDown();
		boolean isShift = e.isShiftDown();
		
		String modifiers = isAlt + " " + isControl + " " + isShift;
		System.out.println(s + " " + c + " " + modifiers);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		display("keyTyped", e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		display("keyPressed", e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		display("keyReleased", e);
	}

}
