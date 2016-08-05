package com.walmart.ticketservice.model;

/**
 * 
 * @author Veda 
 * 
 * Class Customer specifying customer details.
 *
 */
public class Customer {
	
	/**
	 * The fields to represent the customer id and email.
	 */
	private String customerId;
	private String customerEmail;
	
	/**
	 * Returns a String object that represents customer id.
	 * 
	 * @return customerId the current customer id.
	 */
	public String getCustomerId() {
		return customerId;
	}
	
	/**
	 * Registers the id to the customer.
	 * 
	 * @param customerId the String to represent id of the customer.
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	/**
	 * Returns a String object that represents customer email.
	 * 
	 * @return the current customer email.
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	/**
	 * Registers the email to for the customer.
	 * 
	 * @param customerEmail
	 *            the email of the customer.
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

}
