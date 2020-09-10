package com.kh.example.chap02_char.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharDAO {

	public void fileSave() {
		FileWriter fw = null;
		try {
			// 파일에 문자 단위 데이터를 저장하고 싶다
			fw = new FileWriter("b_char.txt");
			fw.write("와, IO 재밌다");
			fw.write('A');
			fw.write(' ');
			char[] cArr = { 'a', 'p', 'p', 'l', 'e', };
			fw.write(cArr);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void fileSave2() {

		try (FileWriter fw = new FileWriter("b_char.txt");) {

			fw.write("try with resource 예시");
			fw.write(' ');
			fw.write('B');
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fileOpen() {
		FileReader fr = null;
		try {
			// 파일을 문자단위 데이터로 읽어오고 싶다
			fr = new FileReader("b_char.txt");

			int value;
			while ((value = fr.read()) != -1) {
				System.out.print((char) value + " ");
			}
//			while (fr.ready()) {
//				System.out.print((char) fr.read());
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void fileOpen2() {

		try (FileReader fr = new FileReader("b_char.txt");) {

			int value;
			while ((value = fr.read()) != -1) {
				System.out.print((char) value + " ");
			}
//			for (int i = fr.read(); i != -1; i = fr.read()) {
//				System.out.print((char) i + " ");
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
