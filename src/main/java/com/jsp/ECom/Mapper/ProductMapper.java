package com.jsp.ECom.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jsp.ECom.Dto.FakeStoreData;
import com.jsp.ECom.Dto.ItemDto;
import com.jsp.ECom.Dto.OrderDto;
import com.jsp.ECom.Dto.ProductDto;
import com.jsp.ECom.Entity.CustomerOrder;
import com.jsp.ECom.Entity.Item;
import com.jsp.ECom.Entity.Merchant;
import com.jsp.ECom.Entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	@Mapping(target = "name", expression = "java(productDto.getName())")
	@Mapping(target = "merchant", expression = "java(merchant)")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "approved", ignore = true)
	Product toProductEntity(ProductDto productDto, Merchant merchant);

	ProductDto toProductDto(Product product);

	List<ProductDto> toProductDtoList(List<Product> products);

	@Mapping(target = "name", expression = "java(item.getProduct().getName())")
	@Mapping(target = "brand", expression = "java(item.getProduct().getBrand())")
	@Mapping(target = "category", expression = "java(item.getProduct().getCategory())")
	@Mapping(target = "price", expression = "java(item.getProduct().getPrice())")
	@Mapping(target = "productId", expression = "java(item.getProduct().getId())")
	ItemDto toItemDto(Item item);

	List<ItemDto> toItemsDtoList(List<Item> items);

	@Mapping(target = "name", expression = "java(data.getTitle())")
	@Mapping(target = "approved", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "merchant", expression = "java(merchant)")
	@Mapping(target = "brand", expression = "java(merchant.getName())")
	@Mapping(target = "size", constant = "FREE")
	@Mapping(target = "stock", constant = "20")
	Product toProductEntity(FakeStoreData data, Merchant merchant);
	
	
	OrderDto toOrderDto(CustomerOrder order);

	List<OrderDto> toOrderDtos(List<CustomerOrder> orders);
}