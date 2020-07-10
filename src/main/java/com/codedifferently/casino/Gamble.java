package com.codedifferently.casino;

import com.codedifferently.casino.Player;

public interface Gamble
{
      public void bet(Player player, double amount);
      public void dealMoney(Player player);

}