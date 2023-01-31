package com.ict.edu2;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBService2 {

	

	static private SqlSessionFactory factory;
	static String resource = "com/ict/edu2/config.xml";

	
	static {
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static SqlSessionFactory getFactory() {
		return factory;
	}

}
