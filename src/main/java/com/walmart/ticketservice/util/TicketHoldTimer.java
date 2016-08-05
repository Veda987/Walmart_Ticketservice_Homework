package com.walmart.ticketservice.util;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * @author Veda
 * 
 * Class TicketHoldTimer to place time for the seats held by the customer.
 *
 */
public class TicketHoldTimer {
	/**
	 * Field to store the state.
	 */
	private Timer timer;
	
	/**
	 * the method to start the timer.
	 * @param task the TimerTask for the task.
	 * @param delay the Long that represents delay. 
	 */
	public void startSeatHoldTimer(TimerTask task, Long delay){
		timer = new Timer();
		timer.schedule(task, delay);		
	}
	
	/**
	 * The method to end the seat hold timer.
	 */
	public void endSeatHoldTimer(){
		timer.cancel();
		
	}
}
