package com.simplilearn.webservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.exception.InvalidException;
import com.simplilearn.webservice.exception.NotFoundException;
import com.simplilearn.webservice.model.Product;
import com.simplilearn.webservice.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	// Get all products list
	@GetMapping("/products")
	public List<Product> getAll() {
		List<Product> productList = productRepository.findAll();
		if (productList.isEmpty()) {
			throw new NotFoundException("Product list empty, No product found");
		}
		return productList;
	}

	// Get one product by id
	@GetMapping("/products/{id}")
	public Product getOne(@PathVariable("id") int id) {
		Optional<Product> productData = productRepository.findById(id);
		if (productData.isPresent()) {
			return productData.get();
		}
		throw new NotFoundException("Product not found with given id " + id);
	}

	// Get one product by name
	@GetMapping("/product")
	public List<Product> getOne(@RequestParam("name") String name) {
		List<Product> productData = productRepository.findByName(name);
		if (!productData.isEmpty()) {
			return productData;
		}
		throw new NotFoundException("Product not found with given name '" + name + "'");
	}

	// Get one product by price
	@GetMapping("/product/price")
	public List<Product> getOne(@RequestParam("price") double price) {
		List<Product> productData = productRepository.findByPrice(price);
		if (!productData.isEmpty()) {
			return productData;
		}
		throw new NotFoundException("Product not found with given price '" + price + "'");
	}

	// Get one product by available
	@GetMapping("/product/available")
	public List<Product> getOne(@RequestParam("available") boolean available) {
		List<Product> productData = productRepository.findByAvailable(available);
		if (!productData.isEmpty()) {
			return productData;
		}
		throw new NotFoundException("Product not found with given available status '" + available + "'");
	}

	// Search products by name
	@GetMapping("/product/search")
	public List<Product> searchOne(@RequestParam("name") String name) {
		List<Product> productData = productRepository.searchByName(name);
		if (!productData.isEmpty()) {
			return productData;
		}
		throw new NotFoundException("Product not found with given name '" + name + "'");
	}

	// Add product to list
	@PostMapping("/products")
	public Product addOne(@RequestBody(required = false) Product product) {
		if (product != null) {
			return productRepository.save(product);
		}
		throw new InvalidException("Product can not be created , Required fileds missing");
	}

	// Update product to list
	@PutMapping("/products")
	public Product updateOne(@RequestBody Product product) {
		Optional<Product> productData = productRepository.findById(product.getId());
		if (productData.isPresent()) {
			return productRepository.save(product);
		}
		throw new NotFoundException("Product not found with given id " + product.getId());
	}

	// Delete product from list
	@DeleteMapping("/products/{id}")
	public Product deleteOne(@PathVariable("id") int id) {
		Optional<Product> productData = productRepository.findById(id);
		if (productData.isPresent()) {
			productRepository.delete(productData.get());
			return productData.get();
		}
		throw new NotFoundException("Product not found with given id " + id);
	}
}
