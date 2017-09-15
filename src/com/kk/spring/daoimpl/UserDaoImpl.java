package com.kk.spring.daoimpl;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kk.spring.beans.User;
import com.kk.spring.beans.UserMapperDao;
import com.kk.spring.dao.UserDao;
import com.kk.utils.DbSqlSession;



@Repository
public class UserDaoImpl   implements UserDao {

	SqlSession session = null;

	
	@Autowired
    private User ruser;

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUser(Integer id) {
		try {
			session = DbSqlSession.getFactory().openSession();
			UserMapperDao umd=session.getMapper(UserMapperDao.class);
			List<User> users = umd.getAllUserExId(id);
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}

	@Override
	public List<User> delOne(Integer id) {
		try {
			session = DbSqlSession.getFactory().openSession();
			UserMapperDao umd=session.getMapper(UserMapperDao.class);
			umd.deleteUser(id);
			session.commit();
			List<User> users = umd.getAllUser();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<User> insertOne(User user) {
		try {
			session = DbSqlSession.getFactory().openSession();
			UserMapperDao umd=session.getMapper(UserMapperDao.class);
			umd.insertUser(user);
			session.commit();
			List<User> users = umd.getAllUser();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Object getUser(User user) {
		try {
			session = DbSqlSession.getFactory().openSession();
			UserMapperDao umd=session.getMapper(UserMapperDao.class);
			ruser = umd.getUserBean(user);
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ruser;
	}

	@Override
	public User getUserById(Integer id) {
		try {
			session=DbSqlSession.getFactory().openSession();
			UserMapperDao umd=session.getMapper(UserMapperDao.class);
			ruser=umd.getUserBeanById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return ruser;
	}

	@Override
	public List<User> updateUser(User user) {
		try {
		session=DbSqlSession.getFactory().openSession();
		UserMapperDao umd=session.getMapper(UserMapperDao.class);
		umd.updateUser(user);
		session.commit();
		List<User> users = umd.getAllUser();
		return users;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}