package com.codedifferently.casino.Games;

import com.codedifferently.casino.Player;
import com.codedifferently.casino.Utilities.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

//
public class GoFish extends CardGame
{

        private int turn = 1; // keeps track of whose turn it is
        private Deck ocean = new Deck(); // cards not dealt to players
        ScanCatcher keyboard = new ScanCatcher();
        private Player turnPlayer; // pls
        private ArrayList<Card> turnHand; // hand of the player whose turn it is
        private Player choicePlayer; // player who is being asked
        private Value searchValue;
        //public boolean passed;
        public boolean guessRight;
        
        public GoFish() 
        {

        }
        
        public GoFish(ArrayList<Player> players) {
            this.players = players;
        }
        
        public GoFish(int numOfPlayers) // Generate given number of players and store in players (ArrayList)
        {   
            if(numOfPlayers >= 2){
                addPlayers(numOfPlayers);
            } else {
                System.out.println("Sorry, you have to have at least two players!");

            }
        }
        public void setup()
        {
            if(!(players.size() > 7)) 
            {
                System.out.println("Welcome to Go Fish!");
                System.out.print("Dealing cards...\n");
                deal();
            }
            
            startCheck();

        }

        // check if anyone has 4 of a kind from the start
        public void startCheck()
        {
            for(int p = 0; p < players.size(); p++) 
            { 
                for(int i = 1; i <= 13; i++) 
                {
                    Player eachPlayer = players.get(p);
                    Value currentVal = numToValue(i);
                    if(countMatches(eachPlayer, currentVal) == 4) 
                    {
                        removeAllOccurrences(eachPlayer, currentVal);
                    }
                }
            }
        }

        public Player getPlayerChoice()
        {  
            int playerChoice = 1;

                System.out.print("Which player do you want to ask? ");
                playerChoice = keyboard.nextInt();
                while(playerChoice < 1 || playerChoice > players.size()) 
                {
                    System.out.print("Invalid player. Please choose a player (1-" + players.size() + "): ");
                    playerChoice = keyboard.nextInt();
                }
                
            choicePlayer = players.get(playerChoice -1);

          return choicePlayer;
        }

        public Value getSearchInt()
        {
            int searchInt = 1;
                    System.out.print("Which value are you asking for? ");
                    searchInt = keyboard.nextInt();
                    while(searchInt < 1 || searchInt > 13) 
                    {
                        System.out.print("Invalid value. Please choose a value (1-13): ");
                        searchInt = keyboard.nextInt();
                    }

            searchValue = numToValue(searchInt);

            return  searchValue;

        }

        //Getting an error here
        public void takePlayerCard(Player choicePlayer)
        { 
            System.out.print("They have " + searchValue + "'s! "); 
            turnHand.addAll(removeAllOccurrences(choicePlayer, searchValue)); // need to remove all occurrences and give to asking player
            if (countMatches(turnPlayer, searchValue) == 4) 
            {
                System.out.println("You have a 4 of kind with " + searchValue);
                removeAllOccurrences(turnPlayer, searchValue); //Why is this here?
                if(isGameEnded()) 
                { 
                    System.out.print("Player " + turn + " wins!");
                }
            }
            System.out.println("Your hand now looks like this:\n");
            
         } 
    
         public Card getFish()
         {
            int fishChoice = 1;
            System.out.print("Pick a number 1-" + ocean.getDeckSize() + " to fish: ");
            fishChoice = keyboard.nextInt();
            while(fishChoice <= 0 || fishChoice > ocean.getDeckSize())
            {
                System.out.print("Invalid number. Pick a number 1-" + ocean.getDeckSize() + " to fish: ");
                fishChoice = keyboard.nextInt();
            }
                           
            return fish(turnPlayer, fishChoice);
        }

        public void checkFishCard(Card fished)
        {
            if(!(fished.getValue().equals(searchValue))) 
            {
                guessRight = false;
            } 
            else if(countMatches(turnPlayer, searchValue) == 4) 
            {
                removeAllOccurrences(turnPlayer, searchValue);
                if(isGameEnded()) 
                { 
                    System.out.print("Player " + turn + " wins!");
                }
                System.out.println("Your fished your card! It's still your turn:");
            } 
            else 
            {
                System.out.println("Your fished your card! It's still your turn:");
            }

        } 

        public void guessCard()
        {
            do{
                System.out.println(turnHand);
                if (ask(getPlayerChoice(), getSearchInt())) 
                {
                    takePlayerCard(choicePlayer);
                } 
                else 
                {
                    System.out.print("They don't have any " + searchValue + "\'s. Go Fish! ");
                    checkFishCard(getFish());
                }
            } while(guessRight); 
        } 

        public void continueGame()
        {
            turnPlayer = players.get(turn - 1);
            turnHand = turnPlayer.getHand();

            System.out.println("\nIt is now Player " + turn + "\'s turn. Here are your cards: ");

            guessRight = true;
            guessCard();  
        }
  
        // Play the Go Fish game
        public void play()
        {
            setup();
            while(!isGameEnded()) 
            {
                continueGame();
                nextTurn();
            }
            System.out.print("Player " + turn + " wins!");
        }
         
            
       /*
        * Deal cards to players
        * Each player gets 7 cards
        */
        public void deal() 
        {
            ocean.shuffle();
            for(int i = 0; i < 7; i++) 
            {
                for(Player eachPlayer : players) 
                {
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
        public Card fish(Player player, int cardInOcean) 
        {
            if(ocean.getDeckSize() > 0) 
            {
                Card cardFished = ocean.getCard(cardInOcean-1); // player picks from unknown cards left, return card at index
                player.addCard(cardFished); // add fished card to their hand
                return cardFished;
            }
            return null;
        }
 
        //This method counts the number of occurences of a value
        public int countMatches(Player player, Value v)
        {
            int matches = 0;
            ArrayList<Card> hand = player.getHand();
            for(int i = 0; i < hand.size(); i++)
            { 
                if(hand.get(i).getValue().equals(v)) 
                {
                    matches++;
                }
            }
            return matches;
        }
        
        // Determines if the game is ended (no more cards left) in one of the player's hand. 
        public boolean isGameEnded(){
            for(Player currentPlayer : players) 
            {
                int handSize = currentPlayer.getHand().size();
                if(handSize == 0) 
                {
                    return true;
                }
            }
            return false;
        }

        // Give the turn to the next player
        public void nextTurn() 
        {
            if(turn != players.size()) 
            {
                turn++;
            } 
            else 
            {
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
        public ArrayList<Card> removeAllOccurrences(Player player, Value cardVal) 
        {
            ArrayList<Card> removedCards = new ArrayList<Card>();

            ArrayList<Card> playerHand = player.getHand();

            for(int i = 0; i < playerHand.size(); i++) 
            {
                if(playerHand.get(i).getValue().equals(cardVal)) 
                {
                    removedCards.add(playerHand.remove(i));
                    i--;
                }
            }
            
            return removedCards;
        }

}   