package com.kh.example.chap01_byte.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteDAO {

	public void fileOpen() {
		FileInputStream fis = null;
		try {
			// 파일의 데이터를 바이트 단위로 읽어오고 싶다
			fis = new FileInputStream("a_byte.txt");

			// 1. 배열을 사용하여 배열에 저장하여 읽어오기
//			int fileSize = (int) new File("a_byte.txt").length();
//			byte[] bArr = new byte[fileSize];
//			fis.read(bArr);
//			for (byte character : bArr) {
//				System.out.print((char) character + " ");
//			}
			// 2. 배열 저장 사용하지 않고 읽어오기
			int value;
			while ((value = fis.read()) != -1) {
				System.out.print((char) value + " ");
			}
//			while (fis.available() != 0) {
//				System.out.print((char) fis.read() + " ");
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void fileOpen2() {

		try (FileInputStream fis = new FileInputStream("a_byte.txt");) {
			// 파일의 데이터를 바이트 단위로 읽어오고 싶다

//			int value;
//			while ((value = fis.read()) != -1) {
//				System.out.print((char) value + " ");
//			}
			for (int i = fis.read(); i != -1; i = fis.read()) {
				System.out.print((char) i + " ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void fileSave() {
		FileOutputStream fos = null;
		try {
			// 파일에 데이터를 바이트 단위로 저장하고 싶다
//			FileOutputStream fos = new FileOutputStream("a_byte.txt");
			fos = new FileOutputStream("a_byte.txt", true);
			fos.write(97);

			byte[] bArr = { 98, 99, 100, 101, 102, 103 };
			fos.write(bArr);

			fos.write(bArr, 1, 3); // 1 index부터 3개
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void fileSave2() {

		try (FileOutputStream fos = new FileOutputStream("a_byte.txt", true);) {
			// 파일에 데이터를 바이트 단위로 저장하고 싶다
			fos.write(94);

			byte[] bArr = { 98, 99, 100, 101, 102, 103 };
			fos.write(bArr);

			fos.write(bArr, 1, 3); // 1 index부터 3개
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
