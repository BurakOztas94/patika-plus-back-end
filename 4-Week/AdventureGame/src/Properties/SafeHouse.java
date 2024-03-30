package Properties;

public class SafeHouse extends NormalLocation {
    public SafeHouse (Player player )
        {
            super (player , "Safe House");
        }

    @Override
    public boolean onLocation ()
        {
            System.out.println ("----> You are in the safe house <---- !");
            System.out.println ("----> Your health is refreshed and full now! <----\n");
            this.getPlayer ().setHealth (this.getPlayer ().getOriginalHealth ());
            return true;
        }
}
