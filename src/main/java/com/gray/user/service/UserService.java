package com.gray.user.service;

import java.util.List;

import com.gray.user.entity.User;

public interface UserService extends BaseSevice{
	public User doUserLogin(User user);
	public User findByUserName(String username);
	public List<User> queryAll();
	public void insertUser(User user);
	public User findByEmail(String email);
}
