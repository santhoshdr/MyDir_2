package com.sanworks.event.eventmanager;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sanworks.common.exception.BaseException;
import com.sanworks.common.exception.BaseRunTimeException;
import com.sanworks.event.common.IEvent;
import com.sanworks.event.exception.EventException;
import com.sanworks.event.exception.EventFaultCodes;
import com.sanworks.event.processor.IEventProcessor;

public class EventManagerImpl implements IEventManager {
	private static final Logger LOG = Logger.getLogger(EventManagerImpl.class.getName());
	private Map<String, IEventProcessor> eventProcessorMap;


	@SuppressWarnings("hiding")
	public void processEvent(IEvent event)throws EventException {

		String eventname = null;
		IEventProcessor eventprocessor = null;

		try{
			/**
			 * Validate user input
			 */
			if (event == null || event.getEventName() == null) {
				throw new IllegalArgumentException("Invalid event name");
			}

			eventname=event.getEventName();

			/**
			 * Check for the event processor associated with event.
			 */
			if (eventProcessorMap == null ||
					eventProcessorMap.get(eventname) == null) {
				LOG.error("Could not locate event processor for the given event: "+eventname);
				throw new BaseRunTimeException(EventFaultCodes.EVENT_FAULT_CODE);
			}

			eventprocessor=eventProcessorMap.get(eventname);
			eventprocessor.processEvent(event);

		} catch(EventException e) {
			LOG.error("Error in processEvent:", e);
			throw e;
		} catch(BaseException e) { //we may not reach this block
			LOG.error("Error in processEvent:", e);
			throw new EventException(e.getFaultCode(), e);
		}
	}

	public void setEventProcessorMap(Map<String, IEventProcessor> eventProcessorMap) {
		if(this.eventProcessorMap == null)
			this.eventProcessorMap = new HashMap<String, IEventProcessor>();
		this.eventProcessorMap.putAll(eventProcessorMap);
	}

	public Map<String, IEventProcessor> getEventProcessorMap() {
		return eventProcessorMap;
	}

	/**
	 * Method a register new event post initilization of the Event Manager.
	 * @param eventProcessorKey
	 * @param eventProcessor
	 */
	public void registerEventProcessor(String eventProcessorKey, IEventProcessor eventProcessor){
		if(this.eventProcessorMap == null)
			this.eventProcessorMap = new HashMap<String, IEventProcessor>();
		eventProcessorMap.put(eventProcessorKey, eventProcessor);
	}

	/**
	 * Method a register new events post initilization of the Event Manager.
	 * @param eventProcessorKey
	 * @param eventProcessor
	 */
	public void registerEventProcessors(Map<String, IEventProcessor> eventProcessorMap){
		if(this.eventProcessorMap == null)
			this.eventProcessorMap = new HashMap<String, IEventProcessor>();
		this.eventProcessorMap.putAll(eventProcessorMap);
	}

}
