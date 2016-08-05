package com.walmart.ticketservice.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.walmart.ticketservice.model.Level;
import com.walmart.ticketservice.model.Venue;

/**
 * 
 * @author Veda
 * 
 *Class ConfigureCustomerMenu to configure the customer view details.
 *
 */
public class ConfigureCustomerMenu {

	/**
	 * Field to store state of the class.
	 */
	HashMap<Integer, List<String>> customerSelectionMenu = new HashMap<Integer, List<String>>();
	
	/**
	 * The method provides the menu for the customer to make a selection from
	 * the options provided to check for available seats, to hold seats, and to
	 * reserve seats in particular row.
	 */
	public void CustomerSelectionMenu() {

		List<String> subMenu = new ArrayList<String>();
		subMenu.add("Enter : [1] for Available Seats, [2] for Holding Seats, [3] for Reservation, [4] for Exit.");
		customerSelectionMenu.put(0, subMenu);
		
		List<String> subMenu1 = new ArrayList<String>();
		subMenu1.add("Enter : [2] for Holding Seats, [3] for Reservation, [4] for Exit.");
		customerSelectionMenu.put(1, subMenu1);
		
		List<String> subMenu2 = new ArrayList<String>();
		subMenu2.add("Enter : [3] for Reservation, [4] for Exit.");
		customerSelectionMenu.put(2, subMenu2);
		
		List<String> subMenu3 = new ArrayList<String>();
		subMenu3.add("Thank You! Visit Again.");
		customerSelectionMenu.put(4, subMenu3);
		
	}
	
	/**
	 * Returns a HashMap that represents customer selection menu.
	 * 
	 * @return customerSelectionMenu the HashMap that represents the customer
	 *         selection details.
	 */
	public HashMap<Integer, List<String>> getCustomerSelectionMenu() {
		return customerSelectionMenu;
	}

	/**
	 * Register a HashMap that represents customer selection menu.
	 * 
	 * @param customerSelectionMenu
	 *            the HashMap that provides the menu selection made by the
	 *            customer.
	 */
	public void setCustomerSelectionMenu(HashMap<Integer, List<String>> customerSelectionMenu) {
		this.customerSelectionMenu = customerSelectionMenu;
	}

	/**
	 * the method that loads the customer selection details.
	 * 
	 * @param customerInput
	 *            the integer that represents the customer input.
	 */
	public void loadCustomerSelectionMenu( int customerInput) {
		
		List<String> subMenu = customerSelectionMenu.get(customerInput);	
		for (String menuOption : subMenu) {
			System.out.println(menuOption);
			
		}
	}
	
	/**
	 * The method to show all the venue levels.
	 * @param venue the venue object tha represents the venue details.
	 */
	public void viewAllVenueLevel( Venue venue) {	
		HashMap<Integer, Level> venuDetails = venue.getVenueDetails();
		for(int i : venuDetails.keySet()) {
			Level level = venuDetails.get(i);
			System.out.println(Messages.appendSpace+"Enter ["+i+"] to View Available Seats in "+level.getLevelName());		
		}
		
		
		
	}
}
