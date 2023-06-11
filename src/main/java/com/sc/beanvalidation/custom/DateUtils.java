package com.sc.beanvalidation.custom;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

	public static final String YYYYMMDDDASH = "yyyy-mm-dd";

	private DateUtils() {

	}

	public static boolean isDateInValidFormat(String inputDate, String checkingFormat) {
		boolean isValidDate = false;

		try {
			SimpleDateFormat format = new SimpleDateFormat(checkingFormat);
			format.setLenient(false);
			format.parse(inputDate);
			isValidDate = true;
		} catch (Exception e) {
			LOGGER.error("Exception occured while parsing date {}, expected format {} and exception {}", inputDate, checkingFormat, e.getMessage());
		}

		return isValidDate;
	}

}
