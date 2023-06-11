package com.sc.beanvalidation.custom;

import org.apache.commons.beanutils.BeanUtils;

import com.sc.beanvalidation.enums.ResponseErrorDetailsEnum;
import com.sc.beanvalidation.enums.TypeEnum;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
	private String firstFieldName;
	private String secondFieldName;

	@Override
	public void initialize(final FieldMatch constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		boolean isValidData = true;

		try {
			final Integer firstObj = Integer.valueOf(BeanUtils.getProperty(value, firstFieldName));
			final String secondObj = BeanUtils.getProperty(value, secondFieldName);

			String message = "";

			if (!TypeEnum.isType1(firstObj)) {
				if (!isDouble(secondObj)) {
					message = ResponseErrorDetailsEnum.INVALID_DETAILS.getErrorCode();
					isValidData = false;
				}
			}

			// disable existing violation message
			context.disableDefaultConstraintViolation();

			// build new violation message and add it
			context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
		} catch (final Exception e) {
			isValidData = false;
		}

		return isValidData;
	}

	boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}