package atm;

public class ATM {
    static int c=0;
    static int p=0;
    static String[] history = new String[1000];
    static int CurrentBalance ;
    public final String ID = "2710";

    public void withdraw(int amount)
    {
        history[c]="Withdraw :- "+amount;
        CurrentBalance -= amount;
        c+=1;
        p=c;
    }
    
    public void deposite(int amount)
    {
    history[c]="Deposit :- "+amount;
    CurrentBalance += amount;
    c+=1;
    p=c;
    }
    
    public String prev()
    {
        p-=1;
        return history[p];
    }
    
    public String next()
    {
        p+=1;
        return history[p];
    }

    public boolean valid(String number){
        return number.equals(ID);     
    }
    
}
