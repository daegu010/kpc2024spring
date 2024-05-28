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

import org.h2.command.Prepared;

public class DeptDao {
	String driver="org.h2.Driver";
	String url="jdbc:h2:tcp://localhost/~/test";
	String user="sa";
	String password="";
	
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
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		
		return list;
	}

	public void save(String dname, String loc) throws SQLException, ClassNotFoundException {
		String sql="insert into dept (dname,loc) values (?,?)";
		Class.forName(driver);
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DriverManager.getConnection(url, user, password);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.executeUpdate();
		}finally {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
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
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return bean;
	}

}













