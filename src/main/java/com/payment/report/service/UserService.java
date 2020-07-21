package com.payment.report.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.payment.report.model.User;

//import com.payment.report.model.User;

public interface UserService {
	
	public List<User> findAllUser();
	public User createUser(User user);
	public User findUserById(String Id);

}
