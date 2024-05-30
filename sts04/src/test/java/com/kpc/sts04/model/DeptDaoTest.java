package com.kpc.sts04.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeptDaoTest {
	static ApplicationContext ctxt;
	private DeptDao<DeptVo> deptDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctxt=new ClassPathXmlApplicationContext("applicationContext.xml");
	}


	@Before
	public void setUp() throws Exception {
		deptDao=ctxt.getBean(DeptDao.class);
	}

	@Test
	public void testSelectAll() {
		if(deptDao.selectAll().size()==0)	fail("더미가 없다고 함");
	}

	@Test
	public void testSelectOne() {
		Object obj=deptDao.select(6).toString();
		log.info(obj.toString());
		assertNotNull(obj);
	}

}






