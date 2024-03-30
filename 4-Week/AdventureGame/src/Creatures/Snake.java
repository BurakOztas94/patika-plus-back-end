package Creatures;

import java.util.Random;

public class Snake extends Monsters{
    Snake() {
        super(4, "Snake", 0, 12, 0);
        this.setMaxDamage(6);
        this.setMinDamage(3);
    }

    @Override
    public int getDamage() {
        Random rand = new Random();
        return rand.nextInt(this.getMaxDamage() + 1 - this.getMinDamage()) + this.getMinDamage();
    }


}
