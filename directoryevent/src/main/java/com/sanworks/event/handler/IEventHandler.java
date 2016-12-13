package com.sanworks.event.handler;

import com.directory.event.Event;
import com.sanworks.event.exception.EventException;

public interface IEventHandler {

	public void processHandler(Event event) throws EventException, Exception;

}
