package com.codedifferently.casino;

    public class Dealer extends Player implements Gamble
    {

        private double betMoney;

        public Dealer()
        {
            super("John", 1500);
            betMoney = 0;
        }



        public void bet(Player player, double amount)
        {
            player.setMoney(player.getMoney()-amount);
            betMoney += amount;
            player.setBet(amount);
        }

        public double getBetMoney()
        {
            return betMoney;
        }


        public void dealMoney(Player player) 
        {
            player.setMoney(player.getMoney()+(player.getBet()*2));
        }

    }
