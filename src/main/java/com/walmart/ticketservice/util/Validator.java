package com.walmart.ticketservice.util;

/**
 * 
 * @author Veda
 * 
 *Class Validator to validate the customer email. 
 */
public class Validator {
	
	/**
	 * The method to validate the email provided by the customer.
	 * @param email the String email provided by the customer.
	 * @return the boolean that says whether the email is valid or not.
	 */
	public static boolean isValidEmailAddress(String email) {
          String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
          java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(ePattern);
          java.util.regex.Matcher matcher = pattern.matcher(email);
          return matcher.matches();
   }
}
