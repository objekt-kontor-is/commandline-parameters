package de.objektkontor.clp.testvalues;

import java.text.SimpleDateFormat;
import java.util.Date;

import de.objektkontor.clp.ParameterConverter;
import de.objektkontor.clp.annotation.CommandLineParameter;

public class TestConverter {

	@CommandLineParameter(value = "d", converter = DateConvertor.class) Date value;
	@CommandLineParameter(value = "D", converter = DateConvertor.class, required = true) Date requiredValue;

	public static class DateConvertor implements ParameterConverter<Date> {

		@Override
		public Date convert(String value) throws Exception {
			return new SimpleDateFormat("dd.MM.yyyy").parse(value);
		}
	}

	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}

	public Date getRequiredValue() {
		return requiredValue;
	}

	public void setRequiredValue(Date requiredValue) {
		this.requiredValue = requiredValue;
	}
}
