package com.gray.user.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gray.user.dao.UserDao;
import com.gray.user.entity.User;
import com.gray.user.service.UserService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Service
@EnableTransactionManagement
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
		List<User> list = dao.selectId(username);
		if (!CollectionUtils.isEmpty(list)){
			return list.get(0);
		} else {
			return null;
		}
	}

	public List<User> queryAll() {
		return dao.queryAll();
	}

	@Override
	@Transactional
	public void insertUser(User user) {
		String insertSql = "INSERT INTO user(username, password, age, name, role, email, phone) "+
				"VALUE('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getAge()+
				"','"+user.getName()+"','"+user.getRole()+"','"+user.getEmail()+"','"+user.getPhone()+"');";
		dao.insert(insertSql);
	}

	@Override
	public User findByEmail(String email) {
		List<User> list = dao.selectEmail(email);
		if (!CollectionUtils.isEmpty(list)){
			return list.get(0);
		} else {
			return null;
		}
	}


}
