package com.brian.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.brian.data.OrdersDataAccessInterface;
import com.brian.models.OrderModel;

@Primary
public class OrdersBusinessService implements OrdersBusinessServiceInterface{
	
	@Autowired
	OrdersDataAccessInterface ordersDAO;

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("OrderBusinessService is working");	}

	@Override
	public List<OrderModel> getOrders() {
		// TODO Auto-generated method stub
		return ordersDAO.getOrders();
	}

	@Override
	public void init() {
		System.out.println("Init method of the Orders Business Service");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroy method of the Orders Business Service");
	}

	@Override
	public OrderModel getById(long id) {
		return ordersDAO.getById(id);
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		return ordersDAO.searchOrders(searchTerm);
	}

	@Override
	public long addOne(OrderModel newOrder) {
		return ordersDAO.addOne(newOrder);
	}

	@Override
	public boolean deleteOne(long id) {
		return ordersDAO.deleteOne(id);
	}

	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		// TODO Auto-generated method stub
		return ordersDAO.updateOne(idToUpdate, updateOrder);
	}
}
