package com.directory.handler;

import com.directory.event.Event;
import com.sanworks.event.exception.EventException;
import com.sanworks.event.handler.IEventHandler;

public class SendSMSHandler implements IEventHandler {

	@Override
	public void processHandler(Event event) throws EventException {


		System.out.println("Here is the code to send SMS... ");

	}

}
