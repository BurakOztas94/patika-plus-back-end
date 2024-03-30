public abstract class Academician extends Employee {
    private String department;
    private String title;

    public Academician (String nameSurname , String phone , String email , String department , String title)
        {
            super (nameSurname , phone , email);         //Super is so important you must enter on the top in the constructor
            this.department = department;
            this.title = title;
        }

    public String getDepartment ()
        {
            return department;
        }

    public void setDepartment (String department)
        {
            this.department = department;
        }

    public String getTitle ()
        {
            return title;
        }

    public void setTitle (String title)
        {
            this.title = title;
        }

    public void enterLesson ()
        {
            System.out.println (this.getNameSurname () + " entered lesson !!");
        }


    public String getEmail ()
        {
            return super.getEmail ();
        }
    public abstract void enterLesson(String lessonHour);

    @Override
    public void login ()
        {
            System.out.println (this.getNameSurname ()+" academician entered gate A");
        }

}
