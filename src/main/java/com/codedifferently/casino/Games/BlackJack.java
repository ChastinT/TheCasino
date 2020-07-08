package com.codedifferently.casino.Games;

import com.codedifferently.casino.Dealer;
import com.codedifferently.casino.Games.CardGame;
import com.codedifferently.casino.Player;
import com.codedifferently.casino.Utilities.Card;
import com.codedifferently.casino.Utilities.Value;


public class BlackJack extends CardGame
    {

        private int playerSum;
        private int dealerSum;
        private Dealer dealer;
        private Player player;


        public void hitPlayer()
        {
            Card cardDrawn = deck.getRandomCard();

        }
        public void hitDealer()
        {


        }

}