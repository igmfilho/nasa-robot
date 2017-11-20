package com.github.igmfilho.challenge.nasarobot.api.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.igmfilho.challenge.nasarobot.exception.InvalidCommandException;
import com.github.igmfilho.challenge.nasarobot.exception.OutOfBorderLimitException;

@RestControllerAdvice
public class ResourceExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(InvalidCommandException.class)
    public ResponseEntity<?> commandInvalidExceptionHandler(HttpServletRequest req, final InvalidCommandException ex){
		String message = getMessage(ex.getMessageIndex());
		return ResponseEntity.badRequest().body(message);
    }
	
	@ExceptionHandler(OutOfBorderLimitException.class)
    public ResponseEntity<?> exceededBoundaryExceptionHandler(HttpServletRequest req, final OutOfBorderLimitException ex){
        String message = getMessage(ex.getMessageIndex());
        return ResponseEntity.badRequest().body(message);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(){
        String message = getMessage("error.unexpected");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }
	
	private String getMessage(final String key) {
       return messageSource.getMessage(key, null, null);
    }
}

