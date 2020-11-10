package com.kh.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet4 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height");
		String[] foods = request.getParameterValues("food");

		String recommendation = "";
		switch (age) {
		case "10대 미만":
			recommendation = "뽀로로 인형";
			break;
		case "10대":
			recommendation = "스마트폰";
			break;
		case "20대":
			recommendation = "돈";
			break;
		case "30대":
			recommendation = "집";
			break;
		case "40대":
			recommendation = "배우자 출장";
			break;
		case "50대":
			recommendation = "건강";
			break;
		}
		
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("age", age);
		request.setAttribute("city", city);
		request.setAttribute("height", height);
		request.setAttribute("foods", foods);
		request.setAttribute("recommendation", recommendation);
		
		RequestDispatcher view = request.getRequestDispatcher("servlet/testServlet4End.jsp");
		
		view.forward(request, response);
	}
}
