package com.directory.dao;

import com.directory.base.IBaseAPI;
import com.directory.dao.entity.RegisterUserDaoEntity;
import com.directory.user.AppUser;
import com.directory.user.SecurityConfig;
import com.directory.user.User;
import com.sanworks.common.exception.RegistrationException;

public interface RegistrationDAO extends IBaseAPI {

	/**
	 * This Api is used to Store USER who has access to the Application(who has username and password).
	 *
	 * @param appUser
	 * @return
	 * @throws Exception
	 */
	public boolean saveAppUser(AppUser appUser) throws Exception;

	/**
	 * This API is ised to store the user information, who doesnot have access to the application.
	 * @param appUser
	 * @return
	 * @throws Exception
	 */

	public boolean saveUser(User user) throws Exception;


	public boolean changePassword(int appUserId) throws Exception;

	public boolean getSecurityConfiguration(SecurityConfig securityConfig, int appUserId) throws Exception;

	public boolean isAppUserPresent(int appUserId) throws Exception;


	public boolean registerNewUser(RegisterUserDaoEntity registerUserDaoEntity) throws RegistrationException;





}
