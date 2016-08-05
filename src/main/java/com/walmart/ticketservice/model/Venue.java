package com.walmart.ticketservice.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Veda
 *
 *Class that represents venue details.
 */
public class Venue {

	/**
	 * Fields to store state of the Venue.
	 */
	private int seqId = 0;
	private HashMap<Integer, Level> venueDetails;
	private List<Order> venueOrders = new ArrayList<Order>();
	private int seatHoldTime;

	/**
	 * Class constructor with a parameter.
	 * 
	 * @param venueDetails the HashMap that initializes the venue object.
	 */
	public Venue(HashMap<Integer, Level> venueDetails) {
		super();
		this.venueDetails = venueDetails;
	}

	/**
	 * Class constructor.
	 */
	public Venue() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns a HashMap that represent an integer value for the level.
	 * 
	 * @return venueDetails the HashMap that holds integer keys and Level values.
	 */
	public HashMap<Integer, Level> getVenueDetails() {
		return venueDetails;
	}

	/**
	 * Registers a HashMap that holds integer keys to point for Level objects.
	 * 
	 * @param venueDetails the HashMap that holds integer values as keys and points to Level objects.
	 */
	public void setVenueDetails(HashMap<Integer, Level> venueDetails) {
		this.venueDetails = venueDetails;
	}

	/**
	 * Returns an integer id to represent the level.
	 * This method returns the level details of the level identified by the levelId passed.
	 * 
	 * @param levelID the integer id that is passed to get the level object.
	 * @return level the Level object that represents the level details.
	 */
	public Level getLevelDetails(Integer levelID) {
		Level level = new Level();
		level = venueDetails.get(levelID);
		return level;
	}

	/**
	 * Returns an integer id that is used to identify the sequence.
	 * The method returns a sequential identifier.
	 * 
	 * @return seqId the integer that represents the sequential id.
	 */
	public int generateSeqId() {
		seqId++;
		return seqId;
	}

	/**
	 * Returns a List of Order objects.
	 * 
	 * @return venueOrders the List of Order objects that represents the orders.
	 */
	public List<Order> getVenueOrders() {
		return venueOrders;
	}

	/**
	 * Registers an Order object for the venue.
	 * 
	 * @param order the Order object the contains order details of the venue.
	 */
	public void setVenueOrders(Order order) {
		venueOrders.add(order);
	}

	/**
	 * Returns an integer that represents the time to held the seats.
	 * 
	 * @return seatHoldTime the integer that represents the allowed time on the seats for hold.
	 */
	public int getSeatHoldTime() {
		return seatHoldTime;
	}

	/**
	 * Registers an integer to specify time to hold the seats.
	 * 
	 * @param seatHoldTime the integer that represents the time allowed on the seat in hold state.
	 */
	public void setSeatHoldTime(int seatHoldTime) {
		this.seatHoldTime = seatHoldTime;
	}

}
