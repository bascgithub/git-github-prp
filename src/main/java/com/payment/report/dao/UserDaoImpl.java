package com.payment.report.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.payment.report.model.User;


public class UserDaoImpl implements UserDao{
	
	//static int id =0;
	Map userStore = new HashMap();
	
	public List<User> findAll() {
		List<User> users= new ArrayList();
		for(int i=0 ; i<userStore.size();i++) {
			users.add((User)userStore.get(i));
		}
		
		return users;
	}
	public User findUserById(String Id){
		
		User user = (User) userStore.get(Id);
		return user;
	}
	
	public User save(User user) {
		
		userStore.put(user.getId() , user);
		return user;
	}

}
