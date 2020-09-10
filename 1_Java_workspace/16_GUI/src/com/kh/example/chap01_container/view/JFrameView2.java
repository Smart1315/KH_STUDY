package com.kh.example.chap01_container.view;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class JFrameView2 {
	
	public void showJFrame() {
		JFrame frame = new JFrame("My Second Frame");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setTitle("My Second Frame");
		
		Rectangle r = new Rectangle(300, 200, 800, 500);
		frame.setBounds(r);
		
		frame.setResizable(false);
		
		try {
			frame.setIconImage(ImageIO.read(new File("image/icon.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
