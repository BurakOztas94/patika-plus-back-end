public class Instructor extends Academician{


    private String doorNo;
    public Instructor(String nameSurname,String phone,String email,String department,String title,String doorNo){
        super(nameSurname,phone,email,department,title);
        this.doorNo=doorNo;
    }
    public String getDoorNo ()
        {
            return doorNo;
        }

    public void setDoorNo (String doorNo)
        {
            this.doorNo = doorNo;
        }

   @Override
    public void login ()
        {
            System.out.println (this.getNameSurname ()+" instructor entered gate B");
        }


    @Override
    public void enterLesson(String hour){
        System.out.println (this.getNameSurname ()+" instructor entered lesson at "+hour);
    }
}
