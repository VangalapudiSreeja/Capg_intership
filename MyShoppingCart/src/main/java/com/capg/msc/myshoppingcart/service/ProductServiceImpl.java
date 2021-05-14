package com.capg.msc.myshoppingcart.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.msc.myshoppingcart.bean.Product;
import com.capg.msc.myshoppingcart.dao.ProductRepository;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	
	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	@Override
	@Transactional
	public Product saveProduct(Product p) {
		
		repo.save(p);
		return p;
	}
	
	@Override
	public Product updateProduct(Product p, int id) {
		Optional<Product> up = repo.findById(id);
		if(up.isPresent())
		{
			Product product = up.get();
			product.setProductName(p.getProductName());
			product.setProductCost(p.getProductCost());
			product.setStarRating(p.getStarRating());
			product.setCategory(p.getCategory());
			return repo.save(product);
		}
		return null;
	}

	@Override
    @Transactional
	public boolean deleteProduct(Product p, int pId) {
		boolean isDeleted = false;
		Product p1 = null;
		List<Product> pList = getAllProducts();
		for(Product product : pList) {
			if(product.getProductId() == pId) {
				isDeleted = true;
				p1 = product;
			}
		}
	
		repo.delete(p);
		return isDeleted;
		
	}

	@Override
	public List<Product> getAllProductsByCategory(String category) {
		
		return repo.getProductByCategory(category);
	}

	@Override
	public List<Product> getAllProductsByCategoryAndPrice(String category, int range1, int range2) {
		
		return repo.getProductByCategoryAndPrice(category, range1, range2);
	}
}
