package com.askidaevimproject.Ask.da.evim.olsun;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions.*;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 *
 */
@SpringBootApplication
@RestControllerAdvice
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);


	}

	/*
	when the security methods are implementing ,
	the comment block is deleted.

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	*/


	/*
	* RestTample AND HttpHeaders => pull the data from city-district-neighborhood data

	* */



	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	public HttpHeaders httpHeaders(){
		return new HttpHeaders();
	}


	/**
	 * @ExceptionHandler
	 * business exception handle it here.
	 * */


	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public IdProblemDetails handleMemberIdNotFoundException(NoSuchElementException noSuchElementException){

		MemberIdNotFoundException memberIdNotFoundException = new MemberIdNotFoundException();
		memberIdNotFoundException.setMessage("Id Error");

		memberIdNotFoundException.setErrors(new HashMap<>());

		for (StackTraceElement stackTraceElement : noSuchElementException.getStackTrace())
		{
			for (int i = 0 ; i < stackTraceElement.getLineNumber();i++){
				memberIdNotFoundException.getErrors().put(stackTraceElement.getFileName(),stackTraceElement.getMethodName());
			}
		}
		return  memberIdNotFoundException;


	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ProblemDetails handleCityNameException(CityNameFoundException cityNameFoundException){
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(cityNameFoundException.getMessage());
		return problemDetails;

	}


	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ProblemDetails handleRoomTypeExistsException(RoomTypeExistsException roomTypeExistsException){

		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(roomTypeExistsException.getMessage());
		return problemDetails;
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ProblemDetails handleFuelIsExistsException(FuelIsExistsException fuelIsExistsException){

		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(fuelIsExistsException.getMessage());
		return problemDetails;
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ProblemDetails handleRoomTypeIsNotFound(RoomTypeNotFoundException roomTypeNotFoundException){

		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(roomTypeNotFoundException.getMessage());
		return problemDetails;
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ProblemDetails handleFuelIdIsNotFound(FuelIdIsNotFoundException fuelIdIsNotFoundException){

		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(fuelIdIsNotFoundException.getMessage());
		return problemDetails;
	}





	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("Validation.Exception");
		validationProblemDetails.setValidationErrors(new HashMap<>());

		for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()){
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return validationProblemDetails;
	}


	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}


}
