/**
 * 
 */
package com.aashish22bansal.developer.learning.springboot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @author Aashish Bansal
 *
 * To create this class into an Entity, we will mark with class with the @Entity Annotation.
 */
@Entity
public class Student {
	/**
	 * In this Entity, we know that 'id' will act as the Primary Key, so we can mark this with
	 * the @Id Annotation to denote the same for the Database.
	 */
	@Id
	private long id;
	private String name;
	private int testScore;
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the testScore
	 */
	
	public int getTestScore() {
		return testScore;
	}
	/**
	 * @param testScore the testScore to set
	 */
	public void setTestScore(int testScore) {
		this.testScore = testScore;
	}
}
