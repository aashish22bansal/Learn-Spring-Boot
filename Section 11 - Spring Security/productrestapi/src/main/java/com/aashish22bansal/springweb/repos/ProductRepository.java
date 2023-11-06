package com.aashish22bansal.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashish22bansal.springweb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
