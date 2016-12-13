/*
 * Class: BaseException
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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;

/**
 * A class used for BaseException
 *
 */
public class BaseException extends Exception {

	private static final long serialVersionUID = 7303294259057377618L;


    protected FaultCode faultCode;
	protected String shortMessage = "";
	protected String occurence;
	protected String detailedMessage = null;


    /**
     * @param FaultCode
     * @param Throwable
     */
    public BaseException(FaultCode code, Throwable exception)
	{
	    super(code.toString(), exception);
	    this.faultCode = code;
	    shortMessage = CommonExceptionHandler.getErrorMessage(faultCode.toString());
	}

	/**
	 * @param FaultCode
	 */
	public BaseException(FaultCode errorCode)
	{
		super(errorCode.toString());
		this.faultCode = errorCode;
	}

	/**
	 * Default constructor
	 */
	public BaseException() {
		this(CommonFaultCodes.FAULTCODE_NOT_FOUND);
	}

	public BaseException(String string) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return JCFaultCode
	 */
	public FaultCode getFaultCode() {
		return faultCode;
	}

	/**
	 * @return String
	 */
	public String getOccurence() {
		return occurence;
	}

	/**
	 * @param occurence as String
	 */
	public void setOccurence(String occurence) {
		this.occurence = occurence;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	public String toString(){
		return (faultCode == null ? super.getMessage() : (faultCode.toString() + " : " + shortMessage));
	}


	/*
	 * Overriding super class method to return error description
	 * (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage(){
		if(detailedMessage  == null)
				{
					detailedMessage = CommonExceptionHandler.getDetailedErrorMessage(faultCode.toString());
					if(faultCode instanceof DynamicFaultCode)
					{
					      DynamicFaultCode dfc = (DynamicFaultCode)faultCode;
					      Object[] messageArguments = dfc.getArguments().toArray();
					      MessageFormat formatter = new MessageFormat(detailedMessage);
					      detailedMessage = formatter.format(messageArguments);
					}
				}
		return detailedMessage;
	}

	/**
	 * @param exception as Throwable
	 * @return String
	 */
	public String getStackTrace(Throwable exception){
	    StringWriter sw=new  StringWriter();
	    PrintWriter pw=new PrintWriter(sw);
		exception.printStackTrace(pw);
		return sw.toString();
	}


}
