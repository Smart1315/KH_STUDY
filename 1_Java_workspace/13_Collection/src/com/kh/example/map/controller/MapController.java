package com.kh.example.map.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import com.kh.example.map.model.compare.SnackComparator;
import com.kh.example.map.model.vo.Snack;

public class MapController {

	public void doMap() {
		HashMap<String, Snack> map = new HashMap<String, Snack>();

		// put(K key, V value) : 키와 값 추가
		map.put("새우깡", new Snack("짠맛", 1500));
		map.put("다이제", new Snack("단맛", 2500));
		map.put("포테이토칩", new Snack("짠맛", 1500));
		map.put("고소미", new Snack("고소한맛", 1000));

		System.out.println(map);

		map.put("새우깡", new Snack("매운맛", 1500)); // key값이 중복되므로 value만 덮어쓰기된다
		System.out.println(map);

		// containsKey(Objcet key) : key가 있으면 true반환
		// containsValue(Object value) : value가 있으면 true반환
		System.out.println(map.containsKey("새우깡"));
		System.out.println(map.containsValue(new Snack("짠맛", 1500)));

		// get(Object Key) : key에 대한 값 반환
		System.out.println(map.get("새우깡"));
		System.out.println(map.get("홈런볼"));

		// values() : 모든 value들을 Collection에 담아 반환
		System.out.println(map.values());

		// 1. keySet() : 모든 키를 set에 담아 반환
		Set<String> set1 = map.keySet();
		Iterator<String> it1 = set1.iterator();

		while (it1.hasNext()) {
			String key = it1.next();
			System.out.printf("키 : %s, 값 : %s\n", key, map.get(key));
		}

		// 2. entrySet() : entry(키+값)를 Set에 담아 반환
		Set<Entry<String, Snack>> set2 = map.entrySet();
//		System.out.println(set2);
		Iterator<Entry<String, Snack>> it2 = set2.iterator();

		while (it2.hasNext()) {
			Entry<String, Snack> en = it2.next();
			System.out.printf("키 : %s, 값 : %s\n", en.getKey(), en.getValue());
		}

		System.out.println();

		TreeMap<String, Snack> map2 = new TreeMap<String, Snack>();
		map2.putAll(map);
		System.out.println(map2);

		TreeMap<String, Snack> map3 = new TreeMap<String, Snack>(new SnackComparator());
		map3.putAll(map);
		System.out.println(map3);

		System.out.println(map3.size());

		// remove(Object key) : 해당 키의 entry 삭제 후 그 키의 값 반환
		System.out.println(map3.remove("다이제"));
		System.out.println(map3);

		// remove(Object key, Object value) : 해당 키와 value값이 일치하는 entry 삭제 후 결과 반환
		System.out.println(map3.remove("포테이토", new Snack("짠맛", 1500)));
		System.out.println(map3);

		map3.clear();
		System.out.println(map3);
		System.out.println(map3.isEmpty());
	}

	public void doProperties() {
		Properties prop = new Properties();
//		prop.put(1,  10);
		prop.setProperty("채소", "오이");
		prop.setProperty("과일", "사과");
		prop.setProperty("간식", "젤리");
		prop.setProperty("채소", "피망");
		System.out.println(prop);

		System.out.println(prop.getProperty("채소"));
		System.out.println(prop.getProperty("견과"));
		System.out.println(prop.getProperty("견과", "땅콩")); // key값이 없으면 2번째 매개변수 반환

	}

	public void fileSave() {
		Properties prop = new Properties();
		prop.setProperty("title", "Properties Practice");
		prop.setProperty("width", "1920");
		prop.setProperty("height", "1080");
		prop.setProperty("language", "kor");

		try (FileOutputStream fos1 = new FileOutputStream("test.properties");
				FileOutputStream fos2 = new FileOutputStream("test.xml");) {
//			prop.store(out, comments); : 저장된 정보를 바이트 스트림으로 출력 저장, comments는 주석으로 저장
//			prop.store(writer, comments); : 저장된 정보를 문자 스트림으로 출력 저장, comments는 주석으로 저장
			prop.store(fos1, "Properties Test File");
			prop.storeToXML(fos2, "storeToML Test File");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fileOpen() {

		try (FileInputStream fis1 = new FileInputStream("test.properties");
				FileInputStream fis2 = new FileInputStream("test.xml");) {
			Properties prop1 = new Properties();
			Properties prop2 = new Properties();
			
			// load(InputStream inStream) : 바이트 스트림으로 저장된 파일의 내용을 읽어와서 Properties에 저장
			// load(Reader reader) : 문자 스트림으로 저장된 파일의 내용을 읽어와서 Properties에 저장
			prop1.load(fis1);
			
			// loadFromXML(InputStream in) : 바이트 스트림으로 저장된 xml파일의 내용을 읽어와서 Properties에 저장
			prop2.loadFromXML(fis2);
			
			System.out.println(prop1);
			System.out.println(prop2);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
