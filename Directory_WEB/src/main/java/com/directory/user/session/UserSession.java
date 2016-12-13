package com.directory.user.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserSession {

	private HttpServletRequest request;



	public UserSession() {
		super();
	}
	public UserSession(HttpServletRequest request) {
		this.request = request;
	}



	public HttpSession createSession(Object o){
		HttpSession session = null;

		try{

			session = request.getSession(true);
			request.getSession().setAttribute("LOGGED_IN_USER", true);
			session.setAttribute("APP_USER", o);

		}catch(Exception e){

		}
		return session;

	}

}
