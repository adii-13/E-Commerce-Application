package com.jsp.ECom.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ECom.Entity.Customer;
import com.jsp.ECom.Entity.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

	List<CustomerOrder> findByCustomer(Customer customer);

}