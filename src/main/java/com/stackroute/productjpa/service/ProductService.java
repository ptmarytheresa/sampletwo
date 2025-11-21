package com.stackroute.productjpa.service;

import java.util.List;

import com.stackroute.productjpa.exception.IdAlreadyExistException;
import com.stackroute.productjpa.exception.IdNotFoundException;
import com.stackroute.productjpa.model.Product;

public interface ProductService {
	
	    Product addProduct(Product product);
	    
	   List<Product> viewAllProducts();
	   
	   boolean deleteProduct(int productid) throws IdNotFoundException;
	   
	   Product updateProduct(Product product) throws IdNotFoundException;

}
