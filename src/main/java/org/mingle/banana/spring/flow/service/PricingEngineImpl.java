package org.mingle.banana.spring.flow.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.mingle.banana.spring.flow.domain.Order;
import org.mingle.banana.spring.flow.domain.Pizza;
import org.mingle.banana.spring.flow.domain.PizzaSize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class PricingEngineImpl implements PricingEngine, Serializable {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PricingEngineImpl.class);

	private static Map<PizzaSize, Float> SIZE_PRICES;
	static {
		SIZE_PRICES = new HashMap<PizzaSize, Float>();
		SIZE_PRICES.put(PizzaSize.SMALL, 6.99f);
		SIZE_PRICES.put(PizzaSize.MEDIUM, 7.99f);
		SIZE_PRICES.put(PizzaSize.LARGE, 8.99f);
		SIZE_PRICES.put(PizzaSize.GINORMOUS, 9.99f);
	}
	private static float PRICE_PER_TOPPING = 0.20f;

	public PricingEngineImpl() {
	}

	public float calculateOrderTotal(Order order) {
		LOGGER.debug("Calculating order total");

		float total = 0.0f;

		for (Pizza pizza : order.getPizzas()) {
			float pizzaPrice = SIZE_PRICES.get(pizza.getSize());
			if (pizza.getToppings().size() > 2) {
				pizzaPrice += (pizza.getToppings().size() * PRICE_PER_TOPPING);
			}
			total += pizzaPrice;
		}

		return total;
	}
}
