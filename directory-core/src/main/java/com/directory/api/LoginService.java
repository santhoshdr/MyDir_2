package com.directory.api;

import com.directory.user.AppUser;
import com.directory.user.User;

public interface LoginService  {

	public User loginUser(AppUser appuser) throws Exception;


}
