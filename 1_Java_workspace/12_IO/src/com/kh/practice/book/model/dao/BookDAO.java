package com.kh.practice.book.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.practice.book.model.vo.Book;

public class BookDAO {
	private Book[] bArr = new Book[10];

	public void fileSave(Book[] bArr) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.txt"));) {
			for (Book b : bArr) {
				if (b != null) {
					oos.writeObject(b);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Book[] fileRead() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.txt"));) {

			for (int i = 0; i < bArr.length; i++) {
				bArr[i] = (Book) ois.readObject();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			return bArr;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return bArr;
	}

}
