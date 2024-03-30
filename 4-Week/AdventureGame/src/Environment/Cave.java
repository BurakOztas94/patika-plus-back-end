package Environment;

import Creatures.Monsters;
import Creatures.Zombie;
import Properties.Player;

public class Cave extends BattleLoc{
    public Cave (Player player)
        {
            super (player , "Cave" , new Zombie () , "Food",3);
        }
}
