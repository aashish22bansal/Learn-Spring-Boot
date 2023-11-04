package com.aashish22bansal.developer.SpringBootRESTLogging.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aashish22bansal.developer.SpringBootRESTLogging.entities.Product;
import com.aashish22bansal.developer.SpringBootRESTLogging.repos.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductRestController {

	@Autowired
	ProductRepository repository;

	/**
	 * Creating a Logger to log the data as INFO, DEBUG or ERROR.
	 * The class name provided in this is the same class in which we are creating the Logger,
	 * i.e., ProductRestController. This will provide us with a unique Logger instance.
	 * This will print the message on the console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);

	@RequestMapping(value = "/products/", method = RequestMethod.GET)
	public List<Product> getProducts() {
		LOGGER.info("Finding all the Products.");
		return repository.findAll();
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id) {
		LOGGER.info("Finding product by ID: "+id);
		return repository.findById(id).get();
	}

	@RequestMapping(value = "/products/", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return repository.save(product);
	}

	@RequestMapping(value = "/products/", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		return repository.save(product);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int id) {
		repository.deleteById(id);
	}

}
