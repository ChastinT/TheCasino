package com.codedifferently.casino.Utilities;

import com.codedifferently.casino.Utilities.Card;
import com.codedifferently.casino.Utilities.Suit;
import com.codedifferently.casino.Utilities.Value;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardTest {

    @Test
    public void CardConstructorTest()
    {
        // Given
        Suit cardSuit = Suit.HEARTS;
        Value cardVal = Value.THREE;

        // When
        Card card = new Card(cardSuit, cardVal);
        Suit actualSuit = card.getSuit();
        Value actualVal = card.getValue();

        // Then
        Assert.assertEquals(cardSuit, actualSuit);
        Assert.assertEquals(cardVal, actualVal);
    }

    Card card;
    @Before
    public void initialize() {
        card = new Card(Suit.HEARTS, Value.THREE);
    }

    @Test
    public void getSuitTest() {
        // Given
        Suit expectedSuit = Suit.HEARTS;

        // When
        Suit actualSuit = card.getSuit();

        // Then
        Assert.assertEquals(expectedSuit, actualSuit);
    }

    @Test
    public void getValueTest() {
        // Given
        Value expectedVal = Value.THREE;

        // When
        Value actualVal = card.getValue();

        // Then
        Assert.assertEquals(expectedVal, actualVal);
    }

    @Test
    public void toStringTest() {
        // Given
        String expected = "THREE OF HEARTS";

        // When
        String actual = card.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

}