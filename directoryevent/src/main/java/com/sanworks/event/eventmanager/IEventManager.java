package com.sanworks.event.eventmanager;

import java.util.Map;





import com.sanworks.event.common.IEvent;
import com.sanworks.event.exception.EventException;
import com.sanworks.event.processor.IEventProcessor;


public interface IEventManager {
	
	public void processEvent(IEvent event) throws EventException;

	public void setEventProcessorMap(Map<String,IEventProcessor> eventProcessorMap);
	
	public Map getEventProcessorMap();
	
	/**
	 * Method a register new event post initilization of the Event Manager.
	 * @param eventProcessorKey
	 * @param eventProcessor
	 */
	void registerEventProcessor(String eventProcessorKey, IEventProcessor eventProcessor);
	
	/**
	 * Method a register new events post initilization of the Event Manager.
	 * @param eventProcessorKey
	 * @param eventProcessor
	 */
	void registerEventProcessors(Map<String, IEventProcessor> eventProcessorMap);
}
