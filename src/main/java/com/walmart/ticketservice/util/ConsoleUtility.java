package com.walmart.ticketservice.util;

/**
 * 
 * @author Veda
 * 
 *Class ConsoleUtility to clear the screen.
 */
public class ConsoleUtility {

	/**
	 * the method to clear the screen.
	 */
	public static void clearScreen() {  
		System.out.print("\033[H\033[2J");
	   } 
}
