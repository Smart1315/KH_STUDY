package com.kh.ajax.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ajax.model.vo.Sample;
import com.kh.ajax.model.vo.User;

@Controller
public class TestController {

	@Autowired
	private Sample samp;

	@RequestMapping("test")
	public void test() {
		System.out.println(samp);
	}

	@RequestMapping("test1")
	public void test1Method(@RequestParam("name") String name, @RequestParam("age") int age,
			HttpServletResponse response) {

		try {
			PrintWriter out = response.getWriter();

			if (name.equals("안영재") && age == 25) {
				out.append("ok");
			} else {
				out.append("fail");
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("test2")
	@ResponseBody
	public String test2Method() {
		JSONObject job = new JSONObject();

		job.put("no", 123);
		job.put("title", "test return json object");
		try {
			job.put("writer", URLEncoder.encode("안영재", "UTF-8"));
			job.put("content", URLEncoder.encode("JSON객체 리턴하기", "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return job.toJSONString();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("test3")
	public void test3Method(HttpServletResponse response) {
		response.setContentType("application/json; charset=UTF-8");
		
		JSONObject job = new JSONObject();
		
		job.put("no", 123);
		job.put("title", "test return json object");
		job.put("writer", "안영재");
		job.put("content", "JSON객체를 리턴하겠습니다.");
		
		try {
			PrintWriter out = response.getWriter();
			out.print(job);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("test4")
	public void test4Method(HttpServletResponse response) {
		response.setContentType("application/json; charset=UTF-8");
		
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("u111", "p111", "강건강", 25, "kkk111@kh.or.kr", "01011112222"));
		list.add(new User("u222", "p222", "남나눔", 25, "nnn111@kh.or.kr", "01022223333"));
		list.add(new User("u333", "p333", "도대담", 25, "ddd111@kh.or.kr", "01033334444"));
		list.add(new User("u444", "p444", "류라라", 25, "rrr111@kh.or.kr", "01044445555"));
		list.add(new User("u555", "p555", "문미미", 25, "mmm111@kh.or.kr", "01055556666"));
		
		JSONArray jArr = new JSONArray();
		for(User user : list) {
			JSONObject jUser = new JSONObject();
			jUser.put("userId", user.getUserId());
			jUser.put("userPwd", user.getUesrPwd());
			jUser.put("userName", user.getUserName());
			jUser.put("age", user.getAge());
			jUser.put("email", user.getEmail());
			jUser.put("phone", user.getPhone());
			
			jArr.add(jUser);
		}
		
		try {
			PrintWriter out = response.getWriter();
			out.println(jArr);
			
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
