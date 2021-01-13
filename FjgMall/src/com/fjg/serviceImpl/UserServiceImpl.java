package com.fjg.serviceImpl;

import java.util.List;

import com.fjg.dao.UserDao;
import com.fjg.daoImpl.UserDaoImpl;
import com.fjg.pojo.User;
import com.fjg.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao dao = new UserDaoImpl();
	@Override
	public boolean regist(String username) {
		// ×¢²á
		boolean queryUsername = dao.QueryUsername(username);
		return queryUsername;
	}

	@Override
	public int registSuccess(User user) {
		// ²åÈë
		int insertUsers = dao.InsertUsers(user);
		return insertUsers;
	}

	@Override
	public User login(User user) {
		// µÇÂ¼
		List<User> list = dao.QueryUsernameAndPwd(user);
		return list.get(0);
	}

}
