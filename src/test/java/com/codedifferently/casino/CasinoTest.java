package com.codedifferently.casino;

import com.codedifferently.casino.Games.BlackJack;


import org.junit.Test;

public class CasinoTest
{

    

    @Test
    public void gameTest()
    {
      Casino casino = new Casino();
            BlackJack bJack = new BlackJack();
      
      casino.setGame(bJack);
    }

}
