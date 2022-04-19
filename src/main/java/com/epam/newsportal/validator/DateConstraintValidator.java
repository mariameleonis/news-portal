package com.epam.newsportal.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateConstraintValidator implements ConstraintValidator<ValidDate, String> {

	@Override
	public boolean isValid(String date, ConstraintValidatorContext context) {

		boolean valid = false;

		try {
			LocalDate.parse(date, DateTimeFormatter.ofPattern("uuuu-MM-dd")
					.withResolverStyle(ResolverStyle.STRICT));

			valid = true;

		} catch (DateTimeParseException e) {
			e.printStackTrace();
			valid = false;
		}

		return valid;
	}

}
