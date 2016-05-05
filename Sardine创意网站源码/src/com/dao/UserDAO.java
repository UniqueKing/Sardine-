package com.dao;

import com.entity.UserObject;


public interface UserDAO {
	UserObject selectUser(String username, String password);
	UserObject isUser(String username);
	String insertUser(String username, String password,String phone);
}
