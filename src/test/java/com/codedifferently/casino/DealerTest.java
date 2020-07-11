package com.codedifferently.casino;

import com.codedifferently.casino.Dealer;
import com.codedifferently.casino.Utilities.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.CharacterData;

import java.util.ArrayList;

public class DealerTest {
    
    @Test
    public void constructorTest() {
        // Given
        String expectedName = "John";
        double expectedMoney = 1500;
        double expectedBet = 0;

        // When
        Dealer testDealer = new Dealer();
        String actualName = testDealer.getName();
        double actualMoney = testDealer.getMoney();
        double actualBet = testDealer.getBet();

        // Then
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedMoney, actualMoney, 0);
        Assert.assertEquals(expectedBet, actualBet, 0);
    }

    Dealer dealPerson;
    @Before
    public void initialize() 
    {
        dealPerson = new Dealer();
    }

    @Test
    public void betTest() {
        // Given
        Player testPlayer = new Player();
        int betAmount = 25;

        double expectedMoney = testPlayer.getMoney() - betAmount;

        // When
        dealPerson.bet(testPlayer, betAmount);

        double actualMoney = testPlayer.getMoney();

        // Then
        Assert.assertEquals(expectedMoney, actualMoney, 0);
        Assert.assertEquals(dealPerson.getBetMoney(), betAmount, 0);
        Assert.assertEquals(testPlayer.getBet(), betAmount, 0);
    }

    @Test
    public void getBetMoneyTest() {
        // Given
        int expectedBet = 100;
        dealPerson.bet(dealPerson, expectedBet);

        // When
        int actualBet = dealPerson.getBetMoney();

        // Then
        Assert.assertEquals(expectedBet, actualBet);
    }

    @Test
    public void dealMoneyTest() {
        // Given
        Player testPlayer = new Player("Sylvester", 300);
        int betMoney = 150;
        double expectedMoney = testPlayer.getMoney() + betMoney;

        dealPerson.bet(testPlayer, betMoney);

        // When
        dealPerson.dealMoney(testPlayer);

        double actualMoney = testPlayer.getMoney();

        // Then
        Assert.assertEquals(expectedMoney, actualMoney, 0);
    }

    @Test
    public void getSumTest()
     {
        // Given

        // When

        // Then
    }

}