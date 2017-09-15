package com.kk.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kk.spring.dao.UserDao;

public class TestMain {

	//private static final Log logger = LogFactory.getLog(TestMain.class);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//         ApplicationContext ac=new ClassPathXmlApplicationContext("classpath*:ac.xml");
//         UserDao userdao=ac.getBean("userDao",UserDao.class);
//         System.out.println(userdao.getUserById(1));
		final Log logger = LogFactory.getLog(TestMain.class);
		logger.warn(" logger");
		logger.error("~~info~~");

		
	}

}
