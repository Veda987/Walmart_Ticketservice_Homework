package com.walmart.ticketservice.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.walmart.ticketservice.model.Level;
import com.walmart.ticketservice.model.Row;
import com.walmart.ticketservice.model.Seat;
import com.walmart.ticketservice.model.Venue;

/**
 * 
 * @author Veda
 * 
 * Class LoadVenueProperties that venue details from the properties file.
 *
 */
public final class LoadVenueProperties {

	/**
	 * Returns a Venue object that represents the venue details.
	 * The method returns the venue object by populating its fields by the information in properties file.
	 * 
	 * @return Venue the venue object that represents venue detail.
	 */
	public static Venue loadVenuDetails() {
		try {
			Venue venue = new Venue();
			HashMap<Integer, Level> venueDetails = new HashMap<Integer, Level>();
			int numberOfLevels = Integer.parseInt(PropertyReader
					.fnGetValue("NO_OF_LEVELS"));
			for (int i = 0; i < numberOfLevels; i++) {
				Level level = new Level();
				level.setLevelId(Integer.parseInt(PropertyReader
						.fnGetValue("LEVEL_" + Integer.toString(i+1) + ".id")));
				//System.out.println(level.getLevelId());
				level.setLevelName(PropertyReader.fnGetValue("LEVEL_" + Integer.toString(i+1) + ".name"));
				//System.out.println(level.getLevelName());
				level.setPrice(Double.parseDouble(PropertyReader
						.fnGetValue("LEVEL_" +Integer.toString(i+1)+ ".price")));
				//System.out.println(level.getPrice());
				level.setRows(setRows(
						Integer.parseInt(PropertyReader.fnGetValue("LEVEL_" + Integer.toString(i+1)+ ".rows")),
						Integer.parseInt(PropertyReader.fnGetValue("LEVEL_" + Integer.toString(i+1) + ".seatsInRow"))));
				venueDetails.put(level.getLevelId(), level);
			}
			venue.setVenueDetails(venueDetails);
			venue.setSeatHoldTime(Integer.parseInt(PropertyReader.fnGetValue("SEAT_HOLD_TIME")));
			return venue;
		} catch (Exception e1) {
			// resultLog.error(PropertyReader.stackTraceToString(e1));
			return null;
		}

	}

	/**
	 * The method returns a list of Seat objects that represents the seats in the row.
	 *  
	 * @param noOfSeats the integer that represents the number of seats required by the customer.
	 * @param rowId the String that represents the identification of the row.
	 * @return Seats the List of seat object that represents seats held for the customer.
	 */
	public static List<Seat> setSeats(int noOfSeats, String rowId) {
		List<Seat> seats = new ArrayList<Seat>();
		try {
			for (int i = 0; i < noOfSeats; i++) {
				Seat seat = new Seat();
				seat.setSeatId(rowId + Integer.toString(i + 1));
				seat.setSeatHold(false);
				seat.setSeatReserved(false);
				seats.add(seat);
			}
			return seats;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * The method that holds the specified number of rows.
	 * 
	 * @param noOfRows the integer that represents number of rows.
	 * @param totalSeats the integer that represents total number of seats.
	 * @return rows the list of row object that represents the row details.
	 */
	public static List<Row> setRows(int noOfRows, int totalSeats) {

		List<Row> rows = new ArrayList<Row>();
		try {
			String rowId = null;
			int counter = 0;
			boolean iterator = false;
			char firstAlphabet = '\u0000';
			if (noOfRows > 0) {
				iterator = true;
			}
			while (iterator) {
				if (firstAlphabet != '\u0000' && String.valueOf(firstAlphabet) != null) {
					firstAlphabet++;
				}
				for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
					if (rowId == null || (rowId.length() == 1 && !rowId.equals("Z"))) {
						rowId = String.valueOf(alphabet);
					} else {
						if (firstAlphabet == '\u0000') {
							firstAlphabet = alphabet;		
						}
						if (String.valueOf(firstAlphabet) == null) {
							rowId = String.valueOf(alphabet);
						}else{
							rowId = String.valueOf(firstAlphabet) + String.valueOf(alphabet);
						}
					}
				//	System.out.println(" rowId : " + rowId);
					Row row = new Row();
					row.setRowId(rowId);
					row.setTotalSeats(totalSeats);
					row.setAvailableSeatsInEachRow(totalSeats);
					row.setSeats(setSeats(totalSeats, rowId));
					rows.add(row);
					counter++;
					if (counter == noOfRows) {
						iterator = false;
						break;
					}
				}
			}
			return rows;
		} catch (Exception e) {
			return null;
		}
		
	}
}
