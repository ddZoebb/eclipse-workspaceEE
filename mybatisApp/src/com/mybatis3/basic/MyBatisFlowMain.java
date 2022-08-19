package com.mybatis3.basic;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class MyBatisFlowMain {

	public static void main(String[] args) throws Exception{
		/*
		 * 0. mybatis-config.xml --> InputStream
		 */
		InputStream myBatisConfigInputStream = Resources.getResourceAsStream("mybatis-config.xml");
		/*
		 * 1. SqlSessionFactoryBuilder
		 */
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
		/*
		 * 2. SqlSessionFactory
		 */
		SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(myBatisConfigInputStream);
		/*
		 * 3. SqlSession open(Connection)
		 */
		SqlSession sqlSession= sqlSessionFactory.openSession();
		/*
		 * autocommit true
		 */
		/*
		 * 4. SqlSession사용(CRUD)
		 */
		System.out.println(sqlSession);
		//sqlSession.select(null, null);
		/*
		 * 5. SqlSession close
		 */
		sqlSession.close();
		
	}
}













