package com.demo.planeproject.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.demo.planeproject.Entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class CustomGlobalExceptionHandler {
	
	@ExceptionHandler(PlaneNotFoundException.class)
	public ResponseEntity<ErrorMessage> planeNotFoundException(PlaneNotFoundException exception, 
			WebRequest request){
		ErrorMessage msg = new ErrorMessage();
		msg.setMessage(exception.getMessage());
		msg.setStatus(HttpStatus.NOT_FOUND);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
	
	}

}
