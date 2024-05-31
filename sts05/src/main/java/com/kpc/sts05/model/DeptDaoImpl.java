package com.kpc.sts05.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
public class DeptDaoImpl implements DeptDao{
	final JdbcTemplate jdbcTemplate;
	
	public DeptDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	private RowMapper<DeptVo> rowMapper=new RowMapper<DeptVo>() {

		@Override
		public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return DeptVo.builder()
					.deptno(rs.getInt("deptno"))
					.dname(rs.getString("dname"))
					.loc(rs.getString("loc"))
					.build();
		}
	};
	
	@Override
	public List<DeptVo> selectRows(){
		String sql="select * from dept";
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public DeptVo selectRow(int deptno) {
		String sql="select * from dept where deptno=?";
		return jdbcTemplate.queryForObject(sql, rowMapper,deptno);
	}
	
	@Override
	public void insertOne(DeptVo bean) {
		String sql="insert into dept (dname,loc) values (?,?)";
		jdbcTemplate.update(sql,bean.getDname(),bean.getLoc());
	}
	
	@Override
	public int updateOne(DeptVo bean) {
		String sql="update dept set dname=?,loc=? where deptno=?";
		return jdbcTemplate.update(sql,bean.getDname(),bean.getLoc(),bean.getDeptno());
	}
	
	@Override
	public int deleteOne(int deptno) {
		String sql="delete from dept where deptno=?";
		return jdbcTemplate.update(sql,deptno);
	}
}










