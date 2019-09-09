package com.sinc.project.board.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("AuterInterceptor > preHandle");
		HttpSession session = request.getSession();
		if( session.getAttribute("loginUser") == null ) {
			savePath(request);
			response.sendRedirect("/user/loginForm.sinc");	// 로그인 페이지로 redirect
			// BoardCtrl으로 넘어가지 않고 다시 되돌린다.
			return false;
		}
		// BoardCtrl으로 넘긴다.
		return true;
	}

	public void savePath(HttpServletRequest request) {
		String uri 			= request.getRequestURI();
		// GET, POST 방식의 모든 정보를 가져온다.(? 뒤의 내용)
		String queryString 	= request.getQueryString();
		
		if(queryString == null || queryString.equals("null")) {
			queryString="";
		} else {
			queryString += "?" + queryString;
		}
		request.getSession().setAttribute("savePath", uri + queryString);
		System.out.println("savePath : " + uri + queryString);
	}
}
