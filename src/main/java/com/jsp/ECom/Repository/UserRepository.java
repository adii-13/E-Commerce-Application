package com.jsp.ECom.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ECom.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsByEmail(String adminEmail);

	Optional<User> findByEmail(String email);

	boolean existsByEmailOrMobile(String email, Long mobile);

}
