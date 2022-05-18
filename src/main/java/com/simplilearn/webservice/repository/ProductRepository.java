package com.simplilearn.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.webservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	// Derived Query Methods in Spring boot
	List<Product> findByName(String name);
	
	List<Product> findByPrice(double price);
	
	List<Product> findByAvailable(boolean available);
	
	// HQL Query Methods in Spring boot
	@Query("select p from Product p where p.name LIKE %?1%")
	List<Product> searchByName(String name);
}
