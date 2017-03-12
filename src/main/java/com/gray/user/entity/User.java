package com.gray.user.entity;

import java.io.Serializable;

public class User implements Serializable {
	private String username; // 用户名
	private String password; // 密码
	private int age; // 年龄
	private String name; // 姓名
	private String role; // 角色字段
	private String email; // 邮箱
	private String phone; // 手机
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
 	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
}
