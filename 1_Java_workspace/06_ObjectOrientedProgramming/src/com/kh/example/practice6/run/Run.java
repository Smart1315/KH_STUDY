package com.kh.example.practice6.run;

import com.kh.example.practice6.model.vo.Book;

public class Run {

	public static void main(String[] args) {
		Book b1 = new Book();
		b1.inform();

		Book b2 = new Book("���� �Ӽ�", "����������Ͻ�", "���ȣ");
		b2.inform();
		
		Book b3 = new Book("�� �غ�", "��������", "�̼���, ȫ�ֿ�", 16000, 0.1);
		b3.inform();

	}

}
