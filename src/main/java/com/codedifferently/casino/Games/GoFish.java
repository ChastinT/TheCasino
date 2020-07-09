package com.codedifferently.casino.Games;

import com.codedifferently.casino.Games.CardGame;
import com.codedifferently.casino.Player;
import com.codedifferently.casino.Utilities.Card;
import com.codedifferently.casino.Utilities.Value;
import com.codedifferently.casino.Utilities.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class GoFish extends CardGame
{

        private int turn = 1; // keeps track of whose turn it is
        private Deck ocean = new Deck(); // cards not dealt to players
        private int matches = 0; //The number of the player's matches 
       // private Card c;

        /* Go Fish: Every player is dealt 7 cards. Users ask the player for the card value. 
           Ace is 1  and Jack\King\Queen are 11, 12, 13 respectively. 
           If the player has the card, then you take that card. If the player doesn't have the card, 
           the player has to draw from the deck.  If that card drawn from the deck matches with any card in 
           the player's hand, they can remove that card from their hand. The game ends when the first person with no cards in 
           hand wins. The person with the most matches(aka Books) wins. 

        */ 
        
        public GoFish(int numOfPlayers)
        {
            for(int i = 0; i < numOfPlayers; i++) {
                Player aPlayer = new Player();
                players.add(aPlayer);
                
            }
        }
        
        /*
        * Deal cards to players
        * Each player gets 7 cards
        */
        public void deal() {
            ocean.shuffle();
            for(int i = 0; i < 7; i++) {
                for(Player eachPlayer : players) {
                    Card nextCard = ocean.getNextCard();
                    eachPlayer.addCard(nextCard); 
                }
            }
        }

        // ask another player if they have cards of that value (Ace - King)
        public boolean ask(Player player, Value cardVal)
        { 
            return player.checkHand(cardVal);
        }

        /*
        * Player has to "go fish" into the ocean for a card
        * Also get to pick which unknown card they want from the ocean (1 - # of cards left in ocean)
        */
        public void fish(Player player, int cardInOcean) {
            if(ocean.getDeckSize() > 0) {
                Card cardFished = ocean.getCard(cardInOcean-1); // player picks from unknown cards left, return card at index
                player.addCard(cardFished); // add fished card to their hand
            }
            
        }

        public int getMatches(){
            return this.matches; 
        }

        public int setMatches(int num){
            return this.matches = num;
        }
        
        //This method counts the matches in their hand aka the duplicates
        public int countMatches(Player player){
            ArrayList<Card> hand = player.getHand();
            int match = setMatches(0); 
            for(int i = 0; i < hand.size(); i++){ //iterating through one card at a time (terrible run time lol)
                boolean isMatch = false;
                for(int j = i + 1; (!isMatch && j < hand.size()); j++){
                    if(hand.get(i).equals(hand.get(j))){
                        isMatch = true; 
                        match ++;
                    }
                }
            }  
            return setMatches(match);
        }
        
        // Determines if any player has won the game (no more cards left)
        public boolean isGameWon(){
            for(Player currentPlayer : players) {
                int handSize = currentPlayer.getHand().size();
                if(handSize == 0) {
                    return true;
                }
            }

            return false;
        }

        // Determines if the player has won the game (no more cards left)
        // Faith with fix this by checking the player with the most matches tmr!!!! (7/9/2020)
        public boolean isGameWon(Player player){
            int handSize = player.getHand().size();
            if(handSize == 0) {
                return true;
            }

            return false;
        }

        // Give the turn to the next player
        public void nextTurn() {
            if(turn != players.size()) {
                turn++;
            } else {
                turn = 1;
            }
        }




}