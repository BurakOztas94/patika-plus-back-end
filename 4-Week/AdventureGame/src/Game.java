import Environment.Cave;
import Environment.Forest;
import Environment.River;
import Properties.Location;
import Properties.Player;
import Properties.SafeHouse;
import Properties.ToolStore;

import java.util.Scanner;


public class Game {



    public void start ()
        {

            System.out.println ("Welcome to Adventure Game !");
            System.out.print ("Please enter name : ");
            String playerName = Location.scan.nextLine ();
            Player player = new Player (playerName);
            System.out.println ("Welcome " + player.getName () + ". This will be the best adventure of your life! Are you ready to purge all of the creatures?\nWhat you experience here will take years off your life...");
            player.selectChar ();

            Location location=null;

            while (true)
                {
                    player.printInfo ();
                    System.out.println ("*************** Locations ***************\n");
                    System.out.println ("===========================================================");
                    System.out.println ("1 - Safe House --> There is no enemy here rest well ! ");
                    System.out.println ("2 - Tool Store --> You can buy weapon or armor here !");
                    System.out.println ("3 - Cave --------> Reward <Food>, be careful you might see Zombies here !");
                    System.out.println ("4 - Forest ------> Reward <Fire Wood>, be careful you might see Vampires here !");
                    System.out.println ("5 - River ------> Reward <Water>, be careful you might see Bears here !");
                    System.out.println ("0 - Exit --------> Exit the Adventure Game");
                    System.out.println ("===========================================================");
                    System.out.print ("\nPlease select the location that you want to teleport :");
                    int selectLoc = Location.scan.nextInt ();
                    System.out.println ();

                   switch (selectLoc){
                       case 0:
                           location=null;
                           break;
                       case 1:
                           location=new SafeHouse (player);
                           break;
                       case 2:
                           location=new ToolStore (player);
                           break;
                       case 3:
                           location=new Cave (player);
                           break;
                       case 4:
                           location=new Forest (player);
                           break;
                       case 5:
                           location=new River (player);
                           break;
                       default:
                           System.out.println ("Please enter valid territory! ");
                            break;
                   }
                    if(location==null){
                        System.out.println ("You surrendered too early ! Come again and close the gap of the eternity! ");
                        break;
                    }
                    if(! location.onLocation ()){
                        System.out.println ("Game Over XXXXXX You DIED NOOB XXXXX");
                        break;
                    }
                }
        }
}
