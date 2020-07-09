package com.codedifferently.casino.Games;
import com.codedifferently.casino.Games.BlackJack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlackJackTest 
{
    @Test
    public void setUpTest()
    {
        BlackJack blackJack = new BlackJack();
        blackJack.getBoard();
    }

    @Test
    public void boardTester()
    {
        BlackJack blackJack = new BlackJack();
        blackJack.dealCards();
        blackJack.getBoard();
    }
}