package com.ziyan.dao;


import com.ziyan.domain.User;

public interface UserDao {

	User selectUser(long id);

}