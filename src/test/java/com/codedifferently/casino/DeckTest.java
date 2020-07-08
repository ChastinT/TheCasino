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
    public void constructorTest() 
    {
        // Given

        // When

        // Then

    }

    @Before
    public Deck initialize()
    {
        Deck testDeck = new Deck();
        return testDeck;
    }

    @Test
    public void getDeckTest() 
    {
        // Given

        // When

        // Then

    }

    @Test
    public void getCardTest() 
    {
        // Given
        Suit testSuit = Suit.SPADES;
        Value testValue = Value.ACE;

        // When
        Card testCard = initialize().getCard(testSuit,testValue);
        Suit actualSuit = testCard.getSuit();
        Value actualValue = testCard.getValue();

        // Then
        Assert.assertEquals(testSuit, actualSuit);
        Assert.assertEquals(testValue, actualValue);

    }
    
}