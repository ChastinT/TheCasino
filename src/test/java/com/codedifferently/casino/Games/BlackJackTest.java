package com.codedifferently.casino.Games;

import com.codedifferently.casino.Player;
import com.codedifferently.casino.Games.BlackJack;
import com.codedifferently.casino.Utilities.Card;
import com.codedifferently.casino.Utilities.Suit;
import com.codedifferently.casino.Utilities.Value;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlackJackTest 
{
   



    @Test
    public void standTester()
    {
        BlackJack bJack = new BlackJack();
        int expected = 1;
        
        bJack.stand();
        int actual = bJack.getTurn();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isBustTester()
    {
        BlackJack bj = new BlackJack();
        Player player = new Player("Dale Dimmodome");
        
        player.addCard(new Card(Suit.HEARTS, Value.QUEEN));
        player.addCard(new Card(Suit.SPADES, Value.QUEEN));
        player.addCard(new Card(Suit.HEARTS, Value.QUEEN));
        player.setSum();
        boolean expected = true;
        
        boolean actual = bj.isBust(player);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareToTest()
    {
        BlackJack bj = new BlackJack();
        Player player = new Player("Dale Dimmodome");
        Player twoPlayer = new Player("Sora");

        player.addCard(new Card(Suit.HEARTS, Value.QUEEN));
        player.addCard(new Card(Suit.SPADES, Value.FIVE));
        twoPlayer.addCard(new Card(Suit.HEARTS, Value.QUEEN));
        twoPlayer.addCard(new Card(Suit.HEARTS, Value.TWO));
        player.setSum();
        twoPlayer.setSum();
        boolean expected = true;

        boolean actual = bj.compareTo(player, twoPlayer);
        
        Assert.assertEquals(expected, actual);

    }
    
}