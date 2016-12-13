package org.directory.controllers;

import java.util.Map;

import org.directory.entity.RequestInfoData;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller

public class RequestInfoController {
	
	
	
	

	
	@RequestMapping(value = "/",method=RequestMethod.POST)
	public String requestInfoPost(@ModelAttribute("requestInfo") RequestInfoData requestInfoData,
						BindingResult result,
						SessionStatus  sessionStatus,RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()){
			return "requestInfo";
		}	
		
		redirectAttributes.addAttribute("name",requestInfoData.getName());
		redirectAttributes.addAttribute("email",requestInfoData.getEmail());
		
		redirectAttributes.addFlashAttribute("requestInfoData", requestInfoData);
			
		
		return "redirect:requestInfoSuccessRedirect";
	}
	
	@RequestMapping("requestInfoSuccessRedirect")
	public String requestInfoSuccessRedirect(){
	
		return  "requestInfoSuccess";
	}

}
