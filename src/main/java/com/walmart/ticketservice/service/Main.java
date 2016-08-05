package com.walmart.ticketservice.service;

import com.walmart.ticketservice.view.CustomerView;

/**
 * 
 * @author Veda
 * 
 * Class Main with main method which is the starting point for the application.
 *
 */
public class Main {

	/**
	 * The Method that takes Array of String elements to respond to command line arguments.
	 * 
	 * @param args the Array of String objects.
	 */
	public static void main(String[] args) {
		CustomerView customerView = new CustomerView();
		customerView.customerAction(0);
	}
}
