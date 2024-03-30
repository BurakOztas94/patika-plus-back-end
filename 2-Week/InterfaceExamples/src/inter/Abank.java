package inter;

public class Abank implements IBank {
    private String bankName;
    private String terminalId;
    private String password;


    public Abank (String bankName , String terminalId , String password)
        {
            this.bankName = bankName;
            this.terminalId = terminalId;
            this.password = password;
        }

    public boolean connect(String ipAddress){
        System.out.println ("User IP " +ipAddress);
        System.out.println ("Machine IP"+this.hostIpAddress);
        System.out.println (this.bankName+" Connected!");
        return true;
    }
    public boolean payment(double price , String cardNumber, String expirationDate, String cvv){
        System.out.println ("Response is waiting from Bank");
        System.out.println ("Transaction Successful");
        return  true;
    }

    public String getBankName ()
        {
            return bankName;
        }

    public void setBankName (String bankName)
        {
            this.bankName = bankName;
        }

    public String getTerminalId ()
        {
            return terminalId;
        }

    public void setTerminalId (String terminalId)
        {
            this.terminalId = terminalId;
        }

    public String setPassword ()
        {
            return password;
        }

    public void setPassword (String password)
        {
            this.password = password;
        }
}
