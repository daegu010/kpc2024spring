package com.kpc.sts04.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DeptDaoImpl implements DeptDao<DeptVo> {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private RowMapper<DeptVo> rowMapper=new RowMapper<DeptVo>() {
		
		@Override
		public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			log.debug(String.valueOf(rowNum));
			return new DeptVo(rs.getInt(1),rs.getString(2),rs.getString(3));
		}
	};

	@Override
	public List<DeptVo> selectAll() {
		String sql="select * from dept order by deptno desc";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public DeptVo select(int pk) {
		String sql="select * from dept where deptno=?";
		return jdbcTemplate.queryForObject(sql, rowMapper,pk);
	}

	@Override
	public void insertOne(DeptVo t) {
		String sql="insert into dept (dname,loc) values (?,?)";
		jdbcTemplate.update(sql,t.getDname(),t.getLoc());
	}

	@Override
	public int updateOne(DeptVo t) {
		String sql="update dept set dname=?,loc=? where deptno=?";
		return jdbcTemplate.update(sql,t.getDname(),t.getLoc(),t.getDeptno());
	}

	@Override
	public int deleteOne(int pk) {
		String sql="delete from dept where deptno=?";
		return jdbcTemplate.update(sql,pk);
	}

}
