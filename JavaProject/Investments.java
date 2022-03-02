/*
Investments
        - Name of investment
        - intial payment
        - total money earned in specific investment
        - total money earned in entire portfolio
        - percent change of investment
            - ask user to enter new amount of investment and will calculate the percent gain or loss
            - will also calculate total portfolio percent gain or loss
*/


public class Investments extends InvestName
{
    //private String investmentName;
    private double intialPayment;
    private double oldInvestmentTotal;
    private double investmentTotal;
    //private double percentChange;

    private static double portfolioTotal = 0;
    private static double intialInvestmentTotal = 0;

    //constructor
    public Investments()
    {
        super();
    }
    public Investments(String investmentName, double intialPayment)
    {
        super(investmentName);
        this.intialPayment = intialPayment;
        this.oldInvestmentTotal = intialPayment;
        this.investmentTotal = intialPayment;
        //this.percentChange =percentChange;

        portfolioTotal += intialPayment;
        intialInvestmentTotal += intialPayment;
    }

    //getters
    public static double getPortfolioTotal()
    {
        return portfolioTotal;
    }

    public static double getIntialInvestmentTotal()
    {
        return intialInvestmentTotal;
    }

    /*
    public String getInvestmentName()
    {
        return this.investmentName;
    }
    

    public double getPercentChange()
    {
        return this.percentChange;
    }
    */

    public double getIntialPayment()
    {
        return this.intialPayment;
    }

    public double getOldInvestmentTotal()
    {
        return this.oldInvestmentTotal;
    }

    public double getInvestmentTotal()
    {
        return this.investmentTotal;
    }

    //setters

    public void setOldInvestmentTotal(double oldInvestmentTotal)
    {
        this.oldInvestmentTotal = oldInvestmentTotal;
    }

    public void setInvestmentTotal(double investmentTotal)
    {
        this.investmentTotal = investmentTotal;
    }
    
    /*
    public void setPercentChange(double percentChange)
    {
        this.percentChange = percentChange;
    }
    */

    //should return percent increase, remember to put % after printing amount.
    
    public static double calcPercentChange(double x, double y)
    {
        double increase = x - y;

        double percentIncrease = (increase/y)*100;

        return percentIncrease;
    }

    /**
     * Will update investment toal and check if it was a total increase or decrease
     * will also check if investment has increased or decreased since last investment total
     * @param newAmount
     */
    public void updateInvestmentTotal(double newAmount)
    {
        if(newAmount > investmentTotal && newAmount > intialPayment)
        {
            portfolioTotal += (newAmount - investmentTotal);
            System.out.println("Intial Payment: $"+ intialPayment);
            oldInvestmentTotal = investmentTotal;
            System.out.println("Previous investment total: $"+ oldInvestmentTotal);
            investmentTotal = newAmount;
            System.out.println("New investment total: $"+ investmentTotal);
            System.out.println("-------------------------------------------------------------------------------------");

            System.out.println("Your investment has increased by " + String.format("%.2f", calcPercentChange(investmentTotal, oldInvestmentTotal))+ "%");
            System.out.println("Your investment has had a total increase of " + String.format("%.2f", calcPercentChange(investmentTotal, intialPayment))+ "%");
        }
        else if(newAmount > investmentTotal && newAmount < intialPayment)
        {
            portfolioTotal += (newAmount - investmentTotal);
            System.out.println("Intial Payment: $"+ intialPayment);
            oldInvestmentTotal = investmentTotal;
            System.out.println("Previous investment total: $"+ oldInvestmentTotal);
            investmentTotal = newAmount;
            System.out.println("New investment total: $"+ investmentTotal);
            System.out.println("-------------------------------------------------------------------------------------");

            System.out.println("Your investment has increased by " + String.format("%.2f", calcPercentChange(investmentTotal, oldInvestmentTotal))+ "%");
            System.out.println("Your investment has had a total decrease of " + String.format("%.2f", calcPercentChange(investmentTotal, intialPayment))+ "%");
        }
        else if(newAmount < investmentTotal && newAmount < intialPayment)
        {
            portfolioTotal += (newAmount - investmentTotal);
            System.out.println("Intial Payment: $"+ intialPayment);
            oldInvestmentTotal = investmentTotal;
            System.out.println("Previous investment total: $"+ oldInvestmentTotal);
            investmentTotal = newAmount;
            System.out.println("New investment total: $"+ investmentTotal);
            System.out.println("-------------------------------------------------------------------------------------");

            System.out.println("Your investment has decreased by " + String.format("%.2f", calcPercentChange(investmentTotal, oldInvestmentTotal))+ "%");
            System.out.println("Your investment has had a total decrease of " + String.format("%.2f", calcPercentChange(investmentTotal, intialPayment))+ "%");
            
        }
        else if(newAmount < investmentTotal && newAmount > intialPayment)
        {
            portfolioTotal += (newAmount - investmentTotal);
            System.out.println("Intial Payment: $"+ intialPayment);
            oldInvestmentTotal = investmentTotal;
            System.out.println("Previous investment total: $"+ oldInvestmentTotal);
            investmentTotal = newAmount;
            System.out.println("New investment total: $"+ investmentTotal);
            System.out.println("-------------------------------------------------------------------------------------");

            System.out.println("Your investment has decreased by " + String.format("%.2f", calcPercentChange(investmentTotal, oldInvestmentTotal))+ "%");
            System.out.println("Your investment has had a total increase of " + String.format("%.2f", calcPercentChange(investmentTotal, intialPayment))+ "%");
            
        }
        else
        {
            System.out.println("Intial Payment: $"+ intialPayment);
            oldInvestmentTotal = investmentTotal;
            System.out.println("Previous investment total: $"+ oldInvestmentTotal);
            investmentTotal = newAmount;
            System.out.println("New investment total: $"+ investmentTotal);
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("Your investment has stayed the same. Consider investing in something more volatile.");
        }
    }
    
