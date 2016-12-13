package com.directory.filter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SecurityFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Im in init method in Filter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("do Filter Start");

/*		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		httpServletRequest.getRequestURI();

		List<String> listOfGuestURLs = new ArrayList<String>();
		listOfGuestURLs.add("home.htm");
*/	//boolean isLoggedInUser =httpServletRequest.getSession().getAttribute("LOGGED_IN_USER") ==null ? false :(boolean) httpServletRequest.getSession().getAttribute("LOGGED_IN_USER");
		//if(isLoggedInUser){
			chain.doFilter(request,response);
			}
	//System.out.println("do Filter End");

	@Override
	public void destroy() {
		System.out.println("do Filter Destroy ");

	}

}
