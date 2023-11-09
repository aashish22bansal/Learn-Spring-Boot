/**
 * 
 */
package com.aashish22bansal.springweb.healthchecks;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import com.aashish22bansal.springweb.repos.ProductRepository;

/**
 * @author aashish
 *
 */
@Component
public class CustomInfoIndicator implements InfoContributor {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void contribute(Builder builder) {
		Map<String, Integer> productDetails = new HashMap<>();
		productDetails.put("test1", 1);
		productDetails.put("test2", 2);      
	    builder.withDetail("products", productDetails );

	}

}
