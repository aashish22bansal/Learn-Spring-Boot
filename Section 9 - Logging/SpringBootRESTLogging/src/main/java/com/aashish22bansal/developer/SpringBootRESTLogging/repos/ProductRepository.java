package com.aashish22bansal.developer.SpringBootRESTLogging.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashish22bansal.developer.SpringBootRESTLogging.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
