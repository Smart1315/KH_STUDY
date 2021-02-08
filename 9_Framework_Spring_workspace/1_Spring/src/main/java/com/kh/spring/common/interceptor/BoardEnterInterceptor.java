package com.kh.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class BoardEnterInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getSession().getAttribute("loginUser") == null) {
			request.setAttribute("msg", "로그인 후 이용하세요");
			request.getRequestDispatcher("WEB-INF/views/home.jsp").forward(request, response);
			return false;
		} 
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
		
	}
	
}
