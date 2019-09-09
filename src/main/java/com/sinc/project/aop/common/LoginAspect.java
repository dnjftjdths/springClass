package com.sinc.project.aop.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("loginAspect")
@Aspect
public class LoginAspect {
	
	@Before("execution(public * com.sinc.project..*Impl.say*(..))")
	public void before(JoinPoint join) {
		System.out.println("LoginAspect > before advice");
	}
	
	@AfterThrowing(pointcut = "execution(public * com.sinc.project..*Impl.say*(..))",
										throwing = "e")
	public void throwing(JoinPoint point, Exception e) {	// 위의 메소드 실행 시 Exception이 발생하면 매개변수의 e에 던져진다.
		System.out.println("LoginAspect > throwing");
		e.printStackTrace();
	}
}
