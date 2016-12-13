package com.directory.base;

import com.directory.event.BaseEvent;
import com.sanworks.event.common.IEvent;
import com.sanworks.event.eventmanager.IEventManager;
import com.sanworks.event.exception.EventException;


public class BaseAPIImpl implements IBaseAPI {

	private IEventManager eventManager;

	
	public <T> T getEvent(Class<T> clazz) { 

		T event = null;
		
		try {
			Object eventInstance = clazz.newInstance();

			if (eventInstance instanceof BaseEvent) {
				BaseEvent baseEvent = (BaseEvent)eventInstance;
			}

			event = (T) eventInstance;
			
		} catch (InstantiationException e) {
			throw new RuntimeException("Unable to instantiate event object", e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("Unable to instantiate event object", e);
		}
		
		return event;
	}
	
	protected BaseEvent processEvent(BaseEvent event) throws Exception { 
		try {
			getEventManager().processEvent((IEvent) event);
		} catch (Exception e) {		
			throw new Exception(e);	
		}
		
		return event;
	}
	
	public IEventManager getEventManager() {
		return eventManager;
	}

	public void setEventManager(IEventManager eventManager) {
		this.eventManager = eventManager;
	}
		
}
