package com.walmart.ticketservice.model;

import java.util.List;

/**
 * 
 * @author Veda
 *
 *Class row that represents row details.
 */
public class Row {
	
	/**
	 * The fields to store the state of row object.
	 */
	private String rowId;
	private List<Seat> Seats;
	private int totalSeats;
	private int availableSeatsInEachRow;
	
	/**
	 * Returns a String object to represent row id.
	 * 
	 * @return rowId the id to represent row in the level.
	 */
	public String getRowId() {
		return rowId;
	}
	
	/**
	 * Registers a String that represents the row id.
	 * 
	 * @param rowId
	 *            the String that identifies the row with an id.
	 */
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	/**
	 * Returns a List of seat objects to represent seats in the row.
	 * 
	 * @return seats the list of seats to represent seats in the row.
	 */
	public List<Seat> getSeats() {
		return Seats;
	}
	
	/**
	 * Registers a list of Seat objects that represents the seats in the row.
	 * 
	 * @param seats
	 *            the list of seats that identifies the seats in the row.
	 */
	public void setSeats(List<Seat> seats) {
		Seats = seats;
	}
	
	/**
	 * Returns an integer to represent total seats in the row.
	 * 
	 * @return totalSeats the integer to represent total seats in the row.
	 */
	public int getTotalSeats() {
		return totalSeats;
	}
	
	/**
	 * Registers an integer that represents total seats in the row.
	 * 
	 * @param totalSeats
	 *            the integer that represents total seats in the row.
	 */
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	
	/**
	 * Returns an integer that represents available seats in each row.
	 * 
	 * @return availableSeatsInEachRow the integer to represent available seats
	 *         in each row.
	 */
	public int getAvailableSeatsInEachRow() {
		for(Seat seat : Seats) {
			if(!seat.isSeatHold() && !seat.isSeatReserved()){
				availableSeatsInEachRow++;
			}
		};
		return availableSeatsInEachRow;	
	}
	
	/**
	 * Registers an integer that represents available seats in each row.
	 * 
	 * @param availableSeatsInEachRow
	 *            the integer that represents available seats in each row.
	 */
	public void setAvailableSeatsInEachRow(int availableSeatsInEachRow) {
		this.availableSeatsInEachRow = availableSeatsInEachRow;
	}

}
