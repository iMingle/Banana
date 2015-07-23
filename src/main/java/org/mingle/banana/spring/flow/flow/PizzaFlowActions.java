package org.mingle.banana.spring.flow.flow;

import static org.mingle.banana.spring.flow.domain.PaymentType.CREDIT_CARD;

import org.mingle.banana.spring.flow.domain.CashOrCheckPayment;
import org.mingle.banana.spring.flow.domain.CreditCardPayment;
import org.mingle.banana.spring.flow.domain.Customer;
import org.mingle.banana.spring.flow.domain.Order;
import org.mingle.banana.spring.flow.domain.Payment;
import org.mingle.banana.spring.flow.domain.PaymentDetails;
import org.mingle.banana.spring.flow.service.CustomerNotFoundException;
import org.mingle.banana.spring.flow.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PizzaFlowActions {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PizzaFlowActions.class);

	public Customer lookupCustomer(String phoneNumber)
			throws CustomerNotFoundException {
		Customer customer = customerService.lookupCustomer(phoneNumber);
		if (customer != null) {
			return customer;
		} else {
			throw new CustomerNotFoundException();
		}
	}

	public void addCustomer(Customer customer) {
		LOGGER.warn("TODO: Flesh out the addCustomer() method.");
	}

	public Payment verifyPayment(PaymentDetails paymentDetails) {
		Payment payment = null;
		if (paymentDetails.getPaymentType() == CREDIT_CARD) {
			payment = new CreditCardPayment();
		} else {
			payment = new CashOrCheckPayment();
		}

		return payment;
	}

	public void saveOrder(Order order) {
		LOGGER.warn("TODO: Flesh out the saveOrder() method.");
	}

	public boolean checkDeliveryArea(String zipCode) {
		LOGGER.warn("TODO: Flesh out the checkDeliveryArea() method.");
		return "75075".equals(zipCode);
	}

	@Autowired
	CustomerService customerService;
}
