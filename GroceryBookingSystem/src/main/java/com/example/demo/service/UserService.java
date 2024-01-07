package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Item;

public interface UserService {

	public List<Item> getItems();

	public Optional<Item> getItemDetails(Long itemId);
}
