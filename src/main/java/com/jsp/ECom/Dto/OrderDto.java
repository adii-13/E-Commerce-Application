package com.jsp.ECom.Dto;

import java.util.List;

import com.jsp.ECom.Entity.Item;

import lombok.Data;

@Data
public class OrderDto {
	private String address;
	private Double amount;
	private List<ItemDto> items;
	private String paymentId;
	private String orderId;
}