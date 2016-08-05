package com.walmart.ticketservice.view;

import java.util.Optional;
import java.util.Scanner;

import com.walmart.ticketservice.model.Seat;
import com.walmart.ticketservice.model.Venue;
import com.walmart.ticketservice.service.CurrentOrder;
import com.walmart.ticketservice.service.SeatHold;
import com.walmart.ticketservice.service.TicketServiceHandler;
import com.walmart.ticketservice.util.LoadVenueProperties;
import com.walmart.ticketservice.util.Validator;
import com.walmart.ticketservice.util.WalMartException;

/**
 * 
 * @author Veda
 *
 *Class CustomerView that makes a view for the customer to make selections to see available seats, hold, and reserve the seats. 
 */
public class CustomerView {

	/**
	 * Fields that stores the state of the class taken from the standard input.
	 */
	static Scanner input = new Scanner(System.in);
	static ConfigureCustomerMenu configureCustomerMenu = new ConfigureCustomerMenu();
	static TicketServiceHandler ticketServiceHandler = new TicketServiceHandler();
	static Venue venue = LoadVenueProperties.loadVenuDetails();
	WalMartException we;
	
	/**
	 * The method that show the menu for the customer and produce proper response by invoking appropriate methods 
	 * and by reading the customer actions made out of menu.
	 */
	public void customerAction(int action) {
		int userAction = action;
		CurrentOrder currentOrder = new CurrentOrder();
		try {
			if (userAction == 0) {
				ticketServiceHandler.setVenue(venue);
				configureCustomerMenu.CustomerSelectionMenu();
				System.out.println(Messages.welcome);
				configureCustomerMenu.loadCustomerSelectionMenu(userAction);
				System.out.print(Messages.customerInput);
				userAction = customerInput();
			}
			if (userAction > 0) {
				{
					switch (userAction) {
					case 1:
						configureCustomerMenu
								.viewAllVenueLevel(ticketServiceHandler
										.getVenue());
						System.out.println( Messages.allLevels);
						System.out.print(Messages.customerInput);
						userAction = customerInput();
						if (userAction > 0) {
							switch (userAction) {
							case 1:
							case 2:
							case 3:
							case 4:
								ticketServiceHandler.numSeatsAvailable(Optional.of(userAction));
								break;
							case 5:
								for (int i : venue.getVenueDetails().keySet()) {
									ticketServiceHandler.numSeatsAvailable(Optional.of(i));
								}
								break;
							}
						}
						configureCustomerMenu.loadCustomerSelectionMenu(1);
						System.out.print(Messages.customerInput);
						userAction = customerInput();
						customerAction(userAction);
						break;
					case 2:
						SeatHold seatHold = new SeatHold();
						System.out.println(Messages.numSeats);
						int numSeats = customerInput();
						System.out.println(Messages.minLevel);
						int minLevel = customerInput();
						System.out.println(Messages.maxLevel);
						int maxLevel = customerInput();
						System.out.println(Messages.customerEmail);
						String customerEmail = emailInput();
						seatHold = ticketServiceHandler.findAndHoldSeats(
								numSeats, Optional.of(minLevel),
								Optional.of(maxLevel), customerEmail);
						if(seatHold.getSeatHoldId() != 0) {
							System.out.println(Messages.confirmSeatHoldId
									+ seatHold.getSeatHoldId());
							String seatsAreOnHold = null;
							for (Seat seat : seatHold.getSeatsHolded()) {
								if (seatsAreOnHold == null) {
									seatsAreOnHold = Messages.appendSpace+"["+seat.getSeatId();
								} else {
									seatsAreOnHold = seatsAreOnHold + ","+ seat.getSeatId();
								}
							}
							System.out.println(Messages.holdSeatSuccess + venue.getVenueDetails().get(seatHold.getLevelId()).getLevelName()+"]");
							System.out.println(seatsAreOnHold+"]");
							System.out.println(Messages.appendSpace+"You have "+venue.getSeatHoldTime()+" Secounds to Reserve your Order.");
							venue = ticketServiceHandler.getVenue();
							new CurrentOrder(venue, seatHold.getSeatHoldId(),
									customerEmail);
							configureCustomerMenu.loadCustomerSelectionMenu(2);
							System.out.println(Messages.customerInput);
							userAction = customerInput();
							customerAction(userAction);
						}
						break;
					case 3:
						currentOrder.setTimerCancelFlag(true);
						venue = currentOrder.getVenue();
						System.out.println(Messages.inputseatHoldId);
						int seatHoldId = customerInput();
						System.out.println(Messages.inputEmail);
						customerEmail = emailInput();
						String confirmaitonId = ticketServiceHandler.reserveSeats(seatHoldId, customerEmail);
						if (confirmaitonId != null && confirmaitonId != "-1") {
							System.out.println(Messages.seatsResevationSuccess);
							System.err.println(Messages.confirmOrderNo+ confirmaitonId);
						} else if (confirmaitonId == "-1") {
							System.out.println(Messages.wrongOrder);
							configureCustomerMenu.loadCustomerSelectionMenu(0);
							System.out.print(Messages.customerInput);
							userAction = customerInput();
							customerAction(userAction);
						}
						System.exit(0);
						break;
					case 4:
						configureCustomerMenu.loadCustomerSelectionMenu(userAction);
						break;

					}
				}
			}
		} catch (Exception e) {
			new WalMartException("-1", e);
		}

	}

	/**
	 * Returns the integer the represents the customer input.
	 * @return userAction the String that represents the customer input.
	 */
	public int customerInput() {
		boolean iterator = true;
		int userAction = 0;
		while (iterator) {
			if (!input.hasNextInt()) {
				input.next();
				System.out.println(Messages.invalidInput);
				System.out.println(Messages.customerInput);
			} else {
				userAction = input.nextInt();
				if (userAction <= 0) {
					System.out.println(Messages.invalidInput);
					System.out.println(Messages.customerInput);
				} else if (userAction > 0) {
					iterator = false;
					break;
				}
			}
		}
		return userAction;
	}

	/**
	 * Returns a String that represents the customer email.
	 * @return userAction the String that represents the customer email.
	 */
	public String emailInput() {
		boolean iterator = true;
		String userAction = null;
		while (iterator) {
			if (input.hasNextInt()) {
				input.next();
				System.out.println(Messages.invalidInput);
				System.out.println(Messages.customerInput);
			} else {
				userAction = input.next();
			if(Validator.isValidEmailAddress(userAction)){
				iterator = false;
				break;
			}else{
				System.out.println(Messages.inCorrectEmailFormat);
				System.out.println(Messages.customerInput);
				}
	
			}
		}
		return userAction;
	}
}
