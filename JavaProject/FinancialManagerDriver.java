/*
Nicholas Garcia
Financial Manager App

Application Features:
    *DONE* Investments
        - Name of investment
        - intial payment
        - total money earned in specific investment
        - total money earned in entire portfolio
        - percent change of investment
            - ask user to enter new amount of investment and will calculate the percent gain or loss
            - will also calculate total portfolio percent gain or loss
        - Maybe track the percentage change in a list (Optional)
    *DONE* Budget System
        - read monthly spending data
        - set limits on spending in different areas and output a budget solution depending on limits crossed
            - Ex. "According to your monthly spendings try to decrease on eating out."
    *DONE* Calculations (Does different math things like Percentages)
    *DONE* Monthly Spendings
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
    *DONE* Manage Bills
        - get user input of the following
            - bill name
            - bill due date
            - bill cost
        - add new bills
    *DONE* Interest *DONE*
        - ask user for interest when creating savings account
        - ask user when they want to apply interest
    *DONE* Create Multiple Accounts *DONE*
        - function to create an account
        - account can be checking or savings
        - ask user to pick account type and also assign a account number
    *DONE* Add or Take money out of accounts *DONE*
        - deposit function
        - withdraw function
Notes:
    // Make more personal 
    // Make gui
    // Work on investments list and creation
    // Read and write to files
*/
import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.Arrays;



public class FinancialManagerDriver
{
    public static void main(String[] args)
    {
       Scanner scanner = new Scanner(System.in);
       
       //arrays
       Account accounts[] = new Account[10];
       BillManager bills[] = new BillManager[50];
       InvestName investments[] = new InvestName[50];
       
       

       int choice;
       int billChoice;
       int monthlySpendingsChoice;
       int investmentChoice;
       int numOfAccounts = 0;

       do
       {
            choice = displayMenu(scanner);
            System.out.println();

            if(choice == 1)
            {
                accounts[numOfAccounts++] = createAccount(scanner);
            }
            else if(choice == 2)
            {
                depositAction(accounts, numOfAccounts, scanner);
            }
            else if(choice == 3)
            {
                withdrawAction(accounts, numOfAccounts, scanner);
            }
            else if(choice == 4)
            {
                applyInterest(accounts, numOfAccounts, scanner);
            }
            else if(choice == 5)
            {
                do
                {
                    billChoice = billMenu(bills, scanner);
                }while(billChoice != 4);
            }
            else if(choice == 6)
            { 
                MonthlySpendings.displayMonthlySpendings();
            }
            else if(choice == 7)
            {
                do
                {
                    monthlySpendingsChoice = monthlySpendingsMenu(scanner);
                }while(monthlySpendingsChoice != 4);
            }
            else if(choice == 8)
            {
                do
                {
                    investmentChoice = investmentsMenu(investments, scanner);
                }while( investmentChoice != 6);
            }
            else
            {
                System.out.println("End of Program.");
            }
            System.out.println();

       }while(choice != 9);

    }

    /**
     * Account menu choice 1
     * 
     * @param scanner
     * @return
     */



    public static int monthlySpendingsMenu(Scanner scanner)
    {

        int mchoice = 0;
        
        do
        {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Budget Helper: Pick a Specific Type of budget");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("1. Penny Pincher"); //similar to create new account
            System.out.println("2. Investor"); //similar to withdraw
            System.out.println("3. Recommended");
            System.out.println("4. Back");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("Enter Your Choice: ");
            mchoice = scanner.nextInt();
            System.out.println("------------------------------------------------------------------------");

            if(mchoice == 1)
            {
                MonthlySpendings.pennyPincher();
            }
            else if(mchoice == 2)
            {
                MonthlySpendings.investor();
            }
            else if(mchoice == 3)
            {
                MonthlySpendings.reccommended();
            }
            else
            {
                System.out.println("Back to Main Menu");
            }


            
            
        }while(mchoice != 4);

        return mchoice;
    }



    public static int accountMenu(Scanner scanner)
    {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Account Type");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");
        System.out.println("-----------------------------------------------------------------------");

