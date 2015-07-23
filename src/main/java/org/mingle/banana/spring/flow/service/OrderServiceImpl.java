package org.mingle.banana.spring.flow.service;

import org.mingle.banana.spring.flow.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderServiceImpl {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OrderServiceImpl.class);

	public OrderServiceImpl() {
	}

	public void saveOrder(Order order) {
		LOGGER.debug("SAVING ORDER:  ");
		LOGGER.debug("   Customer:  " + order.getCustomer().getName());
		LOGGER.debug("   # of Pizzas:  " + order.getPizzas().size());
		LOGGER.debug("   Payment:  " + order.getPayment());
	}
}
