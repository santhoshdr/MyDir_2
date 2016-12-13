package com.directory.user;

import java.util.HashMap;

public class SecurityConfig {

	private HashMap<String,String> securityQuestionAnswer = new HashMap<String,String>();

	public HashMap<String,String> getSecurityQuestionAnswer() {
		return securityQuestionAnswer;
	}

	public void setSecurityQuestionAnswer(HashMap<String,String> securityQuestionAnswer) {
		this.securityQuestionAnswer = securityQuestionAnswer;
	}
	
	
}
