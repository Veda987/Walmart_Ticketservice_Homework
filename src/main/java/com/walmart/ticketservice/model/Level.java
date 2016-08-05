package com.walmart.ticketservice.model;

import java.util.List;

/**
 * 
 * @author Veda
 *
 *Class Level for level details.
 */
public class Level {

	/**
	 * Fields to represent the level state.
	 */
	private int levelId;
	private String levelName;
	private double price;
	private int noOfRows;
	private List<Row> rows;
	
	/**
	 * Returns an integer value that represents level id.
	 * 
	 * @return levelId the current level id.
	 */
	public int getLevelId() {
		return levelId;
	}
	
	/**
	 * Registers the id to for the level.
	 * 
	 * @param levelId
	 *            the integer to represent id of the level.
	 */
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	
	/**
	 * Returns a String value that represents name of the level.
	 * 
	 * @return levelName the current level name.
	 */
	public String getLevelName() {
		return levelName;
	}
	
	/**
	 * Registers the levelName for the level.
	 * 
	 * @param levelName
	 *            the String to represent name of the level.
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	
	/**
	 * Returns a double value that represents the price of the level.
	 * 
	 * @return price the price of the seat for the current level.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Registers the price for the seat in the level.
	 * 
	 * @param price
	 *            the double to represent price of the seat in the level.
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Returns an integer value that represents the number of rows in the level.
	 * 
	 * @return noOfRows the number of rows in the level.
	 */
	public int getNoOfRows() {
		return noOfRows;
	}
	
	/**
	 * Registers the number of rows in the level.
	 * 
	 * @param noOfRows
	 *            the integer to represent number of rows.
	 */
	public void setNoOfRows(int noOfRows) {
		this.noOfRows = noOfRows;
	}
	
	/**
	 * Returns a list of Row objects that represents the number of rows in the
	 * level.
	 * 
	 * @return rows the rows in the level.
	 */
	public List<Row> getRows() {
		return rows;
	}
	
	/**
	 * Registers the rows in the level.
	 * 
	 * @param rows
	 *            the list of rows that represent rows in the level.
	 */
	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
	
	/**
	 * Returns an integer value that represents the available seats in the
	 * level.
	 * 
	 * @return availableSeatsInEachLevel the available seats in each level.
	 */
	public int getAvailableSeatsInEachLevel() {
		int availableSeatsInEachLevel = 0;
		for(Row row : rows) {
			for(Seat seat : row.getSeats()) {
				if(!seat.isSeatHold() && !seat.isSeatReserved()){	
					availableSeatsInEachLevel++;
				}
	     	}
		}
		System.out.println(" availableSeatsInEachLevel :" +availableSeatsInEachLevel);
		return availableSeatsInEachLevel;
	}
	
}
