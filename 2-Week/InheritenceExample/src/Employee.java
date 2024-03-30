public abstract class Employee {
    private String nameSurname;
    private String phone;
    private String email;

    public Employee (String nameSurname , String phone , String email)
        {
            this.nameSurname = nameSurname;
            this.phone = phone;
            this.email = email;
        }

    public String getNameSurname ()
        {
            return nameSurname;
        }

    public void setNameSurname (String nameSurname)
        {
            this.nameSurname = nameSurname;
        }

    public String getPhone ()
        {
            return phone;
        }

    public void setPhone (String phone)
        {
            this.phone = phone;
        }


    public String getEmail ()
        {
            return email;
        }

    public void setEmail (String email)
        {
            this.email = email;
        }

    public void login ()
        {
            System.out.println (this.nameSurname + "  logged in the university !!");
        }

    public void login (String loginHour)

        {
            System.out.println (this.nameSurname + " " + loginHour +  "  logged in the university !!");
        }

    public void login (String loginHour,String logoutHour)
        {
            System.out.println (this.nameSurname + " " + loginHour +  "  login time "+logoutHour+" logout time");
        }


    public void signOut ()
        {
            System.out.println (this.nameSurname + "  logged out the university !!  ");
        }

    public void cafeteria ()
        {
            System.out.println (this.nameSurname + " entered cafeteria !!");
        }

    public static void loginUsers (Employee[] loginUsers){
        for(Employee e: loginUsers){
            e.login ();
        }
    }
}
