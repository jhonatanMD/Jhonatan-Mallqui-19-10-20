package com.examen.poker.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class ConstantTest {

	
	@Test
	public void inputValidationTest() {
		
		String[] cards = {"7C" ,"5H","KC", "QH", "JD" ,"AS" ,"KH","4C" ,"AD" ,"4S"};
		int data = Constant.inputValidation(cards);
		
		assertEquals(20, data);
	}
	
	@Test
	public void inputKeyTest() {
		
		int data = Constant.inputKey("A");
		assertEquals(14,data );
		
	}
}
