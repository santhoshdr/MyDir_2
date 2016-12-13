package org.directory.controllers;

import org.directory.entity.RegistrationInfoData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GetAllmembersController extends BaseController {


	@RequestMapping(value = { "/getAllMembers.htm"}, method = RequestMethod.GET)
	public String getAllMembers(@ModelAttribute("appUser") RegistrationInfoData registrationInfoData, Model model) {






		model.addAttribute("registration","registration");


		return "register";
	}


}
