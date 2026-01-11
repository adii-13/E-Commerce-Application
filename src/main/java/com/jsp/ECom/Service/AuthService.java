package com.jsp.ECom.Service;

import java.util.Map;

import com.jsp.ECom.Dto.CustomerDto;
import com.jsp.ECom.Dto.MerchantDto;
import com.jsp.ECom.Dto.OtpDto;

public interface AuthService {

	Map<String, Object> login(String email, String password);

	Map<String, Object> viewUser(String email);

	Map<String, Object> updatePassword(String email, String oldPassword, String newPassword);

	Map<String, Object> registerMerchant(MerchantDto merchantDto);

	Map<String, Object> verifyMerchantOtp(OtpDto dto);

	Map<String, Object> resendMerchantOtp(String email);
	
	Map<String, Object> registerCustomer(CustomerDto customerDto);

	Map<String, Object> verifyCustomerOtp(OtpDto dto);

	Map<String, Object> resendCustomerOtp(String email);

}
