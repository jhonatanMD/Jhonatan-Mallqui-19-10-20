package com.examen.poker.processor;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.examen.poker.model.Card;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class ControlCaseTest {

	@InjectMocks
	static ControlCase controlCase;

	@Mock
	List<Card> card1 ;
	
	@Before
	public void load() {
		 card1 = Arrays.asList(new Card(1,"C"),new Card(1,"S"),new Card(2,"H"),new Card(8,"C"),new Card(10,"D"));
	}
	
	@Test
	public void removeAndMax1Test() {
		
		
		int max = ControlCase.removeAndMax(card1, 1);
		assertEquals(10, max);
	}
	

	@Test
	public void removeAndMax2Test() {
		
		int max = ControlCase.removeAndMax(card1, 1,10);
		assertEquals(8, max);
	}
	
	@Test
	public void removeAndMax3Test() {
		
		int max = ControlCase.removeAndMax(card1, 1,10,8);
		assertEquals(2, max);
	}
	
	@Test
	public void containTest() {
		
		Map<Integer, Integer> mapContent = ControlCase.contain(card1);
		
		assertThat(mapContent.size(),is(1));
		
	}
	
	@Test
	public void convertStringCardTest() {
		
		List<Card> cardConvert = ControlCase.convertStringCard("1C 1S 2H 8C TD");
		
		assertThat(cardConvert.size(), is(5));
		assertEquals(cardConvert.get(0).getNum(), 1);
		assertEquals(cardConvert.get(0).getSimbolo(), "C");
		assertNotNull(cardConvert);
	}
	
}
