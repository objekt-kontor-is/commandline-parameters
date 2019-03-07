package de.objektkontor.clp.testvalues;

import de.objektkontor.clp.annotation.CommandLineParameter;

public class TestBoolean {

	@CommandLineParameter(value = "b") private boolean value;
	@CommandLineParameter(value = "B", required = true) private boolean requiredValue;

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public boolean isRequiredValue() {
		return requiredValue;
	}

	public void setRequiredValue(boolean requiredValue) {
		this.requiredValue = requiredValue;
	}
}
