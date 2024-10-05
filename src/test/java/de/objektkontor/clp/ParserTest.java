package de.objektkontor.clp;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

import de.objektkontor.clp.testvalues.TestArray;
import de.objektkontor.clp.testvalues.TestBoolean;
import de.objektkontor.clp.testvalues.TestByte;
import de.objektkontor.clp.testvalues.TestCharacter;
import de.objektkontor.clp.testvalues.TestConverter;
import de.objektkontor.clp.testvalues.TestEnum;
import de.objektkontor.clp.testvalues.TestEnum.OptionalEnum;
import de.objektkontor.clp.testvalues.TestEnum.RequiredEnum;
import de.objektkontor.clp.testvalues.TestExtends;
import de.objektkontor.clp.testvalues.TestInteger;
import de.objektkontor.clp.testvalues.TestLong;
import de.objektkontor.clp.testvalues.TestShort;
import de.objektkontor.clp.testvalues.TestString;
import de.objektkontor.clp.testvalues.TestValidators;
import de.objektkontor.clp.testvalues.TestValues;

public class ParserTest {

	@Test
	public void testUnknownParameter() throws Exception {
		assertThrows(InvalidParameterException.class, () -> {
			Parser<TestBoolean> parser = new Parser<>("test", TestBoolean.class);
			parser.parse(new TestBoolean(), "-x", "-b", "-B");
		});
	}

	@Test
	public void testMissingRequiredParameter() throws Exception {
		assertThrows(InvalidParameterException.class, () -> {
			Parser<TestBoolean> parser = new Parser<>("test", TestBoolean.class);
			parser.parse(new TestBoolean(), "-b");
		});
	}

	@Test
	public void testMissingOptionalParameter() throws Exception {
		Parser<TestBoolean> parser = new Parser<>("test", TestBoolean.class);
		TestBoolean testParameters = parser.parse(new TestBoolean(), "-B");
		assertEquals(false, testParameters.isValue());
		assertEquals(true, testParameters.isRequiredValue());
	}

	@Test
	public void testParseBooleanValues() throws Exception {
		Parser<TestBoolean> parser = new Parser<>("test", TestBoolean.class);
		TestBoolean testParameters = parser.parse(new TestBoolean(), "-b", "-B");
		assertEquals(true, testParameters.isValue());
		assertEquals(true, testParameters.isRequiredValue());
	}

	@Test
	public void testParseStringValues() throws Exception {
		Parser<TestString> parser = new Parser<>("test", TestString.class);
		TestString testParameters = parser.parse(new TestString(), "-s", "stringValue", "-S", "stringRequiredValue");
		assertEquals("stringValue", testParameters.getValue());
		assertEquals("stringRequiredValue", testParameters.getRequiredValue());
	}

	@Test
	public void testParseByteValues() throws Exception {
		Parser<TestByte> parser = new Parser<>("test", TestByte.class);
		TestByte testParameters = parser.parse(new TestByte(), "-b", "10", "-B", "11");
		assertEquals(Byte.valueOf((byte) 10), testParameters.getValue());
		assertEquals(11, testParameters.getRequiredValue());
	}

	@Test
	public void testParseShortValues() throws Exception {
		Parser<TestShort> parser = new Parser<>("test", TestShort.class);
		TestShort testParameters = parser.parse(new TestShort(), "-s", "10", "-S", "11");
		assertEquals(Short.valueOf((short) 10), testParameters.getValue());
		assertEquals(11, testParameters.getRequiredValue());
	}

	@Test
	public void testParseCharacterValues() throws Exception {
		Parser<TestCharacter> parser = new Parser<>("test", TestCharacter.class);
		TestCharacter testParameters = parser.parse(new TestCharacter(), "-c", "A", "-C", "B");
		assertEquals(Character.valueOf('A'), testParameters.getValue());
		assertEquals('B', testParameters.getRequiredValue());
	}

	@Test
	public void testParseIntegerValues() throws Exception {
		Parser<TestInteger> parser = new Parser<>("test", TestInteger.class);
		TestInteger testParameters = parser.parse(new TestInteger(), "-i", "10", "-I", "11");
		assertEquals(Integer.valueOf(10), testParameters.getValue());
		assertEquals(11, testParameters.getRequiredValue());
	}

	@Test
	public void testParseLongValues() throws Exception {
		Parser<TestLong> parser = new Parser<>("test", TestLong.class);
		TestLong testParameters = parser.parse(new TestLong(), "-l", "10", "-L", "11");
		assertEquals(Long.valueOf(10), testParameters.getValue());
		assertEquals(11l, testParameters.getRequiredValue());

	}

