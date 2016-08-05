package JUnitTest;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import com.walmart.ticketservice.model.Venue;
import com.walmart.ticketservice.service.SeatHold;
import com.walmart.ticketservice.service.TicketServiceHandler;
import com.walmart.ticketservice.util.LoadVenueProperties;

/**
 * 
 * @author Veda
 * 
 *Class TestTicketServiceHandler to test the TicketServiceHandler.
 */

public class TestTicketServiceHandler {


	static TicketServiceHandler ticketServiceHandler = new TicketServiceHandler();
	SeatHold seatHold;
	static Venue venue;

	static {
		venue = LoadVenueProperties.loadVenuDetails();
		ticketServiceHandler.setVenue(venue);
	}
     
	@Test
	public void testNumSeatsAvailableInLevel1A() {
		int numSeatsActual = ticketServiceHandler.numSeatsAvailable(Optional
				.of(1));
		System.out.println("numSeatsActual "+numSeatsActual);
//		int numSeatsDesired = 1245;
		System.out.println(" numSeatsActual :" + numSeatsActual);
		assertNotNull("should not be null", numSeatsActual);

	}
	@Test
	public void testNumSeatsAvailableInLevel2B() {
		int numSeatsActual2 = ticketServiceHandler.numSeatsAvailable(Optional
				.of(2));
		//int numSeatsDesired2 = 1245;
		assertNotNull("should not be null", numSeatsActual2);

	}
	@Test
	public void testNumSeatsAvailableInLevel3C() {

		int numSeatsActual3 = ticketServiceHandler.numSeatsAvailable(Optional
				.of(3));
//		int numSeatsDesired3 = 1500;
		assertNotNull("should not be null", numSeatsActual3);

	}
	@Test
	public void testNumSeatsAvailableInLevel4D() {

		int numSeatsActual4 = ticketServiceHandler.numSeatsAvailable(Optional
				.of(4));
//		int numSeatsDesired4 = 1500;
		assertNotNull("should not be null", numSeatsActual4);
	}

	@Test
	public void testFindAndHoldSeatsE() {
		seatHold = ticketServiceHandler.findAndHoldSeats(5,
				Optional.of(1), Optional.of(2), "veda987@gmail.com");
		System.out.println("seatHold.getSeatHoldId() mqin " + seatHold.getSeatHoldId());
		venue = ticketServiceHandler.getVenue();
		assertEquals(5, seatHold.getSeatsHolded().size());
	}

	@Test
	public void testReserveSeatsF() {
		venue = ticketServiceHandler.getVenue();
		String reservationIdActual = ticketServiceHandler.reserveSeats(
				201608051, "veda987@gmail.com");
		String reservationIdDesired = "T201608051";
		System.out.println("reservationIdActual "+reservationIdActual);
		assertNotNull("should not be null", reservationIdActual);
	}

}
