package com.jsp.ECom.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jsp.ECom.Dao.ProductDao;
import com.jsp.ECom.Dao.UserDao;
import com.jsp.ECom.Dto.FakeStoreData;
import com.jsp.ECom.Dto.ProductDto;
import com.jsp.ECom.Entity.Merchant;
import com.jsp.ECom.Entity.Product;
import com.jsp.ECom.Mapper.ProductMapper;

import io.jsonwebtoken.lang.Arrays;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService {
	private final ProductDao productDao;
	private final UserDao userDao;
	private final ProductMapper productMapper;
	private final RestTemplate restTemplate;

	@Override
	public Map<String, Object> saveProduct(ProductDto productDto, String email) {
		Merchant merchant = userDao.getMerchantByEmail(email);
		Product product = productMapper.toProductEntity(productDto, merchant);
		productDao.save(product);
		return Map.of("message", "Product Added Success", "product", productMapper.toProductDto(product));
	}

	@Override
	public Map<String, Object> getProducts(String email) {
		Merchant merchant = userDao.getMerchantByEmail(email);
		List<Product> products = productDao.getMerchantProducts(merchant);
		return Map.of("message", "Products Found for User " + merchant.getName(), "products",
				productMapper.toProductDtoList(products));
	}

	@Override
	public Map<String, Object> deleteProduct(Long id, String email) {
		Merchant merchant = userDao.getMerchantByEmail(email);
		Product product = productDao.getProductByIdAndMerchant(id, merchant);
		productDao.delete(product);
		return Map.of("message", "Products Deleted Success", "product", productMapper.toProductDto(product));
	}

	@Override
	public Map<String, Object> updateProduct(Long id, ProductDto productDto, String email) {
		Merchant merchant = userDao.getMerchantByEmail(email);
		productDao.getProductByIdAndMerchant(id, merchant);
		Product product = productMapper.toProductEntity(productDto, merchant);
		product.setId(id);
		productDao.save(product);
		return Map.of("message", "Product Updated Success", "product", productMapper.toProductDto(product));
	}

	@Override
	public Map<String, Object> addProducts(String email) {
		Merchant merchant = userDao.getMerchantByEmail(email);

		FakeStoreData[] data = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreData[].class);
		List<FakeStoreData> productDtos = Arrays.asList(data);
		List<Product> products = new ArrayList<Product>();
		for (FakeStoreData storeData : productDtos) {
			Product product = productMapper.toProductEntity(storeData, merchant);
			products.add(product);
		}
		productDao.saveAll(products);
		return Map.of("Message", "Products Added Success", "products", productMapper.toProductDtoList(products));
	}
}