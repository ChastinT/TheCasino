package com.codedifferently.casino.Games;

import com.codedifferently.casino.Player;
import com.codedifferently.casino.Utilities.Card;
import com.codedifferently.casino.Utilities.Value;
import com.codedifferently.casino.Utilities.Deck;

import java.util.ArrayList;
import java.util.Scanner;

public class GoFish extends CardGame
{

        private int turn = 1; // keeps track of whose turn it is
        private Deck ocean = new Deck(); // cards not dealt to players
        private int matches = 0; //The number of the player's matches; Brent - Not sure why we have this field?
     
        
        // Play the Go Fish game
        public void play() {
            Scanner keyboard = new Scanner(System.in);

            System.out.println("Welcome to Go Fish!");
            System.out.print("Dealing cards...\n");
            deal();

            for(int p = 0; p < players.size(); p++) { // check if anyone has 4 of a kind from the start
                for(int i = 1; i <= 13; i++) {
                    Player eachPlayer = players.get(p);
                    Value currentVal = numToValue(i);
                    if(countMatches(eachPlayer, currentVal) == 4) {
                        removeAllOccurrences(eachPlayer, currentVal);
                    }
                }
            }

            while(!isGameEnded()) {
                Player turnPlayer = players.get(turn - 1);
                ArrayList<Card> turnHand = turnPlayer.getHand();

                System.out.println("\nIt is now Player " + turn + "\'s turn. Here are your cards: ");

                boolean guessRight = true;
                do {
                    System.out.println(turnHand);
                    System.out.print("Which player do you want to ask? ");
                    int playerChoice = keyboard.nextInt() - 1;
                    Player choicePlayer = players.get(playerChoice);
                    System.out.print("Which value are you asking for? ");
                    int searchInt = keyboard.nextInt();
                    Value searchValue = numToValue(searchInt);

                    if (ask(choicePlayer, searchValue)) {
                        System.out.print("They have " + searchValue + "'s! ");
                        turnHand.addAll(removeAllOccurrences(choicePlayer, searchValue)); // need to remove all occurrences and give to asking player
                        if (countMatches(turnPlayer, searchValue) == 4) {
                            System.out.println("You have a 4 of kind with " + searchValue);
                            removeAllOccurrences(turnPlayer, searchValue);
                            if(isGameEnded()) { 
                                System.out.print("Player " + turn + " wins!");
                                break;
                            }
                        }
                        System.out.println("Your hand now looks like this:\n");
                    } else {
                        System.out.print("They don't have any " + searchValue + "\'s. Go Fish! ");
                        System.out.print("Pick a number 1-" + ocean.getDeckSize() + " to fish: ");
                        int fishChoice = keyboard.nextInt() - 1;
                        Card fished = fish(turnPlayer, fishChoice);
                        if(!(fished.getValue().equals(searchValue))) {
                            guessRight = false;
                        } else if(countMatches(turnPlayer, searchValue) == 4) {
                            removeAllOccurrences(turnPlayer, searchValue);
                            if(isGameEnded()) { 
                                System.out.print("Player " + turn + " wins!");
                                break;
                            }
                            System.out.println("Your fished your card! It's still your turn:");
                        } else {
                            System.out.println("Your fished your card! It's still your turn:");
                        }
                    }
                } while(guessRight);
                
                if(isGameEnded()) {System.out.print("Player " + turn + " wins!");}

                nextTurn();
            }

            keyboard.close();
        }
         
        public GoFish() {
            
        }
        
        public GoFish(int numOfPlayers) // Generate given number of players and store in players (ArrayList)
        {
            addPlayers(numOfPlayers);
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
        public Card fish(Player player, int cardInOcean) {
            if(ocean.getDeckSize() > 0) {
                Card cardFished = ocean.getCard(cardInOcean-1); // player picks from unknown cards left, return card at index
                player.addCard(cardFished); // add fished card to their hand
                return cardFished;
            }
            return null;
        }

        public int getMatches(){
            return this.matches; 
        }

        public int setMatches(int num){
            return this.matches = num;
        }
        
        //This method counts the number of occurences of a value
        // @Faith - I think your method checks if two cards are the same (suit and value)
        // *Only needs to check the value of each card to determine a match*
        public int countMatches(Player player, Value v){
            int matches = 0;
            ArrayList<Card> hand = player.getHand();
            for(int i = 0; i < hand.size(); i++){ //iterating through one card at a time (terrible run time lol)
                if(hand.get(i).getValue().equals(v)) {
                    matches++;
                }
            }
            return matches;
        }
        
        // Determines if the game is ended (no more cards left) in one of the player's hand. 
        public boolean isGameEnded(){
            for(Player currentPlayer : players) {
                int handSize = currentPlayer.getHand().size();
                if(handSize == 0) {
                    return true;
                }
            }
            return false;
        }

        //This method has to change as well:
        /*

        // Determines what player won the game after the game is ended. 
        public String whoWonGame(ArrayList<Player> player){
            //iterating through all of the players to find the person with the most matches
            //createing a helper arraylist to store the values of the matches
            ArrayList<Integer> playerMatches = new ArrayList<Integer>();
            for(int i = 0; i < player.size(); i++){
                playerMatches.add(countMatches(player.get(i)));   
            }

            //finding the max num of matches in the playerMatches array
            int max = playerMatches.get(0); 
            int maxPlayer = 0; 
            for(int i = 1; i < playerMatches.size(); i++){
                if(playerMatches.get(i) > max){
                    max = playerMatches.get(i); 
                    maxPlayer = i; 
                }
            }
            return "Player " + maxPlayer + "won with " + playerMatches.get(maxPlayer); 

        } */

        // Give the turn to the next player
        public void nextTurn() {
            if(turn != players.size()) {
                turn++;
            } else {
                turn = 1;
            }
        }

        // return the cards not dealt
        public Deck getOcean() {
            return ocean;
        }

        // return whose turn it is (1 - # of players)
        public int getTurn() {
            return turn;
        }

        // returns value (A-K) based on number (1-13)
        public Value numToValue(int val) {
            switch(val) {
                case 1: return Value.ACE;
                case 2: return Value.TWO;
                case 3: return Value.THREE;
                case 4: return Value.FOUR;
                case 5: return Value.FIVE;
                case 6: return Value.SIX;
                case 7: return Value.SEVEN;
                case 8: return Value.EIGHT;
                case 9: return Value.NINE;
                case 10: return Value.TEN;
                case 11: return Value.JACK;
                case 12: return Value.QUEEN;
                case 13: return Value.KING;
            }
            return null;
        }

        // remove all occurrences of a card value
        public ArrayList<Card> removeAllOccurrences(Player player, Value cardVal) {
            ArrayList<Card> removedCards = new ArrayList<Card>();

            ArrayList<Card> playerHand = player.getHand();

            for(int i = 0; i < playerHand.size(); i++) {
                if(playerHand.get(i).getValue().equals(cardVal)) {
                    removedCards.add(playerHand.remove(i));
                    i -= 1;
                }
            }

            return removedCards;
        }


}   