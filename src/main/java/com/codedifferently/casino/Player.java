package com.codedifferently.casino;

import com.codedifferently.casino.Utilities.Card;
import com.codedifferently.casino.Utilities.Value;

import java.util.ArrayList;

  public class Player
  {
    private String name;
    private double money;

    private ArrayList<Card> hand = new ArrayList<Card>();

    public Player()
    {

    }

    public Player(String name,double money)
    {
      this.name = name;
      this.money = money;
    }

    public Player(String name,double money, ArrayList<Card> cards)
    {
      this.name = name;
      this.money = money;
      hand = cards;
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

    protected void setMoney(double enter)
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

    //Why is this needed?
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


  }
