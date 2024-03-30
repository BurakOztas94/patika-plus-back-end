public class Assistant extends Academician {

    private String officeHour;

    public Assistant (String nameSurname , String phone , String email , String department , String title , String officeHour)
        {
            super (nameSurname , phone , email , department , title);
            this.officeHour = officeHour;
        }

    public String getOfficeHour ()
        {
            return officeHour;
        }

    public void setOfficeHour (String officeHour)
        {
            this.officeHour = officeHour;
        }

    public void quiz ()
        {
            System.out.println (this.getNameSurname () + " made a quiz!!");
        }

    @Override
    public void enterLesson(String hour){
        System.out.println (this.getNameSurname ()+" assistant entered lesson at "+hour);
    }

}
