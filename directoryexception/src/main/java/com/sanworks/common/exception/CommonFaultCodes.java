/*
 * Class: JCCommonFaultCodes
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



/**
 * A class used for JCCommonFaultCodesInfo
 *
 */
public class CommonFaultCodes extends FaultCode {

	private static final long serialVersionUID = -3530134643380395347L;

	/**
  	 * @param faultCode as String
  	 */
  	protected CommonFaultCodes(String faultCode)
  	{
		super(faultCode);
  	}

	public static final CommonFaultCodes FAULTCODE_NOT_FOUND	 = new CommonFaultCodes("11COEX0001");


}
