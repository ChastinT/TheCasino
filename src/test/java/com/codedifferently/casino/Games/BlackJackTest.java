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
        bj.setPlayerSum(player);
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
       bj.setPlayerSum(player);
        bj.setPlayerSum(twoPlayer);
        boolean expected = true;

        boolean actual = bj.compareTo(player, twoPlayer);
        
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void aceValueTest()
    {
        BlackJack bj = new BlackJack();
        Player player = new Player("Matt", 1000);
        player.addCard(new Card(Suit.SPADES, Value.ACE)); //Should be 1
        player.addCard(new Card(Suit.SPADES, Value.QUEEN)); //Should be 10
        player.addCard(new Card(Suit.SPADES, Value.SEVEN)); //Should be 7
        player.addCard(new Card(Suit.SPADES, Value.ACE)); //Should be 1
        
        bj.setPlayerSum(player);
        int expected = 19;
        Assert.assertEquals(expected, player.getSum()); 
    }
    
}