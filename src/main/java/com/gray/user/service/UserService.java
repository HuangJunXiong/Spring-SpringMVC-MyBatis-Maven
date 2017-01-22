package com.gray.user.service;

import java.util.List;

import com.gray.user.entity.User;

public interface UserService {
	User doUserLogin(User user);
	public User findByUserName(String username);
	List<User> queryAll();
}
