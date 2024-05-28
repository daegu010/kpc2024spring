package com.kpc.dept.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;

import com.kpc.template.JdbcTemplate;
import com.kpc.template.RowMapper;

public class DeptDao {
//	DataSource dataSource;
	JdbcTemplate<DeptVo> template=new JdbcTemplate<DeptVo>();
	RowMapper<DeptVo> mapper=new RowMapper<DeptVo>() {
		
		@Override
		public DeptVo row(ResultSet rs) throws SQLException {
			DeptVo bean=new DeptVo();
			bean.setDeptno(rs.getInt("deptno"));
			bean.setDname(rs.getString("dname"));
			bean.setLoc(rs.getString("loc"));
			return bean;
		}
	};
	
	public DeptDao() {
		JdbcDataSource dataSource=new JdbcDataSource();
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUser("sa");
		dataSource.setPassword("");
		template.setDataSource(dataSource);
	}
	
	public List<DeptVo> findAll() throws ClassNotFoundException, SQLException{
		String sql="select * from dept order by deptno desc";
		return template.query(sql,mapper);
	}
	
	public int delete(int deptno) throws SQLException {
		String sql="delete from dept where deptno=?";
		return template.update(sql,deptno);
	}

	public void save(String dname, String loc) throws SQLException, ClassNotFoundException {
		String sql="insert into dept (dname,loc) values (?,?)";
		template.update(sql,dname,loc);
	}

	public DeptVo find(int deptno) throws ClassNotFoundException, SQLException {
		String sql="select * from dept where deptno=?";
		return template.queryForObject(sql,mapper, deptno);
	}

}













