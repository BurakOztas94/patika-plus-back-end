package com.patikadev.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static void setLayout ()
        {
            for ( UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels () )
                {
                    if ( ( "Nimbus".equals (info.getName ()) ) )
                        {

                            try
                                {
                                    UIManager.setLookAndFeel (info.getClassName ());
                                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                                         UnsupportedLookAndFeelException e)
                                {
                                    e.printStackTrace ();
                                }
                            break;


                        }
                }
        }

    public static int screenCenterPoint (String axis , Dimension size)
        {
            int point = 0;
            switch (axis)
                {
                    case "x":
                        point = ( Toolkit.getDefaultToolkit ().getScreenSize ().width - size.width ) / 2;
                        break;
                    case "y":
                        point = ( Toolkit.getDefaultToolkit ().getScreenSize ().height - size.height ) / 2;
                        break;
                    default:
                        point = 0;
                }
            return point;
        }

    public static boolean isFieldEmpty(JTextField field){
        return field.getText ().trim ().isEmpty ();
    }
    public static void showMsg (String str){
        optionPageEN ();
        String msg;
        String title;

        switch (str){
            case "fill":
                msg = "Please ensure all required fields are filled ! ";
                title="Error";
                break;
            case "done":
                msg="Successfully completed !";
                title ="Result";
                break;
            case "error":
                msg="An error occurred !";
                title ="Result";
                break;
            default:
                msg=str;
                title="Message";
                break;

        }
        JOptionPane.showMessageDialog (null,msg,title,JOptionPane.INFORMATION_MESSAGE);
    }
public static boolean confirm(String str){
        optionPageEN ();
        String msg;
        switch (str){
            case "sure":
                    msg ="Are you sure to delete this item?" ;
                    break;
            default:
                msg = str;
                break;
        }
    return JOptionPane.showConfirmDialog (null,msg,"Are you really sure ? ",JOptionPane.YES_NO_OPTION)==0;
}
    public static void optionPageEN(){          // this method converts english to any language but we use englşsh so we do same thing
        UIManager.put("OptionPane.okButtonText","Okay");
        UIManager.put("OptionPane.yesButtonText","Yes");
        UIManager.put("OptionPane.noButtonText","No");
    }







}
