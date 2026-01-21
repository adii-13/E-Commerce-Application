package com.jsp.ECom.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ECom.Entity.Customer;
import com.jsp.ECom.Entity.User;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByUser(User user);

}