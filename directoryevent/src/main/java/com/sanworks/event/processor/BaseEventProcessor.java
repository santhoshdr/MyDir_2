package com.sanworks.event.processor;


import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sanworks.event.common.IEvent;
import com.sanworks.event.exception.EventException;


public class BaseEventProcessor implements IEventProcessor {
private static final Logger LOG = Logger.getLogger(BaseEventProcessor.class.getName());


private List handlersList;

	/**
	 * @return the handlersList
	 */
	public List getHandlersList() {
		return handlersList;
	}
	



	/**
	 * @param handlersList the handlersList to set
	 */
	public void setHandlersList(List handlersList) {
		this.handlersList = handlersList;
	}
	
	public void processEvent(IEvent event) throws EventException {
		// TODO Auto-generated method stub
		
	}


	public void processEvent(Map<String, Object> map) throws EventException {
		if(handlersList.iterator().hasNext()){
			handlersList.iterator().next();

		}
	}
}
