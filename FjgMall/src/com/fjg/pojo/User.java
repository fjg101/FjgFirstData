package com.fjg.pojo;

import java.math.BigDecimal;

public class User {
	//用户javabean
	private BigDecimal id;			//用户id
	private String username;		//用户名
	private String nickname;		//用户昵称
	private String password;		//用户密码
	private String email;			//邮箱
	private String phone;			//手机号
	
	//get 、set
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	//构造方法
	public User(BigDecimal id, String username, String nickname, String password, String email, String phone) {
		super();
		this.id = id;
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	//无id
	public User(String username, String nickname, String password, String email, String phone) {
		super();
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	//用户名+密码，构造	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	//空构造
	public User() {
		super();
	}
	//toString
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", nickname=" + nickname + ", password=" + password
				+ ", email=" + email + ", phone=" + phone + "]";
	}
	
}
