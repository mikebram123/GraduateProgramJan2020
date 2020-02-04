package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mastek.training.basics.SolutionProvider;

class SolutionProviderTest {

	@Test
	void testGetMaxNumberValidParams() {
		//assert<condition>(<Expected-Result>,<call the function for actual Result>,
		//				<message to display if expected result does not match actual result>);
		
		assertEquals(10, SolutionProvider.getMaxNumber(10, 2),"Invalid Max Number returned");
	}
	
	@Test
	void testGetMaxNumberEqualParams() {
		assertEquals(9, SolutionProvider.getMaxNumber(9,9),"Invalid Max Number returned");
	}
	
	@Test
	void testGetMaxNumberNegativeValueParams() {
		assertEquals(-1, SolutionProvider.getMaxNumber(-1,-10),"Invalid Max Number returned");
	}
	
	@Test
	void testGetMaxNumberMaxLimitsForIntParams() {
		assertEquals(999999999, SolutionProvider.getMaxNumber(999999999,9),"Invalid Max Number returned");
	}
	
	@Test
	void testKilosToMiles() {
		assertEquals(1.24, SolutionProvider.kilosToMiles(2),"Invalid Max Number returned");
	}
	@Test
	void testCalculateArea() {
		assertEquals(25, SolutionProvider.calculateArea(5, 5));
	}
	
	@Test
	void testTimeTaken() {
		assertEquals(1, SolutionProvider.timeTaken(60, 60));
	}
	
	@Test
	void testCircleArea() {
		assertEquals(78.54, SolutionProvider.circleArea(5));
	}
	
	@Test
	void testMinNumber() {
		assertEquals(1, SolutionProvider.minNumber(2, 2, 1));
	}
	
	@Test
	void testTestScores() {
		assertEquals("pass", SolutionProvider.studentDetails(1, "Mike", 21, 601, 60, 60));
	}
	@Test
	void testAverageScore() {
		assertEquals("A+", SolutionProvider.averageScore(95, 95, 95));
	}
	@Test
	void testLuckyNum() {
		assertEquals(6, SolutionProvider.getLucky(12345));
	}
}
