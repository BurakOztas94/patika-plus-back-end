package Properties;

import Environment.Armor;
import Environment.Weapon;

import java.lang.ref.WeakReference;

public class ToolStore extends NormalLocation {

    public ToolStore (Player player)
        {
            super (player , "Tool Store");
        }

    @Override
    public boolean onLocation ()
        {
            System.out.println ("----> Welcome to the tool store! <----\n");
            boolean showMenu = true;          //menu exit
            while (showMenu)
                {
                    System.out.println ("1- Weapons ");
                    System.out.println ("2- Armors ");
                    System.out.println ("3- Exit ");
                    System.out.print ("Your selection : ");
                    int selectCase = Location.scan.nextInt ();
                    while (selectCase < 1 || selectCase > 3)
                        {
                            System.out.println ("Invalid value , please enter again : ");
                            selectCase = scan.nextInt ();
                        }

                    switch (selectCase)
                        {
                            case 1 ->
                                {
                                    printWeapon ();
                                    buyWeapon ();
                                }
                            case 2 ->
                                {
                                    printArmor ();
                                    buyArmor ();
                                }
                            case 3 ->
                                {
                                    System.out.println ("Come again !");
                                    showMenu = false;     // For menu exit

                                }
                        }
                }


            return true;
        }

    public void printWeapon ()
        {
            System.out.println ("************* Weapons *************");
            System.out.println ();

            for ( Weapon w : Weapon.weapons () )
                {
                    System.out.println (w.getName () + " < ID : " + w.getId () + " price :  " + w.getPrice () + " , damage  : " + w.getDamage () + " >\n");
                }
            System.out.println ("0 - Exit ");

        }


    public void buyWeapon ()
        {
            System.out.print ("Select a weapon : ");
            int selectWeaponID = scan.nextInt ();
            while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons ().length)
                {
                    System.out.println ("Invalid value , please enter again : ");
                    selectWeaponID = scan.nextInt ();
                }

            if ( selectWeaponID != 0 )
                {
                    Weapon selectedWeapon = Weapon.getWeaponObjById (selectWeaponID);

                    if ( Weapon.getWeaponObjById (selectWeaponID) != null )
                        {
                            if ( selectedWeapon.getPrice () > this.getPlayer ().getMoney () )
                                {
                                    System.out.println ("You do not have enough money to buy !");

                                }
                            else
                                {
                                    // Purchasing function
                                    System.out.println ("You purchased : " + selectedWeapon.getName ());
                                    int balance = this.getPlayer ().getMoney () - selectedWeapon.getPrice ();
                                    this.getPlayer ().setMoney (balance);
                                    System.out.println ("Remain money : " + this.getPlayer ().getMoney ());
                                    this.getPlayer ().getInventory ().setWeapon (selectedWeapon);
                                    System.out.println ("New weapon : " + this.getPlayer ().getInventory ().getWeapon ().getName ());
                                }
                        }
                }
        }



    public void printArmor ()
        {
            System.out.println ("************* Armors *************");
            System.out.println ();

            for ( Armor a : Armor.armors () )
                {
                    System.out.println (a.getName () + " < ID : " + a.getId ()
                            + " price :  " + a.getPrice () + " , armor power   : " + a.getBlock () + " >\n");
                }
            System.out.println ("0 - Exit ");
        }

    public void buyArmor ()
        {
            System.out.print ("Select an Armor : ");
            int selectArmorID = scan.nextInt ();
            while (selectArmorID < 0 || selectArmorID > Armor.armors ().length)
                {
                    System.out.println ("Invalid value , please enter again : ");
                    selectArmorID = scan.nextInt ();
                }
            if ( selectArmorID != 0 )
                {
            Armor selectedArmor = Armor.getArmorObjById (selectArmorID);

            if ( Armor.getArmorObjById (selectArmorID) != null )
                {
                    if ( selectedArmor.getPrice () > this.getPlayer ().getMoney () )
                        {
                            System.out.println ("You do not have enough money to buy !");

                        }
                    else
                        {
                            // Purchasing function
                            System.out.println ("You purchased : " + selectedArmor.getName ());
                            int balance = this.getPlayer ().getMoney () - selectedArmor.getPrice ();
                            this.getPlayer ().setMoney (balance);
                            System.out.println ("Remain money : " + this.getPlayer ().getMoney ());
                            this.getPlayer ().getInventory ().setArmor (selectedArmor);
                            System.out.println ("New weapon : " + this.getPlayer ().getInventory ().getWeapon ().getName ());
                        }
                }

        }}


}
