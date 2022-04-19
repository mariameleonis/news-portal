package com.epam.newsportal.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Component
@Aspect
public class ApplicationLoggingAspect {
	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.epam.newsportal.rest.NewsRestController.*(..))")
	private void forRestControllerPackage() {}
	
	@Pointcut("execution(* com.epam.newsportal.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.epam.newsportal.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forRestControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		String theMethod = theJoinPoint.getSignature().toShortString();
		StringBuilder stringArgList = new StringBuilder();
        Object[] args = theJoinPoint.getArgs();
        for (Object tempArg: args) {
            stringArgList.append(" ").append(tempArg);
        }
		LOGGER.info("======>> in @Before: calling method: " + theMethod + " arguments : " + stringArgList);
	}
	
	@After("forAppFlow()")
	public void after(JoinPoint theJoinPoint) {
		
		String theMethod = theJoinPoint.getSignature().toShortString();
		LOGGER.info("======>> in @After: method executed: " + theMethod);
	}
	
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
    private void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
        String theMethod = theJoinPoint.getSignature().toShortString();
        String shortResult = theResult == null ? "null" : theResult.getClass().getName();
        LOGGER.info("======>> in @AfterReturning: from method: " + theMethod + " result: " + shortResult);
    }
	
	@AfterThrowing(pointcut = "forAppFlow()", throwing = "error")
    private void afterThrowing(JoinPoint joinPoint, Throwable error) {
        String theMethod = joinPoint.getSignature().toShortString();
        LOGGER.error("======>> in @AfterThrowing: from method: " + theMethod + " error: " + error);
    }

}