        int choice;

        do
        {
            System.out.println("Enter Your Choice: ");
            choice = scanner.nextInt();

        }while(choice < 1 || choice >2);

        return choice;
    }

    public static int searchAccount(Account accounts[], int count, int accountNum)
    {
        for(int i = 0; i<count; i++)
        {
            if(accounts[i].getAccountNum() == accountNum)
            {
                return i;
            }
        }

        return -1;
    }

    /**
     * Function will deposit on a account
     * @param account
     * @param count
     */
    public static void depositAction(Account accounts[], int count, Scanner scanner)
    {
        // get the account number
        System.out.print("Enter Account Number: ");
        int accountNum = scanner.nextInt();

        //search and find account
        int index = searchAccount(accounts, count, accountNum);

        //Amount
        if(index >= 0)
        {
            System.out.print("Deposit: ");
            double amount = scanner.nextDouble();

            accounts[index].deposit(amount);
        }
        else
        {
            System.out.println("The account number, "+accountNum +",does not match an existing account.");
        }

    }

    public static void withdrawAction(Account accounts[], int count, Scanner scanner)
    {
        // get the account number
        System.out.print("Enter Account Number: ");
        int accountNum = scanner.nextInt();

        //search and find account
        int index = searchAccount(accounts, count, accountNum);

        //Amount
        if(index >= 0)
        {
            System.out.print("Withdraw: ");
            double amount = scanner.nextDouble();

            accounts[index].withdraw(amount);

            System.out.println("");
            System.out.println("Select the reason for withdrawing: $"+ amount);
            System.out.println("1. Food");
            System.out.println("2. Clothes");
            System.out.println("3. Entertainment");
            System.out.println("4. Gas (Transportation)");
            System.out.println("5. Other");

            System.out.print("Reason: ");
            int reason = scanner.nextInt();

            if(reason == 1)
            {
                MonthlySpendings.updateFoodTotal(amount);
            }
            else if(reason == 2)
            {
                MonthlySpendings.updateClothesTotal(amount);
            }
            else if(reason == 3)
            {
                MonthlySpendings.updateEntertainmentTotal(amount);
            }
            else if(reason == 4)
            {
                MonthlySpendings.updateGasTotal(amount);
            }
            else if(reason == 5)
            {
                MonthlySpendings.updateOtherTotal(amount);
            }
            else
            {
                System.out.println("The reason you selected does not exist.");
                System.out.println("Default Reason: Other");
            }

        }
        else
        {
            System.out.println("The account number, "+accountNum +",does not match an existing account.");
        }
    }

    public static void applyInterest(Account accounts[], int count, Scanner scanner)
    {
        // get the account number
        System.out.print("Enter Savings Account Number: ");
        int accountNum = scanner.nextInt();

        //search and find account
        int index = searchAccount(accounts, count, accountNum);

        //Amount
        if(index >= 0)
        {
            //instance of savings account
            if(accounts[index] instanceof SavingsAccount)
            {
                ((SavingsAccount)accounts[index]).applyInterest();
            }
        }
        else
        {
            System.out.println("The account number, "+accountNum +",does not match an existing account.");
        }

    }

    public static BillManager createBill(Scanner scanner)
    {
        BillManager billManager = null;
        String date;
        int bchoice;
        double bcost;

        String billName;
        System.out.print("Enter New Bill Name: ");
        billName = scanner.next();
        System.out.println("---------------------------------------------");

        System.out.println("---------------------------------------------");
        System.out.println("Will this bill be recurring or one-time?");
        System.out.println("1. Reccuring");
        System.out.println("2. One-time");
        System.out.println("---------------------------------------------");
        System.out.print("Enter Choice: ");
        bchoice = scanner.nextInt();
        System.out.println("---------------------------------------------");

        if(bchoice == 1)
        {
            System.out.print("Enter Due Date day of each month of New Bill (dd): ");
            date = scanner.next();
            System.out.println("---------------------------------------------");

            System.out.print("Enter Cost of New Bill: ");
            bcost = scanner.nextDouble();
            MonthlySpendings.updateBillTotal(bcost);
            System.out.println("---------------------------------------------");
            billManager = new BillManager(billName, date, bcost);
        }
        else
        {
            System.out.println("Enter Due Date of New Bill (dd-mm-yyyy): ");
            date = scanner.next();
            System.out.println("---------------------------------------------");

            System.out.println("Enter Cost of New Bill: ");
            bcost = scanner.nextDouble();
            MonthlySpendings.updateBillTotal(bcost);
            System.out.println("---------------------------------------------");
            billManager = new BillManager(billName, date, bcost);
        }

        return billManager;
    }

    /**
     * creates new account
     * @param scanner
     * @return
     */
    public static Account createAccount(Scanner scanner)
    {
        Account account = null;
        int choice = accountMenu(scanner);

        int accountNum;
        System.out.print("Enter Account Number: ");
        accountNum = scanner.nextInt();

        if(choice == 1) //checking account
        {
            System.out.print("Enter Transaction Fee: ");
            double fee = scanner.nextDouble();

            account = new CheckingAccount(accountNum, fee);
        }
        else //savings account
        {
            System.out.print("Enter Interest Rate: ");
            double ir = scanner.nextDouble();
            account = new SavingsAccount(accountNum, ir);
        }
        return account;
    }

    /**
     * Menu diplays options and gets user input
     * @param scanner
     * @return
     */

    public static int displayMenu(Scanner scanner)
    {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Financial Account Menu Selection");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Apply Interest");
        System.out.println("5. Manage Bills");
        System.out.println("6. Monthly Spendings");
        System.out.println("7. Budget Helper");
        System.out.println("8. Investments");
        System.out.println("9. Exit");

        int choice;

        do
        {
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("Enter Your Choice: ");
            choice = scanner.nextInt();
            System.out.println("------------------------------------------------------------------------");
            
        }while(choice < 1 || choice > 9);

        return choice;
    }

    public static void listBills(BillManager bills[], int count)
    {
        for(int i = 0; i<count; i++)
        {
            System.out.println(bills[i]);
            
        }

    }

    public static int searchBills(BillManager bills[], int count, String billName)
    {
        for(int i = 0; i<count; i++)
        {
            if(bills[i].getBillName().equals(billName))
            {
                return i;
            }
        }
        return -1;

    }

    public static int billMenu(BillManager bills[],Scanner scanner)
    {
        //BillManager bills[] = new BillManager[50];
        

        int nchoice;
        int numOfBills = 0;

        do
        {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Bill Manager");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("1. New Bill"); //similar to create new account
            System.out.println("2. Search for a Bill"); //similar to withdraw
            System.out.println("3. View Bills");
            System.out.println("4. Back");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("Enter Your Choice: ");
            nchoice = scanner.nextInt();
            System.out.println("------------------------------------------------------------------------");

            if(nchoice == 1)
            {
               bills[numOfBills++] = createBill(scanner);
               
            }
            else if(nchoice == 2)
            {
                System.out.print("Enter Bill Name: ");
                String billName = scanner.next();
                System.out.println("------------------------------------------------------------------------------------------------------");

                //search and find account
                int index = searchBills(bills, numOfBills, billName);
                if(index >= 0)
                {
                    System.out.println(bills[index]);
                }
                else
                {
                    System.out.println("The bill, "+billName +", does not match an existing bill.");
                }
            }
            else if(nchoice == 3)
            {
                //String nameBill;
                //int x;
                listBills(bills, numOfBills);
                System.out.println("---------------------------------------------------------");
            }
            else
            {
                System.out.println("Back to Main Menu");
            }


            
            
        }while(nchoice != 4);

        return nchoice;
    }

    public static int investmentsMenu(InvestName investments[],Scanner scanner)
    {
        //InvestName investments[] = new InvestName[50];
        
        int numOfInvest = 0;
        int investmentChoice;

        do
        {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Investments");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("1. New Investment"); //similar to create new account
            System.out.println("2. Search for a Investment"); //similar to withdraw
            System.out.println("3. View Investments");
            System.out.println("4. View Portfolio Information");
            System.out.println("5. Change price of investment");
            System.out.println("6. Back");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("Enter Your Choice: ");
            investmentChoice = scanner.nextInt();
            System.out.println("------------------------------------------------------------------------");

            if(investmentChoice == 1)
            {
                investments[numOfInvest++] = createInvestment(scanner);
               
            }
            else if(investmentChoice == 2)
            {
                System.out.print("Enter Investment Name: ");
                String investName = scanner.next();
                System.out.println("------------------------------------------------------------------------------------------------------");

                //search and find account
                int index = searchInvestments(investments, numOfInvest, investName);
                if(index >= 0)
                {
                    System.out.println(investments[index]);
                }
                else
                {
                    System.out.println("The investment, "+investName +", does not match an existing investment.");
                }
            }
            else if(investmentChoice == 3)
            {
                listInvestments(investments, numOfInvest);
                System.out.println("---------------------------------------------------------");
            }
            else if(investmentChoice == 4)
            {
                double portfolioPercentChange = Investments.calcPercentChange(Investments.getPortfolioTotal(), Investments.getIntialInvestmentTotal());
                System.out.println("Intial Investments Total (money you have put in): $"+ String.format("%.2f", Investments.getIntialInvestmentTotal()));
                System.out.println("Portfolio Total: $"+ String.format("%.2f", Investments.getPortfolioTotal()));
                System.out.println("Total Percentage Change: " + String.format("%.2f", portfolioPercentChange) + "%");
                if(portfolioPercentChange>=100)
                {
                    System.out.println("Your portfolio is to the moon! Your clearly doing something right.");
                }
                else if(portfolioPercentChange >=75)
                {
                    System.out.println("Your portfolio is amazing keep up the good work.");
                }
                else if(portfolioPercentChange >=50)
                {
                    System.out.println("Your portfolio is x2 or more the global average for return rate, your headed in the right direction.");
                }
                else if(portfolioPercentChange >=25)
                {
                    System.out.println("Your portfolio is above average which is better than most good job!");
                }
                else if(portfolioPercentChange >=10)
                {
                    System.out.println("Your portfolio has had a little less than average, but is still good, especially if its been less than a year.");
                }
                else if(portfolioPercentChange >=0)
                {
                    System.out.println("Your portfolio has a low return rate, if investment is less than 6 months old then this is fine. If more, than it may be time to relocate your assets.");
                }
                else
                {
                    System.out.println("Your portfolio is lower than you started if its only been a week this may be fine. If less than 3-6 months this could still be fine, but pushing it. If more than a year investing is not for you and you should seek a financial expert.");
                }
            }
            else if(investmentChoice == 5)
            {
                investmentAction(investments, numOfInvest, scanner);
                
            }
            else
            {
                System.out.println("Back to Main Menu");
            }
            
        }while(investmentChoice != 6);

        return investmentChoice;
    }

    public static InvestName createInvestment(Scanner scanner)
    {
        InvestName investment = null;
        String investmentName;
        double iCost;
        System.out.print("Enter New Investment Name: ");
        investmentName = scanner.next();
        System.out.println("---------------------------------------------");

        System.out.println("---------------------------------------------");
        System.out.println("Enter Intial Cost of investment");
        System.out.println("---------------------------------------------");
        System.out.print("Enter Choice: ");
        iCost = scanner.nextDouble();
        System.out.println("---------------------------------------------");

        MonthlySpendings.updateInvestmentsTotal(iCost);

        investment = new Investments(investmentName, iCost);

        return investment;
    }

    public static int searchInvestments(InvestName investments[], int count, String investmentName)
    {
        for(int i = 0; i<count; i++)
        {
            if(investments[i].getInvestmentName().equals(investmentName))
            {
                return i;
            }
        }

        return -1;
    }

    
    public static void investmentAction(InvestName investments[], int count, Scanner scanner)
    {
        // get the investment name
        System.out.print("Enter Investment Name: ");
        String investName = scanner.next();
        System.out.println("------------------------------------------------------------------------------------------------------");

        //search and find account
        int index = searchInvestments(investments, count, investName);

        //Amount
        if(index >= 0)
        {
            System.out.print("Enter New amount of Investment total for "+ investments[index].getInvestmentName() + ": $");
            double amount = scanner.nextDouble();
            System.out.println("------------------------------------------------------------------------------------------------------");

            investments[index].updateInvestmentTotal(amount);
        }
        else
        {
            System.out.println("The investment, "+investName +", does not match an existing investment.");
        }

    }
    
    public static void listInvestments(InvestName investments[], int count)
    {
        for(int i = 0; i<count; i++)
        {
            System.out.println(investments[i]);
            
        }

    }
}

