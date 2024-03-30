public class LabAssistant extends Assistant {

    public LabAssistant (String nameSurname , String phone , String email , String department , String title , String officeHour)
        {
            super (nameSurname , phone , email , department , title , officeHour);
        }

    public void enterLabResult(){
        System.out.println (this.getNameSurname ()+ " entered lab results");
    }

}
