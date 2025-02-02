package com.kh.example.chap03_assist.part02_object.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.example.chap03_assist.part02_object.model.vo.Member;

public class ObjectDAO {

	public void fileSave() {
		Member[] mar = { new Member("user01", "pass01", "강건강", "kang123@kh.or.kr", 25, '남', 1250.7),
				new Member("user02", "pass02", "남나눔", "nam456@kh.or.kr", 17, '여', 1221.6),
				new Member("user03", "pass03", "도대담", "do789@kh.or.kr", 22, '남', 1234.6) };

		// 객체를 파일에 저장라고 싶음
		// --- --> 객체에 관련된 보조스트림 필요 : ObjectInputStream, ObjectOutputStream
		// --- --> 저장과 관련된 스트림 필요 : ObjectOutputStream(확정)
		// ------- --> 파일 저장과 관련된 스트림 필요 : FileOutputStream(확정), FileWriter

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d_object.txt"));) {

			for (int i = 0; i < mar.length; i++) {
				oos.writeObject(mar[i]);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fileOpen() {

		// 파일에 저장된 객체를 읽어오고 싶음
		// ------ --> ObjectInputStream
		// ------------------> FileInputStream

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d_object.txt"));) {

			Member[] mar = new Member[3];

			for (int i = 0; i < mar.length; i++) {
				mar[i] = (Member) ois.readObject();
			}

			for (Member m : mar) {
				System.out.println(m);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			// 파일을 끝까지 읽은 후의 처리
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
