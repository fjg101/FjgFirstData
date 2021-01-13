package com.fjg.service;

import com.fjg.pojo.User;

public interface UserService {
	//注册，验证用户是否已存在
	public boolean regist(String username);
	//插入，
	public int registSuccess(User user);
	//登录
	public User login(User user);
}
