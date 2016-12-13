package com.directory.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginSecurityFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		httpServletRequest.getRequestURI();

		boolean isLoggedInUser =httpServletRequest.getSession().getAttribute("LOGGED_IN_USER") ==null ? false :(boolean) httpServletRequest.getSession().getAttribute("LOGGED_IN_USER");
		//if(isLoggedInUser){
			chain.doFilter(request,response);
		//}else{
			System.out.println("User is not logged in ...  Need to redirect to home page");


			//String newURI = httpServletRequest.getContextPath()+"/home.htm" ;
		//	request.getRequestDispatcher("/home.htm").forward(request, response);
			//request.getRe
			//request.getRequestDispatcher(newURI).forward(req, res);
		//}


		System.out.println("Into Logged in security filter");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
