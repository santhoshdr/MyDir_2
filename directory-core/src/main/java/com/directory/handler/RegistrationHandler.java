package com.directory.handler;

import java.util.Date;

import org.directory.entity.RegistrationInfoData;

import com.directory.dao.RegistrationDAO;
import com.directory.dao.entity.RegisterUserDaoEntity;
import com.directory.event.Event;
import com.directory.springconfigloader.SpringConfigLoader;
import com.sanworks.event.exception.EventException;
import com.sanworks.event.handler.IEventHandler;

public class RegistrationHandler   implements IEventHandler{


private boolean registerNewUser(RegistrationInfoData registrationInfoData){
	RegisterUserDaoEntity entity = new RegisterUserDaoEntity();

	entity.setAge(registrationInfoData.getAge());
	entity.setName(registrationInfoData.getName());
	entity.setCity(registrationInfoData.getCity());
	entity.setMobile(registrationInfoData.getMobile());
	entity.setCompany(registrationInfoData.getCompany());
	entity.setOccupation(registrationInfoData.getOccupation());
	entity.setAge(registrationInfoData.getAge());
	entity.setDob(registrationInfoData.getDob());
	entity.setFirstName(registrationInfoData.getFirstName());
	entity.setLastName(registrationInfoData.getLastName());
	entity.setEmail(registrationInfoData.getEmail());
	entity.setSex(registrationInfoData.getSex());
	entity.setCreationDate(new Date());
	entity.setUpdatedDate(new Date());
	entity.setCreatedBy("CreatedBY");
	entity.setUpdatedBy("UpdatedBy");

	// need processor concept here

	RegistrationDAO registrationDAO = (RegistrationDAO)SpringConfigLoader.getBean("registrationDAO");

	boolean success = false;
	try {
		success = registrationDAO.registerNewUser(entity);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return success;

}

@Override
public void processHandler(Event event) throws EventException {



	if(event instanceof RegistrationInfoData)
		registerNewUser((RegistrationInfoData)event);
		System.out.println("Hiiii");

}



}
