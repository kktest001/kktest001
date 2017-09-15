package com.kk.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kk.spring.beans.User;

@Repository
public interface UserDao {
	public User getUserById(int id);
	public List<User> getAllUser(Integer id);
	public List<User> delOne(Integer id);
	public List<User> insertOne(User user);
	public Object getUser(User user);
	public User getUserById(Integer id);
	public List<User> updateUser(User user);
}
