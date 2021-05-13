package com.capg.basic.Springmvcapp1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyRestController {
	

	@Autowired
	ProductDAOImpl dao;
	
	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello";
	}
    
	//            localhost:9090:\product\10000\40000
	//  endpoint :- www.abc.com\product\10000\40000
	@GetMapping("/product/{r1}/{r2}")
	public List<Product> getProductsbyrange(@PathVariable int r1 ,@PathVariable int r2)
	{
		return dao.getProductsByRange(r1, r2);
	}
	
	// ..../product/101
	@GetMapping("/product/{searchid}")
	public Product getProductByid(@PathVariable int searchid)
	{
		return dao.getProductById(searchid);
	}
	
	@GetMapping("/product/rating/{ratingVal}")
	public List<Product> getProductByRating(@PathVariable int ratingVal) {
		return dao.getProductByRating(ratingVal);
	}
	
	@GetMapping("/product/all")
	public List<Product> getAllProducts(){
		return dao.getAllProducts();
	}
	
	@GetMapping("/product/delete/{delid}")
	public List<Product> deleteById(@PathVariable int delid){
		return dao.deleteProductById(delid);
	}
	
	@PostMapping("/product/add")
	public Product insertProduct(@RequestBody Product product) {
		if(dao.doAdd(product)) return product;
		return null;
	}
	
	@PutMapping("/product/update")
	public Product updateProduct(@RequestBody Product product) {
		return dao.update(product,product.getProductId());
	}

}
