package com.codedifferently.casino.Utilities;

import com.codedifferently.casino.Utilities.Card;
import com.codedifferently.casino.Utilities.Suit;

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
                    cards.remove(currentCard);
                }
            }
            return currentCard;
        }


        // get a random card
        public Card getRandomCard()
        {
           int cardIndex = rand.nextInt(cards.size());
            Card currentCard = cards.get(cardIndex);
            cards.remove(currentCard);
            return currentCard;
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
