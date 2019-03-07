package de.objektkontor.clp.testvalues;

import de.objektkontor.clp.annotation.CommandLineParameter;

public class TestLong {

	@CommandLineParameter(value = "l") private Long value;
	@CommandLineParameter(value = "L", required = true) private long requiredValue;

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public long getRequiredValue() {
		return requiredValue;
	}

	public void setRequiredValue(long requiredValue) {
		this.requiredValue = requiredValue;
	}
}
