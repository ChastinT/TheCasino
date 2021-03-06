package com.codedifferently.casino;

import com.codedifferently.casino.Utilities.*;


import java.util.ArrayList;

  public class Player
  {
    private String name;
    private double money;
    private int sum; //Used for blackjack to decide hand value
    private int bet; //Used to decide how much money the player will bet
    private int diceValue; //Used for craps 
    private boolean pass;
    protected ArrayList<Card> hand = new ArrayList<Card>();

    public Player()
    {
      name = "John Doe";
      money = 100;
      sum = 0;
    }

    public Player(String name){
      this.name = name;
      this.money = 100; 
      sum = 0; 
    }

    public Player(String name,double money)
    {
      this.name = name;
      this.money = money;
      sum = 0;
    }

    /**
     * Helps test the Player class
     */
    public Player(String name,double money, ArrayList<Card> cards)
    {
      this.name = name;
      this.money = money;
      hand = cards;
      sum = 0;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String enter)
    {
      name = enter;
    }

    public double getMoney()
    {
        return money;
    }

    public void setMoney(double enter)
    {
      this.money = enter;
    }

    public String checkHand()
    {
      String cardHand = name+ " has: ";
      for(int i = 0; i < hand.size(); i++){
        cardHand = cardHand + hand.get(i).toString() + ", ";
      }

      return cardHand.trim();
    }

    public boolean checkHand(Value cardVal)

    {
      for(int i = 0; i < hand.size(); i++)
      {
        if(hand.get(i).getValue() == cardVal)
        {
          return true;
        }
      }
      return false;
    }
    
    public boolean checkHand(Card card)
    {
      for(int i = 0; i < hand.size(); i++)
      {
        if(hand.get(i).toString().equals(card.toString()))
        {
          return true;
        }
      }
      return false;
    }

    public void addCard(Card card)
    {
      hand.add(card);
    }

    public Card removeCard(Card card) { hand.remove(card); return card;} // remove a specific card

    public Card removeCard() { // remove card from front of hand
      Card removed = hand.get(0);
      hand.remove(0);
      return removed;
    }

    /*Sets the players sum*/
    public void setSum(int enter)
    {
      sum = enter;
    }

   

    public int getSum(){
      return sum;
    }

    public void setBet(int betting)
    {
      bet = betting;
    }

    public int getBet()
    {
      return bet;
    } 

    public ArrayList<Card> getHand()
    {
      return hand;
    }

    public Card getCard(int getter)
    {
      return hand.get(getter);
    }


    public boolean checkAce(int result,boolean loopedAlready)
    {
      if ((checkHand(Value.ACE) && (result > 21)) && loopedAlready == false)
      {
        for (int i = 0; i< hand.size();i++)
        {
          if (hand.get(i).getValue() == Value.ACE && hand.get(i).getValue().getIntValue() == 11)
          {
            hand.get(i).getValue().switchAceValue();
          }
        }
        loopedAlready = true;
        return true;

      }
      else if (loopedAlready == true)
      {
        return false;
      }
      return false;
    }

    public void setHand(ArrayList<Card> cards) 
    {
      hand = cards;
    }

    public int getDice()
    {
      return diceValue;
    }

    public void setDice(int enter)
    {
      diceValue = enter;
    }

    public void setPass(int choice){
      if(choice == 1){
        pass = true;
      }
      else
      {
        pass = false;
      }
    }

    public boolean pass(){
      return pass;
    }

  }
