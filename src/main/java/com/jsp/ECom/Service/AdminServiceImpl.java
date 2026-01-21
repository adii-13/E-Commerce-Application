package com.jsp.ECom.Service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jsp.ECom.Dao.ProductDao;
import com.jsp.ECom.Dao.UserDao;
import com.jsp.ECom.Entity.Customer;
import com.jsp.ECom.Entity.Merchant;
import com.jsp.ECom.Entity.Product;
import com.jsp.ECom.Entity.User;
import com.jsp.ECom.Mapper.ProductMapper;
import com.jsp.ECom.Mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

	private final UserDao userDao;
	private final UserMapper userMapper;
	private final ProductMapper productMapper;
	private final ProductDao productDao;

	@Override
	public Map<String, Object> getAllMerchants() {
		List<Merchant> merchants = userDao.getAllMerchants();
		return Map.of("message", "Merchant Records Found", "merchants", userMapper.toMerchantDtoList(merchants));
	}

	@Override
	public Map<String, Object> getAllCustomers() {
		List<Customer> customers = userDao.getAllCustomers();
		return Map.of("message", "Customer Records Found", "customers", userMapper.toCustomerDtoList(customers));
	}

	@Override
	public Map<String, Object> blockUser(Integer id) {
		User user = userDao.findById(id);
		user.setActive(false);
		userDao.save(user);
		return Map.of("message", "Blocked Success", "user", userMapper.toUserDto(user));
	}

	@Override
	public Map<String, Object> unblockUser(Integer id) {
		User user = userDao.findById(id);
		user.setActive(true);
		userDao.save(user);
		return Map.of("message", "Un-Blocked Success", "user", userMapper.toUserDto(user));
	}

	@Override
	public Map<String, Object> getAllProducts() {
		List<Product> products = productDao.getProducts();
		return Map.of("message", "Product Records Found", "products", productMapper.toProductDtoList(products));
	}

	@Override
	public Map<String, Object> approveProduct(Long id) {
		Product product = productDao.getProductById(id);
		product.setApproved(true);
		productDao.save(product);
		return Map.of("message", "Product Approved Success", "product", productMapper.toProductDto(product));
	}

}