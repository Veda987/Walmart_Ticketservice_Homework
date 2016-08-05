package com.walmart.ticketservice.service;

import java.util.Timer;
import java.util.TimerTask;

import com.walmart.ticketservice.model.Order;
import com.walmart.ticketservice.model.Seat;
import com.walmart.ticketservice.model.Venue;
import com.walmart.ticketservice.util.WalMartException;
import com.walmart.ticketservice.view.Messages;

/**
 * 
 * @author Veda
 *
 *Class CurrentOrder that helps to create currentOrder objects.
 */
public class CurrentOrder {
	
	/**
	 * Fields to store state of the instance for the class. 
	 */
	WalMartException we;
	Timer timer;
	private Venue venue;
	private String customerEmail;
	private int seatHoldId;
	private boolean timerCancelFlag = false;

	/**
	 * Returns a Venue object that represents venue details.
	 * 
	 * @return venue the Venue object that has the venue details.
	 */
	public Venue getVenue() {
		return venue;
	}

	/**
	 * Registers  venue object to represent venue details.
	 * 
	 * @param venue the venue object to store the venue details.
	 */
	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	/**
	 * Returns a String object that represents the customer email.
	 * 
	 * @return customerEmail the String that gives the customer email.
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * Registers a String object that represents the customer email.
	 * 
	 * @param customerEmail the String that sets the customer email. 
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * Returns an integer that identifies the seats held.
	 * 
	 * @return seatHoldId the integer that identifies the seats holded.
	 */
	public int getSeatHoldId() {
		return seatHoldId;
	}

	/**
	 * Registers an integer that identifies the seats held.
	 * 
	 * @param seatHoldId the integer that sets  identification for the seats.
	 */
	public void setSeatHoldId(int seatHoldId) {
		this.seatHoldId = seatHoldId;
	}

	/**
	 * Class constructor to initialize the objects.
	 * 
	 * @param venue the venue object that represents venue details.
	 * @param seatHoldId the integer that represents the identification for the seats held.
	 * @param customerEmail the String that represents the email of the customer.
	 */
	public CurrentOrder(Venue venue, int seatHoldId, String customerEmail) {
		this.venue = venue;
		this.seatHoldId = seatHoldId;
		this.customerEmail = customerEmail;
		timer = new Timer();
		timer.schedule(new CancelSeatHolding(), venue.getSeatHoldTime()*1000);
	}

	/**
	 * Class Constructor to initialize objects.
	 */
	public CurrentOrder() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @author Veda
	 *
	 *Class CancelSeatHolding to cancel seats held after 60 seconds.
	 */
	class CancelSeatHolding extends TimerTask {
	public void run() {
		timer.cancel();
		if(!timerCancelFlag){
			try {
				int orderId = 0;
				int orderIndex = 0;
				int seatIndex = 0;
				for (Order order : venue.getVenueOrders()) {
					orderIndex++;
					if (order.getCustomer().getCustomerEmail()
							.equals(customerEmail)) {
						orderId = order.getOrderId();
						if (seatHoldId == orderId) {
							for (Seat seat : order.getSeatsHolded()) {
								seatIndex++;
								order.setOrderExpiration(true);
								System.out
										.println(Messages.orderExpired);
								seat.setSeatHold(false);
								seat.setSeatReserved(false);
								order.getSeatsHolded().set(seatIndex, seat);
								venue.getVenueOrders().set(seatIndex, order);
							}

						}
					}
				}
			} catch (Exception e) {
				//new WalMartException("-1", e);
			}
		}
		
	}
 }

 /**
  * Registers a boolean flag that represents the timer.
  * 
  * @param timerCancelFlag the boolean that sets the flag to false.
  */
public void setTimerCancelFlag(boolean timerCancelFlag) {
	this.timerCancelFlag = timerCancelFlag;
}
 
}
