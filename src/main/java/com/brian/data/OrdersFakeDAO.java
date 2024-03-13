package com.brian.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.brian.models.OrderModel;

@Repository
public class OrdersFakeDAO implements OrdersDataAccessInterface {
	
	List<OrderModel> orders = new ArrayList<OrderModel>();

	public OrdersFakeDAO() {
		orders.add(new OrderModel(0L, "000", "Sky diving experience", 1500.0f, 1));
		orders.add(new OrderModel(1L, "001", "Sky diving experiencel", 1500.0f, 1));
		orders.add(new OrderModel(2L, "002", "Sky diving experience43", 1500.0f, 1));
		orders.add(new OrderModel(3L, "003", "Sky diving experience21", 1500.0f, 1));
		orders.add(new OrderModel(4L, "004", "Sky diving experience32", 1500.0f, 1));
		orders.add(new OrderModel(5L, "005", "Sky diving experience23", 1500.0f, 1));
		orders.add(new OrderModel(6L, "006", "Sky diving experience34", 1500.0f, 1));
	}

	@Override
	public OrderModel getById(long id) {

		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getId() == id) {
				return orders.get(i);
			}
		}
		
		return null;
	}

	@Override
	public List<OrderModel> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		// TODO Auto-generated method stub
		
//		List<OrderModel> foundItems = new ArrayList<OrderModel>();
//		
//		for(int i = 0; i < orders.size(); i++) {
//			if(orders.get(i).getProductName().toLowerCase().contains(searchTerm)) {
//				foundItems.add(orders.get(i));
//			}
//		}
//		
//		return foundItems;
		
		List<OrderModel> foundItems = orders
				.stream()
				.filter(order -> order.getProductName().toLowerCase()
						.contains(searchTerm.toLowerCase()))
				.collect(Collectors.toList());
		
		return foundItems;
		
	}

	@Override
	public long addOne(OrderModel newOrder) {
		// TODO Auto-generated method stub
		boolean success = orders.add(newOrder);
		
		if(success) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean deleteOne(long id) {
		// TODO Auto-generated method stub
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getId() == id) {
				orders.remove(i);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getId() == idToUpdate) {
				orders.set(i,  updateOrder);
				return orders.get(i);
			}
		}
		
		return null;
	}

}
