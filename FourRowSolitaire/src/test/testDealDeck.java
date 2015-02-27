package test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import FourRowSolitaire.Card;
import FourRowSolitaire.DealDeck;
import FourRowSolitaire.DiscardPile;

public class testDealDeck {

	public static DealDeck deck;
	public static DiscardPile dis;
	public static LinkedList<Card> cards;
	@Before
	public void setup()
	{
		cards = new LinkedList<Card>();
		cards.add(new Card("Spades",9,1,9));
		cards.add(new Card("Hearts",5,1,44));
		cards.add(new Card("Clubs",2,1,15));
		cards.add(new Card("Hearts",4,1,43));
		cards.add(new Card("Diamonds",9,1,35));
		cards.add(new Card("Spades",7,1,7));
		dis = new DiscardPile(6);
	}
	
	@Test
	public void testPopOneEasy() 
	{
		deck = new DealDeck(dis,1);
		deck.setDifficulty(1);
		deck.setDeck(cards);
		assertEquals(cards.get(5),deck.pop());//Spades7 - 1
		assertEquals(cards.get(4),deck.pop());//Hearts5 -2
		deck.pop(); deck.pop(); deck.pop(); deck.pop();// 3, 4, 5, 6
		assertEquals(null,deck.pop());//Empty Deck - RESET(1)
		assertEquals(cards.get(5),deck.pop());//Spades7 - 1
		deck.pop(); deck.pop(); deck.pop(); deck.pop(); deck.pop(); deck.pop(); //2, 3, 4, 5, 6, RESET(2)
		deck.pop(); deck.pop(); deck.pop(); deck.pop(); deck.pop(); deck.pop(); //1, 2, 3, 4, 5, 6 - No Deals left
		assertFalse(deck.hasDealsLeft());
	}

	@Test
	public void testPopThreeMedium() 
	{
		deck = new DealDeck(dis,3);
		deck.setDifficulty(2);
		deck.setDeck(cards);
		assertEquals(cards.get(3),deck.pop());//Hearts4 - 3
		assertEquals(cards.get(0),deck.pop());//Spades9 - 6
		deck.pop(); deck.pop(); deck.pop(); deck.pop(); deck.pop(); deck.pop(); //RESET(1), 3, 6, RESET(2), 3, 6 - No Deals Left
		assertFalse(deck.hasDealsLeft());
	}
}
