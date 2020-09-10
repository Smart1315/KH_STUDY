package com.kh.example.practice6.run;

import com.kh.example.practice6.model.vo.Book;

public class Run {

	public static void main(String[] args) {
		Book b1 = new Book();
		b1.inform();

		Book b2 = new Book("µ·ÀÇ ¼Ó¼º", "½º³ë¿ìÆø½ººÏ½º", "±è½ÂÈ£");
		b2.inform();
		
		Book b3 = new Book("´õ ÇØºù", "¼ö¿À¼­Àç", "ÀÌ¼­À±, È«ÁÖ¿¬", 16000, 0.1);
		b3.inform();

	}

}
