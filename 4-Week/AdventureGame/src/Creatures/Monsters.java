package Creatures;

public class Monsters {
    private int id ;
    private String name;
    private int damage;
    private int health;
    private int award;
    private int  originalHealth ;
    private int minDamage;
    private int maxDamage;

    public Monsters (int id , String name , int damage , int health,int award  )
        {
            this.id = id;
            this.name = name;
            this.damage = damage;
            this.originalHealth = health;
            this.award=award;

        }

    public int getId ()
        {
            return id;
        }

    public void setId (int id)
        {
            this.id = id;
        }

    public int getDamage ()
        {
            return damage;
        }

    public void setDamage (int damage)
        {
            this.damage = damage;
        }

    public int getHealth ()
        {
            return health;
        }

    public void setHealth (int health)
        {
            if(health<0) {
                health=0;
            }
            this.health = health;
        }

    public String getName ()
        {
            return name;
        }

    public void setName (String name)
        {
            this.name = name;
        }
    public int getAward ()
        {
            return award;
        }

    public void setAward (int award)
        {
            this.award = award;
        }

    public int getOriginalHealth ()
        {
            return originalHealth;
        }

    public void setOriginalHealth (int originalHealth)
        {
            this.originalHealth = originalHealth;
        }

    public int getMinDamage ()
        {
            return minDamage;
        }

    public void setMinDamage (int minDamage)
        {
            this.minDamage = minDamage;
        }

    public int getMaxDamage ()
        {
            return maxDamage;
        }

    public void setMaxDamage (int maxDamage)
        {
            this.maxDamage = maxDamage;
        }
}
