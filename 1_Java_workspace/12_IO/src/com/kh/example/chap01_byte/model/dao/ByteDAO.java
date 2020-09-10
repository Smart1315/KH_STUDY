package com.kh.example.chap01_byte.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteDAO {

	public void fileOpen() {
		FileInputStream fis = null;
		try {
			// ������ �����͸� ����Ʈ ������ �о���� �ʹ�
			fis = new FileInputStream("a_byte.txt");

			// 1. �迭�� ����Ͽ� �迭�� �����Ͽ� �о����
//			int fileSize = (int) new File("a_byte.txt").length();
//			byte[] bArr = new byte[fileSize];
//			fis.read(bArr);
//			for (byte character : bArr) {
//				System.out.print((char) character + " ");
//			}
			// 2. �迭 ���� ������� �ʰ� �о����
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
			// ������ �����͸� ����Ʈ ������ �о���� �ʹ�

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
			// ���Ͽ� �����͸� ����Ʈ ������ �����ϰ� �ʹ�
//			FileOutputStream fos = new FileOutputStream("a_byte.txt");
			fos = new FileOutputStream("a_byte.txt", true);
			fos.write(97);

			byte[] bArr = { 98, 99, 100, 101, 102, 103 };
			fos.write(bArr);

			fos.write(bArr, 1, 3); // 1 index���� 3��
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
			// ���Ͽ� �����͸� ����Ʈ ������ �����ϰ� �ʹ�
			fos.write(94);

			byte[] bArr = { 98, 99, 100, 101, 102, 103 };
			fos.write(bArr);

			fos.write(bArr, 1, 3); // 1 index���� 3��
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
