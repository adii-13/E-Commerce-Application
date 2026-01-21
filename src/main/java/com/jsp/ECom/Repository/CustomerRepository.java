package com.jsp.ECom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ECom.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}