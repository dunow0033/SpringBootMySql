package com.brian.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import com.brian.models.*;

import com.brian.models.OrderModel;

@Repository
public class OrdersDataService implements OrdersDataAccessInterface {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public OrderModel getById(long id) {
		List<OrderModel> results = jdbcTemplate.query("SELECT * FROM ORDERS WHERE ID = ?",
				new OrdersMapper(), id);
		
		if(results.size() > 0)
			return results.get(0);
		else
			return null;
	}

	@Override
	public List<OrderModel> getOrders() {
		List<OrderModel> results = jdbcTemplate.query("SELECT * FROM ORDERS", new OrdersMapper());
		
		return results;
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long addOne(OrderModel newOrder) {
//		long result = jdbcTemplate.update("INSERT INTO ORDERS (ORDER_NUMBER, PRODUCT_NAME, PRICE, QUANTITY) VALUES (?, ?, ?, ?)",
//				newOrder.getOrderNo(),
//				newOrder.getProductName(),
//				newOrder.getPrice(),
//				newOrder.getQuantity()
//				);
//		
//		return result;
		
		SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(jdbcTemplate);
		
		simpleInsert.withTableName("ORDERS").usingGeneratedKeyColumns("ID");
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("ORDER_NUMBER", newOrder.getOrderNo());
		parameters.put("PRODUCT_NAME", newOrder.getProductName());
		parameters.put("PRICE", newOrder.getPrice());
		parameters.put("QUANTITY", newOrder.getQuantity());
		
		Number result = simpleInsert.executeAndReturnKey(parameters);
		
		return result.longValue();
	}

	@Override
	public boolean deleteOne(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
