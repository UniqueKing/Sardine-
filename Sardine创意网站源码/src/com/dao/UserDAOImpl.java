package com.dao;

import java.sql.*;

import com.entity.UserObject;
import com.util.DBTool;

public class UserDAOImpl implements UserDAO {
	public UserDAOImpl(){
		
	}
	@Override
	public UserObject selectUser(String username, String password) {
		UserObject u = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DBTool.getConnection().createStatement();
			String sql = "select password, username from users where username='" + username + "' and password='" + password +"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				String ps = rs.getString(1);
				String name = rs.getString(2);
				u = new UserObject(name, ps);				
			}										
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();				
			} catch (SQLException e) {				
				e.printStackTrace();
			}			
		}
		return u;		
	}
	@Override
	public UserObject isUser(String username) {
		UserObject u = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DBTool.getConnection().createStatement();
			String sql = "select id, username,password from users where username='" + username + "'";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				String name = rs.getString(2);
				String password = rs.getString(3);
				u = new UserObject(username,password);				
			}										
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();				
			} catch (SQLException e) {				
				e.printStackTrace();
			}			
		}
		return u;		
	}
	@Override
	public String insertUser(String username, String password,String phone) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int id=0;//保存生成的ID 
		try {
			String sql = "insert into users (username, password, phone) values (?,?,?)";
			stmt = DBTool.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, phone);
			stmt.execute();	
			rs = stmt.getGeneratedKeys();
			if(rs != null&&rs.next()) {  
				id=rs.getInt(1);  
			}  
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {				
				if(stmt != null)
					stmt.close();				
			} catch (SQLException e) {				
				e.printStackTrace();
			}			
		}
		return id+"";
	}

}
