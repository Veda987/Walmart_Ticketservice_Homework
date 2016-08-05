package com.walmart.ticketservice.util;

/**
 * 
 * @author Veda
 * 
 * Class WalMartException to handle the exceptions.
 */
@SuppressWarnings("serial")
public class WalMartException extends java.lang.Exception{
	protected Exception exception = null;
	protected String errorCode = null;
	 public WalMartException(String errorCode, Exception exception) {
		this.errorCode = errorCode;
		this.exception =exception;
		System.out.println("Error Code : "+ errorCode+", Message :" + exception.getMessage() );
	}

}