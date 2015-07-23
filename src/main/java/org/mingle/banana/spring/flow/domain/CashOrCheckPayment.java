package org.mingle.banana.spring.flow.domain;

public class CashOrCheckPayment extends Payment {
	private static final long serialVersionUID = 1L;

	public CashOrCheckPayment() {
	}

	public String toString() {
		return "CASH or CHECK:  $" + getAmount();
	}
}
