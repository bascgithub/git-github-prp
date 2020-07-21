package com.payment.report.dao;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.payment.report.model.User;

//import com.payment.report.model.User;

//@Repository
//@Component("userDao")
//public interface UserDao extends CrudRepository<User, Long >{
public interface UserDao{
	
	public List<User> findAll();
	public User findUserById(String userId);
	
	public User save(User user);
}
