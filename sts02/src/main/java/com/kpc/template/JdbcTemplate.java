package com.kpc.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class JdbcTemplate<T> {
DataSource dataSource;

	public JdbcTemplate() {
	}
	
	public JdbcTemplate(DataSource dataSource) {
		this.dataSource=dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void close(Connection conn, PreparedStatement pstmt,ResultSet rs) throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
	
	public int update(String sql, Object... objs) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++)
				pstmt.setObject(i+1, objs[i]);
			return pstmt.executeUpdate();
		}finally {
			close(conn,pstmt,null);
		}
	}
	
	public List<T> query(String sql,RowMapper<T> mapper,Object... objs) throws SQLException {
		List<T> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++)
				pstmt.setObject(i+1, objs[i]);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(mapper.row(rs));
			}
		}finally {
			close(conn,pstmt,rs);
		}
		
		return list;
	}
	public T queryForObject(String sql,RowMapper<T> mapper,Object... objs) throws SQLException {
		return query(sql,mapper,objs).get(0);
	}
}
