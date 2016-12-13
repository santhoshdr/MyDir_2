package com.directory.dao;

import java.util.List;

import com.directory.user.AppUser;
import com.directory.user.User;

public interface AppUserDAO {

	public List<AppUser> getAllAppUsers() throws Exception;

	//Appuserobject without UserObject in it
	public AppUser getAppUserById(int appuserId) throws Exception;

	// Appuser objectwith User object in it
	public AppUser AppUserWithHisUsers(int appuserId) throws Exception;

	public User getUser(int userId) throws Exception;

	public List<User>getAllUsersForAppUser(int appuserId) throws Exception;


	public AppUser valudateLoginUser(AppUser appUser) throws Exception;

}
