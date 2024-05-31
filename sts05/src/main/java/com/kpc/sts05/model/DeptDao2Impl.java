package com.kpc.sts05.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository
public class DeptDao2Impl implements DeptDao{
	@Autowired
	SqlSession sqlsession;

	@Override
	public List<DeptVo> selectRows() {
		return sqlsession.selectList("com.kpc.sts05.model.DeptDao.selectRows");
	}

	@Override
	public DeptVo selectRow(int deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOne(DeptVo bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int updateOne(DeptVo bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int deptno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
