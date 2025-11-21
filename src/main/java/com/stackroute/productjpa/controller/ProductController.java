package com.stackroute.productjpa.controller;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.productjpa.exception.IdNotFoundException;
import com.stackroute.productjpa.model.Product;
import com.stackroute.productjpa.service.ProductService;

@RestController
@RequestMapping("/product/api/v1")
@CrossOrigin
public class ProductController
{

	@Autowired
	 ProductService productservice;
	
	
	@PostMapping("/addproduct")
	public ResponseEntity add(@RequestBody Product product)
	{
	Product resultobj=productservice.addProduct(product);
	
	return new ResponseEntity(resultobj,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/view")
	public ResponseEntity getall()
	{
	List<Product> products=	productservice.viewAllProducts();
		return new ResponseEntity(products,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{productid}")
	public ResponseEntity<?> deleterec(@PathVariable("productid") int pid)
	{
		try {
			boolean result=productservice.deleteProduct(pid);
			return new ResponseEntity("Deleted Successfully" ,HttpStatus.OK);
		} catch (IdNotFoundException e) {
			return new ResponseEntity(e.getMessage() ,HttpStatus.NOT_FOUND); 
		}
		
	
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateproduct(@RequestBody Product product)
	{
		
	Product updatedproduct;
	try {
		updatedproduct = productservice.updateProduct(product);
		return new ResponseEntity(updatedproduct,HttpStatus.OK);
	} catch (IdNotFoundException e) {
 
		return new ResponseEntity(e.getMessage() ,HttpStatus.NOT_FOUND); 

	}
	
		
	}
	
	
	
}

