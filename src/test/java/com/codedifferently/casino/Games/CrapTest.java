package com.codedifferently.casino.Games;
import com.codedifferently.casino.Player;

import org.junit.Test;

public class CrapTest
{
    @Test
    public void tester()
    {
        System.out.println("This works");
    }

    @Test
    public void whoIsFirstTest()
    {
        Craps crap = new Craps();
        Player carter = new Player("Carter");
        Player scar = new Player("Scar");
        Player kris = new Player("Kris");
        Player simba = new Player("Simba");
        crap.getPlayers().add(carter);
        crap.getPlayers().add(kris);
        crap.getPlayers().add(scar);
        crap.getPlayers().add(simba);

        crap.decideWhoIsFirst();

        for (int i = 0; i< crap.getPlayers().size();i++)
        {
            System.out.println(crap.getPlayers().get(i).getName());
        }

    }


}