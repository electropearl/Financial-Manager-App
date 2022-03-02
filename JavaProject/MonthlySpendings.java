/*
**This class will track Monthly Spendings
- Track where funds go and assign to a category
- when user withdraws ask what the money will be used for and assign to category
- if choice == category then, withdraw += category total and withdraw += overall total
- Food total
- Clothes total
- Entertainment total
- Gas total
- Bills total
- investments total
- Other total
- overall total
- Each category total should show it percentage of overall total
*/

public class MonthlySpendings
{
    //private will prevent the use of variables outside the class
    private static double foodTotal = 0;
    private static double clothesTotal = 0;
    private static double entertainmentTotal = 0;
    private static double gasTotal = 0;
    private static double billTotal = 0;
    private static double investmentsTotal = 0;
    private static double otherTotal = 0;
    private static double overallTotal = 0;

    private static double foodPercent;
    private static double clothesPercent;
    private static double entertainmentPercent;
    private static double gasPercent;
    private static double billPercent;
    private static double investmentsPercent;
    private static double otherPercent;

    //constructor what is required of this object
    public MonthlySpendings() {}

    //getters
    public static double getFoodTotal()
    {
        return foodTotal;
    }

    public static double getClothesTotal()
    {
        return clothesTotal;
    }

    public static double getEntertainmentTotal()
    {
        return entertainmentTotal;
    }

    public static double getGasTotal()
    {
        return gasTotal;
    }

    public static double getBillTotal()
    {
        return billTotal;
    }

    public static double getInvestmentsTotal()
    {
        return investmentsTotal;
    }

    public static double getOtherTotal()
    {
        return otherTotal;
    }

    public static double getOverallTotal()
    {
        return overallTotal;
    }  

    //update categories

    public static void updateClothesTotal(double amount)
    {
        clothesTotal += amount;
        overallTotal += amount;

        clothesPercent = calcPaymentPercent(clothesTotal);
        foodPercent = calcPaymentPercent(foodTotal);
        entertainmentPercent = calcPaymentPercent(entertainmentTotal);
        gasPercent = calcPaymentPercent(gasTotal);
        billPercent = calcPaymentPercent(billTotal);
        investmentsPercent = calcPaymentPercent(investmentsTotal);
        otherPercent = calcPaymentPercent(otherTotal);
    }

    public static void updateFoodTotal(double amount)
    {
        foodTotal += amount;
        overallTotal += amount;

        clothesPercent = calcPaymentPercent(clothesTotal);
        foodPercent = calcPaymentPercent(foodTotal);
        entertainmentPercent = calcPaymentPercent(entertainmentTotal);
        gasPercent = calcPaymentPercent(gasTotal);
        billPercent = calcPaymentPercent(billTotal);
        investmentsPercent = calcPaymentPercent(investmentsTotal);
        otherPercent = calcPaymentPercent(otherTotal);
    }

    public static void updateEntertainmentTotal(double amount)
    {
        entertainmentTotal += amount;
        overallTotal += amount;

        clothesPercent = calcPaymentPercent(clothesTotal);
        foodPercent = calcPaymentPercent(foodTotal);
        entertainmentPercent = calcPaymentPercent(entertainmentTotal);
        gasPercent = calcPaymentPercent(gasTotal);
        billPercent = calcPaymentPercent(billTotal);
        investmentsPercent = calcPaymentPercent(investmentsTotal);
        otherPercent = calcPaymentPercent(otherTotal);
    }

    public static void updateGasTotal(double amount)
    {
        gasTotal += amount;
        overallTotal += amount;

        clothesPercent = calcPaymentPercent(clothesTotal);
        foodPercent = calcPaymentPercent(foodTotal);
        entertainmentPercent = calcPaymentPercent(entertainmentTotal);
        gasPercent = calcPaymentPercent(gasTotal);
        billPercent = calcPaymentPercent(billTotal);
        investmentsPercent = calcPaymentPercent(investmentsTotal);
        otherPercent = calcPaymentPercent(otherTotal);
    }

    public static void updateBillTotal(double amount)
    {
        billTotal += amount;
        overallTotal += amount;

        clothesPercent = calcPaymentPercent(clothesTotal);
        foodPercent = calcPaymentPercent(foodTotal);
        entertainmentPercent = calcPaymentPercent(entertainmentTotal);
        gasPercent = calcPaymentPercent(gasTotal);
        billPercent = calcPaymentPercent(billTotal);
        investmentsPercent = calcPaymentPercent(investmentsTotal);
        otherPercent = calcPaymentPercent(otherTotal);
    }

    public static void updateInvestmentsTotal(double amount)
    {
        investmentsTotal += amount;
        overallTotal += amount;

        clothesPercent = calcPaymentPercent(clothesTotal);
        foodPercent = calcPaymentPercent(foodTotal);
        entertainmentPercent = calcPaymentPercent(entertainmentTotal);
        gasPercent = calcPaymentPercent(gasTotal);
        billPercent = calcPaymentPercent(billTotal);
        investmentsPercent = calcPaymentPercent(investmentsTotal);
        otherPercent = calcPaymentPercent(otherTotal);
    }

