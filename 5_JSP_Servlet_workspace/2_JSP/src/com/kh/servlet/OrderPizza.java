package com.kh.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderPizza extends HttpServlet {
	
	private HashMap<String, Integer> pizzaPrice = new HashMap<String, Integer>();
	private HashMap<String, Integer> toppingPrice = new HashMap<String, Integer>();
	private HashMap<String, Integer> sidePrice = new HashMap<String, Integer>();
	
	public OrderPizza() {
		pizzaPrice.put("치즈피자", 5000);
		pizzaPrice.put("콤비네이션피자", 6000);
		pizzaPrice.put("포테이토피자", 7000);
		pizzaPrice.put("고구마피자", 7000);
		pizzaPrice.put("불고기피자", 8000);
		
		toppingPrice.put("고구마무스", 1000);
		toppingPrice.put("콘크림무스", 1500);
		toppingPrice.put("파인애플토핑", 2000);
		toppingPrice.put("치즈토핑", 2000);
		toppingPrice.put("치즈크러스트", 2000);
		toppingPrice.put("치즈바이트", 3000);
		
		sidePrice.put("오븐구이통닭", 9000);
		sidePrice.put("치킨스틱&윙", 4900);
		sidePrice.put("치즈오븐스파게티", 4000);
		sidePrice.put("새우링&웨지감자", 4000);
		sidePrice.put("갈릭포테이토", 3500);
		sidePrice.put("콜라", 1500);
		sidePrice.put("사이다", 1500);
		sidePrice.put("갈릭소스", 500);
		sidePrice.put("피클", 300);
		sidePrice.put("핫소스", 100);
		sidePrice.put("파마산 치즈가루", 100);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String pizza = request.getParameter("pizza");
		String[] topping = request.getParameterValues("topping");
		String[] side = request.getParameterValues("side");
		
		int total = 0;
		
		total += pizzaPrice.get(pizza);

		if(topping != null) {
			for(String t : topping) {
				total += toppingPrice.get(t);
			}
		}
		
		if(side != null) {
			for(String s : side) {
				total += sidePrice.get(s);
			}
		}
		
		request.setAttribute("pizza", pizza);
		request.setAttribute("topping", topping);
		request.setAttribute("side", side);
		request.setAttribute("total", total);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/pizzaEnd.jsp");
		
		rd.forward(request, response);
	}
}
