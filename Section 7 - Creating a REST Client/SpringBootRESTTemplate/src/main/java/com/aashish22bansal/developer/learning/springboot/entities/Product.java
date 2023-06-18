/**
 * 
 */
package com.aashish22bansal.developer.learning.springboot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @author Aashish Bansal
 *
 */
@Entity
public class Product {
	/**
	 * In this Model/Entity, we will create the fields for the Table present in the MySQL Database.
	 * 
	 * The @GeneratedValue will tell Spring Boot that this is an AUTO_INCREMENT field in MySQL.
	 * Along with this, we will also provide the Generation Strategy which includes the
	 * GenerationType and the field value from AUTO, IDENTITY, SEQUENCE, TABLE or UUID.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private int price;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
}
