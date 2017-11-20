package com.github.igmfilho.challenge.nasarobot.exception;

public class OutOfBorderLimitException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	private String messageIndex = "error.out.border.limit";
	
	public OutOfBorderLimitException() {
		super();
	}

	public String getMessageIndex() {
		return messageIndex;
	}
}