/*
 * Class: EventFaultCodes
 *
 * Comments for Developers Only:
 *
 * Version History:
 * 
 * Ver  Date         Who                Release     What and Why
 * ---  ----------   ----------         -------     ---------------------------------------
 * 1.0  25/11/2009   ElayaRaja S		 1.0		Initial version
 * 
 * This software is the confidential and proprietary information of Jamcracker, Inc. 
 * ("Confidential Information").  You shall not disclose such Confidential Information
 *  and shall use it only in accordance with the terms of the license agreement you 
 *  entered into with Jamcracker, Inc. Copyright (c) 2000 Jamcracker, Inc.  All Rights    
 *  Reserved
 *
 *
 * 
 ******************************************************/
package com.sanworks.event.exception;

import com.sanworks.common.exception.FaultCode;

/**
 * A class used for EventFaultCodes
 * 
 */
public class EventFaultCodes extends FaultCode {

	private static final long serialVersionUID = -4119861979164882832L;

	protected EventFaultCodes(String faultCode) {
		super(faultCode);
	}
	
	public static final EventFaultCodes EVENT_FAULT_CODE = new EventFaultCodes("12COEF0001");

}
