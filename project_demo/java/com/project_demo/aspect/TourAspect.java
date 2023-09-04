package com.project_demo.aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TourAspect {
	
	@Before(value="execution(* com.project_demo.controller.*.*(..))")
	public void beforeAdvice1() {
		System.out.println("Before print 1");
	}
	
	/*@Before(value="execution(* com.project_demo.controller.TourController.*(..))")
	public void beforeAdvice() {
		System.out.println("Hello");
	}*/
	
	@Before(value="execution(* com.project_demo.controller.TourController.getUser(..))")
	public void beforeAdvice2() {
		System.out.println("Before print 2");
	}
	
	@Before(value="execution(* com.project_demo.controller.TourController.getUser(..))")
	public void beforeAdvice1(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature()+" started at "+new Date());
	}
	
	@After(value="execution(* com.project_demo.controller.*.*(..))")
	public void afterAdvice1() {
		System.out.println("After print 1");
	}
	
	@After(value="execution(* com.project_demo.controller.TourController.getUser(..))")
	public void afterAdvice2() {
		System.out.println("After print 2");
	}
	
	@After(value="execution(* com.project_demo.controller.TourController.getUser(..))")
	public void afterAdvice1(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature()+" ended at "+new Date());
	}
}
