package com.simplilearn.webservice.model;

import java.util.Date;

public class Product {
	
	// data properties
	private int id;
	private String name;
	private String brand;
	private String details;
	private double price;
	private Date createAt;
	private Date modifiedAt;
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
