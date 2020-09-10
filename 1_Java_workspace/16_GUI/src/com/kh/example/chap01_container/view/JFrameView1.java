package com.kh.example.chap01_container.view;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class JFrameView1 extends JFrame {

	public JFrameView1() {
		super("My First Frame");
//		this.setSize(800, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

//		setLocation(400,  300);
		setBounds(400, 300, 800, 500);
//		setTitle("My First Frame");
		try {
			setIconImage(ImageIO.read(new File("image/icon.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setResizable(false);
		
	}

}
