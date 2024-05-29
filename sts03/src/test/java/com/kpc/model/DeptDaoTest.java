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
	
	@Test
	public void testSelectOne() throws SQLException{
		DeptVo target=new DeptVo(6, "김길동", "서울");
		assertEquals(target, dao.selectOne(target.getDeptno()));
	}
	
	@Test
	public void testEditInsert() throws SQLException{
		int before=dao.selectAll().size();
		DeptVo target=new DeptVo(0, "test1", "서울");
		dao.editInsert(target);
		int after=dao.selectAll().size();
		assertSame(before+1, after);
	}

}

















