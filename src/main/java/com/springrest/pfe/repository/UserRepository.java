package com.springrest.pfe.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.pfe.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByIdUser(Long id);
	User findByEmail(String email);
}
