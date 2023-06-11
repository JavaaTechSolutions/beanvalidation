package com.sc.beanvalidation.custom;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sc.beanvalidation.enums.ResponseErrorDetailsEnum;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected Map<String, Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
		Map<String, Object> objectBody = new LinkedHashMap<>();
		objectBody.put("Current Timestamp", new Date());
		objectBody.put("Status", HttpStatus.BAD_REQUEST);

		// Get all errors
		List<String> exceptionalErrors = exception.getBindingResult()
				.getFieldErrors().
				stream()
				.map(x -> ResponseErrorDetailsEnum.getEnumErrorCode(x.getDefaultMessage()).getErrorMsg())
				.collect(Collectors.toList());

		objectBody.put("Errors", exceptionalErrors);

		return objectBody;
	}

}