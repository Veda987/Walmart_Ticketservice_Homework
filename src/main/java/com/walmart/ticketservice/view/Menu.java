package com.walmart.ticketservice.view;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Veda
 * 
 * Class Menu to represent menu details.
 *
 */
public class Menu {
	
	/**
	 * Field to store state of the menu object.
	 */
	private HashMap<Integer, List<String>> customerActionMenu;

	/**
	 * Returns a HashMap that represents customer actions.
	 * @return customerActionMenu the HashMap object that represents the customer action menu.
	 */
	public HashMap<Integer, List<String>> getCustomerActionMenu() {
		return customerActionMenu;
	}

	/**
	 * Register a HashMap that represents customer actions.
	 * 
	 * @param customerActionMenu the HashMap that shows the menu to the customer to make selection.
	 */
	public void setCustomerActionMenu(HashMap<Integer, List<String>> customerActionMenu) {
		this.customerActionMenu = customerActionMenu;
	}

	

}
