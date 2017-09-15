package com.kk.spring.aop;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.kk.spring.beans.User;

@Aspect
@Component
public class MyLoginAspect {

	
	private  final static Logger logger= Logger.getLogger(MyLoginAspect.class);
		@Pointcut("execution(public * com.kk.spring.controller.LoginController.*(..))")
	public void logincontroller() {
		
	}
	
	@Before(value="logincontroller()")
	public void beforeLoginc(JoinPoint jp) 
	{	
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
        HttpSession session = request.getSession();
        //请求的IP    
        String ip = request.getRemoteAddr(); 
        logger.info("客户机IP地址为："+ip+"访问服务器"+jp.getSignature().getName()+"方法。");
		logger.info("*********开始执行***进入"+jp.getSignature().getName()+"方法****************************");
		
	}
	
	@After(value="logincontroller()")
	public void afterLoginc(JoinPoint jp)
	{
		//System.out.println("*********执行结束***走出"+jp.getSignature().getName()+"方法****************************");
		logger.info("*********执行结束***走出"+jp.getSignature().getName()+"方法****************************");
	}
}