	@Test
	public void testParseEnumValues() throws Exception {
		Parser<TestEnum> parser = new Parser<>("test", TestEnum.class);
		TestEnum testParameters = parser.parse(new TestEnum(), "-e", "FIRST", "-E", "SECOND");
		assertEquals(OptionalEnum.FIRST, testParameters.getValue());
		assertEquals(RequiredEnum.SECOND, testParameters.getRequiredValue());
	}

	@Test
	public void testParseArrayValues() throws Exception {
		Parser<TestArray> parser = new Parser<>("test", TestArray.class);
		TestArray testParameters = parser.parse(new TestArray(),
			"-s", "stringValue1", "stringValue2",
			"-S", "stringRequiredValue1", "stringRequiredValue2");
		assertArrayEquals(
			new String[] { "stringValue1", "stringValue2" },
			testParameters.getValues());
		assertArrayEquals(
			new String[] { "stringRequiredValue1", "stringRequiredValue2" },
			testParameters.getRequiredValues());
	}

	@Test
	public void testValidateValue() throws Exception {
		assertThrows(InvalidParameterException.class, () -> {
			Parser<TestValidators> parser = new Parser<>("test", TestValidators.class);
			parser.parse(new TestValidators(), "-s", "invalid", "-S", "stringRequiredValue");
		});
	}

	@Test
	public void testValidateRequiredValue() throws Exception {
		assertThrows(InvalidParameterException.class, () -> {
			Parser<TestValidators> parser = new Parser<>("test", TestValidators.class);
			parser.parse(new TestValidators(), "-s", "stringValue");
		});
	}

	@Test
	public void testValidateClass() throws Exception {
		assertThrows(InvalidParameterException.class, () -> {
			Parser<TestValidators> parser = new Parser<>("test", TestValidators.class);
			parser.parse(new TestValidators(), "-s", "invalid", "-S", "invalid");
		});
	}

	@Test
	public void testValueConverter() throws Exception {
		Parser<TestConverter> parser = new Parser<>("test", TestConverter.class);
		TestConverter testParameters = parser.parse(new TestConverter(), "-d", "01.02.2003", "-D", "02.03.2004");
		assertEquals(
			new SimpleDateFormat("dd.MM.yyyy").parse("01.02.2003"),
			testParameters.getValue());
		assertEquals(
			new SimpleDateFormat("dd.MM.yyyy").parse("02.03.2004"),
			testParameters.getRequiredValue());
	}

	@Test
	public void testDumpParameters() throws Exception {
		Parser<TestValues> parser = new Parser<>("test", TestValues.class);
		TestValues testParameters = parser.parse(new TestValues(),
			"-b",
			"-B",
			"-i", "10",
			"-I", "11",
			"-j", "2", "3", "4",
			"-J", "5", "6", "7",
			"-s", "stringValue",
			"-S", "stringRequiredValue",
			"-z", "stringValue1", "stringValue2",
			"-Z", "stringRequiredValue1", "stringRequiredValue2");
		String result = parser.dumpParameters(testParameters);
		assertTrue(result.trim().startsWith("( -b ) booleanValue"));
		assertTrue(result.contains("booleanRequiredValue"));
		assertTrue(result.contains("2"));
		assertTrue(result.contains("3"));
		assertTrue(result.contains("3"));
		assertTrue(result.contains("4"));
		assertTrue(result.contains("5"));
		assertTrue(result.contains("6"));
		assertTrue(result.contains("10"));
		assertTrue(result.contains("11"));
		assertTrue(result.contains("stringValue"));
		assertTrue(result.contains("stringRequiredValue"));
		assertTrue(result.contains("stringValue1"));
		assertTrue(result.contains("stringValue2"));
		assertTrue(result.contains("stringRequiredValue1"));
		assertTrue(result.contains("stringRequiredValue2"));
	}

	@Test
	public void testExtends() throws Exception {
		Parser<TestExtends> parser = new Parser<>("test", TestExtends.class);
		TestExtends testParameters = parser.parse(new TestExtends(),
			"-b",
			"-B",
			"-x",
			"-X");
		assertTrue(testParameters.getBooleanValue());
		assertTrue(testParameters.isBooleanRequiredValue());
		assertTrue(testParameters.getExtendedValue());
		assertTrue(testParameters.isExtendedRequiredValue());
	}
}
