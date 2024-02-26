package com.komal.springboot.restAPI.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.komal.springboot.restAPI.user.UserNotFoundException;

import org.slf4j.Logger;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception
	{
		ErrorDetails error  = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception
	{
		ErrorDetails error  = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(error,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request)
	{
		StringBuilder str = new StringBuilder(" ");
		
//		String first = "";
//		List<FieldError> err = ex.getFieldErrors();
//		Iterator<FieldError> it = err.iterator();
//		while(it.hasNext())
//		{
//			FieldError x = it.next();
//			first.concat(x.toString());
//		}
		//ex.getFieldError().getDefaultMessage()
		
		List<FieldError> errors = ex.getFieldErrors();
        for (FieldError error : errors) {
        	str.append(error.getField()).append(" ").append(error.getDefaultMessage());
            logger.error("Filed Name ::: " + error.getField() + "Error Message :::" + error.getDefaultMessage());
        }
		ErrorDetails error  = new ErrorDetails(LocalDateTime.now(),str.toString(),request.getDescription(false));
		return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
	}
	
}
