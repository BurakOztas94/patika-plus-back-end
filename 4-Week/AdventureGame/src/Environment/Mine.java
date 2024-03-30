package Environment;

import Creatures.Monsters;
import Creatures.Snake;
import Properties.Player;

public class Mine extends BattleLoc{
    public Mine (Player player )
        {
            super (player,"Mine","Snake",getAward ,getMaxMonster);

        }
}
