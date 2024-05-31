package com.kpc.sts05.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DeptDao {

	@Select("select * from dept")
	List<DeptVo> selectRows();

	@Select("select * from dept where deptno=#{val}")
	DeptVo selectRow(int deptno);

	@Insert("insert into dept (dname,loc) values (#{dname},#{loc})")
	void insertOne(DeptVo bean);

	@Update("update dept set dname=#{dname}, loc=#{loc} where deptno=#{deptno}")
	int updateOne(DeptVo bean);
	@Delete("delete from dept where deptno=#{val}")
	int deleteOne(int deptno);

}













