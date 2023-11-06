package com.aashish22bansal.developer.Thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Aashish Bansal
 * The @Controller annotation will make this class as a MVC Controller.
 * 
 * The method demoMethod() return a simple Template name. This is actually a .html file
 * but it is not necessary for us to give the .html suffix at the end of the template name.
 * THis is the name with which we will create the HTML File.
 */
@Controller
public class ThymeleafDemoController {
	
	@RequestMapping("/demo")
	public String demoMethod() {
		return "index";
	}
}
