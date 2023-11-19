package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Category;

public interface CategoryRep extends JpaRepository<Category,Integer> {

	List<Category> getAllCategory();
}
