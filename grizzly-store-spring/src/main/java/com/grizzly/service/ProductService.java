package com.grizzly.service;

import java.util.List;

import com.grizzly.entity.Product;

public interface ProductService 
{
	List<Product> listProduct();
	void addProduct(Product p);
	void deleteProduct(int id);
	Product getProduct(int id);
	
}
