package de.objektkontor.clp.testvalues;

import de.objektkontor.clp.annotation.CommandLineParameter;

public class TestArray {

	@CommandLineParameter(value = "s") private String[] values;
	@CommandLineParameter(value = "S", required = true) private String[] requiredValues;

	public String[] getValues() {
		return values;
	}

	public void setValues(String[] values) {
		this.values = values;
	}

	public String[] getRequiredValues() {
		return requiredValues;
	}

	public void setRequiredValues(String[] requiredValues) {
		this.requiredValues = requiredValues;
	}
}
