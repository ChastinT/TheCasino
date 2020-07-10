package com.codedifferently.casino.Games;

import com.codedifferently.casino.Player;
import com.codedifferently.casino.Utilities.Card;
import com.codedifferently.casino.Utilities.Deck;
import com.codedifferently.casino.Utilities.Suit;
import com.codedifferently.casino.Utilities.Value;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class GoFishTest {

    GoFish goFish;

    @Test
    public void constructorTest() {
        // Given
        int numOfPlayers = 4;

        // When
        goFish = new GoFish(4);

        // Then
        Assert.assertEquals(numOfPlayers, goFish.getPlayers().size());
    }

    ArrayList<Player> currentPlayers;
    Player currentPlayer;
    @Before
    public void initialize() {
        goFish = new GoFish(4);
        currentPlayers = goFish.getPlayers();
        currentPlayer = currentPlayers.get(0);
    }

    @Test
    public void dealTest() {
        // Given
        int numOfCards = 7;
        ArrayList<Player> currentPlayers = goFish.getPlayers();

        // When
        goFish.deal();

        // Then
        for(Player eachPlayer : currentPlayers) {
<<<<<<< HEAD
            Assert.assertEquals(numOfCards, eachPlayer.getHand().size());
=======
            Assert.assertEquals(7, eachPlayer.getHand().size());
>>>>>>> f00afa4c64da254025681c150a8ab159320cdf76
        }
    }

    @Test
    public void askTest() {
        // Given
        Card cardExpected = new Card(Suit.SPADES, Value.ACE);

        // When
        currentPlayer.addCard(cardExpected);
        boolean actual = goFish.ask(currentPlayer, cardExpected.getValue());


        // Then
        Assert.assertEquals(true, actual);
    }

    @Test
    public void fishTest() {
        // Given
        Card expected = new Card(Suit.DIAMONDS, Value.SIX);
        goFish.getOcean().addCard(expected);
        int pickedCardIndex = goFish.getOcean().getDeckSize();

        // When
        goFish.fish(currentPlayer, pickedCardIndex);

        // Then
        Assert.assertTrue(currentPlayer.checkHand(expected));
    }
<<<<<<< HEAD
 //Not sure we need to test acessors and getters?
    @Test
    public void getMatchesTest() {
        // Given
        
=======

    @Test
    public void getMatchesTest() {
        // Given
>>>>>>> f00afa4c64da254025681c150a8ab159320cdf76

        // When

        // Then
    }

    @Test
    public void setMatchesTest() {
        // Given

        // When

        // Then
    }

<<<<<<< HEAD
    /*Test is Completed now - Faith */
    @Test
    public void countMatchesTest() {
        // Given
        //get one of the players
        currentPlayer = currentPlayers.get(0);
        //set their hand to have certain cards??
        // Yea that's what I did in another test (Had to create setHand method in Player)
        ArrayList<Card> hand = new ArrayList<Card>();
        Card a = new Card(Suit.HEARTS, Value.FOUR); 
        Card b = new Card(Suit.HEARTS, Value.FOUR); 
        Card c = new Card(Suit.HEARTS, Value.TWO);
        currentPlayer.setHand(hand);
        currentPlayer.addCard(a); 
        currentPlayer.addCard(b);
        currentPlayer.addCard(c);

        int expected = 2; 

        // When
        int actual = goFish.countMatches(currentPlayer, a.getValue()); 

        // Then
        Assert.assertEquals(expected, actual);
=======
    @Test
    public void countMatchesTest() {
        // Given

        // When

        // Then
>>>>>>> f00afa4c64da254025681c150a8ab159320cdf76

    }

    @Test
    public void isGameWonTest() {
        // Given
        for(int i = 0; i < currentPlayer.getHand().size(); i++) { // empty the hand
            currentPlayer.removeCard();
        }

        // When
        boolean gameWon = goFish.isGameWon();

        // Then
        Assert.assertTrue(gameWon);
    }

<<<<<<< HEAD
    //Faith - I'll fix this 
    @Test
    public void whoWonGameTest() {
       //Given 

       //When

       //Then
=======
    @Test
    public void isGameWonTestPlayer() {
        // Given
        for(int i = 0; i < currentPlayer.getHand().size(); i++) { // empty the hand
            currentPlayer.removeCard();
        }

        // When
        boolean gameWon = goFish.isGameWon(currentPlayer);

        // Then
        Assert.assertTrue(gameWon);
>>>>>>> f00afa4c64da254025681c150a8ab159320cdf76
    }

    @Test
    public void nextTurnTest() {
        // Given
        int turn = goFish.getTurn();

        // When
        goFish.nextTurn();
        int actualTurn = goFish.getTurn();

        // Then
        Assert.assertEquals(turn + 1, actualTurn);
    }

    @Test
    public void getOceanTest() {
        // Given
        goFish.deal();
        int deckSize = 52 - (currentPlayers.size() * 7);

        // When
        Deck actualOcean = goFish.getOcean();
        int actualOceanSize = actualOcean.getDeckSize();

        // Then
        Assert.assertEquals(deckSize, actualOceanSize);
    }

    @Test
    public void getTurnTest() {
        // Given
        int expectedTurn = 1;

        // When
        int actualTurn = goFish.getTurn();

        // Then
        Assert.assertEquals(expectedTurn, actualTurn);
    }

<<<<<<< HEAD
    @Test
    public void numToValueTest() {
        // Given
        int num = 12;
        Value expectedVal = Value.QUEEN;

        // When
        Value actualVal = goFish.numToValue(num);

        // Then
        Assert.assertEquals(expectedVal, actualVal);
    }

    @Test
    public void removeAllOccurrencesTest() {
        // Given
        ArrayList<Card> hand = new ArrayList<Card>();
        Value currentVal = Value.NINE;
        Card newCard1 = new Card(Suit.DIAMONDS, currentVal);
        Card newCard2 = new Card(Suit.SPADES, currentVal);
        Card newCard3 = new Card(Suit.HEARTS, currentVal);
        hand.add(newCard1);
        hand.add(newCard2);
        hand.add(newCard3);
        currentPlayer.setHand(hand);

        // When
        goFish.removeAllOccurrences(currentPlayer, currentVal);
        int handSize = currentPlayer.getHand().size();

        // Then
        Assert.assertEquals(0, handSize);
    }

}
    
=======
}
>>>>>>> f00afa4c64da254025681c150a8ab159320cdf76
