package com.sanworks.event.processor;

import java.util.Map;

import com.sanworks.event.common.IEvent;
import com.sanworks.event.exception.EventException;

public interface IEventProcessor {


	/**
	 * @param handlersList the handlersList to set
	 */
	//public void setHandlersList(List handlersList) ;

	public void processEvent(Map<String,Object> map) throws EventException;

	public void processEvent(IEvent event) throws EventException;



}
