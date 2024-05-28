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

public class DeptDao {
	String driver="org.h2.Driver";
	String url="jdbc:h2:tcp://localhost/~/test";
	String user="sa";
	String password="";
	
	public List<?> findAll() throws ClassNotFoundException, SQLException{
		List<Map<String,String>> list=new ArrayList<>();
		String sql="select * from dept order by deptno";
		Class.forName(driver);
		try(
				Connection conn=DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt=conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				){
			while(rs.next()) {
				Map<String,String> map=new HashMap<>();
				map.put("deptno", rs.getString("deptno"));
				map.put("dname", rs.getString("dname"));
				map.put("loc", rs.getString("loc"));
				list.add(map);
			}
		}
		
		return list;
	}

}
