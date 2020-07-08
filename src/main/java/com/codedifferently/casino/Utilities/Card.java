package com.codedifferently.casino.Utilities;

public class Card {

    public enum Suit {HEARTS, DIAMONDS, SPADES, CLUBS}; // Suit can only be of these 4
    public enum Value {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}; // Value can only be of these

    private Suit suit;
    private Value value;

    // Make a card with specified suit and value
    public Card(Suit aSuit, Value aValue) {
        suit = aSuit;
        value = aValue;
    }

    // Returns the suit of the card
    public Suit getSuit() {
        return suit;
    }

    // Returns the value of the card
    public Value getValue() {
        return value;
    }

    // Returns state of card (suit and value)
    public String toString() {
        return value + " OF " + suit;
    }

}