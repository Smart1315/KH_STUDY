package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		
		try {
			InputStream inputStream = Resources.getResourceAsStream("/mybatis-config.xml");
//			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
//			SqlSessionFactory ssf = ssfb.build(inputStream);
//			session = ssf.openSession(false); // AutoCommit false
			
			session = new SqlSessionFactoryBuilder().build(inputStream).openSession(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session;
	}
}
