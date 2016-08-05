package com.walmart.ticketservice.view;

/**
 * 
 * @author Veda
 *
 *Class Messages to display proper messages.
 */
public class Messages {
	public static String newLine ="\n";
	public static String appendSpace ="   ";
	public static String welcome ="Welcome to Wal-Mart Ticket Service";
	public static String customerInput ="Customer Input: "+Messages.newLine;
	public static String invalidInput ="Invalid Customer Input. Please Re-Enter a valid Input.";
	public static String seatsResevationSuccess ="Your Seats are Reserved Successfully.!";
	public static String holdSeatSuccess =Messages.appendSpace+"The Following Seats Are On Hold for You to Reserve On Level[";
	public static String inputseatHoldId ="Enter Your Seat Hold ID :";
	public static String inputEmail ="Enter Customer Email :";
	public static String confirmSeatHoldId =Messages.appendSpace+"Seat Hold Confirmation ID : ";
	public static String confirmOrderNo ="Order Confirmaiton No Is : ";
	public static String numSeats ="Enter No of Seats to Hold :";
	public static String minLevel ="Enter Minimum Level :";
	public static String maxLevel ="Enter Maximum Level :";
	public static String customerEmail ="Enter Customer Email :";
	public static String inCorrectEmailFormat ="In-Correct Email Format.Please Re-Enter:";
	public static String inCorrectEmail ="In-Correct Email.Please Re-Enter:";
	public static String inCorrectSeatHoldId ="In Correct SeatHold ID.Please Re-Enter:";
	public static String orderExpired ="Sorry, Your Order Has Been Expired.";
	public static String allLevels =Messages.appendSpace+"Enter [5] to View Available Seats in All Levels.";
	public static String wrongOrder ="No Orders Found With Your OrderID and Email. Please Start your Search Again.";
}
