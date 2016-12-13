package com.sanworks.common.exception;

public class LoginException  extends BaseException{


	  /**
	 *
	 */
	private static final long serialVersionUID = -7820852379947465329L;

	public LoginException (FaultCode faultCode, Throwable throwable) {
		    super(faultCode, throwable);
	  	}

		public LoginException(FaultCode errorCode)
		{
			super(errorCode);
			this.faultCode = errorCode;
		}

		public LoginException(String errorMessage)
		{

			System.out.println("Error Message" + errorMessage);	}

}
