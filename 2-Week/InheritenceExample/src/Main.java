import java.util.Spliterator;

public class Main {
    public static void main (String[] args)
        {
           // Employee e1 = new Employee ("Burak Öztaş" , "051231123156" , "tombul@gmail.com");
           // e1.login ();

           // Academician a1 = new Academician ("Zeynep Aydınlı" , "05123456789" , "sisko@gmail.com" , "CENG" , "Associate Professor");
          //  a1.login ();
            //a1.enterLesson ();

           // Officer o1 = new Officer ("Pelte Lilly" , "013254161" , "pelte@gmail.com" , " IT " , "08.00-20.00");
            //o1.work ();

            Instructor i1 = new Instructor ("Dombilik Açkalmış" , "01235685256" , "dombilik@gmail.com" , "CENG102" , "Professor" , "103");
          //  i1.login ();

            //Method override
           // Employee[] loginUser={e1,i1};
           // Employee.loginUsers (loginUser);
            i1.enterLesson ("10:00");

        }
}
