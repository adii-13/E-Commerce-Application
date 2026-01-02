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
class AdminAccountCreater implements CommandLineRunner {
	private final UserRepository usr;
	private final PasswordEncoder Pe;
	@Value("${admin.email}")
	private String adminEmail;
	@Value("${admin.password}")
	private String adminPassword;
	@Value("${admin.mobile}")
	private long adminMobile;
	@Value("${admin.userName}")
	private String adminUserName;

	@Override
	public void run(String... args) throws Exception {
		log.info("Admin Account Creation Started");
		if (usr.existsByEmail(adminEmail)) {
			log.info("Admin Account is alredy present");
		} else {
			User u1 = new User();
			u1.setActive(true);
			u1.setEmail(adminEmail);
			u1.setPassword(Pe.encode(adminPassword));
			u1.setMobile(0L);
			u1.setUsername(adminUserName);
			u1.setRole(UserRole.ADMIN);
			usr.save(u1);
			log.info("Admin Account is created Succesfully");
		}
	}
}
