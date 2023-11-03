package com.ecomm.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.backend.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	public Category findById(int id);
}
