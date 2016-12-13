/*
 * Class: JCDynamicFaultCode
 *
 * Comments for Developers Only:
 *
 * Version History:
 * 
 * Ver  Date         Who                Release     What and Why
 * ---  ----------   ----------         -------     ---------------------------------------
 * 1.0  03/11/2009   ElayaRaja S		 1.0		JCException Framework
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

package com.sanworks.common.exception;

import java.util.ArrayList;

/**
 * A class used for JCDynamicFaultCode
 * 
 */
public class DynamicFaultCode extends FaultCode {

	private static final long serialVersionUID = -6436145321573641596L;
	private FaultCode faultCode;
	private ArrayList arguments;	

  	/**
  	 * @param faultCode as JCFaultCode
  	 * @param args as ArrayList
  	 */
  	public DynamicFaultCode(FaultCode faultCode, ArrayList args)
  	{
		super(faultCode.toString());
		this.faultCode = faultCode;
		arguments = args;
	}

	/**
	 * @return JCFaultCode
	 */
	public FaultCode getFaultCode() {
		return faultCode;
	}

	/**
	 * @param faultCode as JCFaultCode
	 */
	public void setFaultCode(FaultCode faultCode) {
		if (faultCode != null)
			this.faultCode = faultCode;
	}

	/**
	 * @return ArrayList
	 */
	public ArrayList getArguments() {
		return arguments;
	}

	/**
	 * @param arguments as ArrayList
	 */
	public void setArguments(ArrayList arguments) {
		if(arguments != null)
			this.arguments = null;
	}

}
