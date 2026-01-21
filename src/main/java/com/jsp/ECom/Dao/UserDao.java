package com.jsp.ECom.Dao;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import com.jsp.ECom.Entity.Customer;
import com.jsp.ECom.Entity.Merchant;
import com.jsp.ECom.Entity.User;
import com.jsp.ECom.Repository.CustomerRepository;
import com.jsp.ECom.Repository.MerchantRepository;
import com.jsp.ECom.Repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class UserDao {

	private final UserRepository userRepository;
	private final MerchantRepository merchantRepository;
	private final CustomerRepository customerRepository;
	private final CustomerOrderRepository customerOrderRepository;

	public boolean checkEmailAndMobieDuplicate(String email, Long mobile) {
		return userRepository.existsByEmailOrMobile(email, mobile);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email)
				.orElseThrow(() -> new NoSuchElementException("No User with Email: " + email));
	}

	public void save(User user) {
		userRepository.save(user);
	}

	public void save(Merchant merchant) {
		merchantRepository.save(merchant);
	}

	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	public List<Merchant> getAllMerchants() {
		List<Merchant> merchants = merchantRepository.findAll();
		if (merchants.isEmpty())
			throw new NoSuchElementException("No Merchant Records Found");
		return merchants;
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		if (customers.isEmpty())
			throw new NoSuchElementException("No Customer Records Found");
		return customers;
	}

	public User findById(Integer id) {
		return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No User with Id: " + id));
	}

	public Merchant getMerchantByEmail(String email) {
		User user = findByEmail(email);
		return merchantRepository.findByUser(user)
				.orElseThrow(() -> new NoSuchElementException("No User with Email: " + email));
	}

	public Customer findCustomerByEmail(String email) {
		User user = findByEmail(email);
		return customerRepository.findByUser(user)
				.orElseThrow(() -> new NoSuchElementException("No User with Email: " + email));
	}

	public void saveOrder(CustomerOrder customerOrder) {
		customerOrderRepository.save(customerOrder);
	}

	public CustomerOrder getOrder(Long id) {
		return customerOrderRepository.findById(id).orElseThrow(()->new NoSuchElementException("No Order Found"));
	}
}