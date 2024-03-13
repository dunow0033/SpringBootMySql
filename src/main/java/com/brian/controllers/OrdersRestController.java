package com.brian.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.brian.models.OrderModel;
import com.brian.services.OrdersBusinessService;
import com.brian.services.OrdersBusinessServiceInterface;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersRestController {
	
	OrdersBusinessServiceInterface service;
	
	@Autowired
	public OrdersRestController(OrdersBusinessServiceInterface service) {
		super();
		this.service = service;
	}


	@GetMapping("/")
	public List<OrderModel> showAllOrders() {
		
		List<OrderModel> orders = service.getOrders();
		
		return orders;
	}
	
	@GetMapping("/search/{searchTerm}")
	public List<OrderModel> searchOrders(@PathVariable(name = "searchTerm") String searchTerm) {
		
		List<OrderModel> orders = service.searchOrders(searchTerm);
		
		return orders;
	}
	
	@PostMapping("/")
	public long addOrder(@RequestBody OrderModel model) {
		
		return service.addOne(model);
	}
	
	@GetMapping("/{id}")
	public OrderModel getById(@PathVariable(name="id") long id) {
		
		return service.getById(id);
	}
	
	@GetMapping("/delete/{id}")
	public boolean deleteOne(@PathVariable(name="id") long id) {
		
		return service.deleteOne(id);
	}
	
	@PostMapping("/update/{id}")
	public OrderModel update(@RequestBody OrderModel model, @PathVariable(name="id") long id) {
		
		return service.updateOne(id, model);
	}
}
