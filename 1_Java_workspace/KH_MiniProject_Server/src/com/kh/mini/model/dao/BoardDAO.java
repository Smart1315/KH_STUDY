package com.kh.mini.model.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.mini.model.vo.Board;

public class BoardDAO {
	private String path = "Board\\";

	public void checkDirectory(String fileName) {
		File f = new File(fileName);

		if (!f.isDirectory()) {
			f.mkdirs();
		}
	}

	public void writeBoard(Board b) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + b.getNum() + ".txt"));) {
			oos.writeObject(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Board> readBoard() {
		checkDirectory(path);

		ArrayList<Board> list = new ArrayList<Board>();

		File[] listOfFiles = new File(path).listFiles();

		for (File file : listOfFiles) {
			if (!file.isDirectory()) {
				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + file.getName()));) {
					list.add((Board) ois.readObject());

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (EOFException e) {

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}

	public Board readBoard(int boardNo) {
		checkDirectory(path);

		Board b = null;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + boardNo + ".txt"));) {
			b = (Board) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}

		return b;
	}

	public void deleteBoard(int boardNo) {
		File f = new File(path + boardNo + ".txt");

		if (f.exists()) {
			f.delete();
		}
	}
}
