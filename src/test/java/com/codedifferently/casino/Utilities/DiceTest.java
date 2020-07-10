package com.codedifferently.casino.Utilities;

import com.codedifferently.casino.Utilities.Dice;

import org.junit.Test;
import org.junit.Assert;

public class DiceTest
{


        @Test
        public void getSideTest()
        {
                Dice dice = new Dice();
                int expected = 0;
                Assert.assertEquals(expected, dice.getSide());
        }

        

}