/*

import java.util.Scanner;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Formatter;
import java.lang.Math;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.FormatterClosedException;
import java.util.InputMismatchException;

//import java.util.ArrayList;
//import java.util.Arrays;



public class FinancialManagerDriver
{
    public static void main(String[] args)
    {
       Scanner scanner = new Scanner(System.in);
       
       //arrays
       Account accounts[] = new Account[10];
       ArrayList<BillManager> bills = new ArrayList<BillManager>();
       ArrayList<Investments> investments = new ArrayList<Investments>();

       try (Scanner input = new Scanner(Paths.get("ActiveItems.txt"))) {
        while (input.hasNext()) {
            bills.add(new BillManager(input.next(), input.next(), input.nextDouble()));
        }
        } catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
        }
        try (Scanner input = new Scanner(Paths.get("SupplyItems.txt"))) {
            while (input.hasNext()) {
                investments.add(new Investments(input.next(), input.nextDouble()));
            }
        } catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
        }
       
       

       int choice;
       int billChoice;
       int monthlySpendingsChoice;
       int investmentChoice;
       int numOfAccounts = 0;

       do
       {
            choice = displayMenu(scanner);
            System.out.println();

            if(choice == 1)
            {
                accounts[numOfAccounts++] = createAccount(scanner);
            }
            else if(choice == 2)
            {
                depositAction(accounts, numOfAccounts, scanner);
            }
            else if(choice == 3)
            {
                withdrawAction(accounts, numOfAccounts, scanner);
            }
            else if(choice == 4)
            {
                applyInterest(accounts, numOfAccounts, scanner);
            }
            else if(choice == 5)
            {
                do
                {
                    billChoice = billMenu(bills, scanner);
                }while(billChoice != 4);
            }
            else if(choice == 6)
            { 
                MonthlySpendings.displayMonthlySpendings();
            }
            else if(choice == 7)
            {
                do
                {
                    monthlySpendingsChoice = monthlySpendingsMenu(scanner);
                }while(monthlySpendingsChoice != 4);
            }
            else if(choice == 8)
            {
                do
                {
                    investmentChoice = investmentsMenu(investments, scanner);
                }while( investmentChoice != 6);
            }
            else
            {
                System.out.println("End of Program.");
            }
            System.out.println();

       }while(choice != 9);

    }

    /**
     * Account menu choice 1
     * 
     * @param scanner
     * @return
     */


