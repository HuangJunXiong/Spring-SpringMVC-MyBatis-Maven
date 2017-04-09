package com.gray.user.dao;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserDao<User> extends BaseDao<User> {
	List<User> selectId(String username);
	List<User> selectEmail(String email);
	List<User> queryAll();
}