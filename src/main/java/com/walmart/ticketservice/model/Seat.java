package com.walmart.ticketservice.model;

/**
 * 
 * @author Veda
 *
 * Class Seat to represent seat details.
 */
public class Seat {
	
	/**
	 * Fields to store state of the seat.
	 */
	private String seatId;
	private boolean seatHold;
	private boolean seatReserved;
	
	/**
	 * Class constructor to initialize the object with the instance values.	
	 * @param seatId the String object that identifies the seat.
 	 * @param seatHold the boolean that represents flag to specify status, false specifies seat not held.
	 * @param seatReserved boolean that represents flag to specify status, false specifies seat not reserved.
	 */
	public Seat(String seatId, boolean seatHold, boolean seatReserved) {
		super();
		this.seatId = seatId;
		this.seatHold = seatHold;
		this.seatReserved = seatReserved;
	}
	
	/**
	 * Class constructor to initialize objects.
	 */
	public Seat() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Returns a String object that identifies seat with the id in the row of
	 * the level.
	 * 
	 * @return seatId the String that represents seat in the row.
	 */
	public String getSeatId() {
		return seatId;
	}
	
	/**
	 * Registers a String object that identifies a seat in the row.
	 * 
	 * @param seatId
	 *            the String to represent seat with id.
	 */
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	
	/**
	 * Registers a boolean flag on a seat to differentiate a reserved seat and a
	 * free seat.
	 * 
	 * @return seatHold the boolean to verify the flag on the seat.
	 */
	public boolean isSeatHold() {
		return seatHold;
	}
	
	/**
	 * Registers a boolean flag on a seat to distinguish a seat is free or hold.
	 * 
	 * @param seatHold
	 *            the boolean to set the status on the seat.
	 */
	public void setSeatHold(boolean seatHold) {
		this.seatHold = seatHold;
	}
	
	/**
	 * Registers a boolean that verifies the seat reserve status.
	 * 
	 * @return seatReserved the boolean to check status of the seat.
	 */
	public boolean isSeatReserved() {
		return seatReserved;
	}
	
	/**
	 * Registers a boolean that sets the status of the seat.
	 * 
	 * @param seatReserved the boolean to set the reservation status of the seat.
	 */
	public void setSeatReserved(boolean seatReserved) {
		this.seatReserved = seatReserved;
	}
	

	

}
