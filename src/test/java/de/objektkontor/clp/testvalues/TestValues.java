package de.objektkontor.clp.testvalues;

import de.objektkontor.clp.annotation.CommandLineParameter;

public class TestValues {

	@CommandLineParameter(value = "b") private Boolean booleanValue;
	@CommandLineParameter(value = "B", required = true) private boolean booleanRequiredValue;
	@CommandLineParameter(value = "i") private Integer integerValue;
	@CommandLineParameter(value = "I", required = true) private int intRequiredValue;
	@CommandLineParameter(value = "j") private Integer[] integerValues;
	@CommandLineParameter(value = "J", required = true) private int[] intRequiredValues;
	@CommandLineParameter(value = "s") private String stringValue;
	@CommandLineParameter(value = "S", required = true) private String stringRequiredValue;
	@CommandLineParameter(value = "z") private String[] stringValues;
	@CommandLineParameter(value = "Z", required = true) private String[] stringRequiredValues;

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

	public Integer getIntegerValue() {
		return integerValue;
	}

	public void setIntegerValue(Integer integerValue) {
		this.integerValue = integerValue;
	}

	public int getIntRequiredValue() {
		return intRequiredValue;
	}

	public void setIntRequiredValue(int intRequiredValue) {
		this.intRequiredValue = intRequiredValue;
	}

	public Integer[] getIntegerValues() {
		return integerValues;
	}

	public void setIntegerValues(Integer[] integerValues) {
		this.integerValues = integerValues;
	}

	public int[] getIntRequiredValues() {
		return intRequiredValues;
	}

	public void setIntRequiredValues(int[] intRequiredValues) {
		this.intRequiredValues = intRequiredValues;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public String getStringRequiredValue() {
		return stringRequiredValue;
	}

	public void setStringRequiredValue(String stringRequiredValue) {
		this.stringRequiredValue = stringRequiredValue;
	}

	public String[] getStringValues() {
		return stringValues;
	}

	public void setStringValues(String[] stringValues) {
		this.stringValues = stringValues;
	}

	public String[] getStringRequiredValues() {
		return stringRequiredValues;
	}

	public void setStringRequiredValues(String[] stringRequiredValues) {
		this.stringRequiredValues = stringRequiredValues;
	}
}
