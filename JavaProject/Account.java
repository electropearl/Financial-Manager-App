//Base class
public abstract class Account
{
    private int accountNum;
    
    protected double balance;

    //constructor
    public Account(){}

    public Account(int accountNum)
    {
        this.accountNum = accountNum;
        balance = 0;
    }

    //getters
    public double getBalance()
    {
        return this.balance;
    }

    public int getAccountNum()
    {
        return this.accountNum;
    }

    //Abstract
    /**  
    * function deposits fund into account if amount is  > 0
    @param amount value to be deposited
    */
    public abstract void deposit(double amount);

    /**  
    * function withdraws funds from account if amount is  > 0
    * @param amount value to be deposited
    */
    public abstract void withdraw(double amount);
}