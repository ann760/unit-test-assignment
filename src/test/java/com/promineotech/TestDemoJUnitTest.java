package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, 
			boolean expectException) 
	{	
		if(!expectException) {
			// When: the method to add positives is called
			// Then: the positives are added
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
			}
		else {
			// When: the method to add positives is called
			// Then: an exception is thrown
			assertThatThrownBy(() -> testDemo.addPositive(a, b))
	        .isInstanceOf(IllegalArgumentException.class)
	        .hasMessage("Both parameters must be positive!");
		}
	}
	
	static Stream<Arguments> argumentsForAddPositive(){
		// @formatter:off
		return Stream.of(
			arguments(2, 4, 6, false),
			arguments(3, 5, 8, false),
			arguments(0, 0, 0, true),
			arguments(6, -4, 7, true)
		);
		// @formatter:off
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
		assertThat(testDemo.addPositive(24,26)).isEqualTo(50);
	}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForGrossPay")
	void assertThatGrossIncomecalculatesCorrectly(double hours, double payRate, double expected, 
			boolean expectException) 
	{	
		if(!expectException) {
			// When: the method to add positives is called
			// Then: the positives are added
			assertThat(testDemo.calIncome(hours, payRate)).isEqualTo(expected);
			}
		else {
			// When: the method to add positives is called
			// Then: an exception is thrown
			assertThatThrownBy(() -> testDemo.calIncome(hours, payRate))
	        .isInstanceOf(IllegalArgumentException.class)
	        .hasMessage("Both parameters must be positive!");
		}
	}
	
	static Stream<Arguments> argumentsForGrossPay(){
		// @formatter:off
		return Stream.of(
			arguments(40, 46.46, 1858.4, false),
			arguments(50, 46.46, 2555.3, false),
			arguments(0, 0, 0, true),
			arguments(0, -43.4, 7, true)
		);
		// @formatter:off
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
}
