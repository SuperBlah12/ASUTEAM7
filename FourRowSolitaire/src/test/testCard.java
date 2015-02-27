package test;

import static org.junit.Assert.*;

import org.junit.Test;

import FourRowSolitaire.Card;

public class testCard {

	@Test
	public void testNormal()
	{
		Card spades = new Card("Spades",1,1,1);
		assertEquals(Card.SPADES_SUIT,spades.getSuit());
		assertEquals(Card.ACE,spades.getNumber());
		assertEquals(1,spades.getFullNumber());
	}
	
	@Test
	public void testHigh()
	{
		Card high = new Card("High",14,5,53);
		assertEquals(Card.INVALID_SUIT,high.getSuit());
		assertEquals(Card.INVALID_NUMBER,high.getNumber());
		assertEquals(0,high.getFullNumber());
	}
	
	@Test
	public void testLow()
	{
		Card low = new Card("Low",0,0,0);
		assertEquals(Card.INVALID_SUIT,low.getSuit());
		assertEquals(Card.INVALID_NUMBER,low.getNumber());
		assertEquals(0,low.getFullNumber());
	}

}