    public static void updateOtherTotal(double amount)
    {
        otherTotal += amount;
        overallTotal += amount;

        clothesPercent = calcPaymentPercent(clothesTotal);
        foodPercent = calcPaymentPercent(foodTotal);
        entertainmentPercent = calcPaymentPercent(entertainmentTotal);
        gasPercent = calcPaymentPercent(gasTotal);
        billPercent = calcPaymentPercent(billTotal);
        investmentsPercent = calcPaymentPercent(investmentsTotal);
        otherPercent = calcPaymentPercent(otherTotal);
    }

    public static double calcPaymentPercent(double x)
    {
        double percent = (x/overallTotal) * 100;

        return percent;
    }

    public static void displayMonthlySpendings()
    {
        System.out.println("Monthly Spendings: $"+ String.format("%.2f", overallTotal));
        System.out.println("-----------------------------------------------");
        System.out.println("Food(USD): $" + String.format("%.2f", foodTotal ));
        System.out.println("Food(Percentage): "+String.format("%.2f", foodPercent)+"%");
        System.out.println("-----------------------------------------------");
        System.out.println("Clothes(USD): $" + String.format("%.2f", clothesTotal ));
        System.out.println("Clothes(Percentage): "+String.format("%.2f", clothesPercent)+"%");
        System.out.println("-----------------------------------------------");
        System.out.println("Entertainment(USD): $" + String.format("%.2f",entertainmentTotal ));
        System.out.println("Entertainment(Percentage): "+String.format("%.2f", entertainmentPercent )+"%");
        System.out.println("-----------------------------------------------");
        System.out.println("Gas(USD): $" + String.format("%.2f", gasTotal ));
        System.out.println("Gas(Percentage): "+String.format("%.2f", gasPercent)+"%");
        System.out.println("-----------------------------------------------");
        System.out.println("Bills(USD): $" + String.format("%.2f", billTotal));
        System.out.println("Bills(Percentage): "+String.format("%.2f", billPercent)+"%");
        System.out.println("-----------------------------------------------");
        System.out.println("Investments(USD): $" + String.format("%.2f", investmentsTotal));
        System.out.println("Investments(Percentage): "+String.format("%.2f", investmentsPercent)+"%");
        System.out.println("-----------------------------------------------");
        System.out.println("Other(USD): $" + String.format("%.2f", otherTotal));
        System.out.println("Other(Percentage): "+String.format("%.2f", otherPercent)+"%");
        System.out.println("-----------------------------------------------");
    }

    public static void pennyPincher()
    {
        if(overallTotal <= 500)
        {
            System.out.println("You only spent $" + overallTotal+ " this month your pinchin just fine." );
        }
        else if(foodPercent <= 30)
        {
            System.out.println("Trying spending less on food");
        }
        else if(clothesPercent <= 15)
        {
            System.out.println("Spend less on clothes, time to accept those hand me downs.");
        }
        else if(entertainmentPercent <= 20)
        {
            System.out.println("You need to stay home more a penny pincher can go out!");
        }
        else if(gasPercent <= 12)
        {
            System.out.println("Time to start car pulling.");
        }else if(otherPercent<=20)
        {
            System.out.println("your spending your money on something and it probably time to stop");
        }
        else if(investmentsPercent<50)
        {
            System.out.println("Time to invest more to stop living your penny pincher life");
        }
        else if(billPercent <= 40)
        {
            System.out.println("bill are pretty high may be time to give up the netflix subscription");
        }
        else
        {
            System.out.println("Data is hard to read or everything checks out");
        }
    }

    public static void investor()
    {
        if(overallTotal <= 10000)
        {
            System.out.println("You only spent $" + overallTotal+ " this month your pinchin just fine." );
        }
        else if(foodPercent <= 30)
        {
            System.out.println("Trying spending less on food");
        }
        else if(clothesPercent <= 15)
        {
            System.out.println("Spend less on clothes, time to accept those hand me downs.");
        }
        else if(entertainmentPercent <= 20)
        {
            System.out.println("You need to stay home more a penny pincher can go out!");
        }
        else if(gasPercent <= 12)
        {
            System.out.println("Time to start car pulling.");
        }else if(otherPercent<=20)
        {
            System.out.println("your spending your money on something and it probably time to stop");
        }
        else if(investmentsPercent<= 60)
        {
            System.out.println("Time to invest more to live the investor life");
        }
        else if(billPercent <= 40)
        {
            System.out.println("bill are pretty high may be time to give up the netflix subscription");
        }
        else
        {
            System.out.println("Data is hard to read or everything checks out");
        }
    }

    public static void reccommended()
    {
        if(overallTotal <= 500)
        {
            System.out.println("You only spent $" + overallTotal+ " this month your pinchin just fine." );
        }
        else if(foodPercent <= 30)
        {
            System.out.println("Trying spending less on food");
        }
        else if(clothesPercent <= 15)
        {
            System.out.println("Spend less on clothes, time to accept those hand me downs.");
        }
        else if(entertainmentPercent <= 20)
        {
            System.out.println("You need to stay home more a penny pincher can go out!");
        }
        else if(gasPercent <= 12)
        {
            System.out.println("Time to start car pulling.");
        }else if(otherPercent<=20)
        {
            System.out.println("your spending your money on something and it probably time to stop");
        }
        else if(investmentsPercent<50)
        {
            System.out.println("Time to invest more to stop living your penny pincher life");
        }
        else if(billPercent <= 40)
        {
            System.out.println("bill are pretty high may be time to give up the netflix subscription");
        }
        else
        {
            System.out.println("Data is hard to read or everything checks out");
        }
    }
    
}