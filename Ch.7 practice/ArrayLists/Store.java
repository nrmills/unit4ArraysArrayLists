import java.util.ArrayList;

public class Store
{
    String highestName = "";
    int highestAmount = 0;
    public Store()
    {
        ArrayList<Customer> listOfCustomers = new ArrayList();
    }

    public void addSale(String customerName, double amount)
    {
        Customer c1 = new Customer(customerName, amount);
        for( int index = 0; index < ; index ++)
        {
            if ( listOfCustomers.get(i).get(0).equals(customerName) )
            {
                listOfCustomers.get(i).get(1) += amount;
                break;
            }
        }
        listOfCustomers.add(c1);
    }

    public String nameOfBestCustomer()
    {
        for( int index = 0; index < listOfcustomers.size(); index++ )
        {
            if( listOfCustomers.get(i).get(1) > highestAmount )
            {
                highestName = listOfCustomers.get(i).get(0);
                //highestAmount = listOfCustomers.get(i).get(1);
            }
        }
        return highestName;
    }

}
