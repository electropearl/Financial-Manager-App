
public abstract class InvestName
{
    //default serialVersion id

    private String investmentName;

    public InvestName(){}

    public InvestName(String investmentName)
    {
        this.investmentName = investmentName;
    }

    public String getInvestmentName()
    {
        return this.investmentName;
    }

    public abstract void updateInvestmentTotal(double newAmount);



}
