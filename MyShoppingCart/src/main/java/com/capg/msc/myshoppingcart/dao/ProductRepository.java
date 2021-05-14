package com.capg.msc.myshoppingcart.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.msc.myshoppingcart.bean.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>,CustomProductRepository {
	/*
	    * finaAll
	    * save
	    * update
	    * delete
	    * 
	    * + 
	    * all methods from custom repo.
	    * 
	    * */

}
