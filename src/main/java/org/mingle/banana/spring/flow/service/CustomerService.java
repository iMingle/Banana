package org.mingle.banana.spring.flow.service;

import org.mingle.banana.spring.flow.domain.Customer;

public interface CustomerService {
	Customer lookupCustomer(String phoneNumber)
			throws CustomerNotFoundException;
}