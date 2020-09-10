package com.kh.practice.map.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import com.kh.practice.map.model.vo.Member;

public class MemberController {
	private HashMap<String, Member> map = new HashMap<String, Member>();

	public boolean joinMembership(String id, Member m) {
		if (!map.containsKey(id)) {
			map.put(id, m);
			return true;
		} else {
			return false;
		}
	}

	public String login(String id, String password) {
		if (map.containsKey(id)) {
			Member m = map.get(id);

			if (m.getPassword().equals(password)) {
				return m.getName();
			}
		}

		return null;

	}

	public boolean changePassword(String id, String oldPw, String newPw) {
		if(map.containsKey(id)) {
			Member m = map.get(id);
			
			if(m.getPassword().equals(oldPw)) {
				m.setPassword(newPw);
				map.put(id, m);
				return true;
			}
		}
		
		return false;
	}

	public void changeName(String id, String newName) {
		Member m = map.get(id);
		m.setName(newName);
		map.put(id, m);
	}

	public TreeMap<String, String> sameName(String name) {
		TreeMap<String, String> t = new TreeMap<String, String>();
		
		Set<String> s = map.keySet();
		
		Iterator<String> it = s.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			Member m = map.get(key);
			if(m.getName().equals(name)) {
				t.put(key, name);
			}
		}
		
		return t;
	}

}