    @Override
    public String toString()
    {
        System.out.println("------------------------------------------------------------------------------");
        return String.format("Investment: %s%nIntial Payment: %s%nInvestment Total: $%s%nPercentage Change: %s Percent",  getInvestmentName(), getIntialPayment(), getInvestmentTotal(), calcPercentChange(getInvestmentTotal(), getIntialPayment()));
        
    }
}

/*public class Investments
{
    private String investmentName;
    private double intialPayment;
    private double oldInvestmentTotal;
    private double investmentTotal;
    //private double percentChange;

    private static double portfolioTotal = 0;
    private static double intialInvestmentTotal = 0;

    //constructor
    public Investments()
    {
    }
    public Investments(String investmentName, double intialPayment)
    {
        this.investmentName = investmentName;
        this.intialPayment = intialPayment;
        this.oldInvestmentTotal = intialPayment;
        this.investmentTotal = intialPayment;
        //this.percentChange = percentChange;

        portfolioTotal += intialPayment;
        intialInvestmentTotal += intialPayment;
    }

    //getters
    public static double getPortfolioTotal()
    {
        return portfolioTotal;
    }

    public static double getIntialInvestmentTotal()
    {
        return intialInvestmentTotal;
    }

    
    public String getInvestmentName()
    {
        return this.investmentName;
    }
    
    /*
    public double getPercentChange()
    {
        return this.percentChange;
    }
    */
    /*
    public double getIntialPayment()
    {
        return this.intialPayment;
    }

    public double getOldInvestmentTotal()
    {
        return this.oldInvestmentTotal;
    }

    public double getInvestmentTotal()
    {
        return this.investmentTotal;
    }

    //setters

    public void setOldInvestmentTotal(double oldInvestmentTotal)
    {
        this.oldInvestmentTotal = oldInvestmentTotal;
    }

    public void setInvestmentTotal(double investmentTotal)
    {
        this.investmentTotal = investmentTotal;
    }
    
    /*
    public void setPercentChange(double percentChange)
    {
        this.percentChange = percentChange;
    }
    */

    //should return percent increase, remember to put % after printing amount.
    /*
    public static double calcPercentChange(double x, double y)
    {
        double increase = x - y;

        double percentIncrease = (increase/y)*100;

        return percentIncrease;
    }

    /**
     * Will update investment toal and check if it was a total increase or decrease
     * will also check if investment has increased or decreased since last investment total
     * @param newAmount
     */

     /*
    public void updateInvestmentTotal(double newAmount)
    {
        if(newAmount > investmentTotal && newAmount > intialPayment)
        {
            portfolioTotal += (newAmount - investmentTotal);
            System.out.println("Intial Payment: $"+ intialPayment);
            oldInvestmentTotal = investmentTotal;
            System.out.println("Previous investment total: $"+ oldInvestmentTotal);
            investmentTotal = newAmount;
            System.out.println("New investment total: $"+ investmentTotal);
            System.out.println("-------------------------------------------------------------------------------------");

            System.out.println("Your investment has increased by " + String.format("%.2f", calcPercentChange(investmentTotal, oldInvestmentTotal))+ "%");
            System.out.println("Your investment has had a total increase of " + String.format("%.2f", calcPercentChange(investmentTotal, intialPayment))+ "%");
        }
        else if(newAmount > investmentTotal && newAmount < intialPayment)
        {
            portfolioTotal += (newAmount - investmentTotal);
            System.out.println("Intial Payment: $"+ intialPayment);
            oldInvestmentTotal = investmentTotal;
            System.out.println("Previous investment total: $"+ oldInvestmentTotal);
            investmentTotal = newAmount;
            System.out.println("New investment total: $"+ investmentTotal);
            System.out.println("-------------------------------------------------------------------------------------");

            System.out.println("Your investment has increased by " + String.format("%.2f", calcPercentChange(investmentTotal, oldInvestmentTotal))+ "%");
            System.out.println("Your investment has had a total decrease of " + String.format("%.2f", calcPercentChange(investmentTotal, intialPayment))+ "%");
        }
        else if(newAmount < investmentTotal && newAmount < intialPayment)
        {
            portfolioTotal += (newAmount - investmentTotal);
            System.out.println("Intial Payment: $"+ intialPayment);
            oldInvestmentTotal = investmentTotal;
            System.out.println("Previous investment total: $"+ oldInvestmentTotal);
            investmentTotal = newAmount;
            System.out.println("New investment total: $"+ investmentTotal);
            System.out.println("-------------------------------------------------------------------------------------");

            System.out.println("Your investment has decreased by " + String.format("%.2f", calcPercentChange(investmentTotal, oldInvestmentTotal))+ "%");
            System.out.println("Your investment has had a total decrease of " + String.format("%.2f", calcPercentChange(investmentTotal, intialPayment))+ "%");
            
        }
        else if(newAmount < investmentTotal && newAmount > intialPayment)
        {
            portfolioTotal += (newAmount - investmentTotal);
            System.out.println("Intial Payment: $"+ intialPayment);
            oldInvestmentTotal = investmentTotal;
            System.out.println("Previous investment total: $"+ oldInvestmentTotal);
            investmentTotal = newAmount;
            System.out.println("New investment total: $"+ investmentTotal);
            System.out.println("-------------------------------------------------------------------------------------");

            System.out.println("Your investment has decreased by " + String.format("%.2f", calcPercentChange(investmentTotal, oldInvestmentTotal))+ "%");
            System.out.println("Your investment has had a total increase of " + String.format("%.2f", calcPercentChange(investmentTotal, intialPayment))+ "%");
            
        }
        else
        {
            System.out.println("Intial Payment: $"+ intialPayment);
            oldInvestmentTotal = investmentTotal;
            System.out.println("Previous investment total: $"+ oldInvestmentTotal);
            investmentTotal = newAmount;
            System.out.println("New investment total: $"+ investmentTotal);
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("Your investment has stayed the same. Consider investing in something more volatile.");
        }
    }
    
    @Override
    public String toString()
    {
        System.out.println("------------------------------------------------------------------------------");
        return String.format("Investment: %s%nIntial Payment: %s%nInvestment Total: $%s%nPercentage Change: %s Percent",  getInvestmentName(), getIntialPayment(), getInvestmentTotal(), calcPercentChange(getInvestmentTotal(), getIntialPayment()));
        
    }
}
*/
