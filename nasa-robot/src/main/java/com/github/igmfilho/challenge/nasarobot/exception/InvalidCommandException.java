package com.github.igmfilho.challenge.nasarobot.exception;

public class InvalidCommandException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String messageIndex = "error.invalid.command";
	
	public InvalidCommandException() {
		super();
	}
	
	public String getMessageIndex() {
		return messageIndex;
	}
}
