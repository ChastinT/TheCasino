package com.codedifferently.casino;

import com.codedifferently.casino.Player;
import com.codedifferently.casino.Utilities.Card;
import com.codedifferently.casino.Utilities.Suit;
import com.codedifferently.casino.Utilities.Value;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PlayerTest
{



         @Test
         public void checkHandTest()
         {
             ArrayList<Card> list = new ArrayList<Card>();
             list.add(new Card(Suit.SPADES, Value.FIVE));
             list.add(new Card(Suit.SPADES, Value.SIX));
             Player player = new Player("Matt", 1000, list);

             String expected = "Matt has: FIVE OF SPADES, SIX OF SPADES,";
             Assert.assertEquals(expected, player.checkHand());

         }

        public static void main(String[]args){
            ArrayList<Card> list = new ArrayList<Card>();
            list.add(new Card(Suit.SPADES, Value.FIVE));
            list.add(new Card(Suit.SPADES, Value.SIX));
            System.out.println(list.get(1).toString());
            System.out.println(list.get(2).toString());
            Player player = new Player("Matt", 1000, list);

        }
    }
