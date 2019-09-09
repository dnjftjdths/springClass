package com.sinc.project.user.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinc.project.user.model.vo.UserVO;
import com.sinc.project.user.service.UserService;

@Controller
@RequestMapping("/user")
// @SessionAttributes({"loginUser"})		// loginUser 속성이 session scope으로 변경된다.
public class UserCtrl {
	
	@Resource(name="userS")
	private UserService service;
	
	@RequestMapping("/loginForm.sinc")
	public String loginForm() {
		System.out.println("UserCtrl loginForm");
		return "/user/login";
	}
	
	@RequestMapping(value="/login.sinc", method=RequestMethod.POST)	// RequestMethod.GET
	// ~public String login(UserVO user, HttpSession session)	// 이라고 하고
	public void login(UserVO user, Model model) {	// user 메소드의 setter 메소드로 자동 bind된다
		System.out.println("UserCtrl login");
		UserVO result = service.loginService(user);
		
		if(result != null) {	
			// ~session.setAttribute(name, value);	// 위의 물결 코드에서 이와 같이 이용해도 됨.
			model.addAttribute("user", result);
		} 
	}
	
	@RequestMapping("/logout.sinc")
	public String logout(HttpSession session) {	// 옛날방식
	//public String logout(SessionStatus status) {
		session.invalidate();				// 옛날방식
		System.out.println("UserCtrl logout");
		// status.setComplete();
		return "redirect:/index.sinc";
	}
	
	@RequestMapping(value="/joinForm.sinc", method=RequestMethod.GET)
	public String joinForm() {
		return "/user/join";
	}
}
