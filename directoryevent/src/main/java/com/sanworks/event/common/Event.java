/*
 * 
 * Class: Event.java
 *
 * Comments for Developers Only:
 *
 * Version History:
 * 
 * Ver  Date          Who                Release     What and Why
 * ---  ----------    ----------         -------     ---------------------------------------

 *      06-AUG-2010   Hareendranath		 1.0		 Added Member Variable startTime
 * 
 * This software is the confidential and proprietary information of Jamcracker, Inc. 
 * ("Confidential Information").  You shall not disclose such Confidential Information
 *  and shall use it only in accordance with the terms of the license agreement you 
 *  entered into with Jamcracker, Inc. Copyright (c) 2000 Jamcracker, Inc.  All Rights    
 *  Reserved
 *
 *
 * 
 *****************************************************
 */

package com.sanworks.event.common;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;


public abstract class Event implements Serializable, IEvent {
	
	private static final long serialVersionUID = -8240686729584168914L;

	// Event name
	private String eventName;

	// Event Id
	private String eventId;

	// If an event triggers another event, then parent event instance id will be there
	private String parentEventId;

	//Response map info
	private Map<String, Object> responseMap;

	private String createdBy;
	private String status;
	private String description;
	private String eventSource;	
	
	private String eventInstanceID; 
	private Timestamp startTime;
	private Timestamp endTime;
	

	private String userAccessInfo;
	
	public String getUserAccessInfo() {
		return userAccessInfo;
	}

	public void setUserAccessInfo(String userAccessInfo) {
		this.userAccessInfo = userAccessInfo;
	}

	public Event() {
		responseMap = new HashMap<String, Object>();
	}
	
	public void putInResponse(String key, Object value) {
		responseMap.put(key, value);
	}
	
	public Object getFromResponse(String key) {
		return (responseMap.get(key));
	}

	/* (non-Javadoc)
	 * @see com.jamcracker.event.dataobjects.IEvent#getEventId()
	 */
	public String getEventId() {
		return eventId;
	}

	/* (non-Javadoc)
	 * @see com.jamcracker.event.dataobjects.IEvent#setEventId(java.lang.String)
	 */
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	
	/* (non-Javadoc)
	 * @see com.jamcracker.event.dataobjects.IEvent#getParentEventId()
	 */
	public String getParentEventId() {
		return parentEventId;
	}

	/* (non-Javadoc)
	 * @see com.jamcracker.event.dataobjects.IEvent#setParentEventId(java.lang.String)
	 */
	public void setParentEventId(String parentEventId) {
		this.parentEventId = parentEventId;
	}

	/* (non-Javadoc)
	 * @see com.jamcracker.event.dataobjects.IEvent#getEventName()
	 */
	public String getEventName() {
		return eventName;
	}

	/* (non-Javadoc)
	 * @see com.jamcracker.event.dataobjects.IEvent#setEventName(java.lang.String)
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEventSource() {
		return eventSource;
	}

	public void setEventSource(String eventSource) {
		this.eventSource = eventSource;
	}

	public String getEventInstanceID() {
		return eventInstanceID;
	}

	public void setEventInstanceID(String eventInstanceID) {
		this.eventInstanceID = eventInstanceID;
	}

	/**
	 * @return the startTime
	 */
	public Timestamp getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public Timestamp getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
}
