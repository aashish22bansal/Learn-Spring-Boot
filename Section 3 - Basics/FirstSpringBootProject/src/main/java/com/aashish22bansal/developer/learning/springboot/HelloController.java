package com.aashish22bansal.developer.learning.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	/** 
	 * To make this a REST End-Point, we will mark it with the @RestController Annotation.
	 * 
	 * This method will host a single message thorugh the hello() method.
	 */
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello Spring Boot";
		/** 
		 * We will map this method to a URI using the @RequestMapping Annotation and within the
		 * parenthesis, we will mention the URI to which we want to map this method to, for example,
		 * in this "/hello".
		 */
	}
}
