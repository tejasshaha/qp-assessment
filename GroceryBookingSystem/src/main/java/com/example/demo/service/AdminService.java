package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Item;

public interface AdminService {
	
	public Item saveItem(Item item);
	
	public List<Item> getItems();
	
	public void deleteItem(Long itemId);
}
