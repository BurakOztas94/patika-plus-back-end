package inter;

import java.util.Scanner;

public class Main {
    public static void main (String[] args)
        {
                Scanner scan=new Scanner (System.in);
            System.out.print ("Enter amount : ");
            double price=scan.nextDouble ();

            System.out.print ("Enter card number : ");
            String cardNumber=scan.nextLine ();
            scan.nextLine ();

            System.out.print ("Enter expiration date : ");
            String date=scan.nextLine ();

            System.out.print ("Enter CVV : ");
            String cvv=scan.nextLine ();

            System.out.println ("1. A Bank ");
            System.out.println ("2. B Bank ");
            System.out.println ("3. C Bank ");
            System.out.println ("Enter Bank : ");
            int selectBank=scan.nextInt ();

            switch (selectBank){
            case 1:
                Abank aPos=new Abank ("A Bank","2151645981654","1313131");
                aPos.connect ("127.1.1.1");
                aPos.payment (price,cardNumber,date,cvv);
                break;
                case 2:
                    Bbank bPos=new Bbank ("B Bank","2151645981654","1313131");
                    bPos.connect ();
                    bPos.payment (price,cardNumber,date,cvv);

                case 3:
                    Abank aPos3=new Abank ("C Bank","874165184","522852");
                default:
                    System.out.println ("Enter Valid Number");

            }


        }
}
