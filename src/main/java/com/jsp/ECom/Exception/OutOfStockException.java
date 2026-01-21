package com.jsp.ECom.Exception;

public class OutOfStockException extends RuntimeException {
	public OutOfStockException(String message) {
		super(message);
	}
}