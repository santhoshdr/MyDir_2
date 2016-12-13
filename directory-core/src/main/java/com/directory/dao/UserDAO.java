package com.directory.dao;

import com.directory.user.User;

public interface UserDAO {

	//get based on user.userid
	public User getUser(User user) throws Exception;

	//get based on user.userid
	public int getAppuserForUser(User user) throws Exception;


}
