package de.objektkontor.clp.testvalues;

import de.objektkontor.clp.annotation.CommandLineParameter;

public class TestEnum {

	public enum OptionalEnum {
		FIRST, SECOND
	};

	public enum RequiredEnum {
		FIRST, SECOND
	};

	@CommandLineParameter(value = "e") private OptionalEnum value;
	@CommandLineParameter(value = "E", required = true) private RequiredEnum requiredValue;

	public OptionalEnum getValue() {
		return value;
	}

	public void setValue(OptionalEnum value) {
		this.value = value;
	}

	public RequiredEnum getRequiredValue() {
		return requiredValue;
	}

	public void setRequiredValue(RequiredEnum requiredValue) {
		this.requiredValue = requiredValue;
	}
}
