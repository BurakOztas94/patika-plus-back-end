package SiniflarArasiIliskiler;

public class Main2 {
    public static void main (String[] args)
        {
            Student st1 = new Student ("Burak" , "oztas" , "1234" , "adress" , 89);
            Student st2 = new Student ("zey" , "ayd" , "357" , "adress" , 89);
            Student st3 = new Student ("lil" , "pelt" , "539" , "adress" , 89);


            System.out.println (st1.getNote ());
            System.out.println (st2.getNote ());
            System.out.println (st3.getNote ());

            Course mat = new Course ("MAT101","MAT");
            Student[] stu={st1,st2,st3};
            System.out.println ("Sınıf Ortalaması : "+mat.calcAverage (stu));
        }
}
