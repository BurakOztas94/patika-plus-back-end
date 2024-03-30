package Environment;

import Creatures.Monsters;
import Properties.Location;
import Properties.Player;

import java.util.Random;
import java.util.Scanner;

public class BattleLoc extends Location {

    private Monsters monster;
    private String award;
    private int maxMonsters;
    Scanner scanner=new Scanner (System.in);

    public BattleLoc (Player player , String name , Monsters monster , String award , int maxMonsters)
        {
            super (player , name);
            this.monster = monster;
            this.award = award;
            this.maxMonsters = maxMonsters;

        }

    @Override
    public boolean onLocation ()
        {
            int monsterNumber = this.randomMonsterNumber ();
            System.out.println ("You are here now : " + this.getName ());
            System.out.println ("Be careful there is/are " + monsterNumber + " " + this.getMonster ().getName () + " (s) living here");
            System.out.print ("<A>ttack or <R>un : ");
            String selectCase = scanner.nextLine ().toUpperCase ();

            if ( selectCase.equals ("A") &&combat (monsterNumber))
                {

                            System.out.println (this.getName () + " you cleaned all monsters!");
                            return true;

                }
            if ( this.getPlayer ().getHealth () <= 0 )
                {
                    System.out.println ("You are dead!");
                    return false;

                }
            return true;
        }

    public boolean combat (int monsterNumber)
        {

            for ( int i = 1;i <= monsterNumber;i++ )
                {
                    this.getMonster ().setHealth (this.getMonster ().getOriginalHealth ());
                    playerStats ();
                    monsterStats (i);
                    while (this.getPlayer ().getHealth () > 0 && this.getMonster ().getHealth () > 0)
                        {
                            System.out.println ("<H>it or <R>un");
                            String selectCase = scanner.nextLine ().toUpperCase ();

                           if ( selectCase.equals ("H")  )
                                {
                                    System.out.println ("You hit !");
                                    this.getMonster ().setHealth (this.getMonster ().getHealth () - this.getPlayer ().getTotalDamage ());
                                    afterHit ();
                                    if ( this.getMonster ().getHealth () > 0 )
                                        {
                                            System.out.println ();
                                            System.out.println ("Damage taken by " + this.getMonster ().getDamage ());
                                            int monsterDamage = this.getMonster ().getDamage () - this.getPlayer ().getInventory ().getArmor ().getBlock ();
                                            if ( monsterDamage < 0 )
                                                {
                                                    monsterDamage = 0;
                                                }
                                            this.getPlayer ().setHealth (this.getPlayer ().getHealth () - monsterDamage);
                                            afterHit ();
                                        }
                                }else{
                               return false;
                           }
                                if(this.getMonster().getHealth ()<this.getPlayer ().getHealth ()){
                                    System.out.println ("You killed the monsters!");
                                    if(this.getMonster ().getHealth ()<=0){
                                        System.out.println ("You won : "+this.getMonster ().getAward ());
                                        this.getPlayer ().setMoney (this.getPlayer ().getMoney ()+this.getMonster ().getAward ());
                                    }

                                    System.out.println ("Current money : "+this.getPlayer ().getMoney ());
                                }
                        }
                }
            return false;
        }

    public void afterHit ()
        {
            System.out.println ("Your health : " + this.getPlayer ().getHealth ());
            System.out.println (this.getMonster ().getName () + " Health : " + this.getMonster ().getHealth ());

        }

    public void playerStats ()
        {
            System.out.println ("Player info ");
            System.out.println ("************************** ");
            System.out.println ("Health : " + this.getPlayer ().getHealth ());
            System.out.println ("Weapon : " + this.getPlayer ().getInventory ().getWeapon ().getName ());
            System.out.println ("Armor : " + this.getPlayer ().getInventory ().getArmor ().getName ());
            System.out.println ("Damage : " + this.getPlayer ().getTotalDamage ());
            System.out.println ("Block : " + this.getPlayer ().getInventory ().getArmor ().getBlock ());
            System.out.println ("Money  : " + this.getPlayer ().getMoney ());
            System.out.println ();

        }

    public void monsterStats (int i )
        {
            System.out.println (i+"."+this.getMonster ().getName () + " Info ");
            System.out.println ("******************************");
            System.out.println ("Health : " + this.getMonster ().getHealth ());
            System.out.println ("Damage : " + this.getMonster ().getDamage ());
            System.out.println ("Award : " + this.getMonster ().getAward ());
            System.out.println ();

        }

    public int randomMonsterNumber ()
        {
            Random r = new Random ();
            return r.nextInt (3) + 1;
        }

    public Monsters getMonster ()
        {
            return monster;
        }

    public void setMonster (Monsters monster)
        {
            this.monster = monster;
        }

    public String getAward ()
        {
            return award;
        }

    public void setAward (String award)
        {
            this.award = award;
        }

    public int getMaxMonsters ()
        {
            return maxMonsters;
        }

    public void setMaxMonsters (int maxMonsters)
        {
            this.maxMonsters = maxMonsters;
        }
}
