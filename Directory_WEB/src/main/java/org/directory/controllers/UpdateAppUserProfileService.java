package org.directory.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.directory.user.AppUser;


@Controller
public class UpdateAppUserProfileService extends BaseController {


@RequestMapping(value = { "/myProfile.htm"}, method = RequestMethod.GET)
public String viewMyProfile(@ModelAttribute("appUser") AppUser appUser, Map<String, Object> map,
        HttpServletRequest request) throws Exception{

	try {
		request.getSession().getId();
		System.out.println("Get User Details." + request.getSession().getId());
	} catch (Exception e) {
			throw e;
	}

	return "myProfile";
}

@RequestMapping(value = { "/editMyProfile.htm"}, method = RequestMethod.POST)
public String editMyProfile(@ModelAttribute("appUser") AppUser appUser, Map<String, Object> map,
        HttpServletRequest request) throws Exception{

	try {
		System.out.println("EDIT User Details.");

	} catch (Exception e) {
			throw e;
	}

	return "loginSuccess";
}


}
