package de.objektkontor.clp.testvalues;

import de.objektkontor.clp.annotation.CommandLineParameter;

public class TestExtends extends TestBase {

	@CommandLineParameter(value = "x") private Boolean extendedValue;
	@CommandLineParameter(value = "X", required = true) private boolean extendedRequiredValue;

	public Boolean getExtendedValue() {
		return extendedValue;
	}

	public void setExtendedValue(Boolean extendedValue) {
		this.extendedValue = extendedValue;
	}

	public boolean isExtendedRequiredValue() {
		return extendedRequiredValue;
	}

	public void setExtendedRequiredValue(boolean extendedRequiredValue) {
		this.extendedRequiredValue = extendedRequiredValue;
	}
}
