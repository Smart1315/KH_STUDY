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

		// put(K key, V value) : Ű�� �� �߰�
		map.put("�����", new Snack("§��", 1500));
		map.put("������", new Snack("�ܸ�", 2500));
		map.put("��������Ĩ", new Snack("§��", 1500));
		map.put("��ҹ�", new Snack("����Ѹ�", 1000));

		System.out.println(map);

		map.put("�����", new Snack("�ſ��", 1500)); // key���� �ߺ��ǹǷ� value�� �����ȴ�
		System.out.println(map);

		// containsKey(Objcet key) : key�� ������ true��ȯ
		// containsValue(Object value) : value�� ������ true��ȯ
		System.out.println(map.containsKey("�����"));
		System.out.println(map.containsValue(new Snack("§��", 1500)));

		// get(Object Key) : key�� ���� �� ��ȯ
		System.out.println(map.get("�����"));
		System.out.println(map.get("Ȩ����"));

		// values() : ��� value���� Collection�� ��� ��ȯ
		System.out.println(map.values());

		// 1. keySet() : ��� Ű�� set�� ��� ��ȯ
		Set<String> set1 = map.keySet();
		Iterator<String> it1 = set1.iterator();

		while (it1.hasNext()) {
			String key = it1.next();
			System.out.printf("Ű : %s, �� : %s\n", key, map.get(key));
		}

		// 2. entrySet() : entry(Ű+��)�� Set�� ��� ��ȯ
		Set<Entry<String, Snack>> set2 = map.entrySet();
//		System.out.println(set2);
		Iterator<Entry<String, Snack>> it2 = set2.iterator();

		while (it2.hasNext()) {
			Entry<String, Snack> en = it2.next();
			System.out.printf("Ű : %s, �� : %s\n", en.getKey(), en.getValue());
		}

		System.out.println();

		TreeMap<String, Snack> map2 = new TreeMap<String, Snack>();
		map2.putAll(map);
		System.out.println(map2);

		TreeMap<String, Snack> map3 = new TreeMap<String, Snack>(new SnackComparator());
		map3.putAll(map);
		System.out.println(map3);

		System.out.println(map3.size());

		// remove(Object key) : �ش� Ű�� entry ���� �� �� Ű�� �� ��ȯ
		System.out.println(map3.remove("������"));
		System.out.println(map3);

		// remove(Object key, Object value) : �ش� Ű�� value���� ��ġ�ϴ� entry ���� �� ��� ��ȯ
		System.out.println(map3.remove("��������", new Snack("§��", 1500)));
		System.out.println(map3);

		map3.clear();
		System.out.println(map3);
		System.out.println(map3.isEmpty());
	}

	public void doProperties() {
		Properties prop = new Properties();
//		prop.put(1,  10);
		prop.setProperty("ä��", "����");
		prop.setProperty("����", "���");
		prop.setProperty("����", "����");
		prop.setProperty("ä��", "�Ǹ�");
		System.out.println(prop);

		System.out.println(prop.getProperty("ä��"));
		System.out.println(prop.getProperty("�߰�"));
		System.out.println(prop.getProperty("�߰�", "����")); // key���� ������ 2��° �Ű����� ��ȯ

	}

	public void fileSave() {
		Properties prop = new Properties();
		prop.setProperty("title", "Properties Practice");
		prop.setProperty("width", "1920");
		prop.setProperty("height", "1080");
		prop.setProperty("language", "kor");

		try (FileOutputStream fos1 = new FileOutputStream("test.properties");
				FileOutputStream fos2 = new FileOutputStream("test.xml");) {
//			prop.store(out, comments); : ����� ������ ����Ʈ ��Ʈ������ ��� ����, comments�� �ּ����� ����
//			prop.store(writer, comments); : ����� ������ ���� ��Ʈ������ ��� ����, comments�� �ּ����� ����
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
			
			// load(InputStream inStream) : ����Ʈ ��Ʈ������ ����� ������ ������ �о�ͼ� Properties�� ����
			// load(Reader reader) : ���� ��Ʈ������ ����� ������ ������ �о�ͼ� Properties�� ����
			prop1.load(fis1);
			
			// loadFromXML(InputStream in) : ����Ʈ ��Ʈ������ ����� xml������ ������ �о�ͼ� Properties�� ����
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
