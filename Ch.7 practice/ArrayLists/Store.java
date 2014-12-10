import java.util.ArrayList;

public class Store
{
    String highestName = "";
    int highestAmount = 0;
    ArrayList<Customer> listOfCustomers = new ArrayList();
    public Store()
    {
    }

    public void addSale(String customerName, String amount)
    {
        ArrayList<String> customer = new ArrayList(2);
        customer.add(0,customerName);
        customer.add(1,amount);
        for( int index = 0; index < listOfCustomers.size(); index ++)
        {
            if ( listOfCustomers.get(index).get(0).equals(customerName) )
            {
                double amount;
                double prevAmount = listOfCustomers.get(index).get(1);
                prevAmount += amount;
                listOfCustomers.get(index).get(1) += amount;
                break;
            }
        }
        listOfCustomers.add(customer);
    }

    public String nameOfBestCustomer()
    {
        for( int index = 0; index < listOfCustomers.size(); index++ )
        {
            if( listOfCustomers.get(index).get(1) > highestAmount )
            {
                highestName = listOfCustomers.get(index).get(0);
                //highestAmount = listOfCustomers.get(index).get(1);
            }
        }
        return highestName;
    }

}
