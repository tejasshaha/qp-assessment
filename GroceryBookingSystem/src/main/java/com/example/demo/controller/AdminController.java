package com.example.demo.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Item;
import com.example.demo.service.AdminServiceImpl;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminServiceImpl adminServiceImpl;

	
	@PostMapping("/addItemToInventory")
	public ResponseEntity<Item> saveItemToInventory(@RequestBody Item item){
		Item savedItem = adminServiceImpl.saveItem(item);
		System.out.println("Saved item is " + savedItem.toString());
		return new ResponseEntity<Item>(savedItem,HttpStatus.CREATED);
	}
	
	@GetMapping("/viewItemsOfInventory")
	public ResponseEntity<List<Item>> viewItemsOfInventory(){
		List<Item> items = adminServiceImpl.getItems();
		System.out.println("Inventory items: "+items.toString());
		return new ResponseEntity<List<Item>>(items,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteItemFromInventory/{itemId}")
	public ResponseEntity<Void> deleteItemFromInventory(@PathVariable("itemId") Long itemId){
		adminServiceImpl.deleteItem(itemId);
		System.out.println("Item with id: " + itemId + " successfully deleted from inventory.");
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateItemFromInventory")
	public ResponseEntity<Item> updateItemFromInventory(@RequestBody Item item){
		Item savedItem = adminServiceImpl.saveItem(item);
		System.out.println("Updated item is " + savedItem.toString());
		return new ResponseEntity<Item>(savedItem,HttpStatus.CREATED);
	}
}
