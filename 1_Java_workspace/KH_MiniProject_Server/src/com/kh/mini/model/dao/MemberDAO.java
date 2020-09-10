package com.kh.mini.model.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.kh.mini.model.vo.Member;

public class MemberDAO {
	private String fileName = "Member.txt";
	private ArrayList<Member> list = new ArrayList<Member>();

	public void checkFile(String fileName) {
		File f = new File(fileName);

		try {
			if (!f.isFile()) {
				if (f.getParentFile() != null) {
					f.getParentFile().mkdirs();
				}
				f.createNewFile();
			}
		} catch (IOException e) {
			f.mkdirs();
		}
	}

	public boolean saveStudent() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));) {
			for (int i = 0; i < list.size(); i++) {
				oos.writeObject(list.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	public boolean saveStudent(Member student) {
		list = readStudent();

		if (list.contains(student)) {
			return false;
		} else {
			Calendar date = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yy");
			if (list.size() > 0) {
				String num = String.valueOf(list.get(list.size() - 1).getNo());
				int ny = Integer.parseInt(sdf.format(date.getTime()));
				int y = Integer.parseInt(num.substring(0, 2));
				int n = Integer.parseInt(num.substring(2));

				if (y < ny) {
					n = 1;
				} else {
					n++;
				}
				student.setNo(ny + String.format("%03d", n));
			} else {
				student.setNo(sdf.format(date.getTime()) + String.format("%03d", 1));
			}

			if (student.getDist() == 0) {
				checkFile("Score\\" + student.hashCode() + ".txt");
			}

			list.add(student);
		}

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));) {
			for (int i = 0; i < list.size(); i++) {
				oos.writeObject(list.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	public ArrayList<Member> readStudent() {
		checkFile(fileName);

		ArrayList<Member> studentList = new ArrayList<Member>();

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));) {
			while (true) {
				studentList.add((Member) ois.readObject());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}

		return studentList;
	}

	public Object editStudent(Member student) {
		list = readStudent();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(student)) {
				list.set(i, student);
				if (saveStudent()) {
					return list.get(i);
				} else {
					return false;
				}
			}
		}

		return false;

	}
}
