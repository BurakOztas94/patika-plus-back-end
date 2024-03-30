package Properties;

import Characters.Archer;
import Characters.GameChar;
import Characters.Knight;
import Characters.Samurai;
import Environment.Inventory;
import Environment.Weapon;

import java.util.Properties;
import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String charName;   //character name
    private String name;
    private  Scanner scan = new Scanner (System.in);

    private Inventory inventory;



    public Player (String name)
        {         //constructor
            this.name = name;
            this.inventory=new Inventory ();
        }

    public void printInfo(){
        System.out.println ("=========================================================================================================\n");
        System.out.println (" ± Weapon : " + this.getInventory ().getWeapon ().getName () +
                " \t||\t -Ø- Armor : " + this.getInventory ().getArmor ().getName () +
                " \t||\t -°- Block : " + this.getInventory ().getArmor ().getBlock () +
                " \t||\t -X- Damage : " + this.getTotalDamage () +
                " \t||\t -H- Health : " + this.getHealth () +
                " \t||\t -$- Money : " + this.getMoney ());
        System.out.println ("=========================================================================================================\n");
    }
public int getTotalDamage(){
    return damage+this.getInventory ().getWeapon ().getDamage ();
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
            this.health = health;
        }

    public int getMoney ()
        {
            return money;
        }

    public void setMoney (int money)
        {
            this.money = money;
        }

    public String getCharName ()
        {
            return charName;
        }

    public void setCharName (String charName)
        {
            this.charName = charName;
        }

    public String getName ()
        {
            return name;
        }

    public void setName (String name)
        {
            this.name = name;
        }

    public Inventory getInventory ()
        {
            return inventory;
        }

    public void setInventory (Inventory inventory)
        {
            this.inventory = inventory;
        }

    public int getOriginalHealth ()
        {
            return originalHealth;
        }

    public void setOriginalHealth (int originalHealth)
        {
            this.originalHealth = originalHealth;
        }

    public void selectChar ()
        {

            GameChar[] charList = {new Samurai () , new Archer () , new Knight ()};       //Creates list of objects
            System.out.println ("Characters");
            //ID select number initializer
            for ( GameChar gameChar : charList )
                {                                        //Prints object and their features on the screen
                    System.out.println ("=========================================================================================================");         //Separator line
                    System.out.println ("ID " + gameChar.getId () + " : \t\t Character : " + gameChar.getName () +
                            " \t||\t -X- Damage : " + gameChar.getDamage () +
                            " \t||\t -H- Health : " + gameChar.getHealth () +
                            " \t||\t -$- Money : " + gameChar.getMoney ());
                    //Gets character information from created classes

                }
            System.out.println ("=========================================================================================================");              //Separator line
            System.out.print ("Please enter character :");
            int select = scan.nextInt ();       //ID selector

            switch (select)
                {
                    case 1 -> initPlayer (new Samurai ());
                    case 2 -> initPlayer (new Archer ());
                    case 3 -> initPlayer (new Knight ());
                    default -> initPlayer (new Samurai ());
                }
            System.out.println ("=========================================================================================================");
            System.out.println ("You selected daredevil <" + this.getCharName () +
                    "> \t||\t -X- Damage : " + this.getDamage () +
                    " \t||\t -H- Health : " + this.getHealth () +
                    " \t||\t -$- Money : " + this.getMoney ());
            System.out.println ("=========================================================================================================\n");
        }



    public void initPlayer (GameChar gameChar)
        {
            this.setDamage (gameChar.getDamage ());
            this.setHealth (gameChar.getHealth ());
            this.setOriginalHealth (gameChar.getHealth ());
            this.setMoney (gameChar.getMoney ());
            this.setCharName (gameChar.getName ());
        }
}
