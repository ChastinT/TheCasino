package com.codedifferently.casino.Games;


import com.codedifferently.casino.Player;
import com.codedifferently.casino.Utilities.Deck;

import java.util.ArrayList;

public class CardGame implements Game
    {

        protected Deck deck = new Deck();
        private boolean win = false;
        protected ArrayList<Player> players = new ArrayList<Player>();

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
                //Will create player with their name being their position, ie: Player 1, Player 2
                Player newPlayer = new Player("Player "+(i+1), 500);
                players.add(newPlayer);
            }
        }

        // determine if a player has won the game
        public boolean isGameWon()
        {
            return win;
        }

        public String getGameName() {
            return null;
        }


        //Will start the game
        public void play()
        {
            deck.shuffle();
        }

        public ArrayList<Player> getPlayers() {
            return players;
        }

        public String changeGameName(String name) {
            return null;
        }
    }
