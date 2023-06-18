package com.aashish22bansal.developer.learning.springboot;

import com.aashish22bansal.developer.learning.springboot.entities.Product;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootRestTemplateApplicationTests {

	/**
	 * We are going to retrieve a single product using REST Template from Spring.
	 */
	@Test
	public void testGetProduct() {
		// Creating a REST Template Object
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject("http://localhost:8080/productapi/products/1", Product.class);
		assertNotNull(product);
		assertEquals("iPhone", product.getName());
	}
}