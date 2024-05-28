package com.kpc.dept.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.h2.command.Prepared;
import org.h2.jdbcx.JdbcDataSource;

import com.kpc.template.JdbcTemplate2;

public class DeptDao {
	DataSource dataSource;
	String driver="org.h2.Driver";
	String url="jdbc:h2:tcp://localhost/~/test";
	String user="sa";
	String password="";
	
	public DeptDao() {
		JdbcDataSource dataSource=new JdbcDataSource();
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUser("sa");
		dataSource.setPassword("");
		this.dataSource=dataSource;
	}
	
	public void close(Connection conn, PreparedStatement pstmt,ResultSet rs) throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
	
	public List<?> findAll() throws ClassNotFoundException, SQLException{
		List<DeptVo> list=new ArrayList<>();
		String sql="select * from dept order by deptno desc";
		Class.forName(driver);
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DriverManager.getConnection(url, user, password);
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				DeptVo bean=new DeptVo();
				bean.setDeptno(rs.getInt("deptno"));
				bean.setDname(rs.getString("dname"));
				bean.setLoc(rs.getString("loc"));
				list.add(bean);
			}
		}finally {
			close(conn,pstmt,rs);
		}
		
		return list;
	}
	
	public int delete(int deptno) throws SQLException {
		String sql="delete from dept where deptno=?";
		JdbcTemplate2 template=new JdbcTemplate2(dataSource);;
		return template.update(sql,new Object[]{deptno});
	}

	public void save(String dname, String loc) throws SQLException, ClassNotFoundException {
		String sql="insert into dept (dname,loc) values (?,?)";
		JdbcTemplate2 template = new JdbcTemplate2(dataSource);
		template.update(sql,new Object[] {dname,loc});
	}

	public DeptVo find(int deptno) throws ClassNotFoundException, SQLException {
		String sql="select * from dept where deptno=?";
		DeptVo bean=new DeptVo();
		Class.forName(driver);
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DriverManager.getConnection(url, user, password);
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bean.setDeptno(deptno);
				bean.setDname(rs.getString("dname"));
				bean.setLoc(rs.getString("loc"));
			}
		}finally {
			close(conn,pstmt,rs);
		}
		return bean;
	}

}













