package Environment;

import Creatures.Monsters;
import Creatures.Vampire;
import Properties.Player;

public class Forest extends BattleLoc{
    public Forest (Player player )
        {
            super (player , "Forest" , new Vampire () , "firewood",3);
        }
}
