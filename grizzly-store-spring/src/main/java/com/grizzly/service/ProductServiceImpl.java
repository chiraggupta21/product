package com.grizzly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grizzly.dao.ProductDAO;
import com.grizzly.dao.ProductDAOImpl;
import com.grizzly.entity.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO productDAO=new ProductDAOImpl();
	
	@Override
	@org.springframework.transaction.annotation.Transactional
	public List<Product> listProduct() 
	{
		return productDAO.listProduct();
	}

	@Transactional
	@Override
	public void addProduct(Product p) {
		productDAO.addProduct(p);
	}

	@Transactional
	@Override
	public void deleteProduct(int id) {
		productDAO.deleteProduct(id);
	}

	@Transactional
	@Override
	public Product getProduct(int id) {
		return productDAO.getProduct(id);
	}

}
