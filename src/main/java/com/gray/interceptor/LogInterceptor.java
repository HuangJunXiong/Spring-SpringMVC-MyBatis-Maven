package com.gray.interceptor;

import com.gray.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogInterceptor {
	private final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
//	@Before(value = "execution(* com.gray.user.controller.*.*(..))")
//	public void before(){
//		logger.info("login start!");
//	}
//	@After(value = "execution(* com.gray.user.controller.*.*(..))")
//	public void after(){
//		logger.info("login end!");
//	}
    @Pointcut("@annotation(com.gray.annotation.Log)")
    public void controllerAspect() {
    	
    }
    @Before("controllerAspect()")
    public void before(JoinPoint joinPoint){
		logger.info(getOper(joinPoint));
	}
	private String getOper(JoinPoint joinPoint) {
		MethodSignature methodName = (MethodSignature)joinPoint.getSignature();
		Method method = methodName.getMethod();
		return method.getAnnotation(Log.class).oper();
	}
	
}
