package com.test;

import com.directory.api.RegistrationService;
import com.directory.springconfigloader.SpringConfigLoader;
import com.directory.user.AppUser;

public class RegisterUser {

	public static void main(String[] args) {

		AppUser appuser = new AppUser();
		
		appuser.setUserFirstName("Santhosh");
		appuser.setUserLastName("Desikulkarni");
		appuser.setAge(30);
		appuser.setLocation("Bangalore");
		appuser.setIsMarried("Yes");
		appuser.setIsalive(true);
		appuser.setRememberme(true);
		appuser.setRole("admin");
		appuser.setUserEmailId("santhoshdesikulkarni@gmail.com");
		appuser.setUserPassword("abc");
		
		
		
		RegistrationService registrationService = (RegistrationService) SpringConfigLoader.getBean("registrationService");
		
		
		try {
			registrationService.registerUser(appuser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Hiii" + registrationService);
		
	}

}
