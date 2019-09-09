package com.sinc.project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TestInterceptor preHandler");
		// HttpSession session = request.getSession();
		// if(session.getAttribute("loginUser")) {
		//		response.sendRedirect("로그인 페이지로");
		// }
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {	// modelAndView 객체도 매개변수로 담고 있다.
		System.out.println("TestInterceptor postHandler");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
}
