package com.codedifferently.casino;

import com.codedifferently.casino.Player;

public interface Gamble
{
      public void bet(Player player, int amount);
      public void dealMoney(Player player);

}