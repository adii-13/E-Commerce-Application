package com.jsp.ECom.Service;

import java.util.Map;

public interface AdminService {

	Map<String, Object> getAllMerchants();

	Map<String, Object> getAllCustomers();

	Map<String, Object> blockUser(Integer id);

	Map<String, Object> unblockUser(Integer id);

	Map<String, Object> getAllProducts();

	Map<String, Object> approveProduct(Long id);

}
