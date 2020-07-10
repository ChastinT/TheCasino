package com.codedifferently.casino;

import com.codedifferently.casino.Player;
import com.codedifferently.casino.Utilities.Card;
import com.codedifferently.casino.Utilities.Suit;
import com.codedifferently.casino.Utilities.Value;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.CharacterData;

import java.util.ArrayList;

public class PlayerTest
{


        @Test
        public void player2Test(){
            Player player = new Player("Matt", 1000);
            Assert.assertEquals("Matt", player.getName());
            Assert.assertEquals((int)1000.00,(int) player.getMoney());
        }
        @Test
        public void player3Test(){
            ArrayList<Card> list = new ArrayList<Card>();
            list.add(new Card(Suit.SPADES, Value.FIVE));
            list.add(new Card(Suit.SPADES, Value.SIX));
            Player player = new Player("Matt", 1000, list);
            Assert.assertEquals("Matt", player.getName());
            Assert.assertEquals((int)1000.00,(int) player.getMoney());
            String expected = "Matt has: FIVE OF SPADES, SIX OF SPADES,";
            Assert.assertEquals(expected, player.checkHand());
        }

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

        @Test
        public void checkHand2Test(){
            ArrayList<Card> list = new ArrayList<Card>();
            list.add(new Card(Suit.SPADES, Value.FIVE));
            list.add(new Card(Suit.SPADES, Value.SIX));
            Player player = new Player("Matt", 1000, list);

            boolean expected = true;
            Assert.assertEquals(expected, player.checkHand(Value.SIX));
        }
        @Test
        public void checkHand3Test(){
            ArrayList<Card> list = new ArrayList<Card>();
            list.add(new Card(Suit.SPADES, Value.FIVE));
            list.add(new Card(Suit.SPADES, Value.SIX));
            Player player = new Player("Matt", 1000, list);

            boolean expected = true;
            Assert.assertEquals(expected, player.checkHand(new Card(Suit.SPADES, Value.FIVE)));
        }
        @Test
        public void getNameTest(){
            ArrayList<Card> list = new ArrayList<Card>();
            list.add(new Card(Suit.SPADES, Value.FIVE));
            list.add(new Card(Suit.SPADES, Value.SIX));
            Player player = new Player("Matt", 1000, list);

            String expected = "Matt";
            Assert.assertEquals(expected, player.getName());
        }
        @Test
        public void getMoneyTest(){
             ArrayList<Card> list = new ArrayList<Card>();
             list.add(new Card(Suit.SPADES, Value.FIVE));
             list.add(new Card(Suit.SPADES, Value.SIX));
             Player player = new Player("Matt", 1000, list);

             double expected = 1000.00;
             Assert.assertEquals((int)expected,(int) player.getMoney());
         }
    @Test
    public void setNameTest(){
        ArrayList<Card> list = new ArrayList<Card>();
        list.add(new Card(Suit.SPADES, Value.FIVE));
        list.add(new Card(Suit.SPADES, Value.SIX));
        Player player = new Player("Matt", 1000, list);
        player.setName("Matthew");
        String expected = "Matthew";
        Assert.assertEquals(expected, player.getName());
    }
    @Test
    public void setMoneyTest(){
        ArrayList<Card> list = new ArrayList<Card>();
        list.add(new Card(Suit.SPADES, Value.FIVE));
        list.add(new Card(Suit.SPADES, Value.SIX));
        Player player = new Player("Matt", 1000, list);
        player.setMoney(2000.00);
        double expected = 2000.00;
        Assert.assertEquals((int)expected,(int) player.getMoney());
    }

        @Test
        public void addCardTest()
        {
            Player player = new Player("Matt", 1000);

            player.addCard(new Card(Suit.SPADES, Value.FIVE));
            player.addCard(new Card(Suit.SPADES, Value.SIX));

            boolean expected = true;
            Assert.assertEquals(expected, player.checkHand(new Card(Suit.SPADES, Value.FIVE)));
        }

        @Test
        public void getSumTest()
        {
            Player player = new Player("Matt", 1000);

            player.addCard(new Card(Suit.SPADES, Value.FIVE));
            player.addCard(new Card(Suit.SPADES, Value.SIX));

            int expected = 0;
            Assert.assertEquals(expected, player.getSum());
        }

        @Test
        public void setSumTest()
        {
            Player player = new Player("Matt", 1000);
            player.addCard(new Card(Suit.SPADES, Value.FIVE));
            player.addCard(new Card(Suit.SPADES, Value.SIX));
            player.setSum();
            int expected = 11;
            Assert.assertEquals(expected, player.getSum());
        }

        @Test
        public void switchAceTest()
        {
            Player player = new Player("Matt", 1000);
            player.addCard(new Card(Suit.SPADES, Value.ACE));
            player.getCard(0).getValue().switchAceValue();

            int expected = 1;
            Assert.assertEquals(expected, player.getCard(0).getValue().getIntValue()); 
        }
        @Test
        public void aceValueTest()
        {
            Player player = new Player("Matt", 1000);
            player.addCard(new Card(Suit.SPADES, Value.ACE));  
            player.addCard(new Card(Suit.SPADES, Value.ACE)); 
            
            player.setSum();
            int expected = 2;
            Assert.assertEquals(expected, player.getSum()); 
        }
    
    }
