public abstract class Officer extends Employee{
    private String department;
    private String overTime;

public Officer(String nameSurname,String phone,String email,String department,String overTime){
    super(nameSurname,phone,email);
    this.department=department;
            this.overTime=overTime;
}

    public String getDepartment(){
    return department;
    }

    public void setDepartment(String department){
    this.department=department;
    }


    public String getOverTime(){
    return overTime;
    }

    public void setOverTime(String overTime){
    this.overTime=overTime;
    }

    public abstract void work(String workHour);


    @Override
    public void login ()
        {
            System.out.println (this.getNameSurname ()+" officer entered gate C");
        }


}
