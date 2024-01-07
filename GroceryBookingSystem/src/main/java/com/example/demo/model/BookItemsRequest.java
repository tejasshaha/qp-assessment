package com.example.demo.model;

public class BookItemsRequest {

	private Long itemId;
	private int itemQuantity;
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	@Override
	public String toString() {
		return "BookItemsRequest [itemId=" + itemId + ", itemQuantity=" + itemQuantity + "]";
	}
	
}
