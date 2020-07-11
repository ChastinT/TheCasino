package com.codedifferently.casino.Utilities;

import com.codedifferently.casino.Player;
import com.codedifferently.casino.Utilities.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


    public class Deck
    {

        private Random rand = new Random(); // for getting random card
        private ArrayList<Card> cards = new ArrayList<Card>(52);

        // Fill the deck (fill ArrayList)
        public Deck()
        {
            for(Suit suit : Suit.values())
            { // iterate through each suit
                for(Value val : Value.values())
                { // iterate through each value
                    Card currentCard = new Card(suit, val);
                    cards.add(currentCard);
                }
            }
        }

        // get the cards in the deck
        public ArrayList<Card> getDeck()
        {
            return cards;
        }

        public int getDeckSize()
        {
            return cards.size();
        }

        // get a card based on index in array
        public Card getCard(int index) {
            return cards.remove(index);
        }
        
        // get a specfied Card
        public Card getCard(Suit suit, Value value)
        {
            Card currentCard = new Card();
            for (int i = 0; i < cards.size(); i++)
            {
                currentCard = cards.get(i);
                Suit currentSuit = currentCard.getSuit();
                Value currentVal = currentCard.getValue();
                if (currentSuit.equals(suit) && currentVal.equals(value))
                {
                    cards.remove(i);
                    break;
                }
            }
            return currentCard;
        }

        //Draws multiple card and adds it to players hand
        public void drawCard(int toDraw, Player player)
        {
            for (int i = 0; i <  toDraw; i++)
            {
                player.addCard(cards.get(i));
                cards.remove(i);
            }
        }

        public Card drawCard(Player player){ //drawing one card for (Go Fish) and returning that card
            Card x = new Card();
            for (int i = 0; i < 1; i++)
            {
                player.addCard(cards.get(i));
                x = cards.remove(i);
            }
            return x;
        }


        // get a random card
        public Card getRandomCard()
        {
            int cardIndex = rand.nextInt(cards.size());
            Card currentCard = cards.remove(cardIndex);
            return currentCard;
        }

        // get next card in the deck
        public Card getNextCard() {
            Card next = cards.remove(0);
            return next;
        }

        // add a card to the deck
        public void addCard(Card card)
        {
            cards.add(card);
        }

        // shuffle cards in deck
        public void shuffle()
        {
            Collections.shuffle(cards);
        }

    }
