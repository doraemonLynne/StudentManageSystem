package com.chf.entity;

/**
 * 用户表
 * @author shuai
 *
 */
public class User 
{
	//无意义，自增长id，主键
	private Integer id;
	//用户名
	private String userName;
	//密码
	private String password;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password="
				+ password + "]";
	}
	
}
