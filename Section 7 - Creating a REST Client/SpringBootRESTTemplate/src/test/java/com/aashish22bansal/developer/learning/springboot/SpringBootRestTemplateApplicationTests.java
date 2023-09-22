package com.aashish22bansal.developer.learning.springboot;

import com.aashish22bansal.developer.learning.springboot.entities.Product;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRestTemplateApplicationTests {

	@Autowired(required=true)
	private Product product;

	/**
	 * We are going to retrieve a single product using REST Template from Spring. We will invoke
	 * the Endpoint using Postman and use the URL in the RestTemplate Object and the type of object
	 * that will be coming back to us. This will do the deserialization of it.
	 */
	@Test
	public void testGetProduct() {
		// Creating a REST Template Object
		RestTemplate restTemplate = new RestTemplate();
		// Setting Expectation
		product = restTemplate.getForObject("http://localhost:8080/productapi/products/1", Product.class);
		// Performing Assertions
		assertNotNull(product);
		assertEquals("iPhone", product.getName());
	}

	/**
	 * Using HTTP POST Method
	 * URL: POST URL
	 * Request: It consists of the new Product that we want to create.
	 * Response Type: It is what we are expecting.
	 */
	@Test
	public void testCreateProduct(){
		RestTemplate restTemplate = new RestTemplate();
//		Product product = new Product();
		product.setName("Oneplus Mobile");
		product.setDescription("Smartphone");
		product.setPrice(60000);
		Product newProduct = restTemplate.postForObject("http://localhost:8080/productapi/products/", product, Product.class);
		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("Oneplus Mobile", newProduct.getName());
	}

	@Test
	public void testUpdateProduct() {
		// Creating a REST Template Object
		RestTemplate restTemplate = new RestTemplate();
		// Setting Expectation
		product = restTemplate.getForObject("http://localhost:8080/productapi/products/1", Product.class);
		// Performing Update
		product.setPrice(75000);
		// Sending Updated content
		restTemplate.put("http://localhost:8080/productapi/products/", product);
		// Performing Assertions
		assertNotNull(product);
		assertEquals("iPhone", product.getName());
	}
}