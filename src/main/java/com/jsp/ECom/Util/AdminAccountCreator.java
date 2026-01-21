package com.jsp.ECom.Util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jsp.ECom.Entity.User;
import com.jsp.ECom.Enum.UserRole;
import com.jsp.ECom.Repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component

@Slf4j

@RequiredArgsConstructor
public class AdminAccountCreator implements CommandLineRunner {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Value("${admin.email}")
	private String adminEmail;

	@Value("${admin.password}")
	private String adminPassword;

	@Value("${admin.mobile}")
	private Long adminMobile;

	@Value("${admin.username}")
	private String adminUserName;

	@Override
	public void run(String... args) throws Exception {
		log.info("Admin Account Creation Started");
		if (userRepository.existsByEmail(adminEmail)) {
			log.info("Admin Account Already Exists");
		} else {
			User user = new User(null, adminUserName, adminEmail, adminMobile, passwordEncoder.encode(adminPassword),
					UserRole.ADMIN, true);
			userRepository.save(user);
			log.info("Admin Account Creaion Success - " + adminUserName);
		}
	}

}
