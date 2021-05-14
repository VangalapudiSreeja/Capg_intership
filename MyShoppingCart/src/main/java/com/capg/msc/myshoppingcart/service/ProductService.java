package com.capg.msc.myshoppingcart.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.capg.msc.myshoppingcart.bean.Product;

public interface ProductService {
	
    public List<Product> getAllProducts();
	
	public Product saveProduct(Product p);
	
	public boolean deleteProduct(Product p, int pId);
	
	public Product updateProduct(Product p,int id);
	
	public List<Product> getAllProductsByCategory(String category);
	
	public List<Product> getAllProductsByCategoryAndPrice(String category,int range1,int range2);
}
