package com.kpc.dept.model;

import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class DeptDao {

	RowMapper<DeptVo> mapper=new RowMapper<DeptVo>() {
		
		@Override
		public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			DeptVo bean=new DeptVo();
			bean.setDeptno(rs.getInt("deptno"));
			bean.setDname(rs.getString("dname"));
			bean.setLoc(rs.getString("loc"));
			return bean;
		}
	};
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<DeptVo> findAll() throws SQLException{
		String sql="select * from dept order by deptno desc";
		return template.query(sql,mapper);
	}
	
	public int delete(int deptno) throws SQLException {
		String sql="delete from dept where deptno=?";
		return template.update(sql,deptno);
	}

	public void save(String dname, String loc) throws SQLException{
		String sql="insert into dept (dname,loc) values (?,?)";
		template.update(sql,dname,loc);
	}

	public DeptVo find(int deptno) throws SQLException {
		String sql="select * from dept where deptno=?";
		return template.queryForObject(sql,mapper, deptno);
	}

}













