package com.aashish22bansal.developer.Thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aashish22bansal.developer.Thymeleaf.model.Student;

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
	
	@RequestMapping("/sendData")
	public ModelAndView sendData() {
		// Create a new ModalAndView Object
		ModelAndView mav = new ModelAndView("data"); // Pass the template as a Parameter
		
		mav.addObject("message", "Thymeleaf Demo"); // Format mav.addObject("ATTRIBUTE", "VALUE_ASSIGNED_TO_ATTRIBUTE")
		
		return mav;
	}
	
	@RequestMapping("/student")
	public ModelAndView getStudent() {
		// Create a new ModalAndView Object
		ModelAndView mav = new ModelAndView("student"); // Pass the template as a Parameter
		
		// Creating a Student Object
		Student student = new Student();
		
		// Assigning values
		student.setName("Student A");
		student.setScore(100);
		
		// Passing the Student() Object to the View.
		mav.addObject("student", student);
		
		// Returning mav
		return mav;
	}
}
