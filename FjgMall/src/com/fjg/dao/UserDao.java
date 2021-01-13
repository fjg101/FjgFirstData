package com.fjg.dao;

import java.util.List;

import com.fjg.pojo.User;

public interface UserDao {
	//注册，验证用户是否已存在
	public boolean QueryUsername(String username);
	//插入，
	public int InsertUsers(User user);
	//登录
	public List<User> QueryUsernameAndPwd(User user);
}
