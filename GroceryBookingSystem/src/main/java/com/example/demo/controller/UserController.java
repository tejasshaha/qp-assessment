package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookItemsRequest;
import com.example.demo.model.BookItemsResponse;
import com.example.demo.model.Item;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/viewItemsOfInventory")
	public ResponseEntity<List<Item>> viewItemsOfInventory(){
		List<Item> items = userService.getItems();
		System.out.println("Inventory items: "+items.toString());
		return new ResponseEntity<List<Item>>(items,HttpStatus.OK);
	}
	
	@PostMapping("/bookItems")
	public ResponseEntity<BookItemsResponse> bookGrocerryItems(@RequestBody List<BookItemsRequest> bookItemsRequests){
		int totalPrice=0;
		BookItemsResponse bookItemsResponse = new BookItemsResponse(0, null);
		try {
			for(BookItemsRequest bookItemsRequest:bookItemsRequests) {
				Optional<Item> itemDetails = userService.getItemDetails(bookItemsRequest.getItemId());
				if(itemDetails.get().getQuantity()>=bookItemsRequests.get(0).getItemQuantity()) {
					totalPrice+=bookItemsRequests.get(0).getItemQuantity()*itemDetails.get().getPrice();
					
				}
			}
			bookItemsResponse.setPrice(totalPrice);
			bookItemsResponse.setErrorMsg(null);
			return new ResponseEntity<BookItemsResponse>(bookItemsResponse,HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println("Exception occured while booking grocerry items "+e);
			bookItemsResponse.setErrorMsg("Cannot book items now. Please try again later. Apologies for inconvinience");
			return new ResponseEntity<BookItemsResponse>(bookItemsResponse,HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
