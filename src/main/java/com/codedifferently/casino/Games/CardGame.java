package com.codedifferently.casino.Games;


import com.codedifferently.casino.Player;
import com.codedifferently.casino.Utilities.Deck;

import java.util.ArrayList;

public class CardGame implements Game
    {

        protected Deck deck;
        private boolean win = false;

        // add one new player to a card game
        public void addPlayer() {
            Player newPlayer = new Player("Player", 500);
            players.add(newPlayer);
        }

        // add one new player to a card game
        public void addPlayer(Player player) 
        {
            players.add(player);
        }

        // add a specified number of players to a card game
        public void addPlayers(int numOfPlayers)
        {
            for(int i = 0; i < numOfPlayers; i++)
            {
                Player newPlayer = new Player("Player", 500);
                players.add(newPlayer);
            }
        }

        // determine if a player has won the game
        public boolean IsGameWon() {
            return win;
        }

        public String getGameName() {
            return null;
        }

        public boolean isGameWon() {
            return false;
        }

        //Will start the game
        public void play()
        {
            deck.shuffle();
        }

        public ArrayList<Player> getPlayers() {
            return null;
        }

        public String changeGameName(String name) {
            return null;
        }
    }
