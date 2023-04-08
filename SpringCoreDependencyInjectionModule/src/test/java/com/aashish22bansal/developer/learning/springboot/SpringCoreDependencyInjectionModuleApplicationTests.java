package com.aashish22bansal.developer.learning.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aashish22bansal.developer.learning.springboot.services.PaymentService;
import com.aashish22bansal.developer.learning.springboot.services.PaymentServicesImpl;

/**
 * @author Aashish Bansal
 * 
 * We need to add a static import for the JUnit Assertion.
 */
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringCoreDependencyInjectionModuleApplicationTests {
	
	/**
	 * We will inject the PaymentService into this class and it will be wired with @Autowired
	 * Annotation.
	 */
	@Autowired
	PaymentService paymentService;
	
	/**
	 * We will inject the PaymentServicesImpl into this class and it will be wired with @Autowired
	 * Annotation.
	 */
	@Autowired
	PaymentServicesImpl paymentServicesImpl;

	/**
	 * @author Aashish Bansal
	 * 
	 * Within the method testDependencyInjection(), we will test if the Payment Service is being
	 * instantiated as expected and all the dependencies that the Payment Service require are
	 * being wired by Spring.
	 */
	@Test
	void testDependencyInjection() {
		// Asserting the Dependencies
		assertNotNull(paymentService); // If this passes, then all of them have been wired properly.
		
		assertNotNull(paymentServicesImpl.getDao()); // If true, then DAO is being Injected into the Service.
	}

}
