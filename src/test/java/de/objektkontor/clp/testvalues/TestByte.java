package de.objektkontor.clp.testvalues;

import de.objektkontor.clp.annotation.CommandLineParameter;

public class TestByte {

	@CommandLineParameter(value = "b") private Byte value;
	@CommandLineParameter(value = "B", required = true) private byte requiredValue;

	public Byte getValue() {
		return value;
	}

	public void setValue(Byte value) {
		this.value = value;
	}

	public byte getRequiredValue() {
		return requiredValue;
	}

	public void setRequiredValue(byte requiredValue) {
		this.requiredValue = requiredValue;
	}
}
