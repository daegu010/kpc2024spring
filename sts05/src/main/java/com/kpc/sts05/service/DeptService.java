package com.kpc.sts05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kpc.sts05.model.DeptDao;
import com.kpc.sts05.model.DeptVo;

import lombok.RequiredArgsConstructor;

@Service
public class DeptService {
	@Autowired
	DeptDao deptDao;
	
	public List<DeptVo> getList(){
		return deptDao.selectRows();
	}
	
	public DeptVo getOne(int deptno) {
		return deptDao.selectRow(deptno);
	}
	
	@Transactional
	public void addDb(DeptVo bean) {
		deptDao.insertOne(bean);
	}
	@Transactional
	public void updateDb(DeptVo bean) {
		deptDao.updateOne(bean);
	}
	@Transactional
	public void deleteDb(int deptno) {
		deptDao.deleteOne(deptno);
	}
}
















