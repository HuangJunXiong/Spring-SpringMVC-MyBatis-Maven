package com.gray.user.service.impl;

import java.util.List;

import com.gray.user.dao.BaseDao;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gray.user.dao.UserDao;
import com.gray.user.entity.User;
import com.gray.user.service.UserService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Service
@EnableTransactionManagement
public class UserServiceImpl extends BaseSeviceImpl implements UserService {
	@Autowired
	private UserDao<User> userdao;

	public User doUserLogin(User user) {
		List<User> list = userdao.selectId(user.getUsername());
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
		List<User> list = userdao.selectId(username);
		if (!CollectionUtils.isEmpty(list)){
			return list.get(0);
		} else {
			return null;
		}
	}

	public List<User> queryAll() {
		return userdao.queryAll();
	}

	@Override
	@Transactional
	public void insertUser(User user) {
		String insertSql = "INSERT INTO user(username, password, age, name, role, email, phone) "+
				"VALUE('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getAge()+
				"','"+user.getName()+"','"+user.getRole()+"','"+user.getEmail()+"','"+user.getPhone()+"');";
		super.insert(insertSql);
	}

	@Override
	public User findByEmail(String email) {
		List<User> list = userdao.selectEmail(email);
		if (!CollectionUtils.isEmpty(list)){
			return list.get(0);
		} else {
			return null;
		}
	}


}
