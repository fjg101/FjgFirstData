package com.fjg.dao;

import java.util.List;

import com.fjg.pojo.User;

public interface UserDao {
	//ע�ᣬ��֤�û��Ƿ��Ѵ���
	public boolean QueryUsername(String username);
	//���룬
	public int InsertUsers(User user);
	//��¼
	public List<User> QueryUsernameAndPwd(User user);
}
