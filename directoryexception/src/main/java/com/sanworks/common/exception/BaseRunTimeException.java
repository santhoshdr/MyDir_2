/*
 * Class: BaseRunTimeException
 *
 * Comments for Developers Only:
 *
 * Version History:
 * 
 * Ver  Date         Who                Release     What and Why
 * ---  ----------   ----------         -------     ---------------------------------------
 * 1.0  10/07/2012   Ravi M		 1.0		JCException Framework
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
 * BaseException for runtime exception
 * 
 */
public class BaseRunTimeException extends RuntimeException {
	
	private static final long serialVersionUID = -1963571621903584633L;	

	private static org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(BaseRunTimeException.class.getName());
    
	protected FaultCode faultCode;
	protected String shortMessage = "";
	protected String occurence;
	protected String detailedMessage = null;

    
    /**
     * @param FaultCode
     * @param Throwable
     */
    public BaseRunTimeException(FaultCode code, Throwable exception)
	{
	    super(code.toString(), exception);
	    this.faultCode = code;
	    shortMessage = CommonExceptionHandler.getErrorMessage(faultCode.toString());
	}    

	/**
	 * @param FaultCode
	 */
	public BaseRunTimeException(FaultCode errorCode)
	{
		super(errorCode.toString());
		this.faultCode = errorCode;
	}
	
	/**
	 * Default constructor
	 */
	public BaseRunTimeException() {
		this(CommonFaultCodes.FAULTCODE_NOT_FOUND);
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
					if (LOG.isDebugEnabled()){
						LOG.debug("Message inside getMessage(): "+ detailedMessage);
						LOG.debug("FaultCode class:" + faultCode.getClass());						
					}
					if(faultCode instanceof DynamicFaultCode)
					{
					      DynamicFaultCode dfc = (DynamicFaultCode)faultCode;
					      Object[] messageArguments = dfc.getArguments().toArray();
					      MessageFormat formatter = new MessageFormat(detailedMessage);
					      detailedMessage = formatter.format(messageArguments);
					      if (LOG.isDebugEnabled()){
					    	  LOG.debug("Dyna message: "+ detailedMessage);
					      }					    	  
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
