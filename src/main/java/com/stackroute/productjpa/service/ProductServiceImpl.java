package com.stackroute.productjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.productjpa.exception.IdNotFoundException;
import com.stackroute.productjpa.model.Product;
import com.stackroute.productjpa.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productrepo;

	@Override
	public Product addProduct(Product product) {
		 
	Product productstored=	productrepo.save(product);
			
		return productstored;
	}

	@Override
	public List<Product> viewAllProducts() {
	List<Product>  products=  productrepo.findAll();
		return products;
	}

	@Override
	public boolean deleteProduct(int productid) throws IdNotFoundException {
	Optional<Product> productopt=	 productrepo.findById(productid);
	
	if(productopt.isPresent())
	{
		productrepo.deleteById(productid);
		
		return true;
	}
	else
		throw new IdNotFoundException("invalid id");
	}

	@Override
	public Product updateProduct(Product producttoupdate) throws IdNotFoundException {
	
	Optional<Product> optproduct=productrepo.findById(producttoupdate.getProductId());
	
	if(optproduct.isPresent())
	{
	
		return productrepo.save(producttoupdate);
		
	}
	else
		throw new IdNotFoundException("Invalid id");
	
	}

}
