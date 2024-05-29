package com.kpc.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeptDaoTest {
	static ApplicationContext ac;
	DeptDao<DeptVo> dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Before
	public void setUp() throws Exception {
		dao=ac.getBean(DeptDao.class);
	}

	@Test
	public void testSelectAll() throws SQLException{
		for(DeptVo bean : dao.selectAll()) {
			System.out.println(bean);
		}
	}

}

















