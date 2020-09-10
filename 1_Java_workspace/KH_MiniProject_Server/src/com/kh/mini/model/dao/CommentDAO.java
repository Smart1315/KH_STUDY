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

import com.kh.mini.model.vo.Comment;

public class CommentDAO {
	private String path = "Board\\Comment\\";

	public void checkDirectory(String fileName) {
		File f = new File(fileName);

		if (!f.isDirectory()) {
			f.mkdirs();
		}
	}

	public void writeComment(Comment c) {

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(path + c.getBoardNo() + "\\" + c.getNum() + ".txt"));) {
			oos.writeObject(c);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Comment> readComment(int boardNo) {
		checkDirectory(path + boardNo + "\\");

		ArrayList<Comment> list = new ArrayList<Comment>();

		File[] listOfFiles = new File(path + boardNo + "\\").listFiles();

		for (File file : listOfFiles) {
			try (ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(path + boardNo + "\\" + file.getName()));) {
				list.add((Comment) ois.readObject());

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (EOFException e) {

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public void editComment(Comment c) {
		writeComment(c);
	}

	public void deleteComment(Comment c) {
		File f = new File(path + c.getBoardNo() + "\\" + c.getNum() + ".txt");

		if (f.exists()) {
			f.delete();
		}
	}
}
