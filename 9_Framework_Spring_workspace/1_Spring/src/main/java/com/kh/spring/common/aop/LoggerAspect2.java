package com.kh.spring.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect2 {
	private Logger logger = LoggerFactory.getLogger(LoggerAspect2.class);
	
//	@Pointcut("execution(* com.kh.spring.board..*(..))")
//	public void myPointcut() {}
	
//	@Around("myPointcut()")
	@Around("execution(* com.kh.spring.board..*(..))")
	public /*void*/ Object loggerAdvice(/*JoinPoint joinPoint*/ProceedingJoinPoint joinPoint) throws Throwable {
		Signature signature = joinPoint.getSignature();
//		logger.debug("signature : " + signature);
		
		String type = signature.getDeclaringTypeName(); // 메소드가 있는 클래스의 풀 네임
		String methodName = signature.getName(); // 타겟 객체의 메소드
//		logger.debug("type : " + type);
//		logger.debug("methodName : " + methodName);
		
		String component = "";
		if(type.indexOf("Controller") > -1) {
			component = "Controller  \t: "; 
		} else if(type.indexOf("Service") > -1) {
			component = "ServiceImpl  \t:  ";
		} else if(type.indexOf("DAO") > -1) {
			component = "DAO  \t\t:  ";
		}
		
		logger.debug("[Before]" + component + type + "." + methodName + "()");
		
//		Object obj = null;
//		try {
//			obj = joinPoint.proceed();
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
		
		Object obj = joinPoint.proceed();
		
		logger.debug("[After]" + component + type + "." + methodName + "()");
		
		return obj;
	}
	
}
