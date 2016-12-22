package org.directory.controllers;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.directory.entity.RegistrationInfoData;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.directory.api.LoginService;
import com.directory.api.RegistrationService;
import com.directory.user.AppUser;
import com.directory.user.session.UserSession;


@Controller
public class RegistrationController extends BaseController {



	private RegistrationService registrationService;

	private LoginService loginService;



	@RequestMapping(value = { "guest/doLogin.htm"}, method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("appUser") AppUser appUser, Map<String, Object> map,
	        HttpServletRequest request) throws Exception{

		loginService = (LoginService)configLoader.getBean("loginService");

		try {
			AppUser loggedInAppUser = (AppUser) loginService.loginUser(appUser);
			// create object by spring injection ? check
			UserSession userSession = new UserSession(request);
			HttpSession session = userSession.createSession(loggedInAppUser);

			System.out.println("loggedInAppUser" + loggedInAppUser);
		} catch (Exception e) {
				throw e;
		}

		return "return redirect:/login/login.jsp";
	}


	@RequestMapping(value = { "guest/getLogin.htm"}, method = RequestMethod.GET)
	public String getLogin(@ModelAttribute("appUser") AppUser appUser, Map<String, Object> map,
	        HttpServletRequest request) {




		return "register";
	}






	@RequestMapping(value = {"/submitRegistration.htm"}, method = RequestMethod.POST)
	public String submitRegistration(@ModelAttribute("appUser") RegistrationInfoData registrationInfoData, Model model) throws Exception {
	System.out.println("hiii");

	for(int i=0; i<10;i++){

		registrationInfoData.setEmail("emailid");
	registrationInfoData.setDob(new Date());
	registrationInfoData.setOccupation("Occupation");
	registrationInfoData.setCity("location");

	registrationInfoData.setFirstName("FirstName");
	registrationInfoData.setLastName("LastName");

	registrationInfoData.setMarried(true);
	registrationInfoData.setSex("Male");
	registrationService = (RegistrationService)configLoader.getBean("registrationService");

	try {
		registrationService.registerNewUser(registrationInfoData);
	} catch (Exception e) {
		throw e;
	}

	}



		return "registrationSuccess";
	}


	@RequestMapping(value = { "guest/registerUser.htm"}, method = RequestMethod.GET)
	public String registerUser(@ModelAttribute("registrationInfoData") RegistrationInfoData registrationInfoData, Model model) {


		model.addAttribute("registration","registration");


		return "newRegistration";
	}


	public LoginService getLoginService() {
		return loginService;
	}


	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}




}
