package com.kpc.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class DeptDaoImpl extends JdbcDaoSupport implements DeptDao<DeptVo> {
	RowMapper<DeptVo> rowMapper=new RowMapper<DeptVo>() {

		@Override
		public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new DeptVo(
					rs.getInt("deptno")
					,rs.getString("dname")
					,rs.getString("loc")
					);
		}
	};
	
	@Override
	public List<DeptVo> selectAll() throws SQLException {
		String sql="select * from dept";
		return getJdbcTemplate().query(sql, rowMapper);
	}

	@Override
	public DeptVo selectOne(int pk) throws SQLException {
		String sql="select * from dept where deptno=?";
		return getJdbcTemplate().queryForObject(sql, rowMapper,pk);
	}

	@Override
	public void editInsert(DeptVo t) throws SQLException {
		String sql="insert into dept (dname,loc) values (?,?)";
		getJdbcTemplate().update(sql,t.getDname(),t.getLoc());
	}

	@Override
	public int editUpdate(DeptVo t) throws SQLException {
		return 0;
	}

	@Override
	public int editDelete(int pk) throws SQLException {
		return 0;
	}

}
