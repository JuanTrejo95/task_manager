package com.juanTrejo95.task_manager.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	 @ExceptionHandler(ResponseStatusException.class)
	 public ResponseEntity<String> handleResponseStatusException(ResponseStatusException ex) {
	     return ResponseEntity
	             .status(ex.getStatusCode())
	             .body(ex.getReason());
	 }
}
