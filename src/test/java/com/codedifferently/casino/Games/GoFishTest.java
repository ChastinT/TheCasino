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
            Assert.assertEquals(7, eachPlayer.getHand().size());
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

    @Test
    public void getMatchesTest() {
        // Given

        // When

        // Then
    }

    @Test
    public void setMatchesTest() {
        // Given

        // When

        // Then
    }

    @Test
    public void countMatchesTest() {
        // Given

        // When

        // Then

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

}
