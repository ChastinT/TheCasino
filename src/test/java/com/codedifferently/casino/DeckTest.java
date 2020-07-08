package com.codedifferently.casino;
import com.codedifferently.casino.Utilities.Card;
import com.codedifferently.casino.Utilities.Deck;
import com.codedifferently.casino.Utilities.Suit;
import com.codedifferently.casino.Utilities.Value;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class DeckTest 
{

   @Test
   public void drawTest()
   {
       Player tom = new Player("Tom",500);
       Deck deck = new Deck();
       deck.drawCard(4,tom);

      System.out.println(tom.checkHand());

   }

    @Test
    public void getDeckTest() 
    {
        // Given
        Deck test = new Deck();
        int expected =  52;
        // When
    int actual = test.getDeckSize();
        // Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getCardTest() 
    {

        // Given
        Deck testDeck = new Deck();
        Suit testSuit = Suit.SPADES;
        Value testValue = Value.ACE;

        // When
        Card testCard = testDeck.getCard(testSuit,testValue);
        Suit actualSuit = testCard.getSuit();
        Value actualValue = testCard.getValue();

        // Then
        Assert.assertEquals(testSuit, actualSuit);
        Assert.assertEquals(testValue, actualValue);

    }
    
}