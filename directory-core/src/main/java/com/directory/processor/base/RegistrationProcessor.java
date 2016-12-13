package com.directory.processor.base;

import java.util.List;
import java.util.Map;

import com.sanworks.event.common.IEvent;
import com.sanworks.event.exception.EventException;
import com.sanworks.event.processor.IEventProcessor;

public class RegistrationProcessor implements IEventProcessor {

	private List handlersList;




	@Override
	public void processEvent(Map<String, Object> map) throws EventException {
		// TODO Auto-generated method stub

		map.get("registrationEvent");





	}




	public List getHandlersList() {
		return handlersList;
	}




	public void setHandlersList(List handlersList) {
		this.handlersList = handlersList;
	}




	@Override
	public void processEvent(IEvent event) throws EventException {
		// TODO Auto-generated method stub
		
	}


}
