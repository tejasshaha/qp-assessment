package com.example.demo.model;

public class BookItemsResponse {

	private int price;
	private String errorMsg;
	
	public int getPrice() {
		return price;
	}
	public BookItemsResponse(int price, String errorMsg) {
		super();
		this.price = price;
		this.errorMsg = errorMsg;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	@Override
	public String toString() {
		return "BookItemsResponse [price=" + price + ", errorMsg=" + errorMsg + "]";
	}
	
	
}
