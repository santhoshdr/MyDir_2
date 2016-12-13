package com.directory.handler;

import com.directory.dao.AppUserDAO;
import com.directory.event.Event;
import com.directory.springconfigloader.SpringConfigLoader;
import com.directory.user.AppUser;
import com.sanworks.event.exception.EventException;
import com.sanworks.event.handler.IEventHandler;

public class LoginUserHandler  implements IEventHandler{

	@Override
	public void processHandler(Event event) throws Exception {

		try{

		if(event instanceof AppUser){
			doLoginUser((AppUser)event);
			System.out.println("Hiiii");
		}
	}catch(Exception e){

		throw e;
	}
	}
	private void doLoginUser(AppUser appUser) throws Exception {


		AppUserDAO appUserDAO = (AppUserDAO)SpringConfigLoader.getBean("appUserDAO");
		try {
			appUserDAO.valudateLoginUser(appUser);
		} catch (Exception e) {
			throw e;
		}

	}



}
