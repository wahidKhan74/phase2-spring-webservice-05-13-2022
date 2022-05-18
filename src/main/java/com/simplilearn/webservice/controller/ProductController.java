package com.simplilearn.webservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

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

@RestController
@RequestMapping("/api")
public class ProductController {

	List<Product> productList = new ArrayList<Product>();

	// Get all products list
	@GetMapping("/products")
	public List<Product> getAll() {
		if (productList.isEmpty()) {
			addDefaults();
		}
		return productList;
	}

	// Get one product by id
	@GetMapping("/products/{id}")
	public Product getOne(@PathVariable("id") int id) {
		for (Product product : productList) {
			if (product.getId() == id) {
				return product;
			}
		}
		throw new NotFoundException("Product not found with given id "+id);
	}

	// Get one product by name
	@GetMapping("/product")
	public Product getOne(@RequestParam("name") String name) {
		for (Product product : productList) {
			if (product.getName().equals(name)) {
				return product;
			}
		}
		throw new NotFoundException("Product not found with given name '"+name +"'");
	}

	// Search products by name
	@GetMapping("/product/search")
	public Product searchOne(@RequestParam("name") String name) {
		for (Product product : productList) {
			if (product.getName().contains(name)) {
				return product;
			}
		}
		throw new NotFoundException("Product not found with given name '"+name +"'");
	}

	// Add product to list
	@PostMapping("/products")
	public Product addOne(@RequestBody(required=false) Product product) {
		if (product != null) {
			productList.add(product);
			return product;
		}
		throw new InvalidException("Product can not be created , Required fileds missing");
	}

	// Update product to list
	@PutMapping("/products")
	public Product updateOne(@RequestBody Product product) {
		for (int index = 0; index < productList.size(); index++) {
			if (product.getId() == productList.get(index).getId()) {
				productList.set(index, product);
				return productList.get(index);
			}
		}
		throw new NotFoundException("Product not found with given id "+product.getId());
	}

	// Delete product from list
	@DeleteMapping("/products/{id}")
	public Product deleteOne(@PathVariable("id") int id) {
		for (int index = 0; index < productList.size(); index++) {
			if (id == productList.get(index).getId()) {
				//return removed record
				Product removed = productList.get(index);
				// remove data from list
				productList.remove(index);
				return removed;
			}
		}
		throw new NotFoundException("Product not found with given id "+id);
	}

	public void addDefaults() {
		productList.add(new Product(10001, "Apple Mac book", "Apple", "It is a laptop", 5645.45, true));
		productList.add(new Product(10002, "HP RySon book", "HP", "It is a laptop", 1645.45, false));
		productList.add(new Product(10003, "Dell Inspiron book", "Dell", "It is a laptop", 3645.45, true));
		productList.add(new Product(10004, "Lenovo Ideapad book", "Lenovo", "It is a laptop", 2699.45, true));
		productList.add(new Product(10005, "Acer Gamming book", "Acer", "It is a laptop", 5599.45, false));
	}
}
