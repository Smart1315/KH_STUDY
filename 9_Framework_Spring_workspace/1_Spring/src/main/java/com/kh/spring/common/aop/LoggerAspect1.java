package com.kh.spring.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerAspect1 {
	private Logger logger = LoggerFactory.getLogger(LoggerAspect1.class);
	
	public /*void*/ Object loggerAdvice(/*JoinPoint joinPoint*/ProceedingJoinPoint joinPoint) {
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
		
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		logger.debug("[After]" + component + type + "." + methodName + "()");
		
		return obj;
	}
	
}
