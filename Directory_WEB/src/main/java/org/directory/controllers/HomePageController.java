package org.directory.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomePageController {


	//@Autowired
//	private CourseService courseService;
//
	@Autowired
//	private AboutUsService aboutUsService;

	//@Autowired
//	private TestimonialService testimonialService ;

	@RequestMapping("guest/home.htm")
	public String home(HttpSession session){

	//	ServletContext application=session.getServletContext();
	//	application.setAttribute("courses",courseService.getAll(false));
	//	application.setAttribute("aboutUs", aboutUsService.get("aboutUs123"));
		//application.setAttribute("goodTestimonials",testimonialService.getGoodTestimonials());
		return "baseLayout";
	}
	 @RequestMapping(value = "/user", method = RequestMethod.GET)
	    public String getLoginHome(ModelMap map) {
System.out.println("Hello Worlf i M,, ");

		 return "loginHomePageBody";
	    }





}
