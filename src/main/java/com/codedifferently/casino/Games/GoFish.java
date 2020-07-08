package com.codedifferently.casino.Games;

import com.codedifferently.casino.Games.CardGame;
import com.codedifferently.casino.Player;
import com.codedifferently.casino.Utilities.Card;
import com.codedifferently.casino.Utilities.Value;

import java.util.ArrayList;

public class GoFish extends CardGame
{

        private int turn = 1;
        private ArrayList<Card> ocean; // cards not dealt to players

        public GoFish(int players)
        {

        }

        // ask another player if they have cards of that value (Ace - King)
        public boolean ask(Player player, Value cardVal)
        {
            return player.checkHand(cardVal);
        }

        // player has to "go fish" into the ocean for a card
        public void fish(Player player, Card card) {

        }




}