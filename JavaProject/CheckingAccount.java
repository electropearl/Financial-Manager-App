public class CheckingAccount extends Account
{
    
    private static double FEE = 2.5;

    //constructor
    public CheckingAccount()
    {
        super();
    }

    public CheckingAccount(int accountNum, double fee)
    {
        super(accountNum);
        FEE = fee;
    }


    //Abstract
    /**  
    * function deposits fund into account if amount is  > 0
    * @param amount value to be deposited
    */
    public void deposit(double amount)
    {
        if(amount > 0)
        {
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);

            balance -= FEE;
            System.out.printf("FEE %.2f Applied%n", FEE);
            System.out.printf("Current Balance is: %.2f%n", balance);
        }
        else
        {
            System.out.println("A negative amount can not be deposited");
        }
    }

    /**  
    * function deposits fund into account if amount is  > 0
    * @param amount value to be deposited
    */
    public void withdraw(double amount)
    {
        if(amount > 0)
        {
            if ((amount + FEE) <= balance)
            {
                System.out.println("Withdrew: $"+ amount);
                balance -= amount;
                balance -= FEE;
                System.out.println("Fee: $"+ amount);
                System.out.println("Balance: $"+ balance);
            }
        }
        else
        {
            System.out.println("Negative amount cannot be withdrawn");
        }
    }
}