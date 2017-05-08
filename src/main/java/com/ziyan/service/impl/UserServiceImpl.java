package com.ziyan.service.impl;

import com.ziyan.dao.UserDao;
import com.ziyan.domain.User;
import com.ziyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User selectUser(long userId) {
		return this.userDao.selectUser(userId);
	}

}