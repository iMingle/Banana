package org.mingle.banana.spring.flow.service;

import org.mingle.banana.spring.flow.domain.Order;

public interface PricingEngine {
	public float calculateOrderTotal(Order order);
}
