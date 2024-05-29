package com.kpc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class DeptDaoImpl extends JdbcDaoSupport implements DeptDao<DeptVo> {
	PlatformTransactionManager transactionManager;
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
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
//		return getJdbcTemplate().query(sql, rowMapper);
		PreparedStatementCreator psc=null;
		List<DeptVo> result=null;
		
		TransactionDefinition definition=new DefaultTransactionDefinition();
		TransactionStatus status=transactionManager.getTransaction(definition) ;
		try {
			psc=new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					System.out.println(conn.hashCode());
					return conn.prepareStatement(sql);
				}
			};
			getJdbcTemplate().query(psc, rowMapper);
			psc=new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					System.out.println(conn.hashCode());
					return conn.prepareStatement(sql);
				}
			};
			result= getJdbcTemplate().query(psc, rowMapper);
			transactionManager.commit(status);
		}catch (Exception e) {
			transactionManager.rollback(status);
		}
		return result;
		
	}

	@Override
	public DeptVo selectOne(int pk) throws SQLException {
		String sql="select * from dept where deptno=?";
		return getJdbcTemplate().queryForObject(sql, rowMapper,pk);
	}

	@Override
	public void editInsert(DeptVo t) throws SQLException {
		
//		TransactionDefinition definition=new DefaultTransactionDefinition();
//		TransactionStatus status=transactionManager.getTransaction(definition) ;
//		try {
			String sql="insert into dept (dname,loc) values (?,?)";
			getJdbcTemplate().update(sql,t.getDname(),t.getLoc());
//			sql="insert into dept (dname,loc) values (?,?)";
//			getJdbcTemplate().update(sql,t.getDname(),t.getLoc());
//			transactionManager.commit(status);
//		}catch (Exception e) {
//			transactionManager.rollback(status);
//		}
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







