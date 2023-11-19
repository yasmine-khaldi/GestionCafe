package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import com.example.Wrapper.ProductWrapper;
import com.example.model.Product;

import jakarta.transaction.Transactional;

public interface ProductRep extends JpaRepository<Product, Integer>{

	List<ProductWrapper> getAllProduct();

	@Modifying
	@Transactional
	Integer updateProductStatus(@Param("status") String status, Integer id);

	List<ProductWrapper> getProductByCategory(@Param("id") Integer id);

	ProductWrapper getProductById(@Param("id") Integer id);
}
