package com.kpc.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcTemplate2 {
	DataSource dataSource;
	
	public JdbcTemplate2(DataSource dataSource) {
		this.dataSource=dataSource;
	}


	public void close(Connection conn, PreparedStatement pstmt,ResultSet rs) throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
	
	public int update(String sql, Object[] objs) throws SQLException {
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
	
}











