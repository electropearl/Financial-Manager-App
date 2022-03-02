//Saving account subclass
//interest

public class SavingsAccount extends Account
{
    private double interestRate;

    public SavingsAccount()
    {
        super();
    }

    //account number and interest rate
    public SavingsAccount(int accountNum, double interestRate)
    {
        super(accountNum);
        this.interestRate = interestRate;
    }

    //getters
    public double getInterestRate()
    {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate)
    {
        this.interestRate = interestRate;
    }

    public double calcInterest()
    {
        return balance * interestRate;
    }

    public void applyInterest()
    {
        double interest = calcInterest();
        System.out.println("Interest Added: $" + interest);
        deposit(interest);
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
            System.out.println("Balance: $"+ balance);
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
            if (amount <= balance)
            {
                System.out.println("Withdrew: $"+ amount);
                balance -= amount;
                System.out.println("Balance: $"+ balance);
            }
        }
        else
        {
            System.out.println("Negative amount cannot be withdrawn");
        }
    }
}