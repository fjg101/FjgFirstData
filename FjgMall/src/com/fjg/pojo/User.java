package com.fjg.pojo;

import java.math.BigDecimal;

public class User {
	//�û�javabean
	private BigDecimal id;			//�û�id
	private String username;		//�û���
	private String nickname;		//�û��ǳ�
	private String password;		//�û�����
	private String email;			//����
	private String phone;			//�ֻ���
	
	//get ��set
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
	//���췽��
	public User(BigDecimal id, String username, String nickname, String password, String email, String phone) {
		super();
		this.id = id;
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	//��id
	public User(String username, String nickname, String password, String email, String phone) {
		super();
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	//�û���+���룬����	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	//�չ���
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
