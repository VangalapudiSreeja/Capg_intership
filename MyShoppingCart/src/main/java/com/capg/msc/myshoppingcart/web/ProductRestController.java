package com.capg.msc.myshoppingcart.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.msc.myshoppingcart.bean.Product;
import com.capg.msc.myshoppingcart.exception.InvalidCostRangeException;
import com.capg.msc.myshoppingcart.exception.InvalidProductCategory;
import com.capg.msc.myshoppingcart.exception.InvalidProductCost;
import com.capg.msc.myshoppingcart.service.ProductService;

@Validated
@RestController
@RequestMapping("/api")

public class ProductRestController {
	
	@Autowired
	private ProductService service;
	
	public ProductRestController() {
		System.out.println(" ----->> Product Rest Controller Constructor ");
	}

	@GetMapping("/home")
	public String homeRequest()
	{
		return "Welcome : My Shopping App "+LocalDateTime.now();
	}
	
	@PostMapping("/product")
	public Product insertProduct(@RequestBody @Valid Product product)
	{
		service.saveProduct(product);
		return product;
	}
	
	@PostMapping("/product/productcost")
	public Product insertproductbasedoncost(@RequestBody Product product) throws InvalidProductCost
	{
		if(product.getProductCost() > 20000)
		{
			service.saveProduct(product);
			return product;
		}
		throw new InvalidProductCost(product.getProductCost());
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts()
	{
		return service.getAllProducts();
	}
	
	@PutMapping("/product/{id}")
	public Product updateProduct(@RequestBody Product p,@PathVariable int id)
	{
		return service.updateProduct(p, id);
	}

	@PostMapping("/product/delete")
	public boolean deleteProduct(@RequestBody Product product) {
		return service.deleteProduct(product, product.getProductId());
	}
	
	@GetMapping("/products/{category}")
	public List<Product> getAllProductsByCategory(@PathVariable String category) throws InvalidProductCategory
	{
		if(category.equals("Laptop") || category.equals("Camera") || category.equals("Mobile"))
		{
			return service.getAllProductsByCategory(category);
		}
		throw new InvalidProductCategory(category);
	}
	
	
	@GetMapping("/products/{category}/{range1}/{range2}")
	public List<Product> getAllProductsByCategoryAndPrice(@PathVariable String category,
			@PathVariable int range1,@PathVariable int range2)throws InvalidCostRangeException
	{
		if(category.equals("Laptop")&&range1<10000)
		{
			throw new InvalidCostRangeException(range1,range2);
		}
		return service.getAllProductsByCategoryAndPrice(category, range1, range2);
	}
	
	

}
