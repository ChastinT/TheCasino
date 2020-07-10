package com.codedifferently.casino.Games;

import com.codedifferently.casino.Player;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

public class CardGameTest {
    
    CardGame cGame;
    @Before
    public void initialize() {
        cGame = new CardGame();
    }
    
    @Test
    public void addPlayerTest() {
        // Given
        Player expected = new Player("Player", 500);

        // When
        cGame.addPlayer();
        Player actual = cGame.getPlayers().get(cGame.getPlayers().size()-1);

        // Then
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getMoney(), actual.getMoney(), 0);
    }

    @Test
    public void addPlayerSpecificTest() {
        // Given
        Player expected = new Player("Bugs Bunny", 1000);

        // When
        cGame.addPlayer(expected);
        Player actual = cGame.getPlayers().get(cGame.getPlayers().size()-1);

        // Then
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getMoney(), actual.getMoney(), 0);
    }

    @Test
    public void addPlayersTest() {
        // Given
        Player expected1 = new Player("Player 1", 500);
        Player expected2 = new Player("Player 2", 500);

        // When
        cGame.addPlayers(2);
        Player actual1 = cGame.getPlayers().get(cGame.getPlayers().size()-2);
        Player actual2 = cGame.getPlayers().get(cGame.getPlayers().size()-1);

        // Then
        Assert.assertEquals(expected1.getName(), actual1.getName());
        Assert.assertEquals(expected1.getMoney(), actual1.getMoney(), 0);
        Assert.assertEquals(expected2.getName(), actual2.getName());
        Assert.assertEquals(expected2.getMoney(), actual2.getMoney(), 0);
    }

    @Test
    public void isGameWonTest() {
        // Given
        boolean expected = false;

        // When
        boolean actual = cGame.isGameWon();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getGameNameTest() {
        // Given

        // When

        // Then
    }

    @Test
    public void getPlayersTest() {
        // Given
        Player player1 = new Player("Daffy", 100);
        Player player2 = new Player("Tweety", 200);
        cGame.addPlayer(player1);
        cGame.addPlayer(player2);

        // When
        ArrayList<Player> actualPlayers = cGame.getPlayers();

        // Then
        Assert.assertEquals(player1.getName(), actualPlayers.get(0).getName());
        Assert.assertEquals(player1.getMoney(), actualPlayers.get(0).getMoney(), 0);
        Assert.assertEquals(player2.getName(), actualPlayers.get(1).getName());
        Assert.assertEquals(player2.getMoney(), actualPlayers.get(1).getMoney(), 0);
    }

}
