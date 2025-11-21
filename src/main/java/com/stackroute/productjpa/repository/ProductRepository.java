package com.stackroute.productjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.productjpa.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
