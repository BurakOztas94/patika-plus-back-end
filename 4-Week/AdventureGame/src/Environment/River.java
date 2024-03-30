package Environment;

import Creatures.Bear;

import Properties.Player;

public class River extends BattleLoc{
    public River (Player player )
        {
            super (player , "River" , new Bear () , "water",2);
        }
}
