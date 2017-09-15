package com.kk.utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbSqlSession {
	
	public static SqlSessionFactory sqlSessionFactory=null;
	
	static {
		try {
			String resouse="mybatis-config.xml";
			InputStream inputStream=Resources.getResourceAsStream(resouse);
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream,"mysql");
			
			}catch(Exception e) {
						e.printStackTrace();
     	}finally {
     		
     	}
	}
	
	public static SqlSessionFactory getFactory() {
		return sqlSessionFactory;
	}

	

}
