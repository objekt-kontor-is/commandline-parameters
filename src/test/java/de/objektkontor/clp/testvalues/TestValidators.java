package de.objektkontor.clp.testvalues;

import de.objektkontor.clp.ParameterValidator;
import de.objektkontor.clp.annotation.CommandLineParameter;
import de.objektkontor.clp.annotation.CommandLineValidator;
import de.objektkontor.clp.testvalues.TestValidators.ClassValidator;

@CommandLineValidator(ClassValidator.class)
public class TestValidators {

	@CommandLineParameter(value = "s", validator = OptionValidator.class) String value;
	@CommandLineParameter(value = "S", required = true) String requiredValue;

	public static class OptionValidator implements ParameterValidator<String> {

		@Override
		public String validate(String value) {
			if ("invalid".equals(value))
				return "Error";
			return null;
		}
	}

	public static class ClassValidator implements ParameterValidator<TestValidators> {

		@Override
		public String validate(TestValidators options) {
			if ("invalid".equals(options.getValue()) && "invalid".equals(options.getRequiredValue()))
				return "Error";
			return null;
		}
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRequiredValue() {
		return requiredValue;
	}

	public void setRequiredValue(String requiredValue) {
		this.requiredValue = requiredValue;
	}
}
