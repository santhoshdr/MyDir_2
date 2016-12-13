package com.directory.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class User {

	@RequestMapping(value="{name}", method=RequestMethod.GET, produces="application/json")
	public List getUser(@PathVariable String username){
		ArrayList<Object> userList = new ArrayList<Object>();
		userList.add("Santhosh");

		return userList;
	}

}
