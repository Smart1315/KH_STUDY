package com.kh.example.set.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import com.kh.example.set.model.compare.DogComparator;
import com.kh.example.set.model.vo.Dog;

public class SetController {
	
	public void doSet() {
//		HashSet<Dog> set = new HashSet<>(); // 타입 추론
		HashSet<Dog> set = new HashSet<Dog>();
		
		// add(E e) : set 안에 데이터 추가
		set.add(new Dog("마음", 3.3));
		set.add(new Dog("모모", 2.3));
		set.add(new Dog("이든", 5.6));
		System.out.println(set);	
		
		set.add(new Dog("모모", 2.3));
		System.out.println(set);
		
		LinkedHashSet<Dog> set2 = new LinkedHashSet<Dog>();
		
		set2.add(new Dog("초코", 2.1));
		set2.add(new Dog("콩이", 8.3));
		set2.add(new Dog("두부", 5.0));
		set2.add(new Dog("초코", 2.1));
		System.out.println(set2);	
		set2.add(new Dog("로이", 6.1));
		set2.add(new Dog("공주", 5.2));
		set2.add(new Dog("왕자", 9.5));
		set2.add(new Dog("조이", 12.5));
		
		System.out.println(set2);
		
		TreeSet<Dog> set3 = new TreeSet<Dog>(set2);
		set3.add(new Dog("봉이", 6.1));
		System.out.println(set3);
		
		TreeSet<Dog> set4 = new TreeSet<Dog>(new DogComparator());
		set4.addAll(set2);
		set4.add(new Dog("봉이", 6.1));
		System.out.println(set4);
		
		Iterator<Dog> it = set4.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		while(it.hasNext()) {
			System.out.println("re : " + it.next());
		}
	}
}
