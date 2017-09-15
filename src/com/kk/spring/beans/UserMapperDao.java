package com.kk.spring.beans;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public interface UserMapperDao {
	public List<User> getAllUser();
	public void insertUser(User user);
	public void deleteUser(Integer id);
	public User getUserBean(User user);
	public User getUserBeanById(Integer id);
	public void updateUser(User user);
	public List<User> getAllUserExId(Integer id);
}
