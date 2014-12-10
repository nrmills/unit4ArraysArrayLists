import java.util.Scanner;

public class Cashier
{
    public static void main(String[] args)
    {
        Store s1 = new Store();
        boolean moreCustomers = true;
        Scanner input = new Scanner(System.in);
        String name;
        double amount;
        
        //Input All Customers
        while ( moreCustomers == true )
        {
            System.out.print("Enter Name: ");
            name = input.next();
            System.out.print("Enter Sale Amount: ");
            amount = input.next();
            System.out.println();
            s1.addSale(name,amount);
        }
        
        //Print out Top Customer Name
        s1.nameOfBestCustomer();
    }
}