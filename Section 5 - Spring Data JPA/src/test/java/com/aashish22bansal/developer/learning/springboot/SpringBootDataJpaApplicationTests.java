package com.aashish22bansal.developer.learning.springboot;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aashish22bansal.developer.learning.springboot.entities.Student;
import com.aashish22bansal.developer.learning.springboot.repositories.StudentRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpringBootDataJpaApplicationTests {
	
	/**
	 * To use the repository inside the Test class, we need to Inject it.
	 * 
	 * We will also need to use @Autowired Annotation so that it gets wired automatically.
	 */
	@Autowired
	private StudentRepository repository;

	@Test
	void testSaveStudent() {
		/**
		 * With the Spring Data JPA, we can directly use all the CRUD methods.
		 */
		Student student = new Student();
		student.setId(1l); // 1l -> 1 Long
		student.setName("Aashish");
		student.setTestScore(97);
		repository.save(student);
		/**
		 * Now, this data will be saved to the database but we can check this using the findById()
		 * method to make sure.
		 * The save() method will save the data to the database (if the data does not exist in it
		 * from before) otherwise it will update the data which is already present in it.
		 */
		Student savedStudent = repository.findById(1l).get();
		/**
		 * Here, findById() method returns an Optional value and get() method will give us the Entity back.
		 * Now, we can use Assert Statement.
		 */
		assertNotNull(savedStudent);
		/**
		 * Now, we are not able to see the repositories which are being created and added by 
		 * hibernate in the backend, so we can go to the application.properties file in the 
		 * src/main/resources directory. In this file, we can add "spring.jpa.show-sql = true"
		 * and this will display the SQL Statements on the Console.
		 */
	}

}
