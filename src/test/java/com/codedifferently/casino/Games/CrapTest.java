package com.codedifferently.casino.Games;
import com.codedifferently.casino.Player;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

public class CrapTest
{
    @Test
    public void tester()
    {
        System.out.println("This works");
    }

    @Test
    public void whoIsFirstTestMax()
    {
        //Given
        Craps crap = new Craps();
        crap.highOrLow = "High";
        Player carter = new Player("Carter");
        Player scar = new Player("Scar");
        Player kris = new Player("Kris");
        Player simba = new Player("Simba");
        
        //When
        crap.getPlayers().add(carter);
        crap.getPlayers().get(0).setDice(1);

        crap.getPlayers().add(kris);
        crap.getPlayers().get(1).setDice(5);

        crap.getPlayers().add(scar);
        crap.getPlayers().get(2).setDice(12);

        crap.getPlayers().add(simba);
        crap.getPlayers().get(3).setDice(7);

        Player expected = crap.getPlayers().get(2); //Should be player with highest dice int
        crap.decideWhoIsShooter();

        //Then
        Assert.assertEquals(expected, crap.getPlayers().get(0));

    }

    @Test
    public void whoIsFirstTestMin()
    {
        //Given
        Craps crap = new Craps();
        crap.highOrLow = "Low";
        Player carter = new Player("Carter");
        Player scar = new Player("Scar");
        Player kris = new Player("Kris");
        Player simba = new Player("Simba");
        
        //When
        crap.getPlayers().add(carter);
        crap.getPlayers().get(0).setDice(12);

        crap.getPlayers().add(kris);
        crap.getPlayers().get(1).setDice(1);

        crap.getPlayers().add(scar);
        crap.getPlayers().get(2).setDice(4);

        crap.getPlayers().add(simba);
        crap.getPlayers().get(3).setDice(3);

        Player expected = crap.getPlayers().get(1); //Should be player lowest dice int
        crap.decideWhoIsShooter();

        //Then
        Assert.assertEquals(expected, crap.getPlayers().get(0));

    }

    @Test
    public void constructorTest() {
        // Given
        String gameName = "Craps";

        // When
        Craps craps = new Craps();
        String actualName = craps.getGameName();

        // Then
        Assert.assertEquals(gameName, actualName);
    }

    Craps craps;
    @Before
    public void initialize() 
    {
        craps = new Craps();
    }

    @Test
    public void getGameNameTest() {
        // Given
        String gameName = "Craps";

        // When
        String actualName = craps.getGameName();

        // Then
        Assert.assertEquals(gameName, actualName);
    }

    //Is this supposed to get a player from the players arrayList or  the size?
    @Test
    public void getPlayersTest() {
        // Given

        // When
        craps.addPlayers(2);
        // Then
        Assert.assertEquals(2, craps.getPlayers().size());
    }

    @Test
    public void sumOfDieTest() {
        // Given
        Player player = new Player();
        // When
        int actual = craps.sumOfDie(player);
        // Then
        Assert.assertEquals(craps.getFirstDie()+craps.getSecondDie(), actual);
    }

    @Test
    public void getStartingRollTest() 
    {
        // Given
        Player player = new Player();
        // When
        craps.addPlayer(player);
        craps.getStartingRoll();
        // Then
        Assert.assertEquals(craps.getFirstDie() + craps.getSecondDie(), craps.getSumOfDie(player));

    }


    @Test
    public void rollDiceTest() {
        // Given

        // When
        craps.rollDice();;
        // Then
        Assert.assertNotEquals(0, craps.getFirstDie());
        Assert.assertNotEquals(0, craps.getSecondDie());
    }

    @Test
    public void betTest() {
        // Given
        Player player = new Player();
        // When
        craps.bet(player, 50);
        // Then
        Assert.assertEquals(50, player.getBet());
    }

    //Complete
    @Test
    public void dealMoneyTest() {
       // Given
       Player player = new Player();
       double expected = player.getMoney() + 100;
       // When
       craps.bet(player, 50);
       craps.dealMoney(player);
       // Then
       Assert.assertEquals(expected, player.getMoney(),0);
    }


    @Test
    public void addPlayerTest() {
        // Given

        // When
        craps.addPlayer();
        // Then
        Assert.assertEquals(1, craps.getPlayers().size());
    }

    @Test
    public void addPlayerSpecificTest() {
         // Given
        Player player = new Player();
        // When
        craps.addPlayer(player);
        // Then
        Assert.assertEquals(1, craps.getPlayers().size());
    }

    @Test
    public void addPlayersTest() {
         // Given

        // When
        craps.addPlayers(2);
        // Then
        Assert.assertEquals(2, craps.getPlayers().size());
    }

}