package com.payment.report.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.payment.report.dao.UserDao;
import com.payment.report.dao.UserDaoImpl;
import com.payment.report.model.User;

//import com.payment.report.dao.UserDao;
//import com.payment.report.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	
	private UserDao userDao = new UserDaoImpl();
	
	public List<User> findAllUser() {
		List<User> users = userDao.findAll();
		//ResponseEntity response = new ResponseEntity<>(users, HttpStatus.OK);
		//response.
		
		return users;
	}
	
	
	public User findUserById(String Id) {
		
		User user = userDao.findUserById(Id);
		
		//ResponseEntity response = new ResponseEntity<>(users, HttpStatus.OK);
		//response.
		
		return user;
	}
	
	public User createUser(User user) {
		
		User newUser = null;		
		newUser = userDao.save(user);
				
		//ResponseEntity response = new ResponseEntity<>(newUser, HttpStatus.CREATED);
		//response.
		
		return newUser;
	}

}
