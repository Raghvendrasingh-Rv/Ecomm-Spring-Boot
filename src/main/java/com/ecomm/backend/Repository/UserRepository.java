package com.ecomm.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.backend.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findById(int userId);

	public User findByEmail(String email);
}
