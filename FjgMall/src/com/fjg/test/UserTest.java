package com.fjg.test;

import org.junit.Test;

import com.fjg.dao.UserDao;
import com.fjg.daoImpl.UserDaoImpl;
import com.fjg.pojo.User;
import com.fjg.service.UserService;
import com.fjg.serviceImpl.UserServiceImpl;

public class UserTest {

	//×¢²á
	@Test
	public void test01() {
		UserDao dao = new UserDaoImpl();
		boolean queryUsername = dao.QueryUsername("admin");
		System.out.println(queryUsername);
	}
	//µÇÂ¼
	@Test
	public void test02() {
		UserDao dao = new UserDaoImpl();
//		boolean queryUsernameAndPwd = dao.QueryUsernameAndPwd(new User("admin","admin"));
//		System.out.println(queryUsernameAndPwd);
	}
	//µÇÂ¼
	@Test
	public void test04() {
		UserService service = new UserServiceImpl();
//		boolean login = service.login(new User("wff123","123456"));
//		System.out.println(login);
	}
	//²åÈë
	@Test
	public void test03() {
		UserDao dao = new UserDaoImpl();
		int insertUsers = dao.InsertUsers(new User("wff123", "Íõö­ö­", "123456", "964641079@qq.com", "13052676296"));
		System.out.println(insertUsers);
	}
}
