public class SecurityOfficer extends Officer{

    private String document;

    public SecurityOfficer (String nameSurname , String phone , String email , String department , String overTime , String document)
        {
            super (nameSurname , phone , email , department , overTime);
            this.document = document;
        }

    public String getDocument ()
        {
            return document;
        }

    public void setDocument (String document)
        {
            this.document = document;
        }

    public void guardDuty(){
        System.out.println (this.getNameSurname ()+" is on duty");
    }

    @Override
    public void work(String hour){
        System.out.println (this.getNameSurname ()+" is started working at"+hour);
    }
}
