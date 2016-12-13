package org.directory.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.directory.entity.RegistrationInfoData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.directory.user.AppUser;

@Controller
public class MemberService  extends BaseController{



	/**
	 * Gets the registration form to add new family member
	 * @param appUser
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
/*	@RequestMapping(value = { "/addFamilyMember.htm"}, method = RequestMethod.GET)
	public String addFamilyMember(@ModelAttribute("registrationInfoData") RegistrationInfoData registrationInfoData, Model model) throws Exception{

		try {
			model.addAttribute("registration","registration");
			System.out.println("Get User Details." );
		} catch (Exception e) {
				throw e;
		}

		return "addMember";
	}
*/



}
