package inter;

public class Bbank implements IBank{

    private String bankName;
    private String terminalId;
    private String password;


    public Bbank (String bankName , String terminalId , String password)
        {
            this.bankName = bankName;
            this.terminalId = terminalId;
            this.password = password;
        }



    @Override
    public boolean connect (String ipAddress)
        {
            return false;
        }

    @Override
    public boolean payment (double price , String cardNumber , String date , String cvv)
        {
            return false;
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


