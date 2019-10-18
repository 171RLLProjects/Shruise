package com.mphasis.ship.configuration;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectHelper {
	private static final Logger logger=Logger.getLogger(AspectHelper.class);
	
	@Pointcut("execution(* com.mphasis.training.*.*.*(..))")
	public void getAll() {}
	
	@Before("getAll()")
	public void beforeMethod(JoinPoint jp) {
		logger.debug("Before the Method " + jp.getSignature().getName());
		logger.debug(Arrays.toString(jp.getArgs()));
	}
	
	@After("getAll()")
	public void afterMethod(JoinPoint jp) {
		logger.debug("After the Method " + jp.getSignature().getName());
		logger.debug(Arrays.toString(jp.getArgs()));
	}
	
	@AfterThrowing(pointcut="execution(* com.mphasis.training.*.*.*(..))")
	public void afterThrowingMethod(JoinPoint jp) {
		logger.debug("After Throwing the Method " + jp.getSignature().getName());
		logger.debug(Arrays.toString(jp.getArgs()));
	}
}