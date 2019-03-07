package de.objektkontor.clp.testvalues;

import de.objektkontor.clp.annotation.CommandLineParameter;

public class TestCharacter {

	@CommandLineParameter(value = "c") private Character value;
	@CommandLineParameter(value = "C", required = true) private char requiredValue;

	public Character getValue() {
		return value;
	}

	public void setValue(Character value) {
		this.value = value;
	}

	public char getRequiredValue() {
		return requiredValue;
	}

	public void setRequiredValue(char requiredValue) {
		this.requiredValue = requiredValue;
	}
}
