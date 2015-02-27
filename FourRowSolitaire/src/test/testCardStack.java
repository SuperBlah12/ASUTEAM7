package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import FourRowSolitaire.Card;
import FourRowSolitaire.CardStack;
import FourRowSolitaire.Column;

public class testCardStack {

	public static CardStack standard;
	public static CardStack rStandard;
	public static CardStack colored;
	public static CardStack rColored;
	public static CardStack numbered;
	public static CardStack rNumbered;
	
	@Before
	public void setup()
	{
		//Forwards
		standard = new CardStack();
		standard.addCard(new Card("Spades",6,1,6));
		standard.addCard(new Card("Diamonds",5,1,31));
		standard.addCard(new Card("Clubs",4,1,17));
		standard.addCard(new Card("Hearts",3,1,42));
		standard.addCard(new Card("Spades",2,1,2));
		colored = new CardStack();
		colored.addCard(new Card("Hearts",6,1,45));
		colored.addCard(new Card("Diamonds",5,1,31));
		colored.addCard(new Card("Hearts",4,1,43));
		colored.addCard(new Card("Diamonds",3,1,29));
		colored.addCard(new Card("Hearts",2,1,41));
		numbered = new CardStack();
		numbered.addCard(new Card("Spades",6,1,6));
		numbered.addCard(new Card("Diamonds",3,1,29));
		numbered.addCard(new Card("Clubs",4,1,17));
		numbered.addCard(new Card("Hearts",5,1,44));
		numbered.addCard(new Card("Spades",2,1,2));
		
		//Reverse
		rStandard = new CardStack();
		rStandard.addCard(new Card("Spades",2,1,2));
		rStandard.addCard(new Card("Hearts",3,1,42));
		rStandard.addCard(new Card("Clubs",4,1,17));
		rStandard.addCard(new Card("Diamonds",5,1,31));
		rStandard.addCard(new Card("Spades",6,1,6));
		rColored = new CardStack();
		rColored.addCard(new Card("Hearts",2,1,41));
		rColored.addCard(new Card("Diamonds",3,1,29));
		rColored.addCard(new Card("Hearts",4,1,43));
		rColored.addCard(new Card("Diamonds",5,1,31));
		rColored.addCard(new Card("Hearts",6,1,45));
		rNumbered = new CardStack();
		rNumbered.addCard(new Card("Spades",2,1,2));
		rNumbered.addCard(new Card("Hearts",5,1,44));
		rNumbered.addCard(new Card("Clubs",4,1,17));
		rNumbered.addCard(new Card("Diamonds",3,1,29));
		rNumbered.addCard(new Card("Spades",6,1,6));
	
	}
	
	@Test
	public void testPush()
	{
		CardStack actual = new CardStack();
		actual.push(standard);
		assertEquals(rStandard.pop(),actual.pop());//First Card
		assertEquals(rStandard.pop(),actual.pop());//Second Card
		assertEquals(rStandard.pop(),actual.pop());//Third Card
		assertEquals(rStandard.pop(),actual.pop());//Fourth Card
		assertEquals(rStandard.pop(),actual.pop());//Fifth Card
	}
	
	@Test
	public void testPop() 
	{
		//Cards to be popped
		CardStack temp = new CardStack();
		temp.addCard(new Card("Spades",2,1,2));
		temp.addCard(new Card("Hearts",3,1,42));
		temp.addCard(new Card("Clubs",4,1,17));
		//resulting reverse list
		CardStack expected = new CardStack();
		expected.addCard(new Card("Clubs",4,1,17));
		expected.addCard(new Card("Hearts",3,1,42));
		expected.addCard(new Card("Spades",2,1,2));
		//get Actual
		CardStack actual = standard.pop(temp);
		//Test Values
		assertEquals(expected.pop(),actual.pop());//First Card
		assertEquals(expected.pop(),actual.pop());//Second Card
		assertEquals(expected.pop(),actual.pop());//Third Card
	}
	
	@Test
	public void testGoodSearch()
	{
		Card fourClubs = new Card("Clubs",4,1,17);
		int expected = 3;
		int actual = standard.search(fourClubs);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBadSearch()
	{
		Card badCard = new Card("Bad",0,0,0);
		int expected = -1;
		int actual = standard.search(badCard);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testStandardValid()
	{
		assertTrue(standard.isValidCard(3));
	}
	
	@Test
	public void testColoredValid()
	{
		assertFalse(colored.isValidCard(3));
	}
	
	@Test
	public void testNumberedValid()
	{
		assertFalse(numbered.isValidCard(3));
	}
	
	@Test
	public void testGetStackCard()
	{
		Card fourClubs = new Card("Clubs",4,1,17);
		CardStack expected = new CardStack();
		expected.addCard(new Card("Spades",2,1,2));
		expected.addCard(new Card("Hearts",3,1,42));
		expected.addCard(new Card("Clubs",4,1,17));
		CardStack actual = standard.getStack(fourClubs);
		assertEquals(expected.pop(),actual.pop());//First Card
		assertEquals(expected.pop(),actual.pop());//Second Card
		assertEquals(expected.pop(),actual.pop());//Third Card
	}
	
	@Test
	public void testGetStackInt()
	{
		CardStack expected = new CardStack();
		expected.addCard(new Card("Spades",2,1,2));
		expected.addCard(new Card("Hearts",3,1,42));
		expected.addCard(new Card("Clubs",4,1,17));
		CardStack actual = standard.getStack(3);
		assertEquals(expected.pop(),actual.pop());//First Card
		assertEquals(expected.pop(),actual.pop());//Second Card
		assertEquals(expected.pop(),actual.pop());//Third Card
	}
	
	@Test
	public void testGetAvailCardsStandard()
	{
		Column tempColumn = new Column();
		tempColumn.addCard(rStandard.pop());
		tempColumn.addCard(rStandard.pop());
		tempColumn.addCard(rStandard.pop());
		tempColumn.addCard(rStandard.pop());
		tempColumn.addCard(rStandard.pop());
		CardStack actual = tempColumn.getAvailableCards();
		setup();
		assertEquals(rStandard.pop(),actual.pop());
		assertEquals(rStandard.pop(),actual.pop());
		assertEquals(rStandard.pop(),actual.pop());
		assertEquals(rStandard.pop(),actual.pop());
		assertEquals(rStandard.pop(),actual.pop());
	}
	
	@Test
	public void testGetAvailCardsColored()
	{
		Column tempColumn = new Column();
		tempColumn.addCard(rColored.pop());
		tempColumn.addCard(rColored.pop());
		tempColumn.addCard(rColored.pop());
		tempColumn.addCard(rColored.pop());
		tempColumn.addCard(rColored.pop());
		CardStack actual = tempColumn.getAvailableCards();
		assertEquals(colored.pop(),actual.pop());
		assertEquals(null,actual.peek());
	}
	
	@Test
	public void testGetAvailCardsNumbered()
	{
		Column tempColumn = new Column();
		tempColumn.addCard(rNumbered.pop());
		tempColumn.addCard(rNumbered.pop());
		tempColumn.addCard(rNumbered.pop());
		tempColumn.addCard(rNumbered.pop());
		tempColumn.addCard(rNumbered.pop());
		CardStack actual = tempColumn.getAvailableCards();
		assertEquals(numbered.pop(),actual.pop());
		assertEquals(null,actual.peek());
	}
	
}
