/**
 * This class will manage the bill function or program
 * get user input of the following
 * bill name
 * bill due date
 * bill cost
 * add new bills
 * delete old bills
 * 
 */

public class BillManager 
{
    private String billName;
    private String date;
    private double cost;
    
    public BillManager(String billName)
    {
        this.billName = billName;
    }

    /**
     * Create a new bill by intializing
     * @param billName unique name of bill
     * @param date due date for bill
     * @param cost cost of bill
    
     */
    public BillManager(String billName, String date, double cost)
    {
        this.billName = billName;
        this.date = date;
        this.cost = cost;
    }

    //getters

    public String getBillName()
    {
        return this.billName;
    }

    public String getDate()
    {
        return this.date;
    }

    public double getCost()
    {
        return this.cost;
    }


    //setters

    public void setName(String billName)
    {
       this.billName = billName;
    }

    public void setDate(String date)
    {
        this.date = date;
    }
    public void setCost(double cost)
    {
        this.cost = cost;
    }

    
    public void addNewBill()
    {

    }

    @Override
    public String toString()
    {
        System.out.println("------------------------------------------------------------------------------");
        return String.format("Bill: %s%nDate: %s%nCost: $%s",  getBillName(), getDate(), getCost());
        
    }

    
}
