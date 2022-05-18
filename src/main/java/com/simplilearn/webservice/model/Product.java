package com.simplilearn.webservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products_data")
public class Product {
	
	// data properties
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private int id;
	
	@Column(name="product_name")
	private String name;
	
	@Column(name="product_brand")
	private String brand;
	
	@Column(name="product_details")
	private String details;
	
	@Column(name="product_price")
	private double price;
	
	@Column(name="product_created_at")
	private Date createAt;
	
	@Column(name="product_modified_at")
	private Date modifiedAt;
	
	@Column(name="product_available")
	private boolean available;
	
	//constructor
	public Product() {}
	public Product(int id, String name, String brand, String details, double price,boolean available) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.details = details;
		this.price = price;
		this.createAt =  new Date();
		this.modifiedAt = new Date();
		this.available = available;
	}
	
	// public get and sets methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
}
