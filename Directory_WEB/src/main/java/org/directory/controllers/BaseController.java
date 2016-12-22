package org.directory.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import com.directory.springconfigloader.SpringConfigLoader;

@Controller
public class BaseController {

public BaseController() {
	// TODO Auto-generated constructor stub
}

public ApplicationContext configLoader = (ApplicationContext) SpringConfigLoader.getContext();

}
