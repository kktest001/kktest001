package com.kk.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kk.spring.beans.User;
import com.kk.spring.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public List<User> getAllUser(Integer id){
		return userDao.getAllUser(id);
	}
	
	public List<User> delOne(Integer id){
		return userDao.delOne(id);
	}
	
	public List<User> insertOne(User user){
		return userDao.insertOne(user);
	}
	public Object getUser(User user) {
		return userDao.getUser(user);
	}
	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}
	public List<User> updateUser(User user){
		return userDao.updateUser(user);
		
	}
} 
