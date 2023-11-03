package com.ecomm.backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.backend.Model.Category;
import com.ecomm.backend.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	public Product findById(int id);

	List<Product> findByCategory(Category category);
}
