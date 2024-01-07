package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookItemsRequest;
import com.example.demo.model.Item;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Item> getItems() {

		return userRepository.findAll();
	}

	@Override
	public Optional<Item> getItemDetails(Long itemId) {

		return userRepository.findById(itemId);
	}

}
