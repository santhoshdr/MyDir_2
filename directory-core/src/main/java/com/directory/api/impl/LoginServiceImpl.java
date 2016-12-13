package com.directory.api.impl;

import java.util.Iterator;
import java.util.List;

import com.directory.api.LoginService;
import com.directory.base.BaseAPIImpl;
import com.directory.processor.base.LoginProcessor;
import com.directory.springconfigloader.SpringConfigLoader;
import com.directory.user.AppUser;
import com.directory.user.User;
import com.sanworks.common.exception.FaultCode;
import com.sanworks.common.exception.LoginException;
import com.sanworks.event.exception.EventException;
import com.sanworks.event.handler.IEventHandler;

public class LoginServiceImpl  extends BaseAPIImpl implements LoginService {

	@Override
	public User loginUser(AppUser appuser) throws LoginException {


		LoginProcessor loginProcessor = (LoginProcessor)SpringConfigLoader.getBean("loginProcessor");

		List listofProcessors = loginProcessor.getHandlersList();

		Iterator listofProcessorsIterator = listofProcessors.iterator();

		while(listofProcessorsIterator.hasNext()){

			Object o = listofProcessorsIterator.next();

			if(o instanceof IEventHandler){

			try {
				((IEventHandler) o).processHandler(appuser);
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				throw e;
			} catch(Exception ex){
				throw new LoginException(new FaultCode("122222"));
			}

			}

		}

		return appuser;
	}

}
