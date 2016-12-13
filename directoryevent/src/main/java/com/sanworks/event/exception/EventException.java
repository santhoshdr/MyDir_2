package com.sanworks.event.exception;

import com.sanworks.common.exception.BaseException;
import com.sanworks.common.exception.FaultCode;


public class EventException extends BaseException {
	
	/**
	 * @param FaultCode and exception.
	 */
	public EventException(FaultCode code, Throwable exception){
	    super(code, exception);
	    }    

	/**
	 * @param FaultCode
	 */
	public EventException(FaultCode errorCode){
		super(errorCode);		
	}
	
	/**
	 * Default constructor
	 */
	public EventException() {
	}
}
