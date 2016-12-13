package com.sanworks.event.handler;

/**
 * @author Pullarao.N
 *
 */

public interface AuditableEvent {
	
	/**
	 * returns entity type
	 * @return
	 */
	String getEntityType();
	/**
	 * return entity id
	 * @return
	 */
	String getEntityId();
	/**
	 * returns parent entity name
	 * @return
	 */
	String getEntityName();
	
	String getTaskName();
	
	String getTaskType();
	
	String getSubEntityName();
	
	String getSubEntityId();
	
	String getSubTaskName();
	
}
