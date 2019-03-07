package de.objektkontor.clp.testvalues;

import de.objektkontor.clp.annotation.CommandLineParameter;

public class TestInteger {

	@CommandLineParameter(value = "i") private Integer value;
	@CommandLineParameter(value = "I", required = true) private int requiredValue;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public int getRequiredValue() {
		return requiredValue;
	}

	public void setRequiredValue(int requiredValue) {
		this.requiredValue = requiredValue;
	}
}
