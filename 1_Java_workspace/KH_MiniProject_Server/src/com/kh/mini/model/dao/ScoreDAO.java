package com.kh.mini.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.StudentScore;

public class ScoreDAO {

	public ArrayList<StudentScore> loadScore(Member student) {
		ArrayList<StudentScore> score = new ArrayList<StudentScore>();
		String path = "Score\\" + student.hashCode() + ".txt";
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));) {
			while (true) {
				score.add((StudentScore) ois.readObject());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return score;
	}

	public boolean saveScore(Member student, StudentScore score) {
		ArrayList<StudentScore> s = loadScore(student);
		
		if(!s.contains(score)) {
			s.add(score);
		} else {
			return false;
		}
		
		String path = "Score\\" + student.hashCode() + ".txt";

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
			for(int i = 0; i < s.size(); i++) {
				oos.writeObject(s.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public void editScore(Member student, ArrayList<StudentScore> score) {
		String path = "Score\\" + student.hashCode() + ".txt";

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
			for(int i = 0; i < score.size(); i++) {
				oos.writeObject(score.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
