package com.sinc.project;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinc.project.test.service.TestServiceImpl;

// annotation을 이용해서 객체를 controller로 생성
@Controller
// @RequestMapping("/test")	// 로 기능별 세부 폴더를 나눠서 controller를 관리할 수 있다.
public class TestController {
	
	// 1. String : 페이지의 논리적 이름만 반환
	@RequestMapping("/index.sinc")
	public String main(Model model) {
		System.out.println("TestController main");
		model.addAttribute("msg", "Hi~ model");
		return "home";
	}
	
	// 2. void : 
	/*
	@RequestMapping("/a.sinc")
	public void doA() {
		System.out.println("TextController doA");
	} 	// 404 error (views안에 test 폴더가 없으므로 a.jsp파일을 찾지 못함)
	
	@RequestMapping("/test/a.sinc")
	public void doA() {
		System.out.println("TextController doA");
	}	// /views/test/a.jsp파일로 이동해서 잘 작동한다.
	*/
	
	@RequestMapping("/a.sinc")
	public String doA() {
		System.out.println("TextController doA");
		return "/test/a";
	}
	
	// 3. ModelAndView : model과 view를 담을 수 있는 객체
	// Back에서 가져온 객체와 View 정보를 함께 저장해서 보낸다.
	@RequestMapping("/b.sinc")
	public ModelAndView doB() {
		System.out.println("TextController doB");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");		// home.jsp로
		mv.addObject("msg", "Hi ~ model and view");	// msg 객체를 전달
		return mv;
	}
	
	// root-context.xml파일에서 생성한 testS객체를 이용
	@Resource(name="testS")
	private TestServiceImpl service;
	
	@RequestMapping("/dependency.sinc")
	public String dependency() {
		System.out.println("TestController dependency");
		System.out.println(service.sayEcho("맛점하세요~~"));
		return "home";
	}
}
