package com.sc.beanvalidation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sc.beanvalidation.dto.BaseResponseDTO;
import com.sc.beanvalidation.dto.BeanValidationDTO;
import com.sc.beanvalidation.enums.ResponseErrorDetailsEnum;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class BeanValidationController {

	public static final Logger LOGGER = LoggerFactory.getLogger(BeanValidationController.class);

	@PostMapping(value = "/validateBean")
	public BaseResponseDTO validateBean(@Valid @RequestBody BeanValidationDTO beanValidationRequest, BindingResult bindingResult) {

		LOGGER.info("Validate bean request {}", beanValidationRequest);

		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();

		if (bindingResult.hasErrors()) {
			FieldError fieldError = bindingResult.getFieldError();

			ResponseErrorDetailsEnum errorCodeEnum = ResponseErrorDetailsEnum.getEnumErrorCode(fieldError.getDefaultMessage());

			baseResponseDTO.setResponseCode(errorCodeEnum.getErrorCode());
			baseResponseDTO.setResponseMessage(errorCodeEnum.getErrorMsg());
		} else {

			try {

				// Business logic
				baseResponseDTO.setResponseCode(ResponseErrorDetailsEnum.SUCCESS.getErrorCode());
				baseResponseDTO.setResponseMessage(ResponseErrorDetailsEnum.SUCCESS.getErrorMsg());
			} catch (Exception e) {
				LOGGER.info("Exception occured while validating bean request {} and exception {}", beanValidationRequest, e);
				baseResponseDTO.setResponseCode(ResponseErrorDetailsEnum.FAILED.getErrorCode());
				baseResponseDTO.setResponseMessage(ResponseErrorDetailsEnum.FAILED.getErrorMsg());
			}
		}

		LOGGER.info("Validate bean response {} for request {}", baseResponseDTO, beanValidationRequest);

		return baseResponseDTO;
	}

}
