public class InformationTechnologyOfficer extends Officer {

    private String  duty;

    public InformationTechnologyOfficer (String nameSurname , String phone , String email , String department , String overTime , String duty)
        {
            super (nameSurname , phone , email , department , overTime);
            this.duty = duty;
        }

    public String getDuty ()
        {
            return duty;
        }

    public void setDuty (String duty)
        {
            this.duty = duty;
        }

    public void networkInstallation(){
        System.out.println (this.getNameSurname ()+ " installed network !!");
    }

    @Override
    public void work(String hour){
        System.out.println (this.getNameSurname ()+" is started working at"+hour);
    }

}
