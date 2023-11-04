package com.aashish22bansal.developer.SpringBootRESTLogging.repos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aashish22bansal.developer.SpringBootRESTLogging.entities.Product;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Qualifier("productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
