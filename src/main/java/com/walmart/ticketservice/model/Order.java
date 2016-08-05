package com.walmart.ticketservice.model;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Veda
 * 
 * Class Order to specify order details.
 */
public class Order {
	
	/**
	 * Fields to store state of the order.
	 */
	private int orderId;
	private Customer customer;
	private int levelId;
	private int numberOfSeats;
	private double orderAmount;
	private List<Seat> seatsHolded;
	private List<Seat> seatsReserved;
	private boolean orderExpiration; 
	
	/**
	 * Returns an integer that represents order id.
	 * 
	 * @return orderId the current order id.
	 */
	public int getOrderId() {
		return orderId;
	}
	
	/**
	 * Registers the id to the order.
	 * 
	 * @param orderId the integer to represent id of the order.
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * Returns an integer that represents level id.
	 * 
	 * @return levelId the current level id.
	 */
	public int getLevelId() {
		return levelId;
	}
	
	/**
	 * Returns a list of Seat object that represents seats holded.
	 * 
	 * @return seatsHolded the seats holded for the order.
	 */
	public List<Seat> getSeatsHolded() {
		return seatsHolded;
	}
	
	/**
	 * Registers the List of Seat object to represent seats holded for the order.
	 * 
	 * @param seatsHolded the List to represent seats holded for the order.
	 */
	public void setSeatsHolded(List<Seat> seatsHolded) {
		this.seatsHolded = seatsHolded;
	}
	
	/**
	 * Registers the integer to represent id for the level.
	 * 
	 * @param levelId the integer to represent levelId for the order.
	 */
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	
	/**
	 * Returns an integer that represents number of seats.
	 * 
	 * @return numberOfSeats the number of seats selected by customer for the order.
	 */
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	
	/**
	 * Registers an integer to represent number of seats to reserve or to hold in the level.
	 * 
	 * @param numberOfSeats the integer to represent number of seats required by the customer for the order.
	 */
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
	/**
	 * Returns a double that represents order total.
	 * 
	 * @return orderAmount the amount of the order.
	 */
	public double getOrderAmount() {
		return orderAmount;
	}
	
	/**
	 * Registers a double to represent the amount of the order.
	 * 
	 * @param orderAmount the double to represent the order total amount.
	 */
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	/**
	 * Returns a list of seats that represents the seats reserved.
	 * 
	 * @return seatsReserved the seats reserved for the current order.
	 */
	public List<Seat> getSeatsReserved() {
		return seatsReserved;
	}
	
	/**
	 * Registers a List of Seat objects to represent the seats reserved for the order.
	 * 
	 * @param seatsReserved the list to represent the seats reserved for the customer order.
	 */
	public void setSeatsReserved(List<Seat> seatsReserved) {
		this.seatsReserved = seatsReserved;
	}
	
	/**
	 * Returns a customer object that represents the customer.
	 * 
	 * @return customer the customer for the current transaction.
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * Registers a customer object for the order.
	 * 
	 * @param customer the customer object to represent the customer details.
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}	
	
	/**
	 * The method to generate unique order id for the order.
	 * This method generates a unique id for the order with current date and the seqId.
	 * 
	 * @param seqId the id to represent the order.	 
	 */
	public void generateOrderId (int seqId) {
		Format formatter = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		orderId = Integer.parseInt(formatter.format(date)+Integer.toString(seqId));
		//System.out.println(" orderId : "+ orderId);
	}
	
	/**
	 * Returns a boolean that represents the order expiration status.
	 * 
	 * @return orderExpiration the boolean that tells the status as false if the order expired true if the order is active.
	 */
	public boolean isOrderExpired() {
		return orderExpiration;
	}
	
	/**
	 * Registers a boolean to represents order expiration status.
	 * 
	 * @param orderExpiration the boolean to sets to true if the order is active and false if the order is expired.
	 */
	public void setOrderExpiration(boolean orderExpiration) {
		this.orderExpiration = orderExpiration;
	}
	
}
