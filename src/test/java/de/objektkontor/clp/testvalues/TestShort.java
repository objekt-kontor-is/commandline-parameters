package de.objektkontor.clp.testvalues;

import de.objektkontor.clp.annotation.CommandLineParameter;

public class TestShort {

	@CommandLineParameter(value = "s") private Short value;
	@CommandLineParameter(value = "S", required = true) private short requiredValue;

	public Short getValue() {
		return value;
	}

	public void setValue(Short value) {
		this.value = value;
	}

	public short getRequiredValue() {
		return requiredValue;
	}

	public void setRequiredValue(short requiredValue) {
		this.requiredValue = requiredValue;
	}
}
