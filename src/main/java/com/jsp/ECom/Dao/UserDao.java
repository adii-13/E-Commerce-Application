
package com.jsp.ECom.Dao;

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

	public boolean checkEmailAndMobieDuplicate(String email, Long mobile) {
		return userRepository.existsByEmailOrMobile(email, mobile);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email).orElseThrow();
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
}
