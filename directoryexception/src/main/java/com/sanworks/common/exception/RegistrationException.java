package com.sanworks.common.exception;


public class RegistrationException  extends BaseException{


	  /**
	 *
	 */
	private static final long serialVersionUID = -7820852379947465329L;

	public RegistrationException (FaultCode faultCode, Throwable throwable) {
		    super(faultCode, throwable);
	  	}

		public RegistrationException(FaultCode errorCode)
		{
			super(errorCode);
			this.faultCode = errorCode;
		}

		public RegistrationException(String errorMessage)
		{

			System.out.println("Error Message" + errorMessage);	}

}
