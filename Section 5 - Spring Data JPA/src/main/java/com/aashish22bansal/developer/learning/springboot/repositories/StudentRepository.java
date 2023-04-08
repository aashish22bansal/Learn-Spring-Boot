/**
 * 
 */
package com.aashish22bansal.developer.learning.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashish22bansal.developer.learning.springboot.entities.Student;

/**
 * @author aashi
 *
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
	/**
	 * The JpaRepository is a Generic of <T, ID> where:
	 * - T: This represents the Entity. Here, we will specify the name of the Entity which would 
	 * 		be used. In this, it is "Student". This will tell that Spring should take care of all
	 * 		the CRUD Operations on this Entity.
	 * - ID: In this, we need to mention the data type of the Primary Key.
	 */
}
