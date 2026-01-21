package com.jsp.ECom.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ECom.Entity.Merchant;
import com.jsp.ECom.Entity.User;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {

	Optional<Merchant> findByUser(User user);

}