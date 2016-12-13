package com.directory.api;

import java.util.ArrayList;

import org.directory.entity.RegistrationInfoData;

import com.directory.user.AppUser;
import com.directory.user.SecurityConfig;

public interface RegistrationService {


	public boolean registerUser(AppUser appuser) throws Exception;

	public AppUser getUserInfo(int appuserId) throws Exception;

	public boolean isUserActive(int appuserId) throws Exception;

	public ArrayList<AppUser> getAllUsers() throws Exception;

	public boolean resetPassword(int appuserId) throws Exception;

	public boolean changeSecurityQuestion(SecurityConfig securityConfig,int appuserId);


	public boolean registerNewUser(RegistrationInfoData registrationInfoData) throws Exception;

}