/*
    public static int monthlySpendingsMenu(Scanner scanner)
    {
        int mChoice = 0;
        System.out.println("");
        return mChoice;
    }



    public static int accountMenu(Scanner scanner)
    {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Account Type");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");
        System.out.println("-----------------------------------------------------------------------");

        int choice;

        do
        {
            System.out.println("Enter Your Choice: ");
            choice = scanner.nextInt();

        }while(choice < 1 || choice >2);

        return choice;
    }

    public static int searchAccount(Account accounts[], int count, int accountNum)
    {
        for(int i = 0; i<count; i++)
        {
            if(accounts[i].getAccountNum() == accountNum)
            {
                return i;
            }
        }

        return -1;
    }

    /**
     * Function will deposit on a account
     * @param account
     * @param count
     */

     /*
    public static void depositAction(Account accounts[], int count, Scanner scanner)
    {
        // get the account number
        System.out.print("Enter Account Number: ");
        int accountNum = scanner.nextInt();

        //search and find account
        int index = searchAccount(accounts, count, accountNum);

        //Amount
        if(index >= 0)
        {
            System.out.print("Deposit: ");
            double amount = scanner.nextDouble();

            accounts[index].deposit(amount);
        }
        else
        {
            System.out.println("The account number, "+accountNum +",does not match an existing account.");
        }

    }

    public static void withdrawAction(Account accounts[], int count, Scanner scanner)
    {
        // get the account number
        System.out.print("Enter Account Number: ");
        int accountNum = scanner.nextInt();

        //search and find account
        int index = searchAccount(accounts, count, accountNum);

        //Amount
        if(index >= 0)
        {
            System.out.print("Withdraw: ");
            double amount = scanner.nextDouble();

            accounts[index].withdraw(amount);

            System.out.println("");
            System.out.println("Select the reason for withdrawing: $"+ amount);
            System.out.println("1. Food");
            System.out.println("2. Clothes");
            System.out.println("3. Entertainment");
            System.out.println("4. Gas (Transportation)");
            System.out.println("5. Other");

            System.out.print("Reason: ");
            int reason = scanner.nextInt();

            if(reason == 1)
            {
                MonthlySpendings.updateFoodTotal(amount);
            }
            else if(reason == 2)
            {
                MonthlySpendings.updateClothesTotal(amount);
            }
            else if(reason == 3)
            {
                MonthlySpendings.updateEntertainmentTotal(amount);
            }
            else if(reason == 4)
            {
                MonthlySpendings.updateGasTotal(amount);
            }
            else if(reason == 5)
            {
                MonthlySpendings.updateOtherTotal(amount);
            }
            else
            {
                System.out.println("The reason you selected does not exist.");
                System.out.println("Default Reason: Other");
            }

        }
        else
        {
            System.out.println("The account number, "+accountNum +",does not match an existing account.");
        }
    }

    public static void applyInterest(Account accounts[], int count, Scanner scanner)
    {
        // get the account number
        System.out.print("Enter Savings Account Number: ");
        int accountNum = scanner.nextInt();

        //search and find account
        int index = searchAccount(accounts, count, accountNum);

        //Amount
        if(index >= 0)
        {
            //instance of savings account
            if(accounts[index] instanceof SavingsAccount)
            {
                ((SavingsAccount)accounts[index]).applyInterest();
            }
        }
        else
        {
            System.out.println("The account number, "+accountNum +",does not match an existing account.");
        }

    }

    public static BillManager createBill(Scanner scanner)
    {
        BillManager billManager = null;
        String date;
        int bchoice;
        double bcost;

        String billName;
        System.out.print("Enter New Bill Name: ");
        billName = scanner.next();
        System.out.println("---------------------------------------------");

        System.out.println("---------------------------------------------");
        System.out.println("Will this bill be recurring or one-time?");
        System.out.println("1. Reccuring");
        System.out.println("2. One-time");
        System.out.println("---------------------------------------------");
        System.out.print("Enter Choice: ");
        bchoice = scanner.nextInt();
        System.out.println("---------------------------------------------");

        if(bchoice == 1)
        {
            System.out.print("Enter Due Date day of each month of New Bill (dd): ");
            date = scanner.next();
            System.out.println("---------------------------------------------");

            System.out.print("Enter Cost of New Bill: ");
            bcost = scanner.nextDouble();
            MonthlySpendings.updateBillTotal(bcost);
            System.out.println("---------------------------------------------");
            billManager = new BillManager(billName, date, bcost);
        }
        else
        {
            System.out.println("Enter Due Date of New Bill (dd-mm-yyyy): ");
            date = scanner.next();
            System.out.println("---------------------------------------------");

            System.out.println("Enter Cost of New Bill: ");
            bcost = scanner.nextDouble();
            MonthlySpendings.updateBillTotal(bcost);
            System.out.println("---------------------------------------------");
            billManager = new BillManager(billName, date, bcost);
        }

        return billManager;
    }

    /**
     * creates new account
     * @param scanner
     * @return
     */

     /*
    public static Account createAccount(Scanner scanner)
    {
        Account account = null;
        int choice = accountMenu(scanner);

        int accountNum;
        System.out.print("Enter Account Number: ");
        accountNum = scanner.nextInt();

        if(choice == 1) //checking account
        {
            System.out.print("Enter Transaction Fee: ");
            double fee = scanner.nextDouble();

            account = new CheckingAccount(accountNum, fee);
        }
        else //savings account
        {
            System.out.print("Enter Interest Rate: ");
            double ir = scanner.nextDouble();
            account = new SavingsAccount(accountNum, ir);
        }
        return account;
    }

    /**
     * Menu diplays options and gets user input
     * @param scanner
     * @return
     */

     /*

    public static int displayMenu(Scanner scanner)
    {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Financial Account Menu Selection");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Apply Interest");
        System.out.println("5. Manage Bills");
        System.out.println("6. Monthly Spendings");
        System.out.println("7. Budget Helper");
        System.out.println("8. Investments");
        System.out.println("9. Exit");

        int choice;

        do
        {
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("Enter Your Choice: ");
            choice = scanner.nextInt();
            System.out.println("------------------------------------------------------------------------");
            
        }while(choice < 1 || choice > 9);

        return choice;
    }

    public static void listBills(ArrayList<BillManager> bills, int count)
    {
        for(int i = 0; i<count; i++)
        {
            System.out.println(bills.get(i));
            
        }

    }

    public static int searchBills(ArrayList<BillManager> bills, int count, String billName)
    {
        for(int i = 0; i<count; i++)
        {
            if(bills.get(i).getBillName().equals(billName))
            {
                return i;
            }
        }
        return -1;

    }

    public static int billMenu(ArrayList<BillManager> bills, Scanner scanner)
    {
        //BillManager bills[] = new BillManager[50];
        

        int nchoice;
        int numOfBills = 0;

        do
        {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Bill Manager");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("1. New Bill"); //similar to create new account
            System.out.println("2. Search for a Bill"); //similar to withdraw
            System.out.println("3. View Bills");
            System.out.println("4. Back");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("Enter Your Choice: ");
            nchoice = scanner.nextInt();
            System.out.println("------------------------------------------------------------------------");

            if(nchoice == 1)
            {
               bills.add(createBill(scanner));
               
            }
            else if(nchoice == 2)
            {
                System.out.print("Enter Bill Name: ");
                String billName = scanner.next();
                System.out.println("------------------------------------------------------------------------------------------------------");

                //search and find account
                int index = searchBills(bills, numOfBills, billName);
                if(index >= 0)
                {
                    System.out.println(bills.get(index).toString());
                }
                else
                {
                    System.out.println("The bill, "+billName +", does not match an existing bill.");
                }
            }
            else if(nchoice == 3)
            {
                listBills(bills, numOfBills);
                System.out.println("---------------------------------------------------------");
            }
            else
            {
                System.out.println("Back to Main Menu");
            }


            
            
        }while(nchoice != 4);

        return nchoice;
    }

    public static int investmentsMenu(ArrayList<Investments> investments,Scanner scanner)
    {
        //Investments investments[] = new Investments[50];
        
        int numOfInvest = 0;
        int investmentChoice;

        do
        {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Investments");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("1. New Investment"); //similar to create new account
            System.out.println("2. Search for a Investment"); //similar to withdraw
            System.out.println("3. View Investments");
            System.out.println("4. View Portfolio Information");
            System.out.println("5. Change price of investment");
            System.out.println("6. Back");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("Enter Your Choice: ");
            investmentChoice = scanner.nextInt();
            System.out.println("------------------------------------------------------------------------");

            if(investmentChoice == 1)
            {
                investments.add(createInvestment(scanner));
               
            }
            else if(investmentChoice == 2)
            {
                System.out.print("Enter Investment Name: ");
                String Investments = scanner.next();
                System.out.println("------------------------------------------------------------------------------------------------------");

                //search and find account
                int index = searchInvestments(investments, numOfInvest, Investments);
                if(index >= 0)
                {
                    System.out.println(investments.get(index));
                }
                else
                {
                    System.out.println("The investment, "+Investments +", does not match an existing investment.");
                }
            }
            else if(investmentChoice == 3)
            {
                listInvestments(investments, numOfInvest);
                System.out.println("---------------------------------------------------------");
            }
            else if(investmentChoice == 4)
            {
                double portfolioPercentChange = Investments.calcPercentChange(Investments.getPortfolioTotal(), Investments.getIntialInvestmentTotal());
                System.out.println("Intial Investments Total (money you have put in): $"+ String.format("%.2f", Investments.getIntialInvestmentTotal()));
                System.out.println("Portfolio Total: $"+ String.format("%.2f", Investments.getPortfolioTotal()));
                System.out.println("Total Percentage Change: " + String.format("%.2f", portfolioPercentChange) + "%");
                if(portfolioPercentChange>=100)
                {
                    System.out.println("Your portfolio is to the moon! Your clearly doing something right.");
                }
                else if(portfolioPercentChange >=75)
                {
                    System.out.println("Your portfolio is amazing keep up the good work.");
                }
                else if(portfolioPercentChange >=50)
                {
                    System.out.println("Your portfolio is x2 or more the global average for return rate, your headed in the right direction.");
                }
                else if(portfolioPercentChange >=25)
                {
                    System.out.println("Your portfolio is above average which is better than most good job!");
                }
                else if(portfolioPercentChange >=10)
                {
                    System.out.println("Your portfolio has had a little less than average, but is still good, especially if its been less than a year.");
                }
                else if(portfolioPercentChange >=0)
                {
                    System.out.println("Your portfolio has a low return rate, if investment is less than 6 months old then this is fine. If more, than it may be time to relocate your assets.");
                }
                else
                {
                    System.out.println("Your portfolio is lower than you started if its only been a week this may be fine. If less than 3-6 months this could still be fine, but pushing it. If more than a year investing is not for you and you should seek a financial expert.");
                }
            }
            else if(investmentChoice == 5)
            {
                investmentAction(investments, numOfInvest, scanner);
                
            }
            else
            {
                System.out.println("Back to Main Menu");
            }
            
        }while(investmentChoice != 6);

        return investmentChoice;
    }

    public static Investments createInvestment(Scanner scanner)
    {
        Investments investment = null;
        String investmentName;
        double iCost;
        System.out.print("Enter New Investment Name: ");
        investmentName = scanner.next();
        System.out.println("---------------------------------------------");

        System.out.println("---------------------------------------------");
        System.out.println("Enter Intial Cost of investment");
        System.out.println("---------------------------------------------");
        System.out.print("Enter Choice: ");
        iCost = scanner.nextDouble();
        System.out.println("---------------------------------------------");

        MonthlySpendings.updateInvestmentsTotal(iCost);

        investment = new Investments(investmentName, iCost);

        return investment;
    }

    public static int searchInvestments(ArrayList<Investments> investments, int count, String investmentName)
    {
        for(int i = 0; i<count; i++)
        {
            if(investments.get(i).getInvestmentName().equals(investmentName))
            {
                return i;
            }
        }

        return -1;
    }

    
    public static void investmentAction(ArrayList<Investments> investments, int count, Scanner scanner)
    {
        // get the investment name
        System.out.print("Enter Investment Name: ");
        String Investments = scanner.next();
        System.out.println("------------------------------------------------------------------------------------------------------");

        //search and find account
        int index = searchInvestments(investments, count, Investments);

        //Amount
        if(index >= 0)
        {
            System.out.print("Enter New amount of Investment total for "+ investments.get(index).getInvestmentName() + ": $");
            double amount = scanner.nextDouble();
            System.out.println("------------------------------------------------------------------------------------------------------");

            investments.get(index).updateInvestmentTotal(amount);
        }
        else
        {
            System.out.println("The investment, "+Investments +", does not match an existing investment.");
        }

    }
    
    public static void listInvestments(ArrayList<Investments> investments, int count)
    {
        for(int i = 0; i<count; i++)
        {
            System.out.println(investments.get(i));
            
        }

    }
}

*/