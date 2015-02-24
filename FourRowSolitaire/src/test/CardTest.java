package test;

import static org.junit.Assert.*;

import org.junit.Test;

import FourRowSolitaire.Card;

public class CardTest {

	@Test
	public void testCardFirst() {
		boolean bool;
		int x;
		int y;
		String a;
		int z;
		
		Card test = new  Card("Spades",1,1,1);
		a = test.getSuit();
		x = test.getNumber();
		z = test.getDeckNumber();
		y = test.getFullNumber();
		
		bool = test.isValidSuit(a);
		
		assertTrue(bool);
		assertEquals(1,x);
		assertEquals(1,z);
		assertEquals(1,y);
	}
	
	@Test
	public void testCardSecond() {
		int x;
		int y;
		int z;
		String a;
		
		Card test = new  Card("Rock",0,0,0);
		a = test.getSuit();
		x = test.getNumber();
		z = test.getDeckNumber();
		y = test.getFullNumber();
		
		assertEquals("Invalid Suit",a);
		assertEquals(-1,x);
		assertEquals(0,z);
		assertEquals(0,y);
	}
	
	@Test
	public void testCardThird() {
		int x;
		int y;
		int z;
		String a;
		
		Card test = new  Card("Paper",14,5,53);
		a = test.getSuit();
		x = test.getNumber();
		z = test.getDeckNumber();
		y = test.getFullNumber();
		
		assertEquals("Invalid Suit",a);
		assertEquals(-1,x);
		assertEquals(0,z);
		assertEquals(0,y);
	}

}
