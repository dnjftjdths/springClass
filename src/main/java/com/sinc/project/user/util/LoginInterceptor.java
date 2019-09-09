package com.sinc.project.user.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(	HttpServletRequest request, HttpServletResponse response, 
							Object handler, ModelAndView modelAndView ) 
					throws Exception {
		
		System.out.println("LoginInterceptor > postHandle");
		HttpSession session = request.getSession();
		ModelMap model = modelAndView.getModelMap();
		Object obj = model.get("user");
		
		String dest = checkDestination(request);
		String path = (dest != null) ? dest : "/";
		
		if(obj != null) {
			System.out.println("Interceptor success");
			session.setAttribute("loginUser", obj);
			response.sendRedirect(path);
		} else {
			response.sendRedirect("/user/loginForm.sinc");
		}
	}
	
	// 로그인이 완료되면 index페이지가 아니라 로그인 전에 있던 페이지로 이동
	public String checkDestination(HttpServletRequest request) {
		System.out.println("LoginIntercepter > checkDestination");
		HttpSession session = request.getSession();
		String savePath = (String)session.getAttribute("savePath");
		session.removeAttribute("savePath");	// 특정 속성만 clear
		// session.invalidate();	// session에 저장된 모든 속성 clear
		System.out.println("savePath : " + savePath);
		return savePath;
	}
	
}
