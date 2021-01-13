package com.fjg.daoImpl;

import java.util.List;

import com.fjg.dao.UserDao;
import com.fjg.pojo.User;
import com.fjg.utils.UpdateUtil;
import com.fjg.utils.queryUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean QueryUsername(String username) {
		// ×¢²á
		String sql = "select id,username,nickname,password,email,phone from f_user where username = ?";
		List<User> list = queryUtil.getInstance(User.class, sql, username);
		if(list.size()>0) {
			return false;
		}else {
			return true;
		}
		
	}

	@Override
	public int InsertUsers(User user) {
		// ²åÈë
		String sql = "insert into f_user(id,username,nickname,password,email,phone)values(f_user_seq.nextval,?,?,?,?,?)";
		int update = UpdateUtil.update(sql, user.getUsername(),user.getNickname(),user.getPassword(),user.getEmail(),user.getPhone());
		return update;
	}

	@Override
	public List<User> QueryUsernameAndPwd(User user) {
		// µÇÂ¼
		String sql = "select id,username,nickname,password,email,phone from f_user where username = ? and password = ?";
		List<User> list = queryUtil.getInstance(User.class, sql, user.getUsername(),user.getPassword());
		return list;
		
	}

}
