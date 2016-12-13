package com.directory.api.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.directory.entity.RegistrationInfoData;
import org.springframework.stereotype.Service;

import com.directory.api.RegistrationService;
import com.directory.base.BaseAPIImpl;
import com.directory.dao.RegistrationDAO;
import com.directory.processor.base.RegistrationProcessor;
import com.directory.registration.event.RegistrationEvent;
import com.directory.springconfigloader.SpringConfigLoader;
import com.directory.user.AppUser;
import com.directory.user.SecurityConfig;
import com.sanworks.event.handler.IEventHandler;


@Service
public class RegistrationServiceImpl extends BaseAPIImpl  implements RegistrationService {

/*	@Autowired
	private RegistrationDAO registrationDAO;*/



	@Override
	public boolean registerUser(AppUser appUser) throws Exception {

		RegistrationEvent registrationEvent = getEvent(RegistrationEvent.class);

		registrationEvent.setAppuser(appUser);

		RegistrationDAO registrationDAO = (RegistrationDAO)SpringConfigLoader.getBean("registrationDAO");

		boolean success = registrationDAO.saveAppUser(appUser);
		return success;
	}

	@Override
	public AppUser getUserInfo(int appuserId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUserActive(int appuserId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<AppUser> getAllUsers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean resetPassword(int appuserId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeSecurityQuestion(SecurityConfig securityConfig,
			int appuserId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewUser(RegistrationInfoData registrationInfoData)
			throws Exception {

		Map<String,Object> registrationMap = new HashMap<String, Object>();


		try{
		registrationMap.put("registrationEvent", registrationInfoData);
		RegistrationProcessor registrationProcessor = (RegistrationProcessor)SpringConfigLoader.getBean("registrationProcessor");


		List listofProcessors = registrationProcessor.getHandlersList();

		Iterator listofProcessorsIterator = listofProcessors.iterator();

		while(listofProcessorsIterator.hasNext()){

			Object o = listofProcessorsIterator.next();

			if(o instanceof IEventHandler){

			((IEventHandler) o).processHandler(registrationInfoData);

			}

		}
		}catch(Exception e){
			throw e;
		}




		return true;



	}




}
