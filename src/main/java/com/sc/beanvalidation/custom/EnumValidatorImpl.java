package com.sc.beanvalidation.custom;

import java.util.ArrayList;
import java.util.List;

import com.sc.beanvalidation.enums.TypeEnum;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, Integer> {

	List<Integer> valueList = null;

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		return valueList.contains(value);
	}

	@Override
	public void initialize(EnumValidator constraintAnnotation) {
		valueList = new ArrayList<>();
		Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClass();

		Enum<?>[] enumValArr = enumClass.getEnumConstants();

		for (Enum<?> enumVal : enumValArr) {
			if (enumVal instanceof TypeEnum) {
				valueList.add(((TypeEnum) enumVal).getType());
			}
		}
	}
}
