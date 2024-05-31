package com.kpc.sts05.service;

import static org.junit.Assert.*;

import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.kpc.sts05.model.DeptVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class DeptServiceTest {
	@Autowired
	DeptService deptService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void 리스트테스트() {
		deptService.getList().forEach(e->System.out.println(e));
//		assertNotNull(deptService.getList());
	}
	
//	@Transactional
	@Test
	public void 입력테스트() {
		DeptVo target=DeptVo.builder().dname("ex98").loc("테스트").build();
		deptService.addDb(target);
	}
}




















