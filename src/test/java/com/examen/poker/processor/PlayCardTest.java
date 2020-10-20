package com.examen.poker.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class PlayCardTest {

	
	public String cardPair;
	public String cardTwoPair;
	public String cardThreeOfAKind;
	public String cardPoker;
	public String cardFullHoust;
	public String cardStraight;
	public String cardFlush;
	public String cardStraightFlush;
	public String cardRoyalFlush;
	
	
	@Before
	public void load() {
		
		cardPair = "5H 5C 6S 7S KD";
		cardTwoPair= "5C 5H 6S 6H 1D";
		cardThreeOfAKind = "2D 9C AS AH AC";
		cardPoker = "2D 2C 2S 2H AC";
		cardFullHoust = "2H 2D 4C 4D 4S";
		cardStraight = "2D 3C 4S 5H 6C";
		cardFlush = "3D 6D 7D TD QD";
		cardStraightFlush = "5D 1D 2D 3D 4D";
		cardRoyalFlush = "TD JD QD KD AD";
	}
	
	
	@Test
	public void pairTest() {
		boolean data = PlaysCard.isPair(cardPair);
		assertEquals(true, data);
	}
	
	@Test
	public void twoPairTest() {
		boolean data = PlaysCard.isTwoPair(cardTwoPair);
		assertEquals(true, data);
	}
	
	@Test
	public void threeOfAKindTest() {
		boolean data = PlaysCard.isThreeOfAKind(cardThreeOfAKind);
		assertEquals(true, data);
	}
	
	@Test
	public void pokerTest() {
		boolean data = PlaysCard.isFourOfAKind(cardPoker);
		assertEquals(true, data);
	}
	
	@Test
	public void fullHouseTest() {
		boolean data = PlaysCard.isFullHouse(cardFullHoust);
		assertEquals(true, data);
	}
	
	@Test
	public void straightTest() {
		boolean data = PlaysCard.isStraight(cardStraight);
		assertEquals(true, data);
	}
	
	@Test
	public void flushTest() {
		boolean data = PlaysCard.isFlush(cardFlush);
		assertEquals(true, data);
	}
	
	@Test
	public void straightFlushTest() {
		boolean data = PlaysCard.isStraightFlush(cardStraightFlush);
		assertEquals(true, data);
	}
	
	@Test
	public void royalFlushTest() {
		boolean data = PlaysCard.isRoyalFlush(cardRoyalFlush);
		assertEquals(true, data);
	}
	
	@Test
	public void scoreTwoPairTest() {
		int score = PlaysCard.score(cardTwoPair);
		assertEquals(3, score);
	}
	
}
