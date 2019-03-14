package com.grizzly.dao;

import java.util.List;

import com.grizzly.entity.Product;

public interface ProductDAO 
{
		List<Product> listProduct();
		void addProduct(Product p);
		void deleteProduct(int id);
		Product getProduct(int id);
		
}
