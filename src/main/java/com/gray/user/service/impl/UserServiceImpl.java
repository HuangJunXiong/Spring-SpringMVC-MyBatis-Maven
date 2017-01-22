package com.gray.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gray.user.dao.UserDao;
import com.gray.user.entity.User;
import com.gray.user.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao<User> dao;
	
	public User doUserLogin(User user) {
		List<User> list = dao.selectId(user.getUsername());
		if(list.size() == 0){
			return null;
		}else{
			if(user.getPassword().equals(list.get(0).getPassword())){				
				return list.get(0);			
			}else{
				return null;
			}
		}
	}

	public User findByUserName(String username) {
		return dao.selectId(username).get(0);
	}

	public List<User> queryAll() {
		return dao.queryAll();
	}
	
	
}
