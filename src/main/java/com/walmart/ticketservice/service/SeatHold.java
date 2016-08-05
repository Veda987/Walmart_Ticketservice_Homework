package com.walmart.ticketservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.walmart.ticketservice.model.Customer;
import com.walmart.ticketservice.model.Level;
import com.walmart.ticketservice.model.Order;
import com.walmart.ticketservice.model.Row;
import com.walmart.ticketservice.model.Seat;
import com.walmart.ticketservice.model.Venue;
import com.walmart.ticketservice.util.WalMartException;

/**
 * 
 * @author Veda
 * 
 *Class SeatHold to hold seat.
 */
public class SeatHold {
	
	/**
	 * Fields to store state of SeatHold object.
	 */
	private int seatHoldId;
	private int levelId;
	private List<Seat> seatsHolded = new ArrayList<Seat>();
	WalMartException we;
	
	/**
	 * Class constructor for initializing the SeatHold object with the provided instance values.
	 * @param seatHoldId the integer that identifies the seat hold.
	 * @param seatsHolded the List that represents the seats held.
	 */
	public SeatHold(int seatHoldId, List<Seat> seatsHolded) {
		super();
		this.seatHoldId = seatHoldId;
		this.seatsHolded = seatsHolded;
	}

	/**
	 * Class Constructor to initialize SeatHold object.
	 */
	public SeatHold() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This method is holds the seats from the information provided by the parameters.
	 * 
	 * @param venue the Venue object that represents the venue details.
	 * @param minLevel the Optional integer to represent minimum level opted by the customer.
	 * @param maxLevel the Optional integer to represent maximum level opted by the customer.
	 * @param noOfseatforHolding the integer value that represents number of seats the customer want to hold.
	 * @param cutomerEmail the String that represents the customer email.
	 */
	public void holdSeats(Venue venue, Optional<Integer> minLevel,
			      Optional<Integer> maxLevel,int noOfseatforHolding, String cutomerEmail ) {
		try {
			String firstSeatId = null;
			List<Integer> venueLevels = new ArrayList<Integer>();
			Level level = new Level();
			Customer customer = new Customer();
			int seatHoldedSize =0;
			if (minLevel.isPresent() && maxLevel.isPresent()){
				for (int i = minLevel.get(); i <maxLevel.get()+1;i++) {
					venueLevels.add(i);
			}
			}else if(minLevel.isPresent() && !maxLevel.isPresent()) {
				venueLevels.add(minLevel.get());
			} else if (!minLevel.isPresent() && maxLevel.isPresent()) {
				venueLevels.add(maxLevel.get());
			}else{
				for( int i=0;i< venue.getVenueDetails().size();i++) {
					venueLevels.add(i);
				}
			}		
			outerloop:
			for (int venueLevel : venueLevels) {
				if(venueLevel > 0 ){
					level = venue.getLevelDetails(venueLevel);
					if (level != null) {		
						if(level.getAvailableSeatsInEachLevel() >= noOfseatforHolding) {
							for (Row row : level.getRows()) {
								for(Seat seat : row.getSeats()) {
									if(!seat.isSeatHold() && !seat.isSeatReserved()){
										if(firstSeatId == null) {
											firstSeatId = seat.getSeatId(); 
										}
										seat.setSeatHold(true);
					                    seatsHolded.add(seat);
					                    if(seatsHolded.size() == noOfseatforHolding) {
					                    	seatHoldedSize = seatsHolded.size();
					                    	break outerloop;	
					                    }
									}
								}
							}
					}		
					}
			}
			}	
			if (seatHoldedSize == noOfseatforHolding) {
				Order order = new Order();
				order.generateOrderId(venue.generateSeqId());
				seatHoldId = order.getOrderId();
				order.setLevelId(level.getLevelId());
				setLevelId(level.getLevelId());
				customer.setCustomerId(cutomerEmail);
				customer.setCustomerEmail(cutomerEmail);
				order.setNumberOfSeats(noOfseatforHolding);
				order.setCustomer(customer);
				order.setSeatsHolded(seatsHolded);	
				order.setOrderExpiration(false);
				venue.setVenueOrders(order);
			}else if(level == null){
				System.out.println("You May Have Entered Wrong Level ID.");
				
			}else{
				System.out.println("Requested Number of Tickets are not Available at any Level for Holding.");
			}
		} catch (Exception e) {
			new WalMartException("-1", e);
		}
	}
	
	/**
	 * Returns an integer identification number for the seats held by the customer.
	 * 
	 * @return seatHoldId the integer that represents the seat hold id.
	 */
	public List<Seat> getSeatsHolded() {
		return seatsHolded;
	}

	/**
	 * Registers an integer identification number for the seats held by the customer.
	 * 
	 * @param seatHoldId the integer to represent identification for the seats held.
	 */
	public void setSeatsHolded(List<Seat> seatsHolded) {
		this.seatsHolded = seatsHolded;
	}

	/**
	 * Returns an integer to identify the seats held.
	 * 
	 * @return seatHoldId the integer that represents the identification number for the seats held.
 	 */
	public int getSeatHoldId() {
		return seatHoldId;
	}

	/**
	 * Registers an integer to identify the seats held.
	 * 
	 * @param seatHoldId the integer that sets the identification number for the seats held.
	 */
	public void setSeatHoldId(int seatHoldId) {
		this.seatHoldId = seatHoldId;
	}

	/**
	 * Returns an integer to identify the level.
	 * 
	 * @return levelId the integer the represents the identification of the level.
	 */
	public int getLevelId() {
		return levelId;
	}

	/**
	 * Registers an integer that identify the level.
	 * 
	 * @param levelId the integer the sets the identification of the level.
	 */
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	
}
