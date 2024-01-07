package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Item;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository adminRepository;
	
	public Item saveItem(Item item) {

		Item savedItem =adminRepository.save(item);
		return savedItem;
	}

	public List<Item> getItems() {

		return adminRepository.findAll();
	}

	public void deleteItem(Long itemId) {
		
		adminRepository.deleteById(itemId);
	}

}
