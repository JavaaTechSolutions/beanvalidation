package com.sc.beanvalidation.custom;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckDateValidator implements ConstraintValidator<CheckDateFormat, String> {

	private String pattern;

	@Override
	public void initialize(CheckDateFormat constraintAnnotation) {
		this.pattern = constraintAnnotation.pattern();
	}

	@Override
	public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
		boolean isValidPattern;

		if (object == null) {
			return true;
		}

		try {
			isValidPattern = DateUtils.isDateInValidFormat(object, pattern);
		} catch (Exception e) {
			isValidPattern = false;
		}

		return isValidPattern;
	}
}