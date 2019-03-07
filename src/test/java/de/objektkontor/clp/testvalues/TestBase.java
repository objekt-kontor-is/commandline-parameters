package de.objektkontor.clp.testvalues;

import de.objektkontor.clp.annotation.CommandLineParameter;

public class TestBase {

	@CommandLineParameter(value = "b") private Boolean booleanValue;
	@CommandLineParameter(value = "B", required = true) private boolean booleanRequiredValue;

	public Boolean getBooleanValue() {
		return booleanValue;
	}

	public void setBooleanValue(Boolean booleanValue) {
		this.booleanValue = booleanValue;
	}

	public boolean isBooleanRequiredValue() {
		return booleanRequiredValue;
	}

	public void setBooleanRequiredValue(boolean booleanRequiredValue) {
		this.booleanRequiredValue = booleanRequiredValue;
	}
}
