package com.fjg.service;

import com.fjg.pojo.User;

public interface UserService {
	//ע�ᣬ��֤�û��Ƿ��Ѵ���
	public boolean regist(String username);
	//���룬
	public int registSuccess(User user);
	//��¼
	public User login(User user);
}
