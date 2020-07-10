package com.codedifferently.casino;

import com.codedifferently.casino.Utilities.Card;
import com.codedifferently.casino.Utilities.Value;

import java.util.ArrayList;

  public class Player
  {
    private String name;
    private double money;
    private int sum;
    private double bet;
    private boolean loopedAlready = false;//To check if a method already looped through itself

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

    /* Adds the values from all cards in the hand to the players sum,needs to be worked on to take into account ACE*/
    public void setSum()
    {
     
      sum = 0;
      for (int i = 0; i < hand.size();i++)
      {
       
        sum+= hand.get(i).getValue().getIntValue();
      }

        if (checkAce(getSum(),loopedAlready))
        {
          setSum();
        }

        loopedAlready = false;
          
    }

   

    public int getSum(){
      return sum;
    }

    public void setBet(double betting)
    {
      bet = betting;
    } 

    public double getBet()
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
      return false;
    }

    public void setHand(ArrayList<Card> cards) {
      hand = cards;
    }


  }
