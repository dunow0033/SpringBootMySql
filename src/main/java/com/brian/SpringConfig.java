package com.brian;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.brian.services.OrdersBusinessService;
import com.brian.services.OrdersBusinessServiceInterface;
import com.brian.data.OrdersDataAccessInterface;
import com.brian.data.*;

@Configuration
public class SpringConfig {
	
	@Bean(name="ordersBusinessService", initMethod = "init", destroyMethod = "destroy")
	@RequestScope
	public OrdersBusinessServiceInterface getOrdersBusiness() {
		return new OrdersBusinessService();
	}
	
	@Bean(name="ordersDAO")
	@RequestScope
	public OrdersDataAccessInterface getDataService() {
		return new OrdersDataService();
	}
}